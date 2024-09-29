import java.util.*;

public class Banking_App {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //create initial accounts
        System.out.println("How many number of customers do you want to input?");
        int n = sc.nextInt();
        BankDetails customer[] = new BankDetails[n];
        for(int i=0; i<customer.length; i++) {
            customer[i] = new BankDetails();
        }

        // loop runs until number 5 is not pressed to exit

        int ch;
        do {
            System.out.println("***Banking System Application***");
            System.out.println(" 1. Display all account details \n 2. Search by Account number \n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
                switch(ch) {
                    case 1:
                        for(int i = 0; i<customer.length; i++) {
                            customer[i].showAccount();
                            break;
                        }

                    case 2:
                        System.out.print("Enter account no. you want to search: ");
                        String acc_no = sc.next();
                        boolean found = false;
                        for(int i=0; i<customer.length; i++){
                            found = customer[i].search(acc_no);
                            if(found) {
                                break;
                            }
                        }
                        if(! found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;
                    
                    case 3:
                        System.out.println("Enter account no. :");
                        acc_no = sc.next();
                        found = false;
                        for(int i=0; i<customer.length; i++){
                            found = customer[i].search(acc_no);
                            if(found) {
                                customer[i].deposit();
                                break;
                            }
                        }
                        if(! found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;

                    case 4:
                        System.out.println("Enter Account no. :");
                        acc_no = sc.next();
                        found = false;
                        for(int i=0; i<customer.length; i++){
                            found = customer[i].search(acc_no);
                            if(found) {
                                customer[i].withdrawal();
                                break;
                            }
                        }
                        if(! found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;

                    case 5:
                        System.out.println("See you soon...");
                        break;
                        
                }
        }
        while(ch != 5);
    }
}

class BankDetails {
    String accno;
    String name;
    String acc_type;
    long balance;

    Scanner sc = new Scanner(System.in);

    //method to open new account

    BankDetails() {
        System.out.println("Enter Name: ");
        name = sc.next();
        System.out.println("Enter Account No: ");
        accno = sc.next();
        System.out.println("Enter account type: ");
        acc_type = sc.next();
        System.out.println("Enter Balance: ");
        balance = sc.nextLong();
    }

    // method to display account details

    public void showAccount() {
        System.out.println("Name of the account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    // method to deposit money 

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    // method to withdraw money

    public void withdrawal() {
        long amt;
        System.out.println("Enter the amont you want to withdraw: ");
        amt = sc.nextLong();
        if(balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal : " + balance);
        }
        else {
            System.out.println("Your balance is less than" + amt + "\tTransaction failed....!!!");
        }
    }

    // method to search an account number
    public boolean search(String acc_no) {
        if(accno.equals(acc_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}