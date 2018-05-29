Derek Song
APCS2 - pd8
HW#12 - __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018 - 3 - 1

Q0: What do you make of the multiple class definitions in a single .java file?

It is different than all the syntaxes that we have dealt with in the past term and so far in the term. I personally thought that the file name always had to be the name of the class. However, this file seems to disprove my entire APCS career.

Q1: How are the command line arguments processed?

The command line arguments encompass an integer array and element 0 and 1 control the size of the grid and the delay time, respectively. Scanner is able to set both size and delay time.

Q2: What happens if no command line arguments are given?

The normal, default setting are used.

Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?

Recursion is what allows the animation to be done. It slightly changes the grid and goes back and slightly changes it again.

Q4: What do you expect to see when you run it?

I expect to see an animation.

Q5: How long do you expect it to run?

For however long the delay time is multiplied by the board size.

Q6: What does ANSI stand for? (You are permitted some intertubes searching here…). What is it good for?

ANSI stands for American Nation Standards Institute. This institute creates guidelines based on a national agreement. This allows for little ambiguity.

Q7: How did your expectations compare to your observations?

My observations met my expectations because I expected an animation and I got one.

Q8: How might you adapt this framework to animate a probing for a Knight’s Tour?

For every time we make a move, then we would be able to see where the next possible destination would be. Also, we can explicitly see the borders.

ALGO!
1) Start at center
2) Check if each box has been visited. If so, SOLUTION!
3) Find next possible box
4) Move knight to that possible box
   - If no more possible moves but no completion, move back a move and continue doing so.
5) Complete!