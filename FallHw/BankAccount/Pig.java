/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/
//Team Kick All Dinosaurs (Kenny Li, Addison Huang, Derek Song)
//Derek Song
//APCS1 - pd1
//Hw#24 -- Imetay Otay Ineshay
//2017-10-25

/* pigLatin translator for a string containing spaces
   pigLatin translator for a string with punctuation and capitalization
   Y moves to the end if it is the first letter of a word
   Y is vowel like if there are no vowels in the word
*/

public class Pig {
    //Q: How does this initialization make your life easier?
    //This is a string containing all the vowels that we can reference in our code
    private static final String VOWELS = "aeiou";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/

    /*indexOf returns -1 if the value is not in the String
      So, if it returns anything other than -1 it means it is in the string
      Thus, hasA will return true, else it will return false*/
    public static boolean hasA( String w, String letter ) {
        return w.indexOf(letter) != -1;
    }//end hasA()

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/

    /*Since we already wrote a function that returns whether 
      a character is in a string, I used that function to 
      check whether the letter was in VOWELS. If it is,
      this returns true, else false*/

    public static boolean isAVowel( String letter ) {
    	return hasA(VOWELS, letter);
    }//end isAVowel()

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/

    /*countVowels counts the vowels in string w by iterating through 
      every character in the string using a for loop. If the character 
      is a vowel, 1 is added to the counter(the number of vowels). The counter is returned.
    */
    public static int countVowels( String w ) {
      	int counter = 0;
      	w = w.toLowerCase();
      	for(int x=0; x < w.length() ; x++) {
	    if (isAVowel(w.substring(x, x+1))) {
          	counter += 1;
	    }
      	}
      	return counter;
    }//end countVowels
  
    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/

    /*hasAVowel calls countVowels
      if countVowels is not equal to 0, it obviously has a vowel 
      so hasAVowel returns true, else false
    */
    public static boolean hasAVowel( String w ) {
    	return countVowels(w) != 0;
    }//end hasAVowel


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/

    /*allVowels iterates through each character of String w
      if the character is a vowel, that character is appended to output,
      the string of all vowels in string w
      the outpit is returned
    */
    public static String allVowels( String w ) {
    	String output = "";
    	w.toLowerCase();
    	for (int x=0; x < w.length() ; x++) {
	    if (isAVowel(w.substring(x,x+1))) {
		output += w.substring(x, x+1); 
	    }
    	}
	return output;
    } //end allVowels
    
    
    //pre: w != null
    //post: firstVowel("") --> ""
    //      firstVowel("zzz") --> ""
    //      firstVowel("meatball") --> "e"
    
    public static String firstVowel(String w) {
    	if (hasAVowel(w)) 
	    return allVowels(w).substring(0,1);
    	return "";
    }
    
    //pre: w != null and w.length() > 0
    //post: beginsWithVowel("apple")  --> true
    //      beginsWithVowel("strong") --> false
    public static boolean beginsWithVowel(String w) { 
    	return isAVowel(w.substring(0,1)); 
    }
				
    //pre: w.length() > 0
    //post: engToPig("apple")  --> "appleway"
    //      engToPig("strong") --> "ongstray"
    //      engToPig("java")   --> "avajay"

    public static String engToPig(String w) {
    	if (beginsWithVowel(w)) {
	    return w + "way";
	} else {
	    int firstY = w.indexOf("y");
	    int firstVowel = w.indexOf(firstVowel(w));
	    if (firstY == 0) { 
		return w.substring(1) + "yay";
	    }
	    else if (((firstY < firstVowel) && (firstY != -1)) || (firstVowel == 0)) {
		firstVowel = firstY;
	    }
	    return w.substring(firstVowel) + w.substring(0, firstVowel) + "ay";
	}
    }
		
    public static String toCapitalize(String w) {
	if (w.substring(0,1).toLowerCase().equals(w.substring(0,1))) {
	    w = w.toLowerCase();
	    return engToPig(w);
	} else {
	    w = engToPig(w.toLowerCase());
	    w = w.substring(0,1).toUpperCase() + w.substring(1);
	    return w;
	}
    }

    public static String toPunctuate(String w) {
	String upper = w.toUpperCase();
	String lower = w.toLowerCase();
	String finalString = "";
	int previousPunct = 0;
	for (int x = 0; x < w.length(); x++) {
	    if (upper.substring(x, x + 1).equals(lower.substring(x, x + 1))) {
		finalString = finalString + toCapitalize(w.substring(previousPunct, x)) + w.substring(x, x + 1);
		previousPunct = x + 1;
	    }
	}
	if (previousPunct == w.length()) {
	    return finalString;
	} else {
	    return finalString + toCapitalize(w.substring(previousPunct));
	}
    }
		
    public static String toSentence(String w) {
	String finalString = "";
	if (w.indexOf(" ") == -1) {
	    return toPunctuate(w);
	} else {
	    for (int x = w.indexOf(" "); x != -1; x = w.indexOf(" ")) {
		finalString = finalString + toPunctuate(w.substring(0, x)) + " ";
		w = w.substring(x + 1);
	    }
	}
	return finalString + toPunctuate(w);
    }		

    public static void main(String[] args) {
    	System.out.println("---Testing of hasA---");
	System.out.println("Does cat have an a? " + hasA("cat", "a")); //true
	System.out.println("Does cat have a p? " + hasA("cat", "p")); //false
	System.out.println("---Testing of isaVowel ---");
	System.out.println("Is a a vowel? " + isAVowel("a")); //true
	System.out.println("Is e a vowel? " + isAVowel("e")); //true
	System.out.println("Is i a vowel? " + isAVowel("i")); //true
	System.out.println("Is o a vowel? " + isAVowel("o")); //true
	System.out.println("Is u a vowel? " + isAVowel("u")); //true
	System.out.println("Is d a vowel? " + isAVowel("d")); //false
	System.out.println("---Testing of countVowels---");
	System.out.println("# of vowels in meatball: " + countVowels("meatball")); //3
	System.out.println("# of vowels in monkey: " + countVowels("monkey")); //2
	System.out.println("# of vowels in fly: " + countVowels("fly")); //0
	System.out.println("---Testing of hasAVowel---");
	System.out.println("Does cat have a vowel? " + hasAVowel("cat")); // true
	System.out.println("Does zzz have a vowel? " + hasAVowel("zzz")); // false
	System.out.println("---Testing of allVowels---");
	System.out.println("allVowels of meatball: " + allVowels("meatball")); //eaa
	System.out.println("allVowels of codingbat: " + allVowels("codingbat")); //oia
	System.out.println("---Testing of firstVowel---");
	System.out.println("firstVowel of \"\": " + firstVowel("")); // ""
	System.out.println("firstVowel of zzz: " + firstVowel("zzz")); // ""
	System.out.println("firstVowel of meatball: " + firstVowel("meatball")); //e
	System.out.println("firstVowel of yogurt: " + firstVowel("yogurt")); //o
	System.out.println("---Testing of beginsWithVowel---");
	System.out.println("beginsWithVowel of apple: " + beginsWithVowel("apple")); //true
	System.out.println("beginsWithVowel of strong: " + beginsWithVowel("strong"));//false
	System.out.println("---Testing of engToPig---");
	System.out.println("Piglatin version of apple: " + engToPig("apple")); //appleway
	System.out.println("Piglatin version of strong: " + engToPig("strong")); //ongstray
	System.out.println("Piglatin version of java: " + engToPig("java")); //avajay
	System.out.println("Piglatin version of yellow: " + engToPig("yellow")); //ellowyay
	System.out.println("Piglatin version of my: " + engToPig("my")); //ymay
	System.out.println("Piglatin version of why: " + engToPig("why")); //ywhay
	System.out.println("Piglatin version of strrrrrong: " + engToPig("strrrrrong")); //ongstrrrrray
	System.out.println("Piglatin version of why: " + engToPig("spy")); //yspay
	System.out.println("Piglatin version of why: " + engToPig("fly")); //yflay
    }
}
