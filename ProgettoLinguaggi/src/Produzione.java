import java.io.Serializable;
import java.util.List;

/**
 * Rule in a grammar.
 * A rule consists of a left hand side (LHS, a {@link NonTerminale}) 
 * and a right hand side (RHS, a string of {@link Simbolo}s).
 */
public class Produzione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final NonTerminale lhs;
	private final List<Simbolo> rhs;

	/** Constructs a rule from a given lhs and rhs. */
	public Produzione(NonTerminale lhs, List<Simbolo> rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/** Returns the LHS of this rule. */
	public NonTerminale getLHS() {
		return lhs;
	}
	
	/** Returns the right hand side of this rule. */
	public List<Simbolo> getRHS() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return lhs.getName() + "->" + rhs;
	}
}