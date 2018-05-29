/*****************************************************
 * class ListTester
 * ...for putting your LList through its paces
 * Assumes local version of List.java (interface),
 *  overriding List interface from standard Java library
 *****************************************************/

public class ListTester 
{
    public static void main( String[] args ) 
    {
	//instantiate... var type List, obj type LList
	List wu = new LList();

	System.out.println(wu);
	wu.add("RZA");

	System.out.println(wu);
	wu.add("GZA");

	System.out.println(wu);
	wu.add("ODB");

	System.out.println(wu);
	wu.add("Inspectah Deck");

	System.out.println(wu);
	wu.add("Raekwon the Chef");

	System.out.println(wu);
	wu.add("U-God");

	System.out.println(wu);
	wu.add("Ghostface");

	System.out.println(wu);
	wu.add("Method Man");

	System.out.println(wu);

	for( int i=0; i<7; i++ ) {
	    int n = (int)( wu.size() * Math.random() );
	    System.out.println("adding a poser at index " + n + "...");
	    wu.add( n, "@" );
	    System.out.println("Updated list: " + wu);
	}

	while( wu.size() > 0 ) {
	    int n = (int)( wu.size() * Math.random() );
	    System.out.println("deleting node "+ n + "...");
	    wu.remove(n);
	    System.out.println("Updated list: " + wu);
	}

	List who = new LList();

	System.out.println(who);
	who.addEnd("Wow");

	System.out.println(who);
	who.addEnd("I");

	System.out.println(who);
	who.addEnd("Actually");

	System.out.println(who);
	who.addEnd("Did");

	System.out.println(who);
	who.addEnd("It");

	System.out.println(who);
	who.addEnd("!");

	System.out.println(who);
	who.addEnd("Hi");

	System.out.println(who);
	who.addEnd("Dude");

	System.out.println(who);

    }
}//End class
