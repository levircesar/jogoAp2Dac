package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	public static String formatar(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	public static String formatar(Date data, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(data);
	}
	
	public static void main(String[] args) {
		Date datinha = new Date();
		System.out.println(formatar(datinha));
		System.out.println(formatar(datinha, "dd/MM/yyyy HH:mm"));
	}
}
