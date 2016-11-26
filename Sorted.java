import java.util.Iterator;


public class Sorted implements java.lang.Iterable<Before> {
	
	public static void main(String[] args) {
		Sorted s = new Sorted();
		s.add(new Fruit(1, 3, 3));
		s.add(new Fruit(2, 3, 3));
		s.add(new Fruit(6, 3, 3));
		s.add(new Fruit(3, 3, 3));
		s.add(new Fruit(5, 3, 3));
		s.add(new Fruit(4, 3, 3));
		s.add(new Fruit(0, 0, 3));
		
		System.out.println(s);
		System.out.println("Size: "+s.size());
		System.out.println();
		System.out.println("Iterator:");
		
		Iterator i1 = s.iterator();
		while(i1.hasNext())
			System.out.println(i1.next());
		
		System.out.println();
		System.out.println("Testing remove():");
		Iterator i2 = s.iterator();
		i2.next();
		i2.next();
		i2.remove();
		System.out.println(s);
		
		System.out.println("Element 4 wurde geschloescht");
		System.out.println();
		
		System.out.println("Alle loeschen:");
		
		Iterator i3 = s.iterator();
		while(i3.hasNext())
			i3.remove();
		
		System.out.println("Size: "+s.size());
		
	}
	
	private Node head;
	
    class Node {
    	
        Before elem;
        Node next;
        Node prev;

        public Node(Before elem, Node prev, Node next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
        
    }

    public void add(Before elem) {
    	if(head == null)
    		head = new Node(elem, null, null);
    	else {
    	
    		if(elem.before(head.elem)) {
    			Node tmp = head;
    			head = new Node(elem, null, head);
    			tmp.prev = head;
    		} else {
    			
        		Node node = head;
        		Node prev = null;
        		
        		while(node != null) {
        			
        			if(elem.before(node.elem)) {
        				Node neuesElement = new Node(elem, prev, node);
        				prev.next = neuesElement;
        				node.prev = neuesElement;
        				break;
        			}
        			
        			prev = node;
        			node = node.next;
        			
        		}
        		
        		if(node == null)
        			prev.next = new Node(elem, prev, null);
  
    		}
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
        return new Iterator<Before>() {
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
            	Before ret = index.elem;
            	index = index.next;
                return ret;
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
