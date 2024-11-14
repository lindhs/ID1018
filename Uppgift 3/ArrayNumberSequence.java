// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}
	
	public int length(){
		return numbers.length;
	}

	@Override
	public double upperBound() {
		double tempComparer = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if(numbers[i] > tempComparer){
				tempComparer = numbers[i];
			}
		}

		return tempComparer;
	}

	@Override
	public double lowerBound() {
		double tempComparer = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if(numbers[i] < tempComparer){
				tempComparer = numbers[i];
			}
		}

		return tempComparer;
	}

	@Override
	public double numberAt(int position) throws IndexOutOfBoundsException {
		return numbers[position];
	}

	@Override
	public int positionOf(double number) {
		int tempPos = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number){
				tempPos = i;
			}
		}
		return tempPos;
	}

	@Override
	public boolean isIncreasing() {

		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] >= numbers[i+1]){
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isDecreasing() {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] <= numbers[i+1]){
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean contains(double number) {
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == number){
				return true;
			}
		}

		return false;
	}

	@Override
	public void add(double number) {
		double newNumbers[] = new double[numbers.length+1];
		for (int i = 0; i < numbers.length; i++) {
			newNumbers[i] = numbers[i];
		}
		newNumbers[newNumbers.length-1] = number;
		numbers = newNumbers;
	}

	@Override
	public void insert(int position, double number) throws IndexOutOfBoundsException {
		double newNumbers[] = new double[numbers.length+1];
		for (int i = 0; i < newNumbers.length; i++) {
			if (i < position) { //below
				newNumbers[i] = numbers[i];
			} else if (i == position) {
				newNumbers[i] = number;
			} else { //above (i > position)..;
				newNumbers[i] = numbers[i - 1];
			}
		}
		numbers = newNumbers;

		}
	

	@Override
	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException {
		int counter = 0;
		double[] newNumbers = new double[numbers.length -1];
	
		for (int i = 0; i < numbers.length; i++) {
			if (i != position) {
				newNumbers[counter] = numbers[i];
				counter++;
			}
		}
	
		numbers = newNumbers;
		}
	

	@Override
	public double[] asArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'asArray'");
	}

    // add code here
}