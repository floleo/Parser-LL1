import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class ParserLL {
    private Grammatica grammatica;
    private Map<Simbolo, Set<Terminale>> first;
    private Map<NonTerminale,Set<Terminale>> follow;
    private Map<Produzione, Set<Terminale>> predict;

    public ParserLL(Grammatica grammatica) {
        this.grammatica = grammatica;
        calcFirst();
        //calcFollow();
        //calcPredict();
    }

    public void calcFirst() {
        first = new HashMap<>();
        Set<Terminale> rhs = new HashSet<>();
        for (NonTerminale nt : grammatica.getNonTerminals()) {
        	rhs = first(nt);
        	first.put(nt, rhs);
        }
    }

    public Set<Terminale> first(NonTerminale nt){
		Set<Terminale> rhs = new HashSet<>();
		Set<Terminale> rhs2 = new HashSet<>();
		List<Simbolo> beta = new LinkedList<Simbolo>();
    	Terminale tsym;
		NonTerminale ntsym;
		Terminale epsilon = Terminale.EPSILON;
		for (Produzione r : grammatica.getRules()) {
			if(r.getLHS().equals(nt)){
				beta = r.getRHS();
				if(beta.get(0) instanceof NonTerminale){
					ntsym = (NonTerminale)beta.get(0);
					if(ntsym.checkNonTerminale() && !rhs.contains(ntsym)){
						rhs2 = first(ntsym);
						Iterator<Terminale> it = rhs2.iterator();
						while(it.hasNext())
							rhs.add(it.next());
					}
				}
				if(beta.get(0) instanceof Terminale){
					tsym = (Terminale)beta.get(0);
					if((tsym.equals(epsilon) || tsym.checkTerminale()) && !rhs.contains(tsym)){
						rhs.add(tsym);
					}
				}
			}
		}
		return rhs;
    }
    
    public void calcFollow() {
        follow = new HashMap<>();

        for (NonTerminale t : grammatica.getNonTerminals()) {
            follow.put(t, new HashSet<>());
        }

        Set<Terminale> eofSet = new HashSet<>();
        eofSet.add(Simbolo.EOF);
        follow.put(grammatica.getStart(), eofSet);

        boolean diff = true;
        while (diff) {
            diff = false;

            for (Produzione r : grammatica.getRules()) {
                Set<Terminale> p = new HashSet<>(follow.get(r.getLHS()));

                List<Simbolo> beta = r.getRHS();
                for (int i = beta.size() - 1; i >= 0; i--) {
                    if (beta.get(i) instanceof NonTerminale) {
                        int oldLength = follow.get(beta.get(i)).size();
                        follow.get(beta.get(i)).addAll(p);
                        diff = diff || oldLength < follow.get(beta.get(i)).size();
                        if (first.get(beta.get(i)).contains(Simbolo.EPSILON)) {
                            p.addAll(first.get(beta.get(i)));
                            p.remove(Simbolo.EPSILON);
                        } else {
                            p = new HashSet<>(first.get(beta.get(i)));
                        }
                    } else {
                        p = new HashSet<>(first.get(beta.get(i)));
                    }
                }
            }
        }
    }

    public void calcPredict() {
        predict = new HashMap<>();
        for (Produzione r : grammatica.getRules()) {
            Set<Terminale> pr = new HashSet<>(first.get(r.getRHS().get(0)));
            int i = 1;
            while (i < r.getRHS().size() - 1 && first.get(r.getRHS().get(i)).contains(Simbolo.EPSILON)) {
                pr.addAll(first.get(r.getRHS().get(i)));
                i++;
            }

            predict.put(r, pr);
            if (pr.contains(Simbolo.EPSILON)) {
                predict.get(r).addAll(follow.get(r.getLHS()));
            }
        }
    }

 
    public Map<Simbolo, Set<Terminale>> getFirst() {
        return first;
    }

 
    public Map<NonTerminale, Set<Terminale>> getFollow() {
        return follow;
    }

 
    public Map<Produzione, Set<Terminale>> getPredict() {
        return predict;
    }

 
    public void isLL1(List<Produzione> produzioni) {
    	ListIterator<Produzione> it = produzioni.listIterator();
    	ListIterator<Produzione> it2 = produzioni.listIterator();
    	Produzione p;
    	Produzione p2;
    	boolean b = true, c = false;
    	while(it.hasNext()){
    		p = it.next();
    		while(it2.hasNext()){
    			p2 = it2.next();
    			if(p.getLHS().equals(p2.getLHS()) && (!p.getRHS().equals(p2.getRHS()))){
    				if(p.getRHS().get(0).equals(p2.getRHS().get(0))){
    					c = true;
    					b = false;
    				}
    			}
    		}
    		if(p.getLHS().equals(p.getRHS().get(0))){
    			System.out.println("E' presente una ricorsione sinistra --> No LL(1)");
				b = false;
    		}
    		do{
    			it2.previous();
    		}while(it2.hasPrevious());
    	}
    	if(c) System.out.println("Sono presenti prefissi comuni --> No LL(1)");
    	if(b) System.out.println("La grammatica è LL(1)");
    	else System.out.println("La grammatica non è LL(1)");
        /*for (NonTerm nt : grammar.getNonTerminals()) {
            for (Rule r : grammar.getRules(nt)) {
                for (Rule r2 : grammar.getRules(nt)) {
                    if (r != r2) {
                        Set<Term> intersection = new HashSet<>(firstp.get(r));
                        intersection.retainAll(firstp.get(r2));
                        if (!intersection.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
        }*/
    }
}