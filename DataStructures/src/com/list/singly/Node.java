package com.list.singly;



public final class Node<E extends Comparable<E>>   {

	private E Data;
	private Node<E> nextNode;
	
	
	public Node(E data, Node<E> nextNode) {
		this();
		Data = data;
		this.nextNode = nextNode;
		
	}
	
	public Node() {
		Data = null;
		this.nextNode = null;
		
	}


	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

	public E getData() {
		return Data;
	}


	public void setData(E data) {
		Data = data;
	}

	
	@Override
	public String toString(){
		return "Data: "+ this.Data.toString() ;
		
	}
	
	public static <E extends Comparable<E>> Node<E> valueOf(E value) {
		Node <E>newNode = new Node<E>(value,null);
		return  newNode;
	}
	
	@Override
	public boolean equals(Object obj){
		Node <E> received= null;
	if(obj instanceof Node<?>){
		received = (Node<E>)obj;
		return getData().equals(received.getData());
	}else{
		return false;
	}
		
	}
	
	@Override
	public int hashCode(){
	return getData().hashCode();	
	}
	
}

