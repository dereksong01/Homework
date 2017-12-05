// Derek Song
// APCS1 pd1
// HW#16 -- Get It While You Can
// 2017-10-15

public class Coin {
    double value;
    String upFace;
    String name;
    int flipCtr;
    int headsCtr;
    int tailsCtr;
    double bias;

    //methods
    public Coin() {
        setupFace(null);
	setname (null);
	setbias (0.5);
    }

   public Coin (String coin) {
	this();
        setname (coin);
    }
    
    public Coin (String coin, String face) {
	this();
        setname (coin);
        setupFace (face);
    }

   
    
    //mutators
    public String setname (String newName) {
	String old = name;
	if ((newName == "penny") || (newName == "nickle")
	    || (newName == "dime") || (newName == "quarter")
	    || (newName == "half-dollar") || (newName == "dollar")) {
	    name = newName;
	}
	return old;
    }

    public String setupFace (String face) {
	String old = upFace;
	if ((face == "heads") || (face == "tails")) {
	    upFace = face;
	}
	return old;	       
    }

    public double setvalue (String name) {
	double old = value;
	if (name == "penny") {
	    value = 0.01;
		}
	if (name == "nickel") {
	   value = 0.05;
		}
	if (name == "dime") {
	   value = 0.1;
		}
	if (name == "quarter") {
	    value = 0.25;
		}
	if ((name == "half-dollar") || (name == "halfdollar")) {
		value = 0.5;
		    }
	if (name == "dollar") {
	    value = 1;
		}
	return old;
    }
	
    public double setbias (double yes) {
	double old = bias;
	if (yes != bias) {
	    bias = yes;
	}
	return old;
    }
    
    //flip()
    public String flip () {
	double randDbl = Math.random();
	if (randDbl > bias) {
	    upFace = "heads";
	    headsCtr += 1;
	}
	else {
	    upFace = "tails";
	    tailsCtr += 1;
	}
	flipCtr += 1;
	return upFace;
    }

    //toString ()
    public String toString () {
        return (name + "--" + upFace);
    }

    //equals()
    public boolean equals (Coin name) {
        return upFace.equals(name.upFace);
    }

    public void assignValue (String name) {
	setvalue (name);
    }
}
