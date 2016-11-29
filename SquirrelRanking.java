
public class SquirrelRanking implements Before<SquirrelRanking> {

	//a Ranking should be >= 0
	private float f;

	public SquirrelRanking(float f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "ranking: " + this.f;
	}

	@Override
	//assert s != null
	public boolean before(SquirrelRanking s) {
		return (this.f >= 2 * s.f);

	}
}
