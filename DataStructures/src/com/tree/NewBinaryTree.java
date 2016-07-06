package com.tree;

import java.util.Deque;
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
		
		//binaryTree.preOrderTraversal(binaryTree.getRootNode());
		binaryTree.inOrderTraversal(binaryTree.getRootNode());
		
		System.out.println("inorder predecessor-->"+binaryTree.findInorderPredecessorNode(binaryTree.getRootNode()));
		binaryTree.morrisInorder(binaryTree.getRootNode());
		//binaryTree.postOrderTraversal(binaryTree.getRootNode());
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
		
	}
	
	
	
	
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

/*
 * Using two Stacks
 * Traverse everything on left Sub tree
 * Traverse everything on right Sub tree
 * Visit the Root Node
 * */

	public void postOrderTraversal(NewNode<D> rootNode) {

		if (rootNode == null)
			return;
		Stack<NewNode<D>> stack1 = new Stack<NewNode<D>>();
		Stack<NewNode<D>> stack2 = new Stack<NewNode<D>>();
		stack1.push(rootNode);

		while (!stack1.isEmpty()) {
			rootNode = stack1.pop();

			stack2.push(rootNode);

			if (rootNode.getLeftChild() != null) {
				stack1.push(rootNode.getLeftChild());
			}
			if (rootNode.getRightChild() != null) {
				stack1.push(rootNode.getRightChild());
			}

		}

		System.out.println("Postorder");

		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().getData());
		}

	}
	
	/*
	 * Using one Stack and a auxiliary variable "current" which will point to root node in beginning
	 * Traverse everything on left Sub tree
	 * Traverse everything on right Sub tree
	 * Visit the Root Node
	 * */
	
	
	public void postOrderTraversalUsingOneStack(NewNode<D> rootNode) {

		NewNode<D> current = rootNode;
		if (current == null)
			return;
		Deque<NewNode<D>> stack = new LinkedList<NewNode<D>>();

		// While current is not equal to null

		while (current != null || !stack.isEmpty()) {

			if (current != null) {
				stack.addFirst(current);
				current = current.getLeftChild();
			} else {
				// "current" variable could be pointing to null but
				// stack is not empty see what is the available
				// at the top of stack and get get the right child of that node
				NewNode<D> tempNode = stack.peek().getRightChild();

				// if right child of the node currently at top of stack is null
				if (tempNode == null) {
					// take the node out of the of stack and print it
					tempNode = stack.poll();
					System.out.println(tempNode.getData());

					// we will come to this loop even if
					// TempRightOfTopOfTheStack is not null
					// Now continue to next step
					// 1)check if stack is not empty
					// 2)and we are pointing to right child of whatever is
					//   currently at top of stack
					//point 2 is more of a check to verify that whatever is 
					//currently at top of stack might have right subtree
					//to explore
					while (!stack.isEmpty()
							&& tempNode.getData().compareTo(stack.peek().getRightChild().getData()) == 0) {
						tempNode = stack.poll();
						System.out.println(tempNode.getData());
					}
				}else{
					// we will come here when in last iteration
					//we reached the while loop 
					//of if (tempNode==null) code block
					// and at that point second condition
					//of while loop must have evaluated
					// to false as we have right sub tree to 
					//explore of stacks top element's right
					// and we make that right element as current
					current= tempNode;	
				}

			}

		}

	}
	
	public boolean isSameTree(NewNode<D> root1,NewNode<D> root2){
		
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null || root2 == null)
		{
			return false;
		}
		return root1.getData().compareTo(root2.getData())==0&&isSameTree(root1.getLeftChild(), root2.getLeftChild())
				&&isSameTree(root1.getRightChild(),root2.getRightChild());
		
	}
	
	public int sizeOftree(NewNode<D> root){
		
		if(root==null){
			return 0;
		}
		
		int leftSize = sizeOftree(root.getLeftChild());
		int righttSize = sizeOftree(root.getRightChild());
		return leftSize+ righttSize+1;
		
	}
	
	/*http://www.geekviewpoint.com/java/bst/morris_in_order*/
	public void morrisInorder(NewNode<D> root) {
		
		if (root == null) {
            return;
        }
		NewNode<D> current = root;
		
        while(current != null) {
            //left is null then print the node and go to right
            if (current.getLeftChild() == null) {
                System.out.print(current.getData() + " ");
                current = current.getRightChild();
            }
            else {
                //find the  inorder predecessor.
            	NewNode<D> predecessor = current.getLeftChild();
                
            	 //keep finding the predecessor but also check 
            	//that we are 
                 while (null !=predecessor.getRightChild()  && !current.equals(predecessor.getRightChild())) {
                     predecessor = predecessor.getRightChild();
                 }
            	//if right node is null then go left 
            	//after establishing link from predecessor to current.
                if(predecessor.getRightChild() == null){
                    predecessor.setRightChild(current); 
                    current = current.getLeftChild();
                } else{
                //left is already visit. Go rigth after visiting current.
                System.out.print(current.getData() + " ");
                predecessor.setRightChild(null);
                
                    current = current.getRightChild();
                }
            }
        }
}
}



