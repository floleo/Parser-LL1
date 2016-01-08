import java.io.Serializable;
import java.util.*;

/**
 * Collection of rules with a start symbol.
 */
public class Grammatica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final NonTerminale start;
	private final List<Produzione> regola;
	private final List<NonTerminale> lhss;
	private final List<NonTerminale> nonTerminals;
	private final List<Terminale> terminals;
	//private final Map<NonTerm, List<Rule>> ruleMap;
	
	
	public Grammatica(NonTerminale start, List<Produzione> regola, List<NonTerminale> lhss, List<NonTerminale> nonTerminals, List<Terminale> terminals){
		this.start = start;
		this.regola = regola;
		this.lhss = lhss;
		this.nonTerminals = nonTerminals;
		this.terminals = terminals;
	}
	
	public Grammatica() {
		this.start = new NonTerminale("start");
		this.regola = new LinkedList<>();
		this.lhss = new LinkedList<NonTerminale>();
		this.nonTerminals = new LinkedList<>();
		this.terminals = new LinkedList<>();
	}

	/** Returns the start symbol of this grammar. */
	public NonTerminale getStart() {
		return start;
	}

	
	
	
	/** Adds a rule to this grammar, consisting of a given LHS and
	 * a sequence of RHS symbols.
	 * For an empty RHS, just leave the RHS sequence empty
	 * (as in <code>addRule(elsePart)</code> for elsePart -> epsilon).
	 */
	
	/*
	
	public void addRule(NonTerm lhs, Symbol... rhs) {
		addRule(new Rule(lhs, rhs));
	}

	public void addRule(Rule rule) {
		rules.add(rule);
		NonTerm lhs = rule.getLHS();
		List<Rule> lhsRules = ruleMap.get(lhs);
		if (lhsRules == null) {
			ruleMap.put(lhs, lhsRules = new ArrayList<>());
		}
		lhsRules.add(rule);
		for (Symbol symbol : rule.getRHS()) {
			if (symbol instanceof Term) {
				Term term = (Term) symbol;
				terminals.add(term);
			}
		}
	}

	public void addRule(NonTerm lhs, List<Symbol> rhs) {
		rules.add(new Rule(lhs, rhs));
	}

	*/
	
	/** Returns all rules corresponding to a given LHS symbol. */
	/*public List<Rule> getRules(NonTerm lhs) {
		return ruleMap.get(lhs);
	}*/
	
	/** Returns all rules of this grammar. */
	public List<Produzione> getRules() {
		return regola;
	}
	
	
	public List<NonTerminale> getLhss(){
		return lhss;
	}
	
	
	public List<NonTerminale> getNonTerminals() {
		return nonTerminals;
	}


	/** Returns the set of all terminals in the RHSs of this grammar. */
	public List<Terminale> getTerminals() {
		return terminals;
	}
	
	public boolean isNonTermListValid(){
		if(lhss.equals(nonTerminals))
			return true;
		else return false;
	}


	@Override
	public String toString() {
		return "Rules: " + getRules() + "; Start symbol: "
				+ getStart().getName();
	}
}