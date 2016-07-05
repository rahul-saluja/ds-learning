package com.list.singly;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestList {

	public static void main(String[] args) {
		
		
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtLast(12);
		list.insertAtLast(13);
		list.insertAtLast(14);
		//list.insertAtLast(15);
		/*list.insertAtLast(16);
		list.insertAtLast(17);*/
		
		//System.out.println(3%2);
		
		
		
/*MergeSortList<Integer> mSort = new MergeSortList<Integer>();
		
		Node<Integer> frontStart= null;
		Node<Integer> backStart= null;
		System.out.println(mSort.splitList(list.getFirst(), frontStart, backStart).getData() +""  + backStart.getData());
		System.out.println();*/
//		System.out.println(list);
		
		//list.display();
		/*list.delete(14);
		System.out.println("After delete");
		list.display();*/
		
		//System.out.println(list.findMiddleNode().getData());
		
		
		
		/*Integer int12 = new Integer(12);
		Integer int121 = new Integer(12);
		System.out.println(int12.hashCode()  + "    "  + int121.hashCode());
		Node <Integer> node1 = Node.valueOf(12);
		Node <Integer> node2 = Node.valueOf(12);
		System.out.println(node1==node2  );
*/		//System.out.println(node2   );
		

	}
	
	@Test
	public void testRecursiveCount(){
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtBeginning(12);
		list.insertAtBeginning(13);
		list.insertAtBeginning(14); 
		int result = list.recursiveCount(list.getFirst());
		assertEquals(3,result);
	}

	@Test
	public void testIterativeCount(){
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtBeginning(12);
		list.insertAtBeginning(13);
		list.insertAtBeginning(14); 
		int result = list.iterativeCount(list.getFirst());
		assertEquals(3,result);
	}
	
	@Test
	public void testMiddleNode(){
		
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtLast(12);
		list.insertAtLast(13);
		list.insertAtLast(14);
		list.insertAtLast(15);
		list.insertAtLast(16);
		
		Node<Integer> middleNode = list.FindMiddleNode(list.getFirst());
		assertEquals(14,middleNode.getData().intValue());
	}
	
	@Test
	public void testReverList(){
		
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtLast(12);
		list.insertAtLast(13);
		list.insertAtLast(14);
		list.insertAtLast(15);
		list.insertAtLast(16);
		
		Node<Integer> reversedListHead = list.reverseList(list.getFirst());
		list.copyList(reversedListHead);
		assertEquals(16,reversedListHead.getData().intValue());
		SinglyLinkList<Integer> reversedList = list.copyList(reversedListHead);
		reversedList.display();
		Node<Integer> doublereversedListHead =reversedList.reverseList(reversedList.getFirst());
		list.copyList(doublereversedListHead).display();
		
		
	}
	
	@Test
	public void testRecursiveReverList(){
		
		SinglyLinkList<Integer> list = new SinglyLinkList<Integer>();
		list.insertAtLast(12);
		list.insertAtLast(13);
		list.insertAtLast(14);
		/*list.insertAtLast(15);
		list.insertAtLast(16);*/
		
		list.recursiveReverseList(list.getFirst());
		list.display();
//		Node<Integer> reversedListHead = list.reverserecursiveList(list.getFirst());
		
		/*reversedListHead*/
		
		/*list.copyList(reversedListHead);
		assertEquals(16,reversedListHead.getData().intValue());
		
		SinglyLinkList<Integer> reversedList = list.copyList(reversedListHead);
		reversedList.display();*/
		/*Node<Integer> doublereversedListHead =reversedList.reverseList(reversedList.getFirst());
		list.copyList(doublereversedListHead).display();*/
		
		
	}
}

