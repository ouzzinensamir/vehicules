package ma.sqli.vehicles.inputparser;

public class LengthParser {

	public static int getLength(String input) {
		String[] inputSplitted = input.split(" ");
		return Integer.parseInt(inputSplitted[0]);
	}
}
