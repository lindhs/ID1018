// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'length'");
	}

	@Override
	public double upperBound() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'upperBound'");
	}

	@Override
	public double lowerBound() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'lowerBound'");
	}

	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'numberAt'");
	}

	@Override
	public int positionOf(double number) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'positionOf'");
	}

	@Override
	public boolean isIncreasing() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isIncreasing'");
	}

	@Override
	public boolean isDecreasing() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isDecreasing'");
	}

	@Override
	public boolean contains(double number) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'contains'");
	}

	@Override
	public void add(double number) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}

	@Override
	public void insert(int position, double number) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insert'");
	}

	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeAt'");
	}

	@Override
	public double[] asArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asArray'");
	}

    // add code here
}