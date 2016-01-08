import java.util.List;

/**
 * Rule in a grammar.
 * A rule consists of a left hand side (LHS, a {@link NonTerminale}) 
 * and a right hand side (RHS, a string of {@link Simbolo}s).
 */
public class Regola {
	
	private final NonTerminale lhs;
	private final List<Simbolo> rhs;

	/** Constructs a rule from a given lhs and rhs. */
	public Regola(NonTerminale lhs, List<Simbolo> rhs) {
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