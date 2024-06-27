package com.bank.credit.service;

import java.util.List;

import com.bank.credit.document.Credit;

public interface CreditService {
	
	List<Credit> getCredit();
	Credit saveCredit(Credit credit);
	Credit editCredit(Credit credit);
	boolean deletedCredit(String id);
	Credit searchByCreditNumber(String creditNumber);
	Credit searchByPersonId(String personId);
}
