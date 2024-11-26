// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

*************************************************   ***************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        //sequence = new ArrayNumberSequence(realNumbers);
         sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        //print length
        System.err.println("length: " + sequence.length());

        //upper bound
        System.err.println("one upper bound " + sequence.upperBound());

        //lower bound
        System.err.println("one lower bound " + sequence.lowerBound());
        out.println();

        //number at position index 3... 5
        System.err.println("number at position 3: " + sequence.numberAt(3));
        
        //position index of number 8.. 0
        System.err.println("position of 8: " + sequence.positionOf(8));
        out.println();

        //is increasing // is decreasing
        System.err.println("is increasing " + sequence.isIncreasing());
        System.err.println("is decreasing " + sequence.isDecreasing());
        System.err.println("contains 16.0: " + sequence.contains(16));
        out.println();

        //add 32 to sequence
        System.err.println("add 32.0:");
        sequence.add(32);

        System.err.println(sequence);

        System.err.println("inser 0.0 at position 7:");
        sequence.insert(7, 0);
        System.err.println(sequence);


        System.err.println("remove at position 7");
        sequence.removeAt(7);

        System.err.println(sequence);

        System.err.println("corresponding array");
        System.err.println(sequence);



    }
}