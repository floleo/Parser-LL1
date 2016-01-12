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
	private boolean isContextFree;
	//private final Map<NonTerm, List<Rule>> ruleMap;
	
	
	public Grammatica(NonTerminale start, List<Produzione> regola, List<NonTerminale> lhss, List<NonTerminale> nonTerminals, List<Terminale> terminals){
		this.start = start;
		this.regola = regola;
		this.lhss = lhss;
		this.nonTerminals = nonTerminals;
		this.terminals = terminals;
		this.isContextFree = true;
	}
	
	public Grammatica() {
		this.start = new NonTerminale("start");
		this.regola = new LinkedList<>();
		this.lhss = new LinkedList<NonTerminale>();
		this.nonTerminals = new LinkedList<>();
		this.terminals = new LinkedList<>();
		this.isContextFree = true;
	}

	/** Returns the start symbol of this grammar. */
	public NonTerminale getStart() {
		return start;
	}

	
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
	
	public boolean getIsContextFree(){
		return isContextFree;
	}
	
	public void setIsContextFree(boolean b){
		this.isContextFree = b;
	}


	@Override
	public String toString() {
		return "Rules: " + getRules() + "; Start symbol: "
				+ getStart().getName();
	}
}