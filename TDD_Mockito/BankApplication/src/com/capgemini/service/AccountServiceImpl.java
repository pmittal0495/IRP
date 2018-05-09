package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	
	AccountRepository accountRepository;
	private int amount;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientInitialAmountException
	{
		int a,b,c;
		if(amount<500)
		{
			throw new InsufficientInitialAmountException();
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		 
		if(accountRepository.save(account))
		{
			return account;
		}
	     
		return null;
		
	}

	public int depositamount(int accountNumber,int newamount) throws InvalidAccountNumberException
	{
		/*Account account = new Account();
		account.getAccountNumber();
		
		account.getAmount();
		 
	
		if(account.getAccountNumber() == accountNumber)
		{
			amount = account.setAmount() + amount;
			//throw new InsufficientInitialAmountException();
		}
		//Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(newamount);
		 
		if(accountRepository.readAccount(account)
		{
			amount=newamount + amount;
			return account;
		}
	     
		return null;*/
		
		Account account = accountRepository.searchAccount(accountNumber);
		if(account==null)
			throw new InvalidAccountNumberException();
		
		account.setAmount(account.getAmount()+amount);
		
		return account.getAmount();
		
	}


	public int withdrawlAmount(int accountNumber,int newamount) throws InvalidAccountNumberException, InsufficientInitialAmountException
	{

		Account account = accountRepository.searchAccount(accountNumber);
		if(account==null)
			throw new InvalidAccountNumberException();
		
		account.setAmount(account.getAmount()-amount);
		
		if(account.getAmount() < amount)
			throw new InsufficientInitialAmountException();
		return account.getAmount();
		
		
		
	}
	
}
