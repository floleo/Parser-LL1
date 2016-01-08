public class NonTerminale implements Simbolo {
	/** Constructs a non-terminal with a given name. */
	public NonTerminale(String name) {
		this.name = name.toUpperCase();
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
		} else if (!(obj instanceof NonTerminale)) {
			return false;
		}
		NonTerminale other = (NonTerminale) obj;
		return name.equals(other.name);
	}
}