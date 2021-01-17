package TextBook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Z27_우선순위큐{
	public static void main(String args[]) {
		PriorityQueue pq = new PriorityQueue();
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());// 1 2 3 4		
		}		
		
		System.out.println("----------우선순위 지정-----------");
		PriorityQueue pq2 = new PriorityQueue(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		pq2.offer(1);
		pq2.offer(2);
		pq2.offer(3);
		pq2.offer(4);
		while(!pq2.isEmpty()) {
			System.out.println(pq2.poll());// 4 3 2 1	
		}
		
		//내부나 외부에 정렬기준을 꼭 만들어줘야함.
		PriorityQueue<Com> pp = new PriorityQueue<Com>(new Comparator<Com>() {
			@Override
			public int compare(Com o1, Com o2) {
				//나이가 많은 순, 키 큰 순서.
				if(o1.age != o2.age)
					return -(o1.age - o2.age);
				else
					return -(o1.tall - o2.tall);
			}
		});
		pp.offer(new Com(170, "호랑이", 26));
		pp.offer(new Com(160, "수지", 27));
		pp.offer(new Com(180, "김건모", 26));
		pp.offer(new Com(230, "서장훈", 25));
		while(!pp.isEmpty()) 
		{
			System.out.println(pp.poll().toString());
		}
		
	}// main
}// class


class Com{
	int tall;
	String name;
	int age;
	
	public Com(int tall, String name, int age) {
		super();
		this.tall = tall;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[" + tall + ", " + name + ", " + age + "]";
	}
	
	public Com() {
	}		
}