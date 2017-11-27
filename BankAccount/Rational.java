// Derek Song
// APCS1 - pd1
// HW#37 - Be More Rational
// 2017 - 11 - 20

public class Rational {
    
    //Instance Vars
    int numer;
    int denom;

    //Default Constructor
    public Rational() {
	numer = 0;
	denom = 1;
    }

    //Constructor
    public Rational (int num, int den) {
	this();
	if (den != 0) { //undefined if den = 0
	    numer = num;
	    denom = den;
	}	
    }

    //toString
    public String toString() {
	return numer + "/" + denom;
    }

    //floatValue
    public double floatValue() {
	return (double) numer / denom;
	
    }

    //multiply
    public void multiply(Rational x) {
	numer = numer * x.numer;
	denom = denom * x.denom;
    }

    //divide
    public void divide(Rational x) {
	numer = numer * x.denom;
	denom = denom * x.numer;
    }

    // ===============HW 37====================

    //add
    public void add(Rational x) {	
	numer = (denom * x.numer) + (x.denom * numer) ; // multiplying the numerators by the other rational number's denominator and add them
	denom = denom * x.denom ; // common denom by multiplying the two denom
    }

    //subtract
    public void subtract(Rational x) {
	numer = (numer * x.denom) - (x.numer * denom); // order matters here
	denom = denom * x.denom;
    }
    /*
    //helper function for gcd
    public static int intmin(int a, int b) {
	if (a > b) {
	    return b;
	}
	else {
	    return a;
	}
    }
    */
    
    //gcd
    public static int gcd(int numer, int denom) { //reused code
	int x = 0;
	if (numer == Math.min(numer, denom)){
	    x = denom;
 	}
	else {
	    x = numer;
	}
	while (!(((numer % x) == 0) && ((denom % x) == 0))) {
	    x -=1;
	}
	return x;
    }

    public void reduce() {
	int more = Math.max(numer, denom); // holder for bigger value
	int less = Math.min(numer, denom); // holder for smaller value
	int divisor = gcd(more, less); // finds gcd
	numer = numer / divisor;
	denom = denom / divisor; 
    }

    public int compareTo(Rational x) {
	if (this.floatValue() == x.floatValue()) { 
	    return 0;
	}
	if (this.floatValue() > x.floatValue()) {
	    return 1;
	}
	else {
	    return -1;
	}
    }
    
    public static void main(String [] args) {
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);

	System.out.println("original r: " + r); // shows before operation
	System.out.println("original s: " + s);
	System.out.println("======after multiply=======");
	
        r.multiply(s);
	System.out.println("multiplied r: " + r); // after operation
	System.out.println("multiplied s: " + s);
	System.out.println("---------------------------");

	Rational R = new Rational (2,3);
	Rational S = new Rational (1,2);

	
	System.out.println("original R: " + R); // shows before operation
	System.out.println("original S: " + S);
	System.out.println("======after divide=======");

	R.divide(S);
	System.out.println("divided R: " + R); // shows before operation
	System.out.println("divided S: " + S);
	System.out.println("---------------------------");

	Rational Y = new Rational (2,3);
	Rational Z = new Rational (1,2);

	
	System.out.println("original Y: " + Y); // shows before operation
	System.out.println("original Z: " + Z);
	System.out.println("======after add=======");

	Y.add(Z);
	System.out.println("added Y: " + Y); // shows before operation
	System.out.println("added Z: " + Z);
	System.out.println("---------------------------");

	Rational A = new Rational (2,3);
	Rational B = new Rational (1,2);

	
	System.out.println("original A: " + A); // shows before operation
	System.out.println("original B: " + B);
	System.out.println("======after subtract=======");

	A.subtract(B);
	System.out.println("subtracted A: " + A); // shows before operation
	System.out.println("subtracted B: " + B);
	System.out.println("---------------------------");

	Rational a = new Rational (2,3);
	Rational b = new Rational (1,2);

	
	System.out.println("original a: " + a); // shows before operation
	System.out.println("original b: " + b);
	System.out.println("======after operation=======");
	
	a.multiply(b);
	System.out.println("multiplied a: " + a); // shows before reduction
	System.out.println("======after reduction=======");

	a.reduce();
	System.out.println("reduced a: " + a);
	System.out.println("---------------------------");

	Rational one = new Rational(1,3);
	Rational two = new Rational(2,3);
	Rational three = new Rational(5,3);
	Rational four = new Rational(1,3);

	
	System.out.println(one.compareTo(four));
	System.out.println(two.compareTo(three));
	System.out.println(three.compareTo(one));
	
    }
}
