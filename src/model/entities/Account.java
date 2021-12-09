package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double whithdrawLimit;

	public Account(Integer number, String holder, Double balance, Double whithdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.whithdrawLimit = whithdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWhithdrawLimit() {
		return whithdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
		} 
	private void validateWithdraw(double amount) {
		if (amount > getWhithdrawLimit()) {
			throw new DomainException("Erro de saque: A quantia excede o limite de saque");
		} 
		if (amount > getBalance()) {
			throw new DomainException("Erro de saque: Saldo insuficiente");
		}
	}

}
