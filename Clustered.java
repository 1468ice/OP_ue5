import java.util.Iterator;

public class Clustered<A, B extends Before> extends Sorted<B> {

	private ClusterNode head;

	@Override
	public Iterator iterator() {
		return new Iterator<Before>() {
			ClusterNode index = head;

			@Override
			public void remove() {

				if (index == head) {
					head = index.next;
					if (head != null)
						head.prev = null;
				} else {

					ClusterNode prev = index.prev;
					ClusterNode next = index.next;

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

			public ClusterNode nextClusterNode() {
				ClusterNode ret = index;
				index = index.next;
				return ret;
			}

			@Override
			public boolean hasNext() {
				return index != null;
			}
		};
	}

	public Iterator iterator(final Object o) {
		return new Iterator() {

			ClusterNode index = head;
			ClusteredCollection liste = new ClusteredCollection();
			Iterator i = null;

			{

				while (index != null) {
					for (Object object : index.c) {
						if (o == null || object.equals(o)) {
							liste.add(index);
						}
					}
					index = index.next;
				}

				i = liste.iterator();
			}

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public ClusterNode next() {
				return (ClusterNode) i.next();
			}

		};
	}

	public void add(A[] objects, B elem) {
		ClusteredCollection c = new ClusteredCollection(objects);
		if (head == null)
			head = new ClusterNode(elem, null, null, c);
		else {

			if (elem.before(head.elem)) {
				ClusterNode tmp = head;
				head = new ClusterNode(elem, null, head, c);
				tmp.prev = head;
			} else {

				ClusterNode ClusterNode = head;
				ClusterNode prev = null;

				while (ClusterNode != null) {

					if (elem.before(ClusterNode.elem)) {
						ClusterNode neuesElement = new ClusterNode(elem, prev, ClusterNode, c);
						prev.next = neuesElement;
						ClusterNode.prev = neuesElement;
						break;
					}

					prev = ClusterNode;
					ClusterNode = ClusterNode.next;

				}

				if (ClusterNode == null)
					prev.next = new ClusterNode(elem, prev, null, c);

			}
		}
	}

}
