package fileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this class write in 3 file
 * @author Buscarino Antonino
 *
 */
public class FileWrite {
	private static BufferedWriter fw;
	public static final String DIRECTORY = "database";
	
	/**
	 * create directory, if there isn't exist
	 */
	public static void mkdir() {
		if(new File(DIRECTORY).exists() == false) {
			new File(DIRECTORY).mkdir();
		}
	}
	
	/**
	 * add nickname in nickname.txt
	 * @param nickname
	 * @throws IOException
	 */
	public static void writeNickname(String line) throws IOException {
		fw = new BufferedWriter(new FileWriter(new File(DIRECTORY + "/nickname.txt"), true));
		fw.write(line);
		fw.close();
	}
	
	/**
	 * add nickname in password.txt
	 * @param password
	 * @throws IOException
	 */
	public static void writePassword(String line) throws IOException {
		fw = new BufferedWriter(new FileWriter(new File(DIRECTORY + "/password.txt"), true));
		fw.write(line);
		fw.close();
	}

	/**
	 * add nickname in balance.txt
	 * @param balance
	 * @throws IOException
	 */
	public static void writeBalance(String line) throws IOException {
		fw = new BufferedWriter(new FileWriter(new File(DIRECTORY + "/balance.txt"), true));
		fw.write(line);
		fw.close();
	}
	
	/**
	 * update nickname in balance.txt
	 * @param update balance
	 * @throws IOException
	 */
	public static void writeBalanceOver(String line) throws IOException {
		fw = new BufferedWriter(new FileWriter(new File(DIRECTORY + "/balance.txt")));
		fw.write(line);
		fw.close();
	}

}
