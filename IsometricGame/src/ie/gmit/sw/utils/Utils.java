package ie.gmit.sw.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Returns text file with created environment.
 * Loops every line in file and checks the id number for each tile.
 * @author Kamila
 *
 */
public class Utils {

	public static String loadFile(String path) {

		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				sb.append(line + "\n");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();

	}
	/**
	 * @param number Takes string and converts it to the number for each tile
	 * @return default number
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
}
