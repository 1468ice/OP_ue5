import java.util.Iterator;

public class Clustered<Collection, B extends Before> extends Sorted<B> {
	
class Node {
    	
        Before elem;
        Node next;
        Node prev;
        ClusteredCollection c;
        

        public Node(Before elem, Node prev, Node next, ClusteredCollection c) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
            this.c = c;
        }
}

	Node head; 
	
	@Override
	public Iterator iterator() {
		return super.iterator();
	}


	public Iterator iterator(final Object o) {
		return new Iterator() {
			
			Node index;
			
			
			@Override
			public boolean hasNext() {
				return (next()!= null);
			}

			@Override
			public Node next() {
				while (index.next != null) {
					index = index.next;
					Iterator i = index.c.iterator();
					while(i.hasNext()) {
						if(i.next().equals(o)) {
							return index;
						}
					}
				}
				return null;
			}


			@Override
			public void remove() {
				if(index == head) {
					head = index.next;
					if (head != null)
						head.prev = null;
				} else {

					Node prev = index.prev;
					Node next = index.next;

					prev.next = next;
					next.prev = prev;
				}

				index = index.next;
			}
		};
	}

	public void add(Object[] objects, B elem) {
		ClusteredCollection c = new ClusteredCollection(objects);
	    	if(head == null)
	    		head = new Node(elem, null, null, c);
	    	else {
	    	
	    		if(elem.before(head.elem)) {
	    			Node tmp = head;
	    			head = new Node(elem, null, head, c);
	    			tmp.prev = head;
	    		} else {
	    			
	        		Node node = head;
	        		Node prev = null;
	        		
	        		while(node != null) {
	        			
	        			if(elem.before(node.elem)) {
	        				Node neuesElement = new Node(elem, prev, node, c);
	        				prev.next = neuesElement;
	        				node.prev = neuesElement;
	        				break;
	        			}
	        			
	        			prev = node;
	        			node = node.next;
	        			
	        		}
	        		
	        		if(node == null)
	        			prev.next = new Node(elem, prev, null, c);
	  
	    		}
	    	}
	  	}


}
