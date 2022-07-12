package insertion_sort_03;

import java.util.Random;

// 数组生成器
public class ArrayGenerator {
		
	private ArrayGenerator() {
		
	}
	
	// 生成有序数
	public static Integer[] generateOrderedArray(int n) {
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
//	生成随机数
	public static Integer[] generateRandomArray(int n, int bound) {
		Integer[] arr = new Integer[n];
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = rnd.nextInt(bound);
		}
		return arr;
	}
	
}
