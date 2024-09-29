package classes;

import interfaces.I_List;

public class List implements I_List {
	Node head;
	Node tail;
	public List() {
		this.head=null;
		this.tail=null;
	}
	@Override
	public Node getHead() {
		return this.head;
	}

	@Override
	public Node getTail() {
		return this.tail ;
	}

	@Override
	public boolean append(Node node) {
		if(node == null) {
			return false;
		}
		if(head == null) {//if list is empty both head and tail points to node
			head=node;
			tail=node;
		}else {
			tail.setNext(node);
			node.setPrev(tail);
			tail=node;
		}
		return true;
	}

	@Override
	public boolean insert(int index, Node node) {
		if(node == null || index <0) {
			return false;
		}
		if(index == 0) {//adds at first position
			node.setNext(head);
			head.setPrev(node);
			head=node;
		}
		else {
            Node current = getNodeAtIndex(index-1);
            node.setNext(current.getNext());
            node.setPrev(current);
            current.setNext(node);
            node.getNext().setPrev(node);
         }
		return true;
	}
	//additional method to return the node at given index
	private  Node getNodeAtIndex(int index) {
		Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.getNext();
            currentIndex++;
        }

        return current;
	}
	
	@Override
	public boolean remove(int index) {
		Node current = getNodeAtIndex(index);
        if (current.getPrev() == null) {
        	head = current.getNext();  
        } else {
        	current.getPrev().setNext(current.getNext());
        }
        if (current.getNext() == null) {
        	tail = current.getPrev();          
        } else {
        	current.getNext().setPrev(current.getPrev()); 
        }
        return true;
	}

	@Override
	//took help of chatgpt for this method
	public boolean swap(int first_index, int second_index) {
		Node firstNode = getNodeAtIndex(first_index);
        Node secondNode = getNodeAtIndex(second_index);
        
        if(firstNode==head) {
        	head=secondNode;
        }else if(secondNode==head) {
        	head=firstNode;
        }
        if(firstNode==tail) {
        	tail=secondNode;
        }else if(secondNode==tail){
        	tail=firstNode;
        }
        //swapping next pointers 
        Node tempNext = firstNode.getNext();
        firstNode.setNext(secondNode.getNext());
        secondNode.setNext(tempNext);
        //updating previous pointers of next nodes(like updating neighboring nodes)
        if(firstNode.getNext()!=null) {
        	firstNode.getNext().setPrev(firstNode);
        }
        if(secondNode.getNext()!=null) {
        	secondNode.getNext().setPrev(secondNode);
        }
        //swapping previous pointers
        Node tempPrev = firstNode.getPrev();
        firstNode.setPrev(secondNode.getPrev());
        secondNode.setPrev(tempPrev);
        //updating next pointers of previous nodes
        if(firstNode.getPrev()!=null) {
        	firstNode.getPrev().setNext(firstNode);
        }
        if(secondNode.getPrev()!=null) {
        	secondNode.getPrev().setNext(secondNode);
        }
        return true;
	}

	@Override
	public void sort() {
		 if (head == null || head.next == null) {
	            return; //if the original case list is empty then nothing to sort
	        }
		 //creating two separate lists for emergency and non-emergency
		 Node emergencyHead=null;
		 Node nonEmergencyHead=null;
		 Node emergencyTail=null;
		 Node nonEmergencyTail=null;
		 Node current=head;
		 while(current!=null) {
			 Node nextNode=current.getNext();
			 //disconnecting node from the original list
			 current.next = null;
	         current.prev = null;
	         //checks if case is emergency if it is true it will add that node to emergency list
			 if(current.getCase().getTreatment()== Treatment.emergency) {
				 if (emergencyHead == null) {//if the list is empty head and tail pointing to same node
	                    emergencyHead = current;
	                    emergencyTail = current;
	                }
				 	// when list is not empty appending node at the end
	                current.setPrev(emergencyTail);
	                emergencyTail.setNext(current);
	                emergencyTail = current;	
	          // if case is not emergency adding node  to non-emergency list
			 }else {
				 if (nonEmergencyHead == null) {
	                    nonEmergencyHead = current;
	                    nonEmergencyTail = current;
	                }
				 	current.setPrev(nonEmergencyTail);
	                nonEmergencyTail.setNext(current);
	                nonEmergencyTail = current; 
			 }
			 current=nextNode;
		 	}
		 	// combining both emergency and non-emergency lists
		 	if (emergencyHead != null) {
		 		//if there are emergency cases then head is set to emergency head & tail is set to non-emergency tail
	            head = emergencyHead;
	            emergencyHead.setPrev(null);
	            tail=nonEmergencyTail;
	            emergencyTail.next = nonEmergencyHead;//this pointer combines both the lists
	        } else {
	        	//if there are no emergency cases then head is set to non-emergency head & tail is set to non-emergency tail
	            head = nonEmergencyHead;
	            nonEmergencyHead.setPrev(null);
	            tail=nonEmergencyTail;
	        }
	}

	@Override
	public int findIndex(String personName) {
		 Node current = head;
	     int index = 0;
	     while (current != null) {
	    	  String test=current.getCase().getOwner().getName();
	          if (test.equals(personName)) {
	               return index;
	           }
	           current = current.getNext();
	           index++;
	        }
	    	return -1;
	}
	

}
