import java.io.Serializable;
import java.util.List;

public class Produzione implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final NonTerminale lhs;
	private final List<Simbolo> rhs;

	public Produzione(NonTerminale lhs, List<Simbolo> rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public NonTerminale getLHS() {
		return lhs;
	}
	
	public List<Simbolo> getRHS() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return lhs.getName() + "->" + rhs;
	}
}