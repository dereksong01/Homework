// Team Kappa (Woosuk Lee and Derek Song)
// APCS1 - pd1
// HW#53 - Solid Comparative Analysis
// 2017 - 12 - 13

public class SortTester{
    public static void main( String[] args ){
        
        //using magic numbers 1,3,5,7,12
        
        ArrayList bestCaseBub = new ArrayList<Comparable>();
        ArrayList bestCaseSel = new ArrayList<Comparable>();
        ArrayList bestCaseIns = new ArrayList<Comparable>();
        ArrayList worstCaseBub = new ArrayList<Comparable>();
        ArrayList worstCaseSel = new ArrayList<Comparable>();
        ArrayList worstCaseIns = new ArrayList<Comparable>();
        
        bestCaseBub.add(1);
        bestCaseBub.add(3);
        bestCaseBub.add(5);
        bestCaseBub.add(7);
        bestCaseBub.add(12);
        
        bestCaseSel.add(1);
        bestCaseSel.add(3);
        bestCaseSel.add(5);
        bestCaseSel.add(7);
        bestCaseSel.add(12);

        bestCaseIns.add(1);
        bestCaseIns.add(3);
        bestCaseIns.add(5);
        bestCaseIns.add(7);
        bestCaseIns.add(12);

        worstCaseBub.add(12);
        worstCaseBub.add(7);
        worstCaseBub.add(5);
        worstCaseBub.add(3);
        worstCaseBub.add(1);
        
        worstCaseSel.add(3);
        worstCaseSel.add(5);
        worstCaseSel.add(7);
        worstCaseSel.add(12);
        worstCaseSel.add(1);
        
        worstCaseIns.add(12);
        worstCaseIns.add(7);
        worstCaseIns.add(5);
        worstCaseIns.add(3);
        worstCaseIns.add(1);
        
        MySorts.bubbleSort(bestCaseBub);
        MySorts.bubbleSort(worstCaseBub);
        MySorts.selectionSort(bestCaseSel);
        MySorts.selectionSort(worstCaseSel);
        MySorts.insertionSort(bestCaseIns);
        MySorts.insertionSort(worstCaseIns);
        
        
    }
}
