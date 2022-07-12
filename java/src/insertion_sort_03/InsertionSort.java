package insertion_sort_03;

import java.util.Arrays;

public class InsertionSort {
	
	private InsertionSort() {}
	
	// 插入排序
//	public static void sort(int[] arr) {
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = i - 1; j >= 0; j--) {
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//	}
	
	public static <E extends Comparable<E>> void sort(E[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i; j - 1 >= 0; j--) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					swap(arr, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	// 小优化版本，速度更快，复杂度并没有变化
	public static <E extends Comparable<E>> void sort2(E[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			E temp = arr[i];
			int j;
			for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	
	private static <E> void swap(E[] data, int i, int minIndex) {
		E temp = data[i];
		data[i] = data[minIndex];
		data[minIndex] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] arr = {2, 5, 4, 3, 6, 8, 9, 7, 1 };
//		sort2(arr);
//		for (int n:arr) {
//			System.out.println(n);
//		}
		
		int[] dataSize = {10000, 100000};
		for (int n: dataSize) {
			Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//			Integer[] arr = ArrayGenerator.generateOrderedArray(n);
			Integer[] arr2 = Arrays.copyOf(arr, arr.length);
			
			SortingHelper.sortTest("InsertionSort", arr);
			SortingHelper.sortTest("InsertionSort2", arr2);
		}
	}

}
