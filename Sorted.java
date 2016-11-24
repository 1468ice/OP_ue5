import java.util.Iterator;


public class Sorted implements java.lang.Iterable<Before> {

    Node head;

    @Override
    public String toString() {
        String s = "";
        s += head.elem.toString();
        Iterator it = iterator();
        while (it.hasNext()) {
            s += it.next().toString();
        }
        return s;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Before>() {
            Node index = head;

            @Override
            public void remove() {
                index.prev.next = index.next;
                //PREV
            }

            @Override
            public Before next() {
                return index.next.elem;
            }

            @Override
            public boolean hasNext() {
                return (index.next != null);
            }
        };
    }

    public void add(Before elem) {
        if (this.head == null) {
            head = new Node(elem, null);
        } else {
            Node node = head;
            Node prev = null;
            boolean added = false;
            while(node != null) {                       //SET PREV!!!
                if (elem.before(node.elem)) {
                    Node element = new Node(elem, node);
                    prev.next = element;
                    element.prev = prev;
                    added = true;
                }
                prev = node;
                node = node.next;
                if (node.next == null) {
                    node.next = new Node(elem, null);
                }
            }
        }


    }

    class Node {

        public Node(Before elem, Node next) {
            this.elem = elem;
            this.next = next;
            //next.prev = this;
        }

        Before elem;
        Node next;
        Node prev;

    }


}
