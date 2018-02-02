// Toot Toot Cabbage [Tania Cao, Derek Song, Kayli Matsuyoshi]
// APCS1 pd1
// HW10 -- Mo Money Mo Problems 
// 2017-10-03

public class BankAccount{
    
    // instance variables
    private String name;
    private String passwd;
    private int pin;
    private int acctNum;
    private float balance;
    
    // mutators
    public String setName(String newName){
	String oldName = name;
	name = newName;
	return oldName;
    }
    
    public String setPasswd(String newPasswd){
	String oldPasswd = passwd;
	passwd = newPasswd;
	return oldPasswd;
    }
    
    public int setPin(int newPin){
	int oldPin = pin;
	pin = newPin;
	return oldPin;
    }    

    public int setAcctNum(int newAcctNum){
	int oldAcctNum = acctNum;
	acctNum = newAcctNum;
	return oldAcctNum;
    }
    
    public float setBalance(float newBalance){
	float oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    public void deposit(float depositAmount){
	balance += depositAmount;
    }
    
    //    public void withdraw(float withdrawAmount){
    //        balance -= withdrawAmount;
    //    }
    
    // overwritten toString()
    public String toString(){
	String retStr = "\n Account Info: \n ====================";
	retStr += "\n Name: " + name;
	retStr += "\n Password: " + passwd;
	retStr += "\n PIN: " + pin;
	retStr += "\n Account Number: " + acctNum;
	retStr += "\n Balance: " + balance;
	return retStr;	
    }

    // main method for testing
    public static void main(String args[]){
	BankAccount chase = new BankAccount();
	chase.setPasswd("hello");
	chase.setAcctNum(123456789);
	chase.setName("Aidan");
	chase.setPin(2810);
	chase.deposit(237);
	// chase.withdrawAmount(208.58);
	System.out.println(chase.toString());
    } // end main()
    
} // end class BankAccount
