package com.bank.credit.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "credit")
public class Credit {
	@Id
	private String id;
	private String personId;
	private String creditType;
	private String creditNumber;
	private String currency;
	private float initialSAmount;
	private float currentAmount;
	private boolean isActive;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getInitialSAmount() {
		return initialSAmount;
	}
	public void setInitialSAmount(float initialSAmount) {
		this.initialSAmount = initialSAmount;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Credit(String id, String personId, String creditType, String creditNumber, String currency,
			float initialSAmount, float currentAmount, boolean isActive) {
		super();
		this.id = id;
		this.personId = personId;
		this.creditType = creditType;
		this.creditNumber = creditNumber;
		this.currency = currency;
		this.initialSAmount = initialSAmount;
		this.currentAmount = currentAmount;
		this.isActive = isActive;
	}
	public Credit() {
		super();
	}
	@Override
	public String toString() {
		return "Credit [id=" + id + ", personId=" + personId + ", creditType=" + creditType + ", creditNumber="
				+ creditNumber + ", currency=" + currency + ", initialSAmount=" + initialSAmount + ", currentAmount="
				+ currentAmount + ", isActive=" + isActive + "]";
	}
	
	
}
