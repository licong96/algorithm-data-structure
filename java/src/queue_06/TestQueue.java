package queue_06;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayQueue<Integer> array = new ArrayQueue<>(10);
//		
//		for (int i = 0; i < 10; i++) {
//			array.enqueue(i);
//			System.out.println(array);
//			
//			if (i % 3 == 2) {
//				array.dequeue();
//				System.out.println(array);
//			}
//		}
//		
//		System.out.println("-----------------");
//		
//		LoopQueue<Integer> array2 = new LoopQueue<>(10);
//		
//		for (int i = 0; i < 10; i++) {
//			array2.enqueue(i);
//			System.out.println(array2);
//			
//			if (i % 3 == 2) {
//				array2.dequeue();
//				System.out.println(array2);
//			}
//		}
		
		int opCount = 100000;

		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		double time1 = testTime(arrayQueue, opCount);
		System.out.println("ArrayQueue time = " + time1);
		
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		double time2 = testTime(loopQueue, opCount);
		System.out.println("LoopQueue time = " + time2);
	}
	
	private static double testTime(Queue<Integer> q, int opCount) {
		long startTime = System.nanoTime();
		
		for (int i = 0; i < opCount; i++) {
			q.enqueue(i);
		}
		
		for (int i = 0; i < opCount; i++) {
			q.dequeue();
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000000000.0;
	}

}
