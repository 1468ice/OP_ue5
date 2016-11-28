import java.util.Iterator;

public class ClusteredCollection implements Iterable {
	
	
	public static void main(String[] args) {
		ClusteredCollection c = new ClusteredCollection(new Object[] {"hallo", "test", "hi", new Integer(1)});
		Iterator i = c.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}

	private Node head;

	class Node {

		Object o;
		Node next;

		public Node(Object o, Node next) {
			this.o = o;
			this.next = next;
		}

	}
	
	public ClusteredCollection() {
		
	}

	public ClusteredCollection(Object[] objects) {
		for (Object o : objects)
			add(o);
	}

	public void add(Object elem) {
		if (head == null)
			head = new Node(elem, null);
		else {

			Node node = head;
			while (node.next != null)
				node = node.next;
			
			node.next = new Node(elem, null);
		}
	}

	public int size() {
		Node n = head;
		int size = 0;
		while (n != null) {
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
			public Object next() {
				Object ret = index.o;
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
		while (i.hasNext())
			ret += i.next() + (i.hasNext() ? "\n" : "");
		return ret;
	}

}
