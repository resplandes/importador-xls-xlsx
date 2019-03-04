package com.softjava.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.softjava.modelo.Contato;
import com.softjava.util.ExcelFileFilter;
import com.softjava.util.FileUtil;

public class ImportadorContato {

	public static void main(String[] args) {
		ImportadorContato importador = new ImportadorContato();
		importador.importar();
	}

	public void importar() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new ExcelFileFilter());
		fileChooser.showOpenDialog(null);
		if (fileChooser.getSelectedFile() != null) {
			File file = fileChooser.getSelectedFile();
			String ext = FileUtil.getExtencion(file);
			try (FileInputStream fileInputStream = new FileInputStream(file)) {

				List<Contato> contatos = new ArrayList<>();
				if (ext.equals("xls")) {
					HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
					HSSFSheet sheet = workbook.getSheetAt(0);

					iterateAndCreateContacts(sheet.rowIterator(), contatos);
				} else if (ext.equals("xlsx")) {
					XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
					XSSFSheet sheet = workbook.getSheetAt(0);
					iterateAndCreateContacts(sheet.rowIterator(), contatos);
				}
				
				contatos.stream().forEach(contato->{
					System.out.println(contato);
				});

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Will iterate over the rows and insert in the list the created objects
	 *
	 * @param rows
	 * @param clientes
	 */
	public void iterateAndCreateContacts(Iterator<Row> rows, List<Contato> contatos) {

		while (rows.hasNext()) {
			Row row = rows.next();
			// Ignore the first line, normally is used to the header line
			if (row.getRowNum() == 0) {
				continue;
			}
			Contato contato = new Contato();
			contato.converterRow(row);
			if (contato != null) {
				contatos.add(contato);
			}	
		}

	}
}
