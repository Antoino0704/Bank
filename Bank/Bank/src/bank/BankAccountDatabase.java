package bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import exception.EqualsNickNameException;
import exception.NicknameNotFoundException;
import exception.PasswordException;
import fileManager.FileRead;
import fileManager.FileWrite;

/**
 * this class create bank account that communicate with a database
 * @author Buscarino Antonino
 *
 */
public class BankAccountDatabase extends BankAccount {
	private int position;
	
	/**
	 * constructor
	 * @param nickname
	 * @param password
	 * @param balance
	 */
	public BankAccountDatabase(String nickname, String password, double balance) {
		super(nickname, password, balance);
		position = 0;
	}
	
	/**
	 * constructor
	 * @param nickname
	 * @param password
	 * @throws FileNotFoundException
	 */
	public BankAccountDatabase(String nickname, String password) throws FileNotFoundException {
		super(nickname, password);
		position = 0;
	}
	
	// this method create fileRead object and return it
	private FileRead createFileRead() throws FileNotFoundException {
		FileRead fr = new FileRead();
		fr.initFile();
		return fr;
	}
	
	/**
	 * check if nickname exist, if not exist write bank account's provisional nickname in nickname.txt file
	 * @throws IOException
	 * @throws EqualsNickNameException
	 */
	public void writeNickname() throws IOException, EqualsNickNameException {
		String line;
		if(new File(FileWrite.DIRECTORY + "/nickname.txt").exists()) {
			FileRead fr = createFileRead();
			while((line = fr.readNickname()) != null) {
				if(line.equals(nickname)) {
					throw new EqualsNickNameException();
				}
			}
			fr.close();
		}
		FileWrite.writeNickname(nickname + "\n");
	}
	
	/**
	 * write bank account's provisional password in password.txt file
	 * @throws IOException
	 */
	public void writePassword() throws IOException {
		FileWrite.writePassword(password + "\n");
	}
	
	/**
	 * write bank account's provisional balance in balance.txt file
	 * @throws IOException
	 */
	public void writeBalance() throws IOException {
		FileWrite.writeBalance(Double.toString(balance) + "\n");
	}
	
	/**
	 * modify bank account's balance with bank account's provisional balance
	 * @throws IOException
	 */
	public void modifyWriteBalance() throws IOException {
		StringBuilder sb = new StringBuilder();
		FileRead fr = createFileRead();
		int count = 1;
		String line;
		
		while((line = fr.readBalance()) != null) {
			if(count == position) {
				line = Double.toString(balance);
			}
			sb.append(line + System.lineSeparator());
			count++;
		}
		
		fr.close();
		FileWrite.writeBalanceOver(sb.toString());
	}
	
	/**
	 * read all nickname as far as when there is a match, if there isn't launch NicknameNotFoundException
	 * @throws IOException
	 * @throws NicknameNotFoundException
	 */
	public void readNickname() throws IOException, NicknameNotFoundException {
		boolean check = false;
		String line;
		FileRead fr = createFileRead();
		while((line = fr.readNickname()) != null && check == false) {
			if(line.equals(nickname)) {
				check = true;
			}
			position++;
		}
		fr.close();
		
		if(check == false) {
			throw new NicknameNotFoundException();
		}
	}
	
	/**
	 * read all password as far as correct password
	 * @throws IOException
	 * @throws PasswordException
	 */
	public void readPassword() throws IOException, PasswordException {
		String password = null;
		FileRead fr = createFileRead();
		for(int i=0; i<position; i++) {
			password = fr.readPassword();
		}
		fr.close();
		
		if(checkPassword(password) == false) {
			throw new PasswordException();
		}
	}
	
	/**
	 * read all balance as far as corresponding balance
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void readBalance() throws NumberFormatException, IOException {
		FileRead fr = createFileRead();
		for(int i=0; i<position; i++) {
			balance = Double.parseDouble(fr.readBalance());
		}
		fr.close();
	}
}
