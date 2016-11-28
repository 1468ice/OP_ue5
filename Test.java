import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
//		Sorted s = new Sorted();
//		s.add(new Fruit(1, 3, 3));
//		s.add(new Fruit(2, 3, 3));
//		s.add(new Fruit(6, 3, 3));
//		s.add(new Fruit(3, 3, 3));
//		s.add(new Fruit(5, 3, 3));
//		s.add(new Fruit(4, 3, 3));
//		s.add(new Fruit(0, 0, 3));
//		
//		System.out.println(s);
//		System.out.println("Size: "+s.size());
//		System.out.println();
//		System.out.println("Iterator:");
//		
//		Iterator i1 = s.iterator();
//		while(i1.hasNext())
//			System.out.println(i1.next());
//		
//		System.out.println();
//		System.out.println("Testing remove():");
//		Iterator i2 = s.iterator();
//		i2.next();
//		i2.next();
//		i2.remove();
//		System.out.println(s);
//		
//		System.out.println("Element 4 wurde geschloescht");
//		System.out.println();
//		
//		System.out.println("Alle loeschen:");
//		
//		Iterator i3 = s.iterator();
//		while(i3.hasNext())
//			i3.remove();
//		
//		System.out.println("Size: "+s.size());
//		
		Clustered<String, Nut> c = new Clustered<>();
		
		String[] s = new String[] { "Nut1", "Typ2", "Nut3"};
		String[] s2 = new String[] { "Typ1", "Typ2", "Typ3"};
		String[] s3 = new String[] { "1", "2", "3"};
		
		c.add(s,new Nut(3, 3, 'A'));
		c.add(s2,new Nut(5, 5, 'C'));
		c.add(s3,new Nut(5, 1, 'F'));
		
		Iterator i = c.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		System.out.println();
		
		Iterator i2 = c.iterator("Typ2");
		while(i2.hasNext())
			System.out.println(i2.next());
		
		System.out.println();
		
		
		
		Sorted<Nut> nuts = new Sorted<>();
		
		nuts.add(new Nut(3,3,'A'));
		nuts.add(new Nut(4,4,'B'));
		
		Clustered<Integer, SquirrelRanking> clustered = new Clustered<>();
		
		clustered.add(new Integer[] {1,5,3},new SquirrelRanking(3.5f));
		clustered.add(new Integer[] {4,5,6},new SquirrelRanking(2.5f));	
		
		
		Iterator i3 = clustered.iterator();
		while(i3.hasNext())
			System.out.println(i3.next());
		
		System.out.println();
		
		Iterator i4 = clustered.iterator(5);
		while(i4.hasNext())
			System.out.println(i4.next());
		
		System.out.println();
		
	
		Clustered<String, Fruit> clu = new Clustered<>();
		
		clu.add(s, new Fruit(6, 6, 6));
		clu.add(s2, new Fruit(7, 7, 7));
		clu.add(s3, new Fruit(8, 8, 8));
						
		Iterator i5 = clu.iterator();
		while(i5.hasNext())
			System.out.println(i5.next());
		
		System.out.println("#################################3333");
		
		Clustered<String, SquirelFood> cluster= new Clustered<>();
		Iterator i6 = c.iterator(null);
		
		while(i6.hasNext()){
			ClusterNode tmp = (ClusterNode) i6.next();;
			ClusteredCollection n = tmp.c;
			String[] objects = new String[n.size()];
			Iterator nIt = n.iterator();
			int j = 0;
			while (nIt.hasNext()) {
				objects[j] = (String) nIt.next();
				j++;
			}

			
			cluster.add(objects, (SquirelFood)tmp.elem);
			
		
		}
		
		Iterator i7 = c.iterator(null);
		
		while(i7.hasNext()){
			ClusterNode tmp = (ClusterNode) i7.next();;
			ClusteredCollection n = tmp.c;
			String[] objects = new String[n.size()];
			Iterator nIt = n.iterator();
			int j = 0;
			while (nIt.hasNext()) {
				objects[j] = (String) nIt.next();
				j++;
			}
		

			
			cluster.add(objects, (SquirelFood)tmp.elem);
			
		
		}
		
		Iterator clusterIt = cluster.iterator();
		while (clusterIt.hasNext()) 
			System.out.println(clusterIt.next());
	
		
		System.out.println();

		Iterator clusterIt2 = cluster.iterator("Typ2");
		while (clusterIt2.hasNext()) 
			System.out.println(clusterIt2.next());
	
		System.out.println("ETEASD");
		
		Sorted clusterToSort = cluster;
		System.out.println(clusterToSort);
	}
}
