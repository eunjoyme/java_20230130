package day6;

public class Main2 {

	public static void main(String[] args) {
		//age=0
		Exam2 obj1 = new Exam2();
		obj1.plusAge(); // age=>1
		obj1.plusAge(); // age=>2
		obj1.plusAge(); // age=>3
		//obj1.printAge();
		obj1.forAge();
		
		Exam2 obj2 = new Exam2();
		obj2.plusAge(); // age => 1
		//obj2.printAge();
		
		Exam2.PlusAge1(); // age1 => 101
		Exam2.PlusAge1(); // age1 => 102
		
		
	}

}
