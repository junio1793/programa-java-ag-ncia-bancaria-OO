package application.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	static NumberFormat formatVal = new DecimalFormat("R$ #,##0,00");

	public static String doubleToString(double valor) {
		return formatVal.format(valor);
	}

}
