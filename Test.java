import java.util.Iterator;

public class Test {

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
}
