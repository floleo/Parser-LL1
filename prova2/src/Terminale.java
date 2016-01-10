public class Terminale implements Simboli {
	
	private final String name;

	public Terminale(String name) {
		this.name=name;
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
		} else if (!(o instanceof Terminale)) {
			return false;
		}
		Terminale other = (Terminale) o;
		return name.equals(other.name);
	}
}
