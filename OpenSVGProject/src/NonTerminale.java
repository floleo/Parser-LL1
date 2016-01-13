
public class NonTerminale implements Simboli {
	private final String name;

	public NonTerminale(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (!(o instanceof NonTerminale)) {
			return false;
		}
		NonTerminale other = (NonTerminale) o;
		return name.equals(other.name);
	}
}
