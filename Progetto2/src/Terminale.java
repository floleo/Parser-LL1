public class Terminale implements Simbolo {

	public Terminale(String name) {
		this.name = name.toLowerCase();
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
		} else if (!(obj instanceof Terminale)) {
			return false;
		}
		Terminale other = (Terminale) obj;
		return name.equals(other.name);
	}
}