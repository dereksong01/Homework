public class Greet3 {
 
    public static void main (String [] args) {
	String greeting;

	BigSib3 richard = new BigSib3("Word up ");
	BigSib3 grizz = new BigSib3("Hey ya ");
	BigSib3 tracy = new BigSib3("Sup ");
	BigSib3 dotCom = new BigSib3("Salutations ");

	greeting = richard.greet("freshmen");
	System.out.println(greeting);

	greeting = grizz.greet("Dr.Spaceman");
	System.out.println(greeting);

	greeting = tracy.greet("King Fooey");
	System.out.println(greeting);

	greeting = dotCom.greet("mom");
	System.out.println(greeting);
    }
}
