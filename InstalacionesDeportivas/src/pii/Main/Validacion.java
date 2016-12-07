package pii.Main;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Validacion {

	public static boolean esSaldo(double saldo) {
		if ((saldo < 0))
			return false;

		return true;
	}

	public static boolean esHora(int horasAsignables) {

		if (horasAsignables < 0 || horasAsignables > 20)
			return false;

		return true;
	}

	public static boolean esFechaIngreso(Calendar fechaIngreso) {

		Calendar fechaLimiteA = new GregorianCalendar(1950, 0, 1);
		Calendar fechaLimiteB = new GregorianCalendar(2020, 0, 1);
		if (fechaIngreso.before(fechaLimiteA) || fechaIngreso.after(fechaLimiteB)) {
			return false;
		}

		return true;
	}

	public static boolean esFecha(Calendar fechaIngreso, Calendar fechaNacimiento) {

		int difMes = 0;
		float diferencia = 0;

		if (fechaIngreso.equals(fechaNacimiento)) {
			DecimalFormat decimales = new DecimalFormat("0.0");
			System.out.println("La diferencia de meses es:" + decimales.format(0));
		} else if (fechaIngreso.before(fechaNacimiento)) {
			while (fechaIngreso.get(Calendar.MONTH) != fechaNacimiento.get(Calendar.MONTH)
					|| fechaIngreso.get(Calendar.YEAR) != fechaNacimiento.get(Calendar.YEAR)) {
				fechaIngreso.add(Calendar.MONTH, 1);
				difMes++;
			}

			/* Ya sabemos los meses que tenemos de diferencia */
			diferencia = (float) difMes + (float) fechaNacimiento.get(Calendar.DAY_OF_MONTH)
					/ fechaNacimiento.getActualMaximum(Calendar.DAY_OF_MONTH);
			DecimalFormat decimales = new DecimalFormat("0.0");
			System.out.println("La diferencia de meses es:" + decimales.format(diferencia));
		} else {
			while (fechaIngreso.get(Calendar.MONTH) != fechaNacimiento.get(Calendar.MONTH)
					|| fechaIngreso.get(Calendar.YEAR) != fechaNacimiento.get(Calendar.YEAR)) {
				fechaIngreso.add(Calendar.MONTH, 1);
				difMes++;
			}
			/* Ya sabemos los meses que tenemos de diferencia */

			diferencia = (float) difMes + (float) fechaNacimiento.get(Calendar.DAY_OF_MONTH)
					/ fechaNacimiento.getActualMaximum(Calendar.DAY_OF_MONTH);
			// DecimalFormat decimales = new DecimalFormat("0.0");

		}

		double difAños = diferencia / 12;
		// MIRAMOS SI LA DIFERENCIA ENTRE LAS DOS EDADES NO ES MENOR DE 5 NI
		// MAYOR DE OCHENTA
		if (difAños < 5 || difAños > 80)
			return false;
		return true;
	}

}
