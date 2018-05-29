# Something
Team Something -- Shruthi Venkata, Sean Roudnitsky, Derek Song  
APCS2 pd08  
L #00 -- But What Does the Data Say?  
2018-02-08   

# Hypothesis
Given an nxn 2D array of ints, with the numbers ascending left to right by row and column, then our algorithm will find the position of any desired integer in O(n) runtime.

# Background
We need to design an algorithm that can find the position of an integer in O(n) runtime, given a 2D array of size n x n, where the integers increase from left to right by row, and increase from top to bottom by column.

Our Algorithm:   
Step 1) First, compare the target with the bottom left value.  
Step 2) While the index < n, if the target is greater, move to the right. If it is smaller, move up.                                   If it finds the target, return the coordinates.  
        This repeated until we are out of bounds.  
Step 3) Return (-1, -1) if no coordinates were previously returned.  

# Experiment Methodology
In MFDriver.java, the main method contains a while loop that populates an array of nxn elements, starting at 10x10 and incrementing by 100 values up to a 100000x100000 array. Each time, it uses System.currenttimemillis to determine the amount of time that has elapsed from the start to end of the finder() method (which uses the algorithm to find an int). These values can be stored in a csv file when, in the terminal, you run by entering `java MFDriver >>Data.csv`.

# Results   
Link to spreadsheet with graph of result: https://docs.google.com/spreadsheets/d/114B7jSD60uovatGRFzjDitkmeAAe_fdN-48uSmRre-4/edit?usp=sharing

# Conclusions  
Due to some bug in our code, after n reaches a size of about 3500, the graph dips down. Beofer this dip however, the line appears relatively linear. 
