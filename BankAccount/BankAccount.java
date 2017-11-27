// Derek Song
// APCS1 pd1
// HW#10 -- Mo Money Mo Problems/ Team Toot Toot Cabbage
// 2017-10-03

public class BankAccount {
    public  String AccountHolderName;
    public  String password;
    private int fourdigit;
    private int ninedigitaccount;
    public  double accountbalance;
    
    private static String DefBankAcc (String acctname) {
	String AccountHolderName = acctname;
	return AccountHolderName;
    }
    
    private static String DefPassword (String pass) {
	String password = pass;
	return password;
    }
    
    private static int setFourDig (int fourdig) {
	if ((fourdig > 1000) && (fourdig < 9998)) {
	    int fourdigit = fourdig;
	    return fourdig;
	}
	else {
	    if (fourdig > 9999) {
		system.out.println ("Too long");
	    }
	    else {
		system.out.println ("Too short");
	    }
	}
    }
    
    private static int DefNineDig (int ninedig) {
	if ((ninedig > 100000000) && (ninedig < 999999998)) {
		int ninedigitaccount = ninedig;
		return ninedigitaccount;
	    }
	    else {
		if (ninedig > 1000000000) {
		    system.out.println ("Too long");
		}
		else {
		    system.out.println ("Too short");
		}
	    }
    }
	    
    
    private static double DefAccountBalance (double balance) {
	double accountbalance = balance;
	return accountbalance;
    }
    
    public boolean withdraw (double withdrawamnt) {
	if (withdrawamnt < accountbalance) {
	    double accountbalance = accountbalance - withdrawamnt;
	    return true;
	}
	
	else {
	    double accountbalance = accountbalance;
	    return false;
		}
    }
	
    public boolean deposit (double depositamnt) {
	if (depositamnt > 0){
	    double accountbalance = accountbalance + depositamnt;
	    return true;
	}
	else {
	    return false;
				}
    }
    
    public static void main(String [] args) {
	System.out.println (DefBankAcc ("Derek"));
	System.out.println (DefPassword ("Derek's Password"));
	System.out.println (setFourDig (2958));
	System.out.println (DefNineDig (123456789));
	System.out.println (DefAccountBalance (560.00));
	System.out.println (withdraw (20.00));
	System.out.println (deposit (50.00));
    }
}
