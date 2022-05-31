package debug;

import java.util.Calendar;

public class Code119 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		int a = 0;

		a = cal.get(Calendar.YEAR) - 1900; // ---①
		
		System.out.printf("%d ", a);

		a += cal.get(Calendar.MONTH); // ---②

		System.out.printf("%d ", a);

		a += cal.get(Calendar.DATE);

		System.out.printf("%d\n", a);

	}

}
