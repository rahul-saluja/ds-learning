package com.tree;

public class NewNode<D extends Comparable<? super D>> {
	
	//NewNode<D extends Comparable<D>>
	//This means that the type parameter must support comparison 
	//with other instances of its own type, via the Comparable interface

	private D data;
	private NewNode<D> leftChild;
	private NewNode<D> rightChild;
	private NewNode<D> parentNode;

	public NewNode<D> getParentNode() {
		return parentNode;
	}

	public void setParentNode(NewNode<D> parentNode) {
		this.parentNode = parentNode;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public NewNode<D> getLeftChild() {
		return leftChild;
	}

	public static <D extends Comparable<? super D>> NewNode<D> valueOf(D valueOf) {
		NewNode<D> newNode = new NewNode<D>(valueOf);
		return newNode;
	}

	public void setLeftChild(NewNode<D> leftChild) {
		this.leftChild = leftChild;
	}

	public NewNode<D> getRightChild() {
		return rightChild;
	}

	public void setRightChild(NewNode<D> rightChild) {
		this.rightChild = rightChild;
	}

	public NewNode(D dataPassed) {
		this.data = dataPassed;
		this.leftChild = null;
		this.rightChild = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((leftChild == null) ? 0 : leftChild.getData().hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.getData().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "NewNode [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof NewNode))
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		NewNode<?> other = (NewNode<?>) obj;
		if (data == null) {
			if (other.getData() != null)
				return false;
		} else if (data.compareTo((D) other.getData()) != 0)
			return false;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (leftChild.getData().compareTo((D) other.leftChild.getData()) != 0)
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (rightChild.getData().compareTo((D) other.leftChild.getData()) != 0)
			return false;
		return true;
	}

	public void clear() {
		leftChild = null;
		rightChild = null;
		data = null;
		parentNode = null;
	}

	public boolean search(D ValueTobeSearched) {

		if (this.getData().compareTo(ValueTobeSearched) == 0) {
			return true;
		}
		if (this.getData().compareTo(ValueTobeSearched) > 0) {
			if (this.getLeftChild() == null) {
				return false;
			}
			this.getLeftChild().search(ValueTobeSearched);
		} else if (this.getData().compareTo(ValueTobeSearched) < 0) {
			if (this.getRightChild() == null) {
				return false;
			}
			this.getRightChild().search(ValueTobeSearched);
		}
		return false;
	}

	public boolean removeNode(D dataTobeRemoved, NewNode<D> auxilaryParentNode) {
		
		//search in a left subtree as node passed is smaller than the node on which removeNode has been called
		if (this.getData().compareTo(dataTobeRemoved) > 0) { // go to left
																// subtree if
																// dataTobeRemoved
																// is smaller
																// than root
																// node data
			if (this.getLeftChild() != null)
				return this.getLeftChild().removeNode(dataTobeRemoved, this);//recursive call
			else
				return false;
		}		//search in a right subtree as node passed is greater than the node on which removeNode has been called
		else if (this.getData().compareTo(dataTobeRemoved) < 0) { // go to
																	// right
																	// subtree
																	// if
																	// dataTobeRemoved
																	// is
																	// greater
																	// than root
																	// node data
			if (this.getRightChild() != null)
				return this.getRightChild().removeNode(dataTobeRemoved, this);//recursive call
			else
				return false;
		} else {
			// we have reached to node i.e it is equal to a node to be deleted
			// and it is a Node which has Both  child
			if (getLeftChild() != null && getRightChild() != null) { // case
																		// where
																		// we
																		// are
																		// removing
																		// the
																		// node
																		// that
																		// has
																		// both
																		// childs
				//Find the Inorder successor
				this.setData(this.getRightChild().getMinValue());// get
																			// the
																			// minimum
																			// value
																			// from
																			// the
																			// right
																			// subtree
																			// and
																			// assign
																			// value
																			// to
																			// node
																			// to
																			// be
																			// actually
																			// delted
				this.getRightChild().removeNode(this.getData(), this); // Remove the node of which data has been copied to the root node
			} else if (auxilaryParentNode.getLeftChild() == this) { // if node
																		// to be
																		// deleted
																		// is
																		// left
																		// node
				auxilaryParentNode
						.setLeftChild(this.getLeftChild() != null ? this.getLeftChild() : this.getRightChild());
				this.clear();
			} else if (auxilaryParentNode.getRightChild() == this) {// if node
																		// to be
																		// deleted
																		// is
																		// right
																		// node
				auxilaryParentNode
						.setRightChild(this.getLeftChild() != null ? this.getLeftChild() : this.getRightChild());
				this.clear();
			}

			return true;
		}
	}

	public boolean add(D valueTobeInserted) {

		//preventing duplicate entries
		if (this.getData().compareTo(valueTobeInserted) == 0) {
			System.out.println("Duplicate insertion values tried , we will not allow duplicate values hence returning false ");
			return false;
		}
		if (this.getData().compareTo(valueTobeInserted) > 0) {
			if (this.getLeftChild() == null) {
				NewNode<D> newlyCreatedNode = NewNode.valueOf(valueTobeInserted);
				newlyCreatedNode.setParentNode(this);
				this.setLeftChild(newlyCreatedNode);
				return true;
			}
			this.getLeftChild().add(valueTobeInserted);
		} else if (this.getData().compareTo(valueTobeInserted) < 0) {
			if (this.getRightChild() == null) {
				NewNode<D> newlyCreatedNode = NewNode.valueOf(valueTobeInserted);
				newlyCreatedNode.setParentNode(this);
				this.setRightChild(newlyCreatedNode);
				return true;
			}
			this.getRightChild().add(valueTobeInserted);
		}
		return false;
	}

	public D getMinValue() {

		NewNode<D> currentRootNode = this; // assign node on which this method
											// is called as currentNode

		if (currentRootNode.getLeftChild() != null) {
			this.getLeftChild().getMinValue();
		}
		return currentRootNode.getData();

	}

	public D getMinValueIterative() {

		NewNode<D> currentRootNode = this; // assign node on which this method
											// is called as currentNode
		if (currentRootNode.getLeftChild() == null) {
			return currentRootNode.getData();
		}
		while (currentRootNode.getLeftChild() != null) {
			currentRootNode = currentRootNode.getLeftChild();
		}
		return currentRootNode.getData();

	}
}
