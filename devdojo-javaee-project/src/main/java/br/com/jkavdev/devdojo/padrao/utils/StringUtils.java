package br.com.jkavdev.devdojo.padrao.utils;

public class StringUtils {

	public static String likeLower(String param) {
		return "%" + param.toLowerCase() + "%";
	}

	public static String like(String param) {
		return "%" + param + "%";
	}

}
