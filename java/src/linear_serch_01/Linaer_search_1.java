package linear_serch_01;

public class Linaer_search_1 {
	
	private Linaer_search_1() {};	// 将构造函数改成private，不允许外界实力化对象

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Integer[] data = {12, 24, 54, 11, 64, 84, 42, 9};
		Integer[] data = ArrayGenerator.generateOrderedArray(100000000);
		
		// 计时
		long startTime = System.nanoTime();

		System.out.println("startTime" + startTime);
		int res = Linaer_search_1.search(data, 100000000);
		
		long endTime = System.nanoTime();
		
		double time = (endTime - startTime) / 1000000000.0;
		
		System.out.println("time = " + time);
		System.out.println(res);
		
		int res2 = Linaer_search_1.search(data, 88);
		System.out.println(res2);
		
		// 测试类
		Student[] students = {
				new Student("zhangshang"),
				new Student("lisi"),
				new Student("wanger")
		};
		Student wanger = new Student("wanger");
		int res3 = Linaer_search_1.search(students, wanger);
		System.out.println(res3);
	}
	
	/**
	 * 线性查找算法
	 * <E>泛型方法
	 */
	public static <E> int search(E[] data, E target) {
		for(int i = 0; i < data.length; i++) {
			if (data[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

}
