

public class DoubleArrayQueue<Double>{

    // Array of items in the stack.
    private Double[] data;

    // Index the foremost element in this Queue
    private int front;

    // Number of items currently in the stack.
    private int size;

    // The stack is initially empty.
    public DoubleArrayQueue() {
        data = (Double[]) (new Object[1]);
        size = 0;
        front = 0;
    }

    public void add(Double target) {
        if (isFull()) {
            stretch();
        }
        data[(front + size) % data.length] = target;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected boolean isFull() {
        return size == data.length;
    }

    public Double remove() {
        if (isEmpty()) {
            throw new EmptyStructureException();
        }
        Double result = data[front];
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    protected void stretch() {
        Double[] newData = (Double[]) (new Object[data.length * 2]);  // warning
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
    }

    public Double peek() {
        if (isEmpty()) {
           throw new EmptyStructureException();
        }
        return data[(front + size - 1) % data.length];
    }

    public int size(){
		return size;
	}

	public String toString(){
        String qData = "";
        int f = front;
        for(int x=0;x < size;x++){

            qData = qData + ("" + data[f] + " ");

            f = (f + 1) % 10;

        }
        return qData;
    }
}
