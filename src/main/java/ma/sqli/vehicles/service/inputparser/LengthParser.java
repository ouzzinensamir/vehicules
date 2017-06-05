package ma.sqli.vehicles.service.inputparser;

public class LengthParser {

	public static double getLength(String input) {
		String[] inputSplitted = input.split(" ");
		return Double.parseDouble(inputSplitted[0]);
	}
}
