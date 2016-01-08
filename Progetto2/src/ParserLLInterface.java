import java.util.Map;
import java.util.Set;

public interface ParserLLInterface {
	/** Returns the FIRST-map for the grammar of this calculator instance. */
	public Map<Simbolo, Set<Terminale>> getFirst();

	/** Returns the FOLLOW-map for the grammar of this calculator instance. */
	public Map<NonTerminale, Set<Terminale>> getFollow();

	/** Returns the FIRST+-map for the grammar of this calculator instance. */
	public Map<Regola, Set<Terminale>> getFirstp();

	public boolean isLL1();
}
