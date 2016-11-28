import java.util.Iterator;

public class Clustered<A extends ClusteredCollection, B extends Before> extends Sorted<B> {
	
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
			
			Node index = head;
			ClusteredCollection liste = new ClusteredCollection();
			Iterator i = liste.iterator();
			
			{
				
				while(index != null) {
					for(Object object: index.c) {
						if(object.equals(o)) {
							liste.add(index);
						}
					}
					index = index.next;
				}
				
				
			}
			
			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public Node next() {
				return (Node)i.next();
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
