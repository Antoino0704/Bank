package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class read 3 file 
 * @author Buscarino Antonino
 *
 */
public class FileRead {
	private BufferedReader frN, frP, frB;
	private final String DIRECTORY = "database";
	
	/**
	 * initialize all file read object
	 * @throws FileNotFoundException
	 */
	public void initFile() throws FileNotFoundException {
		frN = new BufferedReader(new FileReader(new File(DIRECTORY + "/nickname.txt")));
		frP = new BufferedReader(new FileReader(new File(DIRECTORY + "/password.txt")));
		frB = new BufferedReader(new FileReader(new File(DIRECTORY + "/balance.txt")));
	}
	
	/**
	 * 
	 * @return nickname
	 * @throws IOException
	 */
	public String readNickname() throws IOException {
		return frN.readLine();
	}
	
	/**
	 * 
	 * @return password
	 * @throws IOException
	 */
	public String readPassword() throws IOException {
		return frP.readLine();
	}

	/**
	 * 
	 * @return balance
	 * @throws IOException
	 */
	public String readBalance() throws IOException {
		return frB.readLine();
	} 
	
	/**
	 * close all file read object
	 * @throws IOException
	 */
	public void close() throws IOException {
		frN.close();
		frP.close();
		frB.close();
	}

}
