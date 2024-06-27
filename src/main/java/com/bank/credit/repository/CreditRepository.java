package com.bank.credit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.credit.document.Credit;

public interface CreditRepository extends MongoRepository<Credit, String> {
	Credit findByCreditNumber(String creditNumber);
	Credit findByPersonId(String personId);

}
