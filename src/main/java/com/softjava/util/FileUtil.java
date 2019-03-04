package com.softjava.util;

import java.io.File;

/**
 * 
 * @author Efraim Gentil
 * @email efraim.gentil@gmail.com
 * @date Dec 11, 2013
 */
public class FileUtil {
	
	public static String getExtencion(File file){
		String ext = null;
		String s = file.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
	}
	
}
