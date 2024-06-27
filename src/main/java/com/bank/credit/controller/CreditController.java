package com.bank.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.credit.document.Credit;
import com.bank.credit.service.CreditService;

@RestController
public class CreditController {
	
	@Autowired
	private CreditService creditService;
	
	@GetMapping(value = "/api/v1/credits")
	@ResponseBody List<Credit> getCredit(){
		return creditService.getCredit();
	}
	@PostMapping(value = "/api/v1/credits")
	@ResponseBody Credit saveCredit(@RequestBody Credit credit){
		return creditService.saveCredit(credit);
	}
	@PutMapping(value = "/api/v1/credits")
	@ResponseBody Credit editCredit(@RequestBody Credit credit){
		return creditService.editCredit(credit);
	}
	@DeleteMapping(value = "/api/v1/credits/{id}")
	@ResponseBody boolean deletedCredit(@PathVariable String id){
		return creditService.deletedCredit(id);
	}
	@GetMapping(value = "/api/v1/credits/numbers/{creditNumber}")
	@ResponseBody Credit searchByCreditNumber(@PathVariable String creditNumber){
		return creditService.searchByCreditNumber(creditNumber);
	}
	@GetMapping(value = "/api/v1/credits/ids/{personId}")
	@ResponseBody Credit searchByPersonId(@PathVariable String personId){
		return creditService.searchByPersonId(personId);
	}
}
