// QueueTest.java

import static java.lang.System.out;

class QueueTest
{
    public static void main (String[] args)
    {
        Queue queue = null;
        queue = new ArrayQueue();
        // queue = new LinkedQueue();
        out.println("the queue: " + queue);

        int numberOfElements = queue.size();
        out.println("number of elements in the queue: "
                    + numberOfElements);
        boolean empty = queue.isEmpty();
        out.println("the queue is empty: " + empty);
        out.println();

        out.println("put elements in the queue");
        queue.put('B');
        queue.put('A');
        queue.put('D');
        queue.put('C');
        out.println("the queue: " + queue);
        out.println("number of elements in the queue: "
                    + queue.size());
        out.println("the queue is empty: " + queue.isEmpty());
        out.println();

        char element = queue.take();
        out.println("take one element from the queue: " + element);
        out.println("the queue: " + queue);
        out.println("number of elements in the queue: " + queue.size());
        out.println();

        out.print("take all the elements from the queue: ");
        while (!queue.isEmpty())
        {
			element = queue.take();
			out.print(element + " ");
		}
		out.println();
		out.println("the queue: " + queue);
        out.println("the queue is empty: " + queue.isEmpty());
		out.println();

        // element = queue.take();
	}
}
