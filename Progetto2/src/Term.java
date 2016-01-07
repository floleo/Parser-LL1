public class Term implements Symbol {

	public Term(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	private final String name;

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Term)) {
			return false;
		}
		Term other = (Term) obj;
		return name.equals(other.name);
	}
}