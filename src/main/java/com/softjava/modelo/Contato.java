package com.softjava.modelo;

import java.io.Serializable;

import org.apache.poi.ss.usermodel.Row;

import com.softjava.util.TratarValores;

public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String telefone;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void converterRow(Row row) {
		this.nome = TratarValores.trabalharValorString(row.getCell(0).getStringCellValue());
		this.telefone = TratarValores.trabalharValorString(row.getCell(1).toString().replace(".0", ""));
		this.email = TratarValores.trabalharValorString(row.getCell(2).toString());
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	

}
