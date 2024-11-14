// ArrayQueue.java

public class ArrayQueue implements Queue
{
    private char[] elements;

    public ArrayQueue ()
    {
        elements = new char[0];
	}

	public String toString ()
	{
		String s = "[";
		for (int i = 0; i < elements.length; i++)
		{
			s += elements[i];
			if (i < elements.length - 1)
			    s += ", ";
		}
		s += "]";

		return s;
	}

	public boolean isEmpty ()
	{
		return elements.length == 0;
	}

	public int size ()
	{
		return elements.length;
	}

	public void put (char element)
	{
		char[] a = new char[elements.length + 1];
		for (int i = 0; i < elements.length; i++)
		    a[i] = elements[i];
		a[a.length - 1] = element;
		elements = a;
	}


	public char take () throws IllegalStateException
	{
		if (this.isEmpty())
		    throw new IllegalStateException(
				                  "take called on empty queue");

		char e = elements[0];
		char[] a = new char[elements.length - 1];
		for (int i = 0; i < elements.length - 1; i++)
		    a[i] = elements[i + 1];
		elements = a;

		return e;
	}
}
