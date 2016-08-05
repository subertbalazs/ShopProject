
public class CustomValidators {

	public static boolean validateInt() {
		String regex = "^(0|[1-9][0-9]*)$";
		if (!regex.matches(regex)) {

		}

		return true;
	}

	public static boolean validateDouble() {
		return true;
	}

	public static boolean validateDate() {
		return true;
	}

}
