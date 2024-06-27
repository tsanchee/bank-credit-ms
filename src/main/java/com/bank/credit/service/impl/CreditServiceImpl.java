package com.bank.credit.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.credit.constant.PersonType;
import com.bank.credit.document.Credit;
import com.bank.credit.repository.CreditRepository;
import com.bank.credit.service.CreditService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CreditServiceImpl implements CreditService {
	
	@Autowired
	private CreditRepository creditRepository;
	
	@Value("${api.people.endpoint}")
	private String personEndpoint;
	
	public List<Credit> getCredit() {
		return creditRepository.findAll();
	}
	
	public String getPersonType(String personId){
		String personType="";
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(personEndpoint, String.class, personId);
	    try {
	    	Map<String, String> map = mapper.readValue(result, Map.class);
	    	personType=map.get("personType");
		} catch (IOException e) {
            e.printStackTrace();
		}
	    return personType;
	}
	public Credit saveCredit(Credit credit) {
		Credit newCredit = null;
		String personType=getPersonType(credit.getPersonId());
		if (personType.equals(PersonType.PERSONAL.toString())) {
			Credit cr= creditRepository.findByPersonId(credit.getPersonId());
			if (cr==null) {
				newCredit= creditRepository.save(credit);
			}else {
				System.out.println("El cliente ya tiene un credito");
			}
		}else if (personType.equals(PersonType.EMPRESARIAL.toString())) {
			newCredit= creditRepository.save(credit);
		}else if (personType.equals(PersonType.CREDIT_CARD.toString())) {
			newCredit= creditRepository.save(credit);
		}
		return newCredit;
	}

	public Credit editCredit(Credit credit) {
		return creditRepository.save(credit);
	}

	public boolean deletedCredit(String id) {
		boolean deleted= false;
		try {
			creditRepository.deleteById(id);
			deleted=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	public Credit searchByPersonId(String personId) {
		return creditRepository.findByPersonId(personId);
	}

	public Credit searchByCreditNumber(String creditNumber) {
		return creditRepository.findByCreditNumber(creditNumber);
	}

}
