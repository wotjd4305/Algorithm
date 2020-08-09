package Algo.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Z22_LinkedList {
	public static void main(String args[]) {

		Node n1 = new Node();
		n1.pre = null;
		n1.data = 1;
		n1.next = null;

		Node head = n1;

		Node n2 = new Node();
		n2.pre = n1;
		n2.data = 2;
		n2.next = null;
		n1.next = n2;

		LinkedList<Integer> list = new LinkedList<>(); //제너릭스표현법
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		//list = list.toString()이나 같음(오버라이딩)
		//Object를 출력시에는 해시코드 값이 나오지만 여기는 toString()
		System.out.println(list); //객체의 주소를 노출x
		list.add(2,100);
		System.out.println(list);
		list.remove(1);//first, last, all, index(지우고싶은데이터)
		System.out.println(list);
		
		
	}
}// class

class Node {
	Node pre;
	int data;
	Node next;
}