package bank;

import exception.balanceException;

/**
 * this class create a bank account
 * @author Buscarino Antonino
 */
public class BankAccount {
	protected double balance;
	protected String nickname, password;
	
	/**
	 * constructor
	 * @param password
	 */
	public BankAccount(String password) {
		this.password = password;
		balance = 0;
	}
	
	/**
	 * constructor
	 * @param nickname
	 * @param password
	 * @param balance
	 */
	public BankAccount(String nickname, String password, double balance) {
		this.nickname = nickname;
		this.password = password;
		this.balance = balance;
	}
	
	/**
	 * constructor
	 * @param nickname
	 * @param password
	 */
	public BankAccount(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
		balance = 0;
	}
	
	/**
	 * deposit ammount in bank account's balance
	 * @param ammount
	 * @throws balanceException 
	 */
	public void deposit(double ammount) throws balanceException {
		if(ammount < 0) {
			throw new balanceException();
		}
		balance += ammount;
	}
	
	/**
	 * withdrawal ammount in bank account's balance
	 * @param ammount
	 * @throws balanceException
	 */
	public void withdrawal(double ammount) throws balanceException {
		if(balance < ammount || ammount < 0) {
			throw new balanceException();
		}
		balance -= ammount;
	}
	
	/**
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * true is correct, false incorrect
	 * @param password
	 * @return boolean value
	 */
	public boolean checkPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		}
		return false;
	}

}
