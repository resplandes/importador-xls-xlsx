package com.softjava.util;

import java.math.BigDecimal;

public class TratarValores {

	public static String trabalharValorString(String valor) {
		if (valor != null) {
			return valor.replace(".0", "").toUpperCase().trim();
		} else {
			return "SEM DADOS";
		}
	}

	public static BigDecimal retornaBigDecimalFormatado(String valor) {
		try {
			return new BigDecimal(valor).setScale(4, BigDecimal.ROUND_HALF_DOWN);
		} catch (java.lang.NumberFormatException e) {
			return BigDecimal.ZERO;
		}
	}

	public static Integer retornaIntegerFormatado(String valor) {
		try {
			return new Integer(valor);
		} catch (java.lang.NumberFormatException e) {
			return new Integer("0");
		}
	}
}
