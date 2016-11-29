
public class Nut extends SquirelFood {

	private char peel; //assert char A-G

	//assert carb and fat >= 0
	public Nut(int carb, int fat, char peelAtoG) {
		super(carb, fat);
		this.peel = peelAtoG;
	}

	@Override
	public String toString() {
		return super.toString() + ", peel: " + this.peel;
	}

}
