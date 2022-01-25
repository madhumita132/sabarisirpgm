package bank;
import java.util.Date;
public class Account {
private String name;
private String accountNumber;
private Double balance;
private Date stateDate;
public Account(String name, String accountNumber, Double balance, Date stateDate) {
	super();
	this.name = name;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.stateDate = stateDate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}

public Date getStateDate() {
	return stateDate;
}

public void setStateDate(Date stateDate) {
	this.stateDate = stateDate;
}
}