package array_04;

public class TestArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<Integer> array = new Array<>(20);
		
		for (int i = 1; i < 15; i++) {
			array.addLast(i);
		}
		
		array.add(1, 21);
		

		System.out.println("————————————————————");
		
		System.out.println(array);
		
		System.out.println("————————————————————");

//		array.addLast(10);
//		array.addLast(11);
		
		array.removeLast();
		array.removeLast();
		array.removeLast();
		array.removeLast();
		array.removeLast();
		array.remove(1);
		array.removeElement(9);

		System.out.println(array);
	}

}
