
public class SquirrelRanking implements Before<SquirrelRanking> {

	float f;

	public SquirrelRanking(float f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "ranking: " + this.f;
	}

	@Override
	public boolean before(SquirrelRanking s) {
		return (this.f >= 2 * s.f);

	}
}
