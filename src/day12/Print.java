package day12;

import java.util.Iterator;
import java.util.List;

import day11.Titanic;

//출력하는 곳
public class Print {

	// 전체 목록을 받아서 생존자의 인원수를 구하시오. (for문 사용)
	public void printSurvived(List<Titanic> list) {
		int cnt = 0;
		for (Titanic t : list) {
			if (t.getSurvived().equalsIgnoreCase("Yes")) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// 전체 목록을 받아서 연령대별 인원수를 구하시오.(단, 0은 제외, while문 사용)
	// 0.01~9 어린이
	// 10~19 10대 => X명
	// 20~29 20대
	// 30~39 30대
	// 40~49 40대
	// 50~59 50대
	public void printAge(List<Titanic> list) {
		int[] cnt = { 0, 0, 0, 0, 0, 0, 0 };
		int i = 0;
		while (i < list.size()) {
			Titanic t = list.get(i);

			if (t.getAge() > 0) {
				int n = t.getAge().intValue() / 10; // 0.01~9 => 0, 10~19=> 1
				cnt[n]++;
			}
			i++;
		}
		for (i = 0; i < cnt.length; i++) {
			System.out.println(i + "대 => " + cnt[i]);
		}
	}

//	public void printAge(List<Titanic> list) {
//		Iterator<Titanic> cursor = list.iterator();
//		int a[] = new int[7]; 
//		while(cursor.hasNext()) {
//			Titanic t = cursor.next();
//			
//			if(t.getAge()>0 && t.getAge()<10) {
//				a[0]++;
//			}
//			else if(t.getAge()<20) {
//				a[1]++;
//			}
//			else if(t.getAge()<30) {
//				a[2]++;
//			}
//			else if(t.getAge()<40) {
//				a[3]++;
//			}
//			else if(t.getAge()<50) {
//				a[4]++;
//			}
//			else if(t.getAge()<60) {
//				a[5]++;
//			}
//			else {
//				a[6]++;
//			}
//			}
//	}

	// 전체 목록에서 티켓등급(pclass)의 종류별 개수를 구하시오. (종류는 1,2,3)
	public int[] printPClass(List<Titanic> list) {
		int[] a = { 0, 0, 0, 0 };
		for (Titanic t : list) {
			int n = t.getPclass();
			a[n]++;
		}
		// a[0]은 사용안함. a[1]에는 1의 개수, a[2]에는 2의 개수, a[3]에는 3의 개수
		return a;
	}

//	public int[] printPClass(List<Titanic> list) {
//		int []a =new int[3];
//		for(Titanic t : list ) {
//			if(t.getPclass()== 1) {
//				a[0]++;
//			}
//			else if(t.getPclass()==2) {
//				a[1]++;
//			}
//			else if(t.getPclass()==3) {
//				a[2]++;
//			}
//		}
//		return null;
//	}

	// 전체 목록에서 운임요금(fare) 30보다 큰것만 fare와 name으로 출력. (단, fare는 소수점을 올림하여 정수로 표시)
	public void printFare(List<Titanic> list) {
		for (Titanic t : list) {
			if (t.getAge() > 30) {
				// 올림하기 Math.ceil(1.1232)
				System.out.println(Math.ceil(t.getFare()));
				System.out.println(t.getName());
			}
		}
	}

	// 전체 목록에서 이름(name)의 Mr.Miss.Mrs.를 각각 포함하는 인원수를 구하시오.
	public void printName(List<Titanic> list) {
		int cnt[] = new int[3];
		for (Titanic t : list) {
			if (t.getName().contains("Mr. ")) {
				cnt[0]++;
			} else if (t.getName().contains("Miss. ")) {
				cnt[1]++;
			} else if (t.getName().contains("Mrs. ")) {
				cnt[2]++;
			}
		}
		System.out.println("Mr 인원수 => " + cnt[0]);
		System.out.println("Miss 인원수 => " + cnt[1]);
		System.out.println("Mrs 인원수 => " + cnt[2]);
	}

	// 연령대별 생존자수 구하기(전체인원 891명, 비율은 소수점으로 표시)
	public void printAgeSurvived(List<Titanic> list) {
		// 연령대별 인원수를 구하고, 연령대별 생존자수 구하기
		// 생존자수/전체인원*100
		int cnt1[] = { 0,0,0,0,0,0,0,0,0};
		int cnt2[] = { 0,0,0,0,0,0,0,0,0};
		
		for(Titanic t : list) {
			if(t.getAge()>0 && t.getAge()<10) {
				cnt1[0]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}
			}
			else if(t.getAge()<20) {
				cnt1[1]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			}
			else if(t.getAge()<30) {
				cnt1[2]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[2]++;
				}
			}
			else if(t.getAge()<40) {
				cnt1[3]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[3]++;
				}
			}
			else if(t.getAge()<50) {
				cnt1[4]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[4]++;
				}
			}
			else if(t.getAge()<60) {
				cnt1[5]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[5]++;
				}
			}
			else if(t.getAge()<70) {
				cnt1[6]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[6]++;
				}
			}
			else if(t.getAge()<80) {
				cnt1[7]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[7]++;
				}
			}
			else if(t.getAge()<90) {
				cnt1[8]++;
				if(t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[8]++;
				}
			}
		}
			System.out.println("어린이 생존 인원수 => "+(float)cnt2[0]/cnt1[0]*100);
			System.out.println("10대 생존 인원수 => "+ (float)cnt2[1]/cnt1[1]*100);
			System.out.println("20대 생존 인원수 => "+ (float)cnt2[2]/cnt1[2]*100);
			System.out.println("30대 생존 인원수 => "+ (float)cnt2[3]/cnt1[3]*100);
			System.out.println("40대 생존 인원수 => "+ (float)cnt2[4]/cnt1[4]*100);
			System.out.println("50대 생존 인원수 => "+ (float)cnt2[5]/cnt1[5]*100);
			System.out.println("60대 생존 인원수 => "+ (float)cnt2[6]/cnt1[6]*100);
			System.out.println("70대 생존 인원수 => "+ (float)cnt2[7]/cnt1[7]*100);
			System.out.println("80대 생존 인원수 => "+ (float)cnt2[8]/cnt1[8]*100);
		
	}
		
//		Iterator<Titanic> iter = list.iterator();
//		int[] cnt = { 0, 0, 0, 0, 0, 0, 0, 0,0 };
//		int[] cnt1 = { 0, 0, 0, 0, 0, 0, 0, 0,0 };
//		int i = 0;
//		while (iter.hasNext()) {
//			Titanic t = iter.next();
//			if (t.getAge() > 0) {
//				int n = t.getAge().intValue() / 10; // 0.01~9 => 0, 10~19=> 1
//				cnt[n]++;
//				System.out.println(cnt[n]);
//				if (t.getSurvived().equalsIgnoreCase("Yes")) {
//					cnt1[n]++;
//				}
//				
//			}
//			if(t.getAge() > 90) {
//				break;
//			}
//		}
//		
//		for (i = 0; i < cnt.length; i++) {
//			System.out.println(i * 10 + "대 생존자수 => " + cnt[i]);
//		}
//	}
	
	
	// 성별 생존자수 구하기(전체인원 891명, 비율은 소수점으로 표시)
	public void printSexSurvived(List<Titanic> list) {
		// 1.남여 인원수를 구하기
		// 2.남여 생존자수 구하기
		// 남 생존자수/남 전체인원*100
		int cnt1[] = { 0, 0 }; // 인원수 보관 cnt1[0] 남자수, cnt1[1] 여자수
		int cnt2[] = { 0, 0 }; // 생존자수 보관

		for (Titanic t : list) {
			if (t.getSex().equals("male")) {
				cnt1[0]++;
				if (t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}
			} else if (t.getSex().equals("female")) {
				cnt1[1]++;
				if (t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			}
		}
		System.out.println("남자 생존자수=> " + (float) cnt2[0] / (float) cnt1[0] * 100);// 18.89
		System.out.println("여자 생존자수=> " + (float) cnt2[1] / (float) cnt1[1] * 100);// 74.20
	}

	// 티켓 등급별 생존자수 구하기(전체인원 891명, 비율은 소수점으로 표시)
	public void printPClassSurvived(List<Titanic> list) {
		// 티켓 등급별 인원수를 구하고, 티켓 등급별 생존자수 구하기
		// 생존자수/전체인원*100
		int cnt1[] = { 0, 0, 0, 0 };
		int cnt2[] = { 0, 0, 0, 0 };

		for (Titanic t : list) {
			if (t.getPclass() == 1) {
				cnt1[0]++;
				if (t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[0]++;
				}

			} else if (t.getPclass() == 2) {
				cnt1[1]++;
				if (t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[1]++;
				}
			} else if (t.getPclass() == 3) {
				cnt1[2]++;
				if (t.getSurvived().equalsIgnoreCase("yes")) {
					cnt2[2]++;
				}
			}
		}
		System.out.println("1등급 생존자수 => " + (float) cnt2[0] / (float) cnt1[0] * 100);
		System.out.println("2등급 생존자수 => " + (float) cnt2[1] / (float) cnt1[1] * 100);
		System.out.println("3등급 생존자수 => " + (float) cnt2[2] / (float) cnt1[2] * 100);
	}

	// for문 사용
	public void printListAll(List<Titanic> list) {
		// 위치를 알 수 없음.
		for (Titanic t : list) {
			System.out.println(t.getName());
		}
		// 위치를 알 수 있음.
		for (int i = 0; i < list.size(); i++) {
			Titanic t = list.get(i);
			System.out.println(t.getName());
		}
	}

	// while문 사용
	public void printListAll1(List<Titanic> list) {
		// List 타입을 반복자(Iterator)로 변환하기
		Iterator<Titanic> cursor = list.iterator();
		while (cursor.hasNext()) {
			Titanic c = cursor.next();
			System.out.println(c.getName());
		}

		int i = 0; // 초기값
		while (i < list.size()) { // 조건
			Titanic c = list.get(i);
			System.out.println(c.getName());
			i++; // 증가값
		}
	}

	// do-while문 이용해서 출력
	public void printListAll2(List<Titanic> list) {
		int i = 0; // 초기값
		do {
			Titanic c = list.get(i);
			System.out.println(c.getName());
			i++; // 증가값
		} while (i < list.size()); // 조건
	}

}
