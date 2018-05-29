public class DequeTester2 {

    public static void main(String[] args) {
    QQKachoo<String> test = new QQKachoo<String>();

    //There was no method for addFirst... curious
    test.addFirst("Alvin");
    test.addLast("Dave");
    test.addFirst("Ian");
    test.addLast("Simon");
    test.addLast("Theodore");

    System.out.println(test); //Expecting Ian Alvin Dave Simon Theodore
    //Worked!

    System.out.println(test.peekLast());// Expecting Theodore
    System.out.println(test.peekFirst()); //Expecting Ian

    System.out.println(test.removeFirst()); //expecting Ian
    
    System.out.println(test.removeLast()); //Expecting Theodore
    //Does not remove the element as it should.

    System.out.println(test.removeFirst()); //Expecting Alvin
    System.out.println(test.removeFirst()); //Expecting Dave
    System.out.println(test.removeFirst()); //Expecting Simon
    System.out.println(test.isEmpty()); //Expecting true

    System.out.println(test.peekFirst()); //Expecting null
    }
}
