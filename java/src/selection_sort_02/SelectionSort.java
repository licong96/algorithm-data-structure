package selection_sort_02;

public class SelectionSort {
	
	private SelectionSort() {}
	
	// 泛型约束 extends 实现 Comparable 接口
	public static <E extends Comparable<E>> void sort(E[] data) {
		
//		for (int i = 0; i < data.length; i++) {
//			for (int j = i + 1; j < data.length; j++) {
//				if (data[i] > data[j]) {
//					int temp = data[i];
//					data[i] = data[j];
//					data[j] = temp;
//				}
//			}
//		}
		
		for (int i = 0; i < data.length; i++) {
//			第一轮循环在维护一个循环不变量 data[i...n)未排序，data[0...i)已排序
			int minIndex = i;	// 每一次循环，都要先记录最小值索引
			for (int j = i; j < data.length; j++) {
				if (data[j].compareTo(data[minIndex]) < 0) {
					minIndex = j;
				}
			}
			// 交换位置
			swap(data, i, minIndex);
		}
		
	}
	
	// 从后往前排序，循环不变量： arr[i...n)已排序，arr[0...i)未排序
	public static <E extends Comparable<E>> void sort2(E[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			int minIndex = i;
			for (int j = i; j >= 0; j--) {
				if (arr[j].compareTo(arr[minIndex]) > 0) {
					minIndex = j;
				}
			}
			// 交换位置
			swap(arr, i, minIndex);
		}
	}
	
	private static <E> void swap(E[] data, int i, int minIndex) {
		E temp = data[i];
		data[i] = data[minIndex];
		data[minIndex] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] data = {2, 4, 5, 1, 7, 3, 11, 8, 12};
		sort2(data);
		
		for (int n:data)
			System.out.println(n);
		
		System.out.println("-----------");
		
		// 测试类
//		Student[] students = {
//				new Student("zhangshang", 99),
//				new Student("lisi", 80),
//				new Student("wanger", 65)
//		};
//		
//		sort(students);
//		for (Student student: students)
//			System.out.print(student + "");

		// 随机数排序
//		int n = 10000;
//		Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//		sort(arr);
//		for (int e: arr) {
//			System.out.println(e);
//		}

		System.out.println("----------- 时间复杂度，10倍数据，n 的二次方");
//		
		int [] dataSize = {10000, 100000};
		for (int n2 : dataSize) {
			Integer[] arr2 = ArrayGenerator.generateOrderedArray(n2);
//			Integer[] arr2 = ArrayGenerator.generateRandomArray(n2, n2);
			SortingHelper.sortTest("SelectionSort", arr2);
		}
		
	}
	

}
