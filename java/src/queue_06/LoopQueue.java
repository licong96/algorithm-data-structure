package queue_06;

import java.sql.Date;

public class LoopQueue<E> implements Queue<E> {
	
	private E[] data;
	
	private int front, tail;
	
	private int size;	// 额外维护一个长度变量，使逻辑编写更加简单
	
	public LoopQueue(int capacity) {
		data = (E[])new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue() {
		this(10);
	}
	
	public int getCapacity() {
		return data.length - 1;
	}
	
	@Override
	public boolean isEmpty() {
		return front == tail;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public E getFront() {
		
		if (isEmpty()) {
			throw new IllegalArgumentException("Error dequeue is empty");
		}
		
		return data[front];
	}
	
	@Override
	public void enqueue(E e) {
		
		if ((tail + 1) % data.length == front) {
			resize(getCapacity() * 2);
		}
		
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}
	
	@Override
	public E dequeue() {
		
		if (isEmpty()) {
			throw new IllegalArgumentException("Error dequeue is empty");
		}
		
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		
		// 缩容
		if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		return ret;
	}
	
	private void resize(int newCapacity) {
		
		E[] newData = (E [])new Object[newCapacity + 1];
		
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		
		data = newData;
		front = 0;
		tail = size;
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		res.append("LoopQueue: ");
		res.append("size = " + size + "; capacity = " + getCapacity());
		res.append(" front [");
		
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			
			res.append(data[i]);
			
			if ((i + 1) % data.length != tail) {
				res.append(", ");
			}
		}
		
//		for (int i = 0; i < size; i++) {
			
//			res.append(data[(i + front) % data.length]);
//			
//			if ((i + front + 1) % data.length != tail) {
//				res.append(", ");
//			}
//		}
		res.append("] tail");
		return res.toString();
	}
}
