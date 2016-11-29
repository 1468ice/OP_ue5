import java.util.Iterator;

public class Sorted<B extends Before> implements Iterable {

	private Node head;

	//inner class; used for listing
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

	//adds Before element into list in a sorted manner;
	//assert elem != null
	public void add(Before elem) {
		//empty list
		if (head == null)
			head = new Node(elem, null, null);
		else {
			if (elem.before(head.elem)) {
				Node tmp = head;
				head = new Node(elem, null, head);
				tmp.prev = head;
			} else {

				Node node = head;
				Node prev = null;

				while (node != null) {

					if (elem.before(node.elem)) {
						Node neuesElement = new Node(elem, prev, node);
						prev.next = neuesElement;
						node.prev = neuesElement;
						break;
					}

					prev = node;
					node = node.next;

				}

				if (node == null)
					prev.next = new Node(elem, prev, null);

			}
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
		return new Iterator<Before>() {
			Node index = head;

			@Override
			public void remove() {

				if (index == head) {
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
		while (i.hasNext())
			ret += i.next() + (i.hasNext() ? "\n" : "");
		return ret;
	}

}
