// Derek Song
// APCS1 pd1
// HW#19 - gcd 3 ways
// 2017-10-8

public class Stats {

    /* ==========PREVIOUS STATS HW=====================
    //finds mean of int values
    public static int intmean(int a, int b, int c) {
	int ans = (a + b + c) / 3;
	return ans;
    }

    //finds mean of double values
    public static double doublemean(double a, double b, double c) {
	double ans = (a + b + c) / 2;
	return ans;
    }

    //finds max of three int values
    public static int intmax3(int a, int b, int c) {
	if (a > b && a > c) {
	    return a;
	}
	else {
	    if (b > c) {
		return b;
	    }
	    else {
		return c;
	    }
	}
    }
    //finds max of two double values
    public static double doublemax(double a, double b, double c) {
	if (a > b && a > c) {
	    return a;
	}
	else {
	    if (b > c) {
		return b;
	    }
	    else {
		return c;
	    }
	}
    }

    //finds geometric mean for two int values
    public static int intGeoMean (int a, int b, int c) {
	int ans = a * b;
	return ans;
    }

    //finds geometric mean for two double values
    public static double doubleGeoMean (double a, double b, double c) {
        double ans = a * b;
	return ans;
    }

    //finds max of two int values
    public static int intmax2(int a, int b) {
	if (a > b) {
	    return a;
	}
	else {
	    return b;
	}
    }
    
    ====================END OF STATS BEGINNING OF GCD==================*/
    
    public static int intmin(int a, int b) {
	if (a > b) {
	    return b;
	}
	else {
	    return a;
	}
    }
    
    public static int gcd(int a, int b) {
	int x = 0;
	if (a == intmin(a,b)){
	    x = b;
	}
	else {
	    x = a;
	}
	while (!(((a % x) == 0) && ((b % x) == 0))) {
	    x -=1;
	}
	return x;
    }

    
    public static int gcdER (int a, int b) {
	if (((a % b)==0) ^ ((b % a) == 0)) {
	    if ((a % b) == 0) {
		return b;
		    }
	    else {
		return a;
	    }
	}
	else {
	    if (a > b) {
		a = a - b;
	    }
	    else {
		b = b - a;
	    }
	    if ((a == 0) || (b == 0)) {
		if (a == 0) {
		    return b;
		}
		else {
		    return a;
		}
		}
	    else {
		return gcdER (a,b);
	    }
	}	
    }
    public static int gcdEW (int a, int b) {
	if ((a % b) == 0) {
	    return a;
	}
	else{
	    while ((a != 0) && (b != 0)){
		if (a > b){
		    a = a - b;}
		else{
		    b = b - a;}

	    }}
	if (a == 0){
	    return b;
	}
	else{
	    return a;
	}}
    
    /* 
       Euclid's Algorithm
         if A is divisble by B then B is the GCD if not keep subtracting min 
         value from max value (overwriting the values each time) until one of
         them is 0, and if one of them is 0 the other number is the GCD
    */
    public static void main (String [] args) {
	System.out.println (gcd (15, 20));
	System.out.println (gcdER (25, 150));
    }
}
