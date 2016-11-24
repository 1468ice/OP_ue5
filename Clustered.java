import java.util.Iterator;

public class Clustered <T,Z> extends Sorted {

    @Override
    public Iterator iterator() {
        return super.iterator();
    }

    public Iterator iterator(T t, Z z) {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }

    public void add(T t, Z z) {

    }

    public void add(T t) {}
}
