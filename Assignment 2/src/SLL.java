public class SLL<T extends Comparable<T>> {
	
	Node<Token> head; 
	
    Node<Token> tail; 
    
    Node<Token> currentNode = null;
    
    int size;
    
    /**
     * Adds tokens in alphabetical order.
     * 
     */
	public void addInOrder(Node<Token> n) {
	       
		   if (head == null) {
	           head = n; tail = n;
	       } 
		   
	       else {
	           if (n.getData().compareTo(head.getData()) <= 0) 
	              addHead(n);
	           else {
	              currentNode = head;
	              while (currentNode.getNext() != null && n.getData().compareTo((Token) currentNode.getNext().getData()) > 0) {
	                 currentNode = currentNode.getNext();
	              }
	              if (currentNode.getNext() == null)  {
	                  addTail(n);
	              }
	              else {
	                  n.setNext(currentNode.getNext());
	                  currentNode.setNext(n);
	              }
	           }
	       }
		   size ++;
	}
	
	public void addInOrder( Token t){
		addInOrder( new Node<Token>( t));
	}
	
	private void addHead( Node<Token> n) {
	      if (head == null) {
	         head = n; 
	         tail = n;
	      }
	      else {
	         n.setNext(head);
	         head = n;
	      }
	}
	
	private void addTail(Node<Token> n) {
	       if (tail == null) {
	           head = n; 
	           tail = n;
	       }
	       else {
	          tail.setNext(n);
	          tail = n;
	       }
	}
	/**
	 * Finds existing Tokens.
	 * 
	 */
	public Token find(String key) {
		    
	       currentNode = head;
	       Token found = null;
	       while (currentNode != null) {
	           
	    	   if (currentNode.getData().getWord().equals(key)) {
	    		   found = currentNode.getData();
	    		   break;
	       }
	    	   else {
	    		   currentNode = currentNode.getNext();
	    	   }
	       }
	       
	       return found;
   }
	
	public int size () {
		return size;
	}
	/**
	 * Finds Tokens with index number.
	 */
	public Token get( int i) {
	      currentNode = head;
	      int j = 0;
	      while ( currentNode.getNext() != null && j < i)
	      {
	         currentNode = currentNode.getNext();
	         j++;
	      }
	         return currentNode.getData();
	}
	/**
	 * Finds the indexs of a token.
	 *
	 */
	public int indexOf(Token w) {
		 currentNode = head;
	      int count = 0;
	      
		 while (currentNode != null) {
	    	   if (currentNode.getData().equals(w))
	    		   return count;
	    	   else
	    		   currentNode = currentNode.getNext();
	    	   count ++;
	       }
		 return count;
		
	}
	/**
	 * Adds tokens in decreasing frequency order.
	 */
	public void addInOrderDec(Node<Token> n) {
	       
		   if (head == null) {
	           head = n; tail = n;
	       } 
		   
	       else if (n.getData() != null && head.getData() != null){
	           if (Token.CompFreqAsc.compare(n.getData(), head.getData()) <= 0) 
	              addHead(n);
	           else {
	              currentNode = head;
	              while (currentNode.getNext() != null && Token.CompFreqAsc.compare(n.getData(), ((Token) currentNode.getNext().getData())) > 0) {
		                 currentNode = currentNode.getNext();
	              }
	              if (currentNode.getNext() == null)  {
	                  addTail(n);
	              }
	              else {
	                  n.setNext(currentNode.getNext());
	                  currentNode.setNext(n);
	              }
	           }
	       }
		   size ++;
	}
	
	public void addInOrderDec( Token t){
		addInOrderDec( new Node<Token>( t));
	}
	/**
	 * Adds tokens in Increasing frequency order.
	 */
	public void addInOrderInec(Node<Token> n) {
	       
		   if (head == null) {
	           head = n; tail = n;
	       } 
		   
	       else if (n.getData() != null && head != null){
	           if ( Token.CompFreqDesc.compare(n.getData(), head.getData()) >= 0) 
	              addHead(n);
	           else {
	              currentNode = head;
	              
	              while (currentNode.getNext() != null &&  Token.CompFreqAsc.compare(n.getData(), ((Token) currentNode.getNext().getData())) < 0) {
		                 currentNode = currentNode.getNext();
	              }
	              if (currentNode.getNext() == null)  {
	                  addTail(n);
	              }
	              else {
	                  n.setNext(currentNode.getNext());
	                  currentNode.setNext(n);
	              }
	           }
	       }
		   size ++;
	}
	
	private int compare(int i, int j) {
		if(i > j) {
			return 1;
		}
		else if (i == j) {
			return 0;
		}
		return -1;
	}

	public void addInOrderInc( Token t){
		addInOrderInec( new Node<Token>( t));
	}
	
}