package day11;

import java.util.List;

public class Main2 {

	public static void main(String[] args) {

		RestTitanic client = new RestTitanic();
		
		client.parseData();
		List<Titanic>list = client.parseData();
		for(Titanic t : list) { //for (한개 꺼냈을때 타입 m : 리스트변수) {
			System.out.println("name : "+ t.getName());
			System.out.println("fare : "+ t.getFare());
			System.out.println("embarked : "+ t.getEmbarked());
			System.out.println("age : "+ t.getAge());
			System.out.println("parch : "+ t.getParch());
			System.out.println("cabin : "+ t.getCabin());
			System.out.println("pclass : "+ t.getPclass());
			System.out.println("sex : "+ t.getSex());
			System.out.println("survived : "+ t.getSurvived());
			System.out.println("ticket : "+ t.getTicket());
			System.out.println("passengerid : "+ t.getPassengerid());
			System.out.println("sibsp : "+ t.getSibsp());
			System.out.println("--------------------------------");
		
  }
 }
}
