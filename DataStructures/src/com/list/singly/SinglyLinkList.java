package com.list.singly;

public class SinglyLinkList<E extends Comparable<E>> {
	
	private Node<E> head = null;
	
	public Node<E> getFirst() {
		return head;
	}


	private void setHead(Node<E> first) {
		this.head = first;
	}


		
	
	public boolean insertAtLast(E data) {

		Node<E> newNode = Node.valueOf(data);
		
		if (getFirst() == null) {
			setHead(newNode);
			return true;
		} else {
			Node<E> currentNode = getFirst();
			Node <E> nextNode = currentNode.getNextNode();
			while (nextNode != null) {
				currentNode = nextNode;
				nextNode = currentNode.getNextNode();
			}
			nextNode = newNode;
			currentNode.setNextNode(nextNode);
			return true;
		}

	}
	
	
	
	public boolean insertAtBeginning(E data) {

		Node<E> newNode = Node.valueOf(data);
		
		if (getFirst() == null) {
			setHead(newNode);
			return true;
		} else {
			Node<E> currentFirstNode = getFirst();
			
			newNode.setNextNode(currentFirstNode);
			setHead(null);
			setHead(newNode);
			return true;
		}

	}
	
	
	
	public boolean insertAfter(E tobeInsertedAfter, E dataToBeInserted) {

		if(tobeInsertedAfter==null){
			return false;
		}
		else{
			Node<E> currentNode = getFirst();
			while(currentNode!=null && (currentNode.getData() != null && currentNode.getData().compareTo(tobeInsertedAfter)!=0)){
				currentNode = currentNode.getNextNode();
			}
			if(currentNode==null){
				System.out.println("Reached at end of List could not find the node after which new node to be inserted hence returning");
				return false;
			}else{
				Node <E> currentNextNode =  currentNode.getNextNode(); // currentNode is referring to node having tobeInsertedAfter element
																	   // Get tothe next  node so that we can set it as next of newnode
				if(currentNextNode==null){// if next node is null that means tobeInsertedAfter is currently last element in the list
					Node <E> newNode = Node.valueOf(dataToBeInserted);
					currentNode.setNextNode(newNode);
				}else{
					Node <E> previousNode = currentNode;
					Node <E> newNode = Node.valueOf(dataToBeInserted); 
					newNode.setNextNode(currentNextNode);
					previousNode.setNextNode(newNode);
				}
			}
		}
		
		Node<E> newNode = Node.valueOf(dataToBeInserted);
		
		if (getFirst() == null) {
			setHead(newNode);
			return true;
		} else {
			Node<E> currentFirstNode = getFirst();
			
			newNode.setNextNode(currentFirstNode);
			setHead(null);
			setHead(newNode);
			return true;
		}

	}
	
	
	public void display(){
		Node <E> firstNode = this.getFirst();
		E data = firstNode.getData();
		if(data!=null){
		System.out.println(data);
		}
		else{
			System.out.println("List is Empty returning");
			return;
		}
		Node <E> nextNode = firstNode.getNextNode();
		while(nextNode!=null ){
			System.out.println(nextNode.getData());
			nextNode = nextNode.getNextNode();
		}
		
	}


	@Override
	public String toString() {
		String  result = "{";
		Node<E> current = this.head;
		
		while(current!=null ){
			result += current.toString() + ","; 
			current = current.getNextNode();
		}
		result+="}";
	return result;
	}
	
	
	public boolean delete(E data) {

		if (getFirst() == null) { //if list is empty
			return false;
		} else {//look in the list
			Node<E> previousNode = getFirst();
			if (previousNode.getData().compareTo(data)==0){// if node to be deleted is the first one
				Node <E> nextNode = previousNode.getNextNode();	
				setHead(nextNode);
				previousNode.setData(null);
				previousNode = null;
				return true;
			}else{// if node to be deleted is not the first one  
				Node <E> currentNode = previousNode.getNextNode(); //start from  node next to first node
				while (currentNode != null && currentNode.getData().compareTo(data)!=0) {// Keep going to the next node until currentNode is NOT NULL , 
																					//also currentNode's Data is not equal to the data to be removed from List
					previousNode = currentNode;
					currentNode = previousNode.getNextNode();
				}
				if(currentNode!=null && currentNode.getData().compareTo(data)==0){//found the matching node
					if(currentNode.getNextNode()==null){//if matched node is the last in the list
						currentNode.setData(null);
						previousNode.setNextNode(null);
						currentNode = null;
						return true;
					}
					else{//if matched node is somewhere in the list
						currentNode.setData(null);
						previousNode.setNextNode(currentNode.getNextNode());
						currentNode = null;
						return true;
					}
				}else{
					return false;
				}
				
			
			}
			
		}

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
	
	
	public int iterativeCount(Node<E> head){
		int count =0;
		if (head==null){
			return count;
		}
		else{
			while(head!=null){
				count++;
				head = head.getNextNode();
			}
			return count;
		}
	}
	
	public int recursiveCount(Node<E> head){
		
		if(head==null){
			return 0;
		}
		else{
			return 1+ recursiveCount(head.getNextNode());
		}
	}
	
	
	public Node<E> reverseList(Node<E> head){
		
		Node <E>current = head ;
		Node <E> next = null;
		Node <E> previous = null;
		
		while(current != null){
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		head = previous;
		
		return head;
	}
	
	
public SinglyLinkList<E> copyList(Node<E> current){
		
		SinglyLinkList<E> copiedList = new SinglyLinkList<E>();
		copiedList.setHead(current);
		
		return copiedList;
	}



public void recursiveReverseList(Node<E> head){
	
	Node <E>current = head ;
	Node <E> nextNode = null;
	Node <E> previous = null;
	
	
	if(current.getNextNode() == null){
		
		this.head=current;
		return;
	}
	recursiveReverseList(current.getNextNode());
	System.out.println("Starting from -->" + current.getData());
	nextNode = current.getNextNode();
	System.out.println(nextNode.getData());
	System.out.println("Now need to update the next nodes next link to current Node");
	nextNode.setNextNode(current);
	System.out.println("Invalidates currentsNode next node as we already have got its address in nextNode");
	current.setNextNode(null);
	
	
	
		/*next = reverserecursiveList(current.getNextNode());
		current.setNextNode(previous);
		previous = current;
		current = next;*/
	/*}else{
	
	head = current;
	}
	return head;*/
}


public void reverseprint(Node <E> head){
	
	
	if(head ==null){
		return;
	}
	else{
		Node<E> current = head;
		reverseprint(head.getNextNode());
		System.out.println("previous >> " + current.getData());
		
		System.out.println(head.getData());
	}
	
}
}
