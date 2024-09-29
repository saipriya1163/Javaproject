package classes;

import interfaces.I_Node;

public class Node implements I_Node  {
	Case currentCase;
	Node prev;
	Node next;
	public Node(Case currentCase) {
		this.currentCase=currentCase;
		this.prev=null;
		this.next=null;
	}

	@Override
	public Node getPrev() {
		return this.prev;
	}

	@Override
	public void setPrev(Node prev) {
		this.prev=prev;
		
	}

	@Override
	public Node getNext() {
		return this.next;
	}

	@Override
	public void setNext(Node next) {
		this.next=next;
		
	}

	@Override
	public Case getCase() {
		return this.currentCase;
	}

}
