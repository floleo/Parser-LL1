import java.util.*;

/**
 * Collection of rules with a start symbol.
 */
public class Grammar {

	private final NonTerm start;
	private final List<Rule> rules;
	private final List<NonTerm> lhss;
	private final List<NonTerm> nonTerminals;
	private final List<Term> terminals;
	//private final Map<NonTerm, List<Rule>> ruleMap;
	
	
	public Grammar(NonTerm start, List<Rule> rules, List<NonTerm> lhss, List<NonTerm> nonTerminals, List<Term> terminals){
		this.start = start;
		this.rules = rules;
		this.lhss = lhss;
		this.nonTerminals = nonTerminals;
		this.terminals = terminals;
	}
	
	public Grammar(NonTerm start) {
		this.start = start;
		this.rules = new ArrayList<>();
		this.lhss = new LinkedList<NonTerm>();
		this.nonTerminals = new LinkedList<>();
		this.terminals = new LinkedList<>();
	}

	/** Returns the start symbol of this grammar. */
	public NonTerm getStart() {
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
	public List<Rule> getRules() {
		return rules;
	}
	
	
	public List<NonTerm> getLhss(){
		return lhss;
	}
	
	
	public List<NonTerm> getNonTerminals() {
		return nonTerminals;
	}


	/** Returns the set of all terminals in the RHSs of this grammar. */
	public List<Term> getTerminals() {
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