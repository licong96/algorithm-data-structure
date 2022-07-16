package queue_06;

public interface Queue<E> {
	
	void enqueue(E e);
	
	E dequeue();
	
	E getFront();
	
	int getSize();
	
	boolean isEmpty();
}
