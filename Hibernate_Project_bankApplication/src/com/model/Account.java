package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
    /*private int password;*/
	
	@Id
	private long accNo;
	
	
	private String accHolderName;
	
	private String address;
	
	private long mobileNo;
	
	private long adharNo;
	
	private String panNo;
	
	private String gender;
	
	private double viewBalance;

	/*public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}*/

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGender() {
		return gender;
	}
	

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getViewBalance() {
		return viewBalance;
	}

	public void setViewBalance(double viewBalance) {
		this.viewBalance = viewBalance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accHolderName=" + accHolderName + ", address=" + address + ", mobileNo="
				+ mobileNo + ", adharNo=" + adharNo + ", panNo=" + panNo + ", gender=" + gender + ", viewBalance="
				+ viewBalance + "]";
	}
	
	
}

