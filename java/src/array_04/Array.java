package array_04;

public class Array<E> {
	
	private E[] data;
	
	private int size;	// 指向数组中下一个没有元素的位置
	
	/**
	 * 构造函数
	 * @param capacity 数组长度
	 */
	public Array(int capacity) {
		data = (E[])new Object[capacity];
		size = 0;
	}
		
	// 无参构造函数，默认10
	public Array() {
		this(10);
	}
		
	// 获取数组中的元素个数
	public int getSize() {
		return size;
	}
	
	// 获取数组的容量
	public int getCapacity() {
		return data.length;
	}
	
	// 获取index索引位置的元素
	public E get(int index) {
		
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. index is error");
		}
		return data[index];
	}
	
	/**
	 * 修改index索引位置的元素为e
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Set failed. index is error");
		}
		
		data[index] = e;
	}
	
	// 查找数组中元素e所在的索引
	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	// 返回数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 向所有元素后添加一个新元素
	public void addLast(E e) {
		add(size, e);
	}
	
	// 向数组头部添加元素
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * 向数组指定位置添加元素
	 * @param index 需要添加的位置
	 * @param e 需要添加的值
	 */
	public void add(int index, E e) {
		
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. index error");
		}
		
		if (size == data.length) {			
//			throw new IllegalArgumentException("Add failed. Array is full");
			resize(2 * data.length);
		}
		
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		
		data[index] = e;
		size++;
	}
	
	// 从数组中删除元素，返回删除的元素
	public E remove(int index) {
		
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Remove failed. index is error");
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}

		size--;
		data[size] = null;	// 手动释放内存
		
		// 删除的时候，判断是否减少空间，只缩容一半
		if (size < data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return ret;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size - 1);
	}
	
	public boolean removeElement(E e) {
		
		int index = find(e);
		if (index != -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		
		res.append(String.format("Array: size = %d, capacity = %d \n",size, data.length));
		res.append('[');
		
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(",");
			}
		}
		res.append(']');
		
		return res.toString();
	}
	
	// 数组扩容，动态数组
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}
