package com.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//First link is which is referrred and on that basis Delete functionality was moved to Node itself
//http://www.algolist.net/Data_structures/Binary_search_tree/Removal

//Second link is more a reference 
//http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

public class NewBinaryTree<D extends Comparable<? super D>> {

	private NewNode<D> rootNode;

	public NewNode<D> getRootNode() {
		return rootNode;
	}

	private void setRootNode(NewNode<D> rootNode) {
		if (rootNode.getData()==null){
			throw new NullPointerException("Roots Data cannot be Null");
		}else
		this.rootNode = rootNode;
	}

	public NewBinaryTree() {
		super();
		this.rootNode = null;
	}

	public static void main(String[] args) {


		
		NewBinaryTree <Integer> binaryTree = new NewBinaryTree<Integer>();
		
		binaryTree.iterativeInsertNode((binaryTree.getNode(Integer.valueOf(12))));
		binaryTree.recursiveInsert(Integer.valueOf(5));
		binaryTree.iterativeInsertNode((binaryTree.getNode(Integer.valueOf(15))));
		binaryTree.recursiveInsert(Integer.valueOf(3));
		binaryTree.iterativeInsertNode((binaryTree.getNode(Integer.valueOf(7))));
		binaryTree.recursiveInsert(Integer.valueOf(13));
		binaryTree.iterativeInsertNode((binaryTree.getNode(Integer.valueOf(17))));
		
		binaryTree.preOrderTraversal(binaryTree.getRootNode());
		binaryTree.inOrderTraversal(binaryTree.getRootNode());
		binaryTree.postOrderTraversal(binaryTree.getRootNode());
		/*System.out.println("Print Tree" +binaryTree.getRootNode());
		
		
		System.out.println((binaryTree.iterativeSearch(binaryTree.getNode(Integer.valueOf(3)))));
		System.out.println(binaryTree.deleteNode(12));
		System.out.println( binaryTree.deleteNode(15));
		System.out.println(binaryTree.deleteNode(17));
		System.out.println(binaryTree.getRootNode());*/
				
		

	}

	
	private  NewNode<D> getNode(D valueOf) {
		return NewNode.valueOf(valueOf);
		
	}

	private  NewNode<D> getNode() {
		return  NewNode.valueOf(null);
		
	}
	
	
	private boolean  recursiveInsert(D valueTobeInserted) {
		//check if node been passed is null 
		
		if (null == valueTobeInserted ) {
			return false;
		}
		NewNode<D> currentRootNode = getRootNode();
		
		if(currentRootNode==null){
			NewNode<D> nodeTobeInserted =null;
			setRootNode(nodeTobeInserted);
			return true;
		} 
		else  {
			return getRootNode().add(valueTobeInserted);
		}
	}


	private boolean recursiveSearch(NewNode<D> nodeTobeSearched) {

		NewNode<D> currentNode = getRootNode();
		return currentNode.search(nodeTobeSearched.getData());

	}
	
	/*private NewNode<D> recursiveNodeSearch(NewNode<D> nodeTobeSearched) {

		NewNode<D> currentNode = getRootNode();
		return currentNode.search(nodeTobeSearched);

	}*/
	
	public int findHeightOfTreeRecursively (NewNode<D> rootNode){
		int height=-1;
		
		if(rootNode==null){
			return height ;
		}
		
		int heightOfLeftSubTree = findHeightOfTreeRecursively( rootNode.getLeftChild());
		int heightOfRighttSubTree = findHeightOfTreeRecursively(rootNode.getRightChild());
		
		return Math.max(heightOfLeftSubTree, heightOfRighttSubTree)+1;
	}	



	public boolean deleteNode(D dataOfNodeTobeDeleted) {
		boolean result = false;
		if (getRootNode() == null) {

			return false;
		}
		if(dataOfNodeTobeDeleted.compareTo(getRootNode().getData())==0) //root node to be deleted
		{
			NewNode<D> auxilaryNode =getNode(); //just creating a temporaryNode
			auxilaryNode.setLeftChild(getRootNode());
			 result =getRootNode().removeNode(dataOfNodeTobeDeleted, auxilaryNode);
			this.setRootNode(auxilaryNode.getLeftChild());
			return result;
		}else{
			result =getRootNode().removeNode(dataOfNodeTobeDeleted, null);
		}
		
		return result;
		
		/*// find the node of data passed in
		NewNode<D> deleteNode = recursiveSearch(getRootNode(),
				NewNode.valueOf(dataOfNodeTobeDeleted));

		if (deleteNode == null) {
			return null;
		}

		NewNode<D> holdNode;

		*//**
		 * case c , when @link{deleteNode} will have both left and right child
		 * we handle case c first as it will be transformed into case a or case
		 * b
		 *//*

		if (deleteNode.getLeftChild() != null
				&& deleteNode.getRightChild() != null) {
			holdNode = findInorderPredecessorNode(deleteNode);
			deleteNode.setData(holdNode.getData());
			//fall through case a or b
			deleteNode = holdNode;

		}

		*//**
		 * case a , when @link{deleteNode} will be a leaf node and both left and
		 * right child are null.
		 *//*
		if (deleteNode.getLeftChild() == null
				&& deleteNode.getRightChild() == null) {
			//deleteHere(deleteNode, null);
			 valueTobeRetured =deleteNode.getData();
			 deleteNode.clear();
			return (NewNode<D>) valueTobeRetured; 
		}
		
		*//**
		 * case c , when @link{deleteNode}  has either of  one childNode
		 *//*
		if (deleteNode.getRightChild() != null) {
			holdNode = deleteNode.getRightChild(); 
			deleteNode.setRightChild(null);
			}else{
				holdNode = deleteNode.getLeftChild(); 
				deleteNode.setLeftChild(null);
			}
			
		//deleteHere(deleteNode, holdNode);
			if(rootNode ==deleteNode){
				rootNode = holdNode;
			}
			
			 valueTobeRetured =deleteNode.getData();
			 deleteNode.clear();
			return deleteNode;
*/		}
//	}
	
	
	/*private void deleteHere(NewNode<D> nodeTobeDeleted, NewNode<D> nodeTobeAttached){
		
		//nodeTobeDeleted has only one subtree node i.e nodeTobeAttached (which is to be attached to parent of nodeTobeDeleted )
		
		NewNode<D> parentOfNodeTobeDeleted = nodeTobeDeleted.getParentNode();
		if(parentOfNodeTobeDeleted==null){
			return;
		}
		//if node to be deleted is left child of its parent
		if(nodeTobeDeleted == parentOfNodeTobeDeleted.getLeftChild()){
			//atach as left subtree
			parentOfNodeTobeDeleted.setLeftChild(null);
			parentOfNodeTobeDeleted.setLeftChild(nodeTobeAttached);
			return;
		}
		//if node to be deleted is right child of its parent		
		parentOfNodeTobeDeleted.setRightChild(null);
		parentOfNodeTobeDeleted.setRightChild(nodeTobeAttached);
	}*/
	
	
/**
 * To be enhanced as per new New Node object
 * 
 * *********/	
public <E> Comparable findMaxRecursive(E rootNode){
		
		if(rootNode==null){
			return Integer.valueOf(-1);
		}
				
		else if((E)((NewNode)rootNode).getRightChild()==null){
			return ((NewNode)rootNode).getData();
		}
		return findMaxRecursive(((NewNode)rootNode).getRightChild());
	}
	
	
public <E> Comparable findMaxIterative(E rootNode){
		
		if(rootNode==null){
			return Integer.valueOf(-1);
					
		}while((E)((NewNode)rootNode).getRightChild()!=null){
			rootNode=(E)((NewNode)rootNode).getRightChild();
					
		}
		
		return ((NewNode)rootNode).getData();
		
	}

public <E> E findMaxNodeIterative(E rootNode){
	
	if(rootNode==null){
		return null;
				
	}while((E)((NewNode)rootNode).getRightChild()!=null){
		rootNode=(E)((NewNode)rootNode).getRightChild();
				
	}
	
	return rootNode;
	
}
	


/*****
 * Iterative Section
 * 
 * ****/

private boolean iterativeInsertNode(NewNode<D> node) {
	
 if (getRootNode()==null){
		setRootNode(node);
		return true;
	}
 else if(getRootNode().getData().equals(node.getData())){
		return false;
	}
	
	NewNode<D> currentRootNode= getRootNode();
	
	
	while (currentRootNode != null) {
		if (currentRootNode.getData().compareTo(node.getData()) > 0) {
			if (currentRootNode.getLeftChild() == null) {
				currentRootNode.setLeftChild(node);
				node.setParentNode(currentRootNode);
				return true;
				}
			else{
				currentRootNode = currentRootNode.getLeftChild();
			}
		} else if (currentRootNode.getData().compareTo(node.getData()) < 0) {
			if (currentRootNode.getRightChild() == null) {
				currentRootNode.setRightChild(node);
				node.setParentNode(currentRootNode);
				return true;
				}
			else{
				currentRootNode = currentRootNode.getRightChild();
			}
		}else{
			if(currentRootNode.getData().compareTo(node.getData()) == 0){
				System.out.println("Duplicate Insert tried");
				return false;
			}
		}
		
	}
	return false;
}



/**
 * This function takes the argement as {@link NewNode} which is counted as rootNode
 * then traverses the tree in breadth first manner from left to right, for each level 
 * height is incremented by 1 , if rootnode is null then height is considered as -1
 * 
 *  
 * There are two conventions to define height of Binary Tree
 * 1) Number of nodes on longest path from root to the deepest node.
 * 2) Number of edges on longest path from root to the deepest node.
 
 *	the second convention is followed. in folowing code
 * 
 * */
public int findHeightOfTreeIteratively (NewNode<D> root){
	int height=-1;
	
	int nodeCount=0;
	
	if(root==null){
		return height;
	}
	
	
	Queue<NewNode<D>> nodesHolder = new LinkedList<NewNode<D>>();
	nodesHolder.add(root);
	while (true){
		
		
		if(nodesHolder.size()>0)
		{
		Iterator<NewNode<D>> nodeIterator =nodesHolder.iterator();
		while(nodeIterator.hasNext()){
		(nodeIterator.next()).getData();
		}
		}

		nodeCount = nodesHolder.size();
		if(nodeCount==0){
			return height;
		}
		height++;
		
		while(nodeCount>0){
			
			NewNode<D> node = nodesHolder.poll();
			
			if(node!=null && node.getLeftChild()!=null){
				nodesHolder.add(node.getLeftChild());
			}
			if(node!=null && node.getRightChild()!=null){
				nodesHolder.add(node.getRightChild());
			}
			nodeCount--;
		}
		
		
	}
	
	}	



private  boolean iterativeBooleanSearch(D value) {

	if (value ==null){
		return false;
	}
	if (getRootNode() == null) {
		return false;
	} 
	else if (getRootNode().getData() == null) {
		return false;
	}else if (value.equals(getRootNode().getData())) {
		return true;
	}
	NewNode<D> tempNewNode = getRootNode();

	while (tempNewNode != null) {
		if (tempNewNode.getData().compareTo(value) > 0) {

			tempNewNode = tempNewNode.getLeftChild();
			if (tempNewNode !=null && tempNewNode.getData().compareTo( value) == 0) {
				return true;
			} 

		}else if (tempNewNode.getData().compareTo( value) < 0) {

			tempNewNode = tempNewNode.getRightChild();
			if (tempNewNode !=null && tempNewNode.getData().compareTo( value) == 0) {
				return true;
			}
		}
	}

	return false;

}



private NewNode<D>   iterativeSearch(NewNode<D> node) {

	if (node ==null){
		return null;
	}
	else if (getRootNode() == null) {
		return null;
	} 
	else if (node.equals(getRootNode().getData())) {
		return getRootNode();
	}
	NewNode<D> currentNode = getRootNode();

	while (currentNode != null) {
		if (currentNode.getData().compareTo(node.getData()) > 0) {
			currentNode = currentNode.getLeftChild();
		}else if (currentNode.getData().compareTo( node.getData()) < 0) {
			currentNode = currentNode.getRightChild();
		}
		else{
			return currentNode;
		}
	}

	return null;

}

	
public  D findMinValueIterative(){

NewNode<D> tempNewNode = getRootNode();
	if(tempNewNode==null){
		return  getNode().getData();
				
	}while(tempNewNode.getLeftChild()!=null){
		tempNewNode=tempNewNode.getLeftChild();
				
	}
	
	return tempNewNode.getData();
	
}


public  NewNode<D> findMinNodeIterative(){

NewNode<D> tempNewNode = getRootNode();
	if(tempNewNode==null){
		return (NewNode<D>) this.getNode();
				
	}while(tempNewNode.getLeftChild()!=null){
		tempNewNode=tempNewNode.getLeftChild();
				
	}
	
	return tempNewNode;
	
}
/**
 * Inorder Predecessor is  the node which will come before the given node 
 * if we do inorder traversal of the whole tree.d
 *
 * */

public  NewNode<D> findInorderPredecessorNode(NewNode<D> node){
	
	NewNode<D> inOrderPredecessor= null;
	if(node.getLeftChild()==null)
	return node;
	else
	{
		inOrderPredecessor = node.getLeftChild();
		
		while(inOrderPredecessor.getRightChild()!=null){
			inOrderPredecessor =inOrderPredecessor.getRightChild();
			
		}
		
	}
		return inOrderPredecessor;
	}



public  void preOrderTraversal(NewNode<D> rootNode){

	System.out.println("PreOrder");
	if(rootNode==null)
		return;

	Stack<NewNode <D>> stack = new Stack<NewNode<D>>();
	stack.push(rootNode);
	
		while (!stack.isEmpty()) {
			rootNode = stack.pop();
			
			System.out.println(rootNode.getData());
			
			if (rootNode.getRightChild() != null) {
				stack.push(rootNode.getRightChild());

			}
			if (rootNode.getLeftChild() != null) {
				stack.push(rootNode.getLeftChild());
			}
			

		}
	}


public  void inOrderTraversal(NewNode<D> rootNode){
	System.out.println("InOrder");
	Stack<NewNode <D>> stack=null;
	if(rootNode==null)
		return;
	else{
		stack = new Stack<NewNode<D>>();
		stack.push(rootNode);
	}
		while (!stack.isEmpty()) {
			
			if(rootNode.getLeftChild()!=null){
				rootNode = rootNode.getLeftChild();
				stack.push(rootNode);
				if(rootNode.getLeftChild()!=null)
					continue;
			}
			
			rootNode = stack.pop();
			System.out.println(rootNode.getData());
			
			if(rootNode.getRightChild()!=null){
				rootNode = rootNode.getRightChild();
				stack.push(rootNode);
				if(rootNode.getRightChild()!=null)
					continue;
			}
			
			}
	}



public void postOrderTraversal(NewNode<D> rootNode){
	
	if(rootNode==null)
		return;
	Stack<NewNode <D>> stack1 = new Stack<NewNode<D>>();
	Stack<NewNode <D>> stack2 = new Stack<NewNode<D>>();
	stack1.push(rootNode);
	
	while(!stack1.isEmpty()){
		 rootNode = stack1.pop();
		 
		 stack2.push(rootNode);
		 
		 if(rootNode.getLeftChild()!=null){
			 stack1.push(rootNode.getLeftChild());
		 }
		 if(rootNode.getRightChild()!=null){
			 stack1.push(rootNode.getRightChild());
		 }
		 
	}
	
	System.out.println("Postorder");
	
	while(!stack2.isEmpty()){
		System.out.println(stack2.pop().getData());
	}
	
}
}


