import java.io.Serializable;
import java.util.*;


public class Grammatica implements Serializable{

	private static final long serialVersionUID = 1L;
	//assioma
	private final NonTerminale start;
	private final List<Produzione> regola;
	private final List<NonTerminale> lhss;
	private final List<NonTerminale> nonTerminals;
	private final List<Terminale> terminals;
	//per verificare che la grammatica sia context-free
	private boolean isContextFree;
	
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


}