import java.util.Arrays;
import java.util.List;

/**
 * Rule in a grammar.
 * A rule consists of a left hand side (LHS, a {@link NonTerm}) 
 * and a right hand side (RHS, a string of {@link Symbol}s).
 */
public class Rule {
	
	private final NonTerm lhs;
	private final List<Symbol> rhs;

	/** Constructs a rule from a given lhs and rhs. */
	public Rule(NonTerm lhs, List<Symbol> rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/** Returns the LHS of this rule. */
	public NonTerm getLHS() {
		return lhs;
	}
	
	/** Returns the right hand side of this rule. */
	public List<Symbol> getRHS() {
		return rhs;
	}
	
	@Override
	public String toString() {
		return lhs.getName() + "->" + rhs;
	}
}