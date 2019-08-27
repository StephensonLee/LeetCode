package problems;

public class P65_Valid {
	public static boolean isNumber(String s) {
		s = s.trim();
		int id = 0;
		int len = s.length();
		if (len == 0)
			return false;
		if (id < len && s.charAt(id) == '+' || s.charAt(id) == '-')
			id++;
		if (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9') {
			while (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9')
				id++;
		} else if (id < len && s.charAt(id) == '.')
			;
		else
			return false;
		if (id < len && s.charAt(id) == '.') {
			id++;
			if (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9') {
				while (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9')
					id++;
			} else if (id < len && s.charAt(id) == 'e'&& id > 1 && s.charAt(id - 2) >= '0' && s.charAt(id - 2) <= '9')
				;
			else
				return id == len && len > 1 && s.charAt(id - 2) >= '0' && s.charAt(id - 2) <= '9';
		}

		if (id < len && s.charAt(id) == 'e') {
			id++;
			if (id < len && (s.charAt(id) == '+' || s.charAt(id) == '-'))
				id++;
			if (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9') {
				while (id < len && s.charAt(id) >= '0' && s.charAt(id) <= '9')
					id++;
			} else
				return false;
		}
		return id == len;
	}

	public static void main(String[] args) {
		String[] strs = {"005047e+6", ".e1","46.e3", ".", "3.", "", ".1", "0", " 0.1 ", "abc", "1 a", "2e10", " -90e3   ", " 1e", "e3",
				" 6e-1", " 99e2.5 ", "53.5e93", " --6 ", "-+3", "95a54e53" };
		boolean[] bs = {true,false, true, false, true, false, true, true, true, false, false, true, true, false, false, true,
				false, true, false, false, false };
//		boolean c = isNumber(strs[3]);
		for (int i = 0; i < strs.length; i++) {
			boolean b = isNumber(strs[i]);
			System.out.printf("%-12s", strs[i]);
			System.out.printf("%-12s", b);
			System.out.printf("%-12s", bs[i]);
			System.out.println();
		}
	}
}
