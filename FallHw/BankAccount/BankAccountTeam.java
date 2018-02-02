// Kathleen Wong, Lynne Wang, Kerwin Chen (team: KerwinTheFrog)
// APCS1 pd1
// HW10 -- Mo Money Mo Problems
// 2017-10-04 

public class BankAccountTeam
{
  //instance variables
  private String name;
  private String passwd;
  private int pin;
  private int acctNum;
  private double balance;


  //mutators
  public String setName( String newName )
  {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd )
  {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public int setPin( int newPin )
  {
    int oldPin = pin;
    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum )
  {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum;
    return oldAcctNum;
  }

  public double setBalance( double newBalance )
  {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }

  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public void withdraw( double withdrawAmount ) {
      if (balance >= withdrawAmount) {
	  balance -= withdrawAmount;
	  System.out.println("\nWithdraw successful: " + true);
      }
      else {
	  System.out.println("\nWithdraw successful: " + false);	  
	  System.out.println("***You cannot withdraw more money than you own. Tsk tsk.***");
      }
  }
	  


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    if (pin >= 1000 && pin <= 9998) {
	retStr = retStr + "\nPIN: " + pin;
    }
    else {
	retStr = retStr + "\nPIN: " + 9999 + "\n***Error - Pin must be 4-digit and cannot start with 0***";
    }
    if (acctNum >= 100000000 && acctNum <= 999999998) {
	retStr = retStr + "\nAccount Number: " + acctNum;
    }
    else {
	retStr = retStr + "\nAccount Number: " + 999999999 + "\n***Error - Account number must be 9-digit and cannot start with 0***";
    }    
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }

    //Authentication methods
    public Boolean authenticate (String trypasswd , int tryacctNum){
	if ((trypasswd == passwd) && (tryacctNum == acctNum)) {
	    return true;
	}
	else {
	    return false;
		}
    }


  //main method for testing
  public static void main( String[] args )
  {
      BankAccount test = new BankAccount();
      test.setName("Lynne");
      test.setPasswd("mumbojumbo11");
      test.setPin(111);
      test.setAcctNum(11111111);
      test.setBalance(99.09);
      System.out.print("\nDid you commit an act of ignorance?\n^^^^^^^^^^^^^^^^^^^^^^^^^^^");      
      test.deposit(1000);
      test.withdraw(10000);
      System.out.print("Authenticated: ");
      System.out.println(test.authenticate("mumbojumbo11",11111111));
      System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
      System.out.println(test.toString());
  }//end main()

}//end class BankAccount
