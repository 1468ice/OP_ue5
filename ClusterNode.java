public class ClusterNode {

	Before elem;
	ClusterNode next;
	ClusterNode prev;
	ClusteredCollection c;

	public ClusterNode(Before elem, ClusterNode prev, ClusterNode next, ClusteredCollection c) {
		this.elem = elem;
		this.prev = prev;
		this.next = next;
		this.c = c;
	}

	@Override
	public String toString() {
		return elem.toString();
	}
}