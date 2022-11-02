package Admin;

import java.util.Scanner;

import com.model.Account;
import com.Service.RBI;
import com.ServiceImpl.SBI;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Added for practise");

		Scanner sc = new Scanner(System.in); 
		SBI sbi = new SBI();

		boolean b = true;

		while (b) {
			System.out.println(" ");
			System.out.println("Enter 1 for creating new Account");
			System.out.println("Enter 2 for view account details");
			System.out.println("Enter 3 for withdrawl money");
			System.out.println("Enter 4 for deposit money");
			System.out.println("Enter 5 for update details");
			System.out.println("Enter 6 for view balance");
			System.out.println("Enter 7 for Exit");

			switch (sc.nextInt()) {
			case 1:
				sbi.createAccount();
				System.out.println("********Account created successfully********");
				break;

			case 2:
				sbi.viewAccountDetails();
				break;

			case 3:
				sbi.withdrawlMoney();
				break;

			case 4:
				sbi.depositeMoney();
				break;

			case 5:
				sbi.updateDetails();
				break;

			case 6:
				sbi.viewbalance();
				System.out.println("Thank You for transaction");
				break;

			case 7:
				System.out.println("Thank You for visit");
				b = false;
				break;

			default:
				System.out.println("Invalid input from you");
				break;
			}
		}

	}

}
