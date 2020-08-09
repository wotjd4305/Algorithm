package Algo.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Z20_선형Queue {
	static Scanner sc = new Scanner(System.in);
	public static int[] q = new int[5];
	public static int front = -1;
	public static int rear = -1;
	public static void main(String args[]){
		//큐를 모두 구현해보기
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(deQueue()); // 1
		System.out.println(deQueue()); // 2
		System.out.println(deQueue()); // 3
		
		//제공하는 API 활용하기
		Queue<Integer> q = new LinkedList<>();
		q.offer(4);
		q.offer(5);
		q.offer(6);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		int q3[] = new int[5];
		int front3 = -1;
		int rear3 = -1;
		q3[++rear3] = 7;
		q3[++rear3] = 8;
		q3[++rear3] = 9;
		System.out.println(q3[++front3]);
		System.out.println(q3[++front3]);
		System.out.println(q3[++front3]);
		
		
	}
	private static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Underflow error~!");
			return -1;
		}else {
			return q[++front];
		}
	}
	
	//큐가 비어있는지 여부를 리턴하는 메소드
	private static boolean isEmpty() {
		return front == rear;
	}
	//큐에 데이터 삽입
	private static void enQueue(int item) {
		if(isFull()) { // 꽉차있으면
			System.out.println("Queue overflow error~!");
		}else {
			q[++rear] = item;
		}	
	}
	//큐가 꽉 차있는지 여부를 리턴하는 메소드
	private static boolean isFull() {
		return rear == q.length -1;
	}
}// class