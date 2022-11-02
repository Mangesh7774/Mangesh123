package com.ServiceImpl;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Account;
import com.Hibernateutil.Hibernateutil;
import com.Service.RBI;

public class SBI implements RBI {

	Session session = null;
	Account ac = new Account();
	Scanner sc = new Scanner(System.in);
	final String Employeeid = "SBI1234";

	@Override
	public void createAccount() {
		Session session = Hibernateutil.getSessionFactory().openSession();

		System.out.println("Enter account No :");
		boolean b = true;
		while (b) {
			ac.setAccNo(sc.nextLong());

			if (ac.getAccNo() >= 10l && ac.getAccNo() <= 9999999999l) {
				System.out.println("Account succesfully done");
				b = false;
			}

			else {
				System.out.println("Please enter valid account no");

			}
		}

		System.out.println("Enter account holderName :");
		ac.setAccHolderName(sc.next() + sc.nextLine());

		System.out.println("Enter account holder Address :");
		ac.setAddress(sc.next() + sc.nextLine());

		System.out.println("Enter account holderMobile No :");
		ac.setMobileNo(sc.nextLong());

		System.out.println("Enter account holder Adhar No :");
		ac.setAdharNo(sc.nextLong());

		System.out.println("Enter account holder Pan No :");
		ac.setPanNo(sc.next());

		System.out.println("Enter account holder gender :");
		ac.setGender(sc.next());

		System.out.println("Enter account balance :");
		ac.setViewBalance(sc.nextDouble());

		session.save(ac);
		session.beginTransaction().commit();
	}

	@Override
	public void viewAccountDetails() {

		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		boolean b = true;
		while (b) {
			System.out.println("Enter customer Account no");
			long cust_ac_no = sc.nextLong();

			Account ac = session.get(Account.class, cust_ac_no);

			try {

				if (cust_ac_no == (ac.getAccNo())) {
					System.out.println(ac);
				}

			} catch (NullPointerException e) {

				System.out.println("Wrong account no entered");
			}
		}

		session.save(ac);
		tx.commit();
	}

	@Override
	public void withdrawlMoney() {

		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		boolean b = true;
		while (b) {
			try {

				System.out.println("Enter customer Account no");
				long cust_ac_no = sc.nextLong();
				Account ac = session.get(Account.class, cust_ac_no);

				if (cust_ac_no == ac.getAccNo()) {
					System.out.println("Enter the withdraw Ammount in Rs. :");
					double wamt = sc.nextDouble();

					double updatedBalance = ac.getViewBalance() - wamt;
					if (updatedBalance >= 500) {

						ac.setViewBalance(ac.getViewBalance() - wamt);

						System.out.println("Rs." + wamt + " Is debited from your account");
						System.out.println("Your currnet balance is Rs." + ac.getViewBalance());
						b = false;
					}

					else {
						System.out.println("You have to maintain min amount Rs.500 in your bank account");
					}
				}

			}

			catch (NullPointerException e) {
				System.out.println("Wrong Account no. Entered");
			}

		}
		session.save(ac);
		tx.commit();
	}

	@Override
	public void depositeMoney() {

		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		long cust_no = sc.nextLong();
		
		Account ac = session.get(Account.class, cust_no);

		if (cust_no==ac.getAccNo()) {

			System.out.println("Enter the deposite amount in Rs.");
			double damt = sc.nextInt();
			ac.setViewBalance(ac.getViewBalance() + damt);
			System.out.println("Rs." + damt + " Is deposited in your account");
			System.out.println("Your current balance is in Rs. " + ac.getViewBalance());
		}
		
		else {
			System.out.println("***** S O R R Y *****");
			System.out.println("Need to create account first");
		}

		tx.commit();
	}

	@Override
	public void updateDetails() {
		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("******SORRY******Work in progress");

		tx.commit();
	}

	@Override
	public void viewbalance() {
		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		if (ac.getAccHolderName() != null && ac.getAccNo() != 0.0d) {
			double bal = ac.getViewBalance();
			System.out.println("Your account balance is Rs." + bal);
		} else {
			System.out.println("***** S O R R Y *****");
			System.out.println("Need to create account first");
		}

		tx.commit();
	}

}
