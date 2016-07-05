package com.list.singly;


public class MergeSortList <E extends Comparable<E>> {

	public static void main(String[] args) {

		
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtLast(12);
		list.insertAtLast(1);
		list.insertAtLast(10);
		list.insertAtLast(9);
		list.insertAtLast(8);

		MergeSortList<Integer> mSort = new MergeSortList<Integer>();
		Node<Integer> sortedNodeHead =mSort.Sort(list.getFirst());
		while (sortedNodeHead!=null) {
			System.out.println(sortedNodeHead);
			sortedNodeHead =sortedNodeHead.getNextNode();
			
		}
	}
	
	//Function of Sort is to take original list and sort it , \
	
	
	
	
	

	//In merge sort we recursively divide the given collection of data 
	//unless the collection has only 1 data in the collection
	// as single data collection is considered sorted in itself
	
	public Node<E> Sort(Node<E> headOriginal){
		
		//As Sort method is called recursively, headOriginal in each stack frame will represent a new head
		
		if(headOriginal == null || headOriginal.getNextNode()==null){ // either empty or only one node in the list
			return headOriginal;
		}
		Node<E> middle = FindMiddleNode(headOriginal); //find middle node
		Node <E> secondListHead = middle.getNextNode();  //when middle node is found take the next node of middle node as start of second list
		middle.setNextNode(null); // marking the next of middle node as end of first 
		
		return merge(Sort(headOriginal),Sort(secondListHead)); //recursively call mergesort for each newly created list
		
	}
	
	
	
	// Merge method is responsible for comparing and arranging the data accordingly  and merging consequently
	//
	private Node<E> merge(Node<E> firstListNode, Node<E> secondListNode) {
		// we create the initial node as null , which will mark as holder of new list 
		Node<E> dummyHead = Node.valueOf(null);
		//currentNode will point to latest node in the  new list , and its head will be dummyNode 
		Node<E> currentNode = dummyHead;
		
		//firstList represent one part of the list
		//secondList represents the remaining part of the list
		while(firstListNode!=null && secondListNode!=null){
			if(null!= firstListNode && firstListNode.getData().compareTo(secondListNode.getData())<=0){
				currentNode.setNextNode(firstListNode);
				firstListNode = firstListNode.getNextNode();
				
			}else{
				currentNode.setNextNode(secondListNode);
				secondListNode = secondListNode.getNextNode();
			}
			// as soon we have added a new node to dummyList 
			currentNode = currentNode.getNextNode();
		}
		currentNode.setNextNode((firstListNode==null)?secondListNode:firstListNode);
		return dummyHead.getNextNode();
	}



	
	
	
	
	public Node<E> FindMiddleNode(Node<E> head) {
		

		  Node<E> fast = null;
		  Node<E> slow = null;
		  int i = 0;
		  if (head==null || head.getNextNode()==null)
		  {
		    /* length < 2 cases */
			  slow = head;
			  fast = null;
		  }
		  else
		  {
		    slow = head;
		    fast = head;
		 
		    while(fast.getNextNode()!=null){
		    	if(i==0)
		    	{
		    		System.out.println("At beginning i is "+i  +" slow is "  + slow.getData() + "   fast is -->" + fast.getData());
		    		fast = fast.getNextNode();
		    		i++;
		    		
		    	}
		    	else if(i==1){
		    		
		    		fast = fast.getNextNode();
		    		slow =slow.getNextNode();
		    		i=0;
		    	}
		    	
		    }
		   
		  }

		return slow;
		
	}



}
