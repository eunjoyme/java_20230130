package main2;

import java.util.Date;

import cls.Course;
import cls.Professor;
import cls.Register;
import cls.Student;

public class Main4 {

	public static void main(String[] args) {

		//1.학생 등록
		Student student = new Student(100,"a",1,new Date());
		
		//2.교수 등록
		Professor professor = new Professor(1,"a", "603", new Date());
		
		//3.과목 등록
		Course course = new Course();
		course.setCode(4000);
		course.setCredit(3);
		course.setName("java 배우기");
		course.setDate(new Date());
		course.setProfessor(professor);
		
		//4.수강신청(1개만)
		Register register = new Register();
		register.setCode(3333);
		register.setDate(new Date());
		register.setStudent(student);
		register.setCourse(course);
		
		//5.수강신청 내역 출력(1개만)
		
		
		
	}

}
