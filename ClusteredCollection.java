import java.util.Iterator;


public class ClusteredCollection implements Iterable {
	

	private Node head;
	
	class Node {
		
		Object o;
		Node next;
		Node prev;
		
		public Node(Object o, Node next, Node prev) {
			this.o = o;
			this.next = next;
			this.prev = prev;
		}
		
		
	}
	
	public ClusteredCollection(Object[] o) {
		
	}
	
	
	
	
	
	
	
    public void add(Object elem) {
    	if(head == null)
    		head = new Node(elem, null, null);
    	else {
    	
        		Node node = head;
        		Node prev = null;
        		
        		while(node.next != null) {
        			
       
        			prev = node;
        			node = node.next;
        			
        		}
        		
        		Node neuesElement = new Node(elem, prev, null);
				prev.next = neuesElement;
				node.prev = neuesElement;
				
        		
        		
  
    		}
    	
    }
    
    public int size() {
    	Node n = head;
    	int size = 0;
		while(n != null) {
			size++;
			n = n.next;
		}
		return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            Node index = head;

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

            @Override
            public Before next() {
            	index = index.next;
                return null;
            }

            @Override
            public boolean hasNext() {
                return index != null;
            }
        };
    }

    @Override
    public String toString() {
    	String ret = "";
        Iterator i = iterator();
        while(i.hasNext())
        	ret += i.next() + (i.hasNext()? "\n" : "");
        return ret;
    }

}
