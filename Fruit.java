
public class Fruit extends SquirelFood {

    //assert eatWithinDays >= 0 and <= Integer.MAX_VALUE
	private int eatWithinDays;

	//assert carb and fat >= 0
	public Fruit(int carb, int fat, int eatWithinDays) {
		super(carb, fat);
		this.eatWithinDays = eatWithinDays;
	}

	@Override
	public String toString() {
		return super.toString() + ", eat within " + eatWithinDays + " days";
	}
}
