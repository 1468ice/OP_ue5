
public class Test {


    public static void main(String[] args) {
        Nut n = new Nut(10, 20, 'C');
        Nut n2 = new Nut(5, 2, 'A');
        System.out.println(n.before(n2));
        System.out.println(n);
        System.out.println(n2);

        Sorted s = new Sorted();
        s.add(n);
        s.add(n2);
        System.out.println(s);
    }
}
