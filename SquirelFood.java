
public abstract class SquirelFood implements Before<SquirelFood> {

	//assert carb and fat >= 0
	private int carb;
	private int fat;

	public SquirelFood(int carb, int fat) {
		this.carb = carb;
		this.fat = fat;
	}

	@Override
	public String toString() {
		return "carb: " + this.carb + "%, fat: " + this.fat + "%";
	}

	//assert that != null
	private boolean equals(SquirelFood that) {
		return (this.fat == that.fat && this.carb == that.carb);
	}

	@Override
	//assert s != null
	public boolean before(SquirelFood s) {
		if (this.equals(s)) {

			return false;
		}

		return (this.carb >= s.carb * 1.2 || this.fat >= s.fat * 1.2);
	}
}
