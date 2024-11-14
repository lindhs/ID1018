// LinkedQueue.java

public class LinkedQueue implements Queue
{
    private class Node
    {
		public char element;
		public Node next;

		public Node (char element)
		{
			this.element = element;
			this.next = null;
		}
	}

    private Node first;

    public LinkedQueue ()
    {
        first = null;
	}

	public String toString ()
	{
		String s = "[";
		Node n = first;
		while (n != null)
		{
			s += n.element;
			if (n.next != null)
			    s += ", ";
			n = n.next;
	    }
		s += "]";

		return s;
	}

	public boolean isEmpty ()
	{
		return first == null;
	}

	public int size ()
	{
		int numberOfElements = 0;
		Node n = first;
		while (n != null)
		{
			numberOfElements++;
			n = n.next;
	    }

		return numberOfElements;
	}

	public void put (char element)
	{
		Node node = new Node(element);
		if (first == null)
		    first = node;
		else
		{
		    Node n = first;
		    while (n.next != null)
			    n = n.next;
			n.next = node;
	    }
	}

	public char take () throws IllegalStateException
	{
		if (this.isEmpty())
		    throw new IllegalStateException(
				                  "take called on empty queue");

		char e = first.element;
		first = first.next;

		return e;
	}
}
