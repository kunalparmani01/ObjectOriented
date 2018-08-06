package com.jda.util;

public class Queue <T>{
	
	Node head = null;
	Node tail;
	class Node{
		T data;
		Node next;
		Node(T d){data = d; next = null;}
	}
	public void nqueue(T d){
		Node new_node = new Node(d);
		if(head == null){
			head = new_node;
			tail = new_node;
			return;
		}
		tail.next = new_node;
		tail = new_node;
	}
	public T dequeue(){
		T value = head.data;
		head = head.next;
		return value;
	}
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
	public int size(){
		if(head == null)
			return 0;
		int count = 1;
		Node current = head;
		while(current != tail){
			count++;
			current = current.next;
		}
		return count;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		Node current = head;
		while(current != null){
			str += current.data;
			str += " ";
			current = current.next;
		}
		return str;
	}

}
