import java.util.Map;
import java.util.Set;

public interface LLCalc {
	/** Returns the FIRST-map for the grammar of this calculator instance. */
	public Map<Symbol, Set<Term>> getFirst();

	/** Returns the FOLLOW-map for the grammar of this calculator instance. */
	public Map<NonTerm, Set<Term>> getFollow();

	/** Returns the FIRST+-map for the grammar of this calculator instance. */
	public Map<Rule, Set<Term>> getFirstp();

	/** Indicates if the grammar of this calculator instance is LL(1). */
	public boolean isLL1();
}
