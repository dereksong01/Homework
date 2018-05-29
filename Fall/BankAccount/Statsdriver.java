public class Statsdriver {
    public static void main (String [] args) {
	
	Stats mean = new Stats();
	Stats dmean = new Stats ();
	Stats max = new Stats ();
	Stats dmax = new Stats ();
	Stats geomean = new Stats ();
	Stats dgeomean = new Stats ();

	System.out.println (mean.intmean(4 ,6, 5));
	System.out.println (dmean.doublemean (4.0, 6.0, 5.0));
	System.out.println (max.intmax (4, 5, 2));
	System.out.println (dmax.doublemax (4.0, 5.0, 3.0));
	System.out.println (geomean.intGeoMean (5, 5, 5));
	System.out.println (dgeomean.doubleGeoMean (5.0, 5.0, 5.0));
    }
}
	





	    /*  //tests
    public static void main(String [] args) {
	System.out.println (intmean(4, 6, 5));
	System.out.println (doublemean (4.0, 6.0, 5.0));
	System.out.println (intmax (4, 5, 2));
	System.out.println (doublemax (4.0, 5.0, 2.0));
	System.out.println (Math.cbrt (intGeoMean (5, 5, 5)));
	System.out.println (Math.cbrt (doubleGeoMean (5.0, 5.0, 5.0)));
    }

	    */
