
public class Nut extends SquirelFood {

	private char peel; // char A-G

	public Nut(int carb, int fat, char peelAtoG) {
		super(carb, fat);
		this.peel = peelAtoG;
	}

	@Override
	public String toString() {
		return super.toString() + ", peel: " + this.peel;
	}

}
