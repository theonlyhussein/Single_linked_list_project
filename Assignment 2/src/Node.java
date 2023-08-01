public class Node<T extends Comparable<T>> {

	private T data;
	
	private Node next;
	
	public Node(T d){
		data = d;
	    setNext(null);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	 public String toString() {
		 return "Node: " + getData().toString();
	 }

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}  
}

