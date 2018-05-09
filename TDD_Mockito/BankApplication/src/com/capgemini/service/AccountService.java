package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialAmountException;
import com.capgemini.model.Account;
import com.capgemini.exceptions.InvalidAccountNumberException;


public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientInitialAmountException;
    int depositAmount(int accountNumber, int newamount) throws InvalidAccountNumberException;
    int withdrawlAmount(int accountNumber, int newamount) throws InvalidAccountNumberException,  InsufficientInitialAmountException;
}