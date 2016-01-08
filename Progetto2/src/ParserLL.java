import java.util.*;

public class ParserLL implements ParserLLInterface {
    private Grammatica grammatica;
    private Map<Simbolo, Set<Terminale>> first;
    private Map<NonTerminale,Set<Terminale>> follow;
    private Map<Produzione, Set<Terminale>> firstp;

    public ParserLL(Grammatica grammatica) {
        this.grammatica = grammatica;
        calcFirst();
        calcFollow();
        calcPredict();
    }

    public void calcFirst() {
        first = new HashMap<>();
        Set<Terminale> eofSet = new HashSet<>();
        eofSet.add(Simbolo.EOF);
        first.put(Simbolo.EOF, eofSet);

        Set<Terminale> epsilonSet = new HashSet<>();
        epsilonSet.add(Simbolo.EPSILON);
        first.put(Simbolo.EPSILON, epsilonSet);

        for (Terminale t : grammatica.getTerminals()) {
            Set<Terminale> set = new HashSet<>();
            set.add(t);
            first.put(t, set);
        }
        for (NonTerminale t : grammatica.getNonTerminals()) {
            first.put(t, new HashSet<>());
        }

        boolean diff = true;
        while (diff) {
            diff = false;

            for (Produzione r : grammatica.getRules()) {
                List<Simbolo> beta = r.getRHS();

                Set<Terminale> rhs = new HashSet<>(first.get(beta.get(0)));
                rhs.remove(Simbolo.EPSILON);

                int i = 0;
                while (i < beta.size() - 1 && first.get(beta.get(i)).contains(Simbolo.EPSILON)) {
                    rhs.addAll(first.get(beta.get(i + 1)));
                    rhs.remove(Simbolo.EPSILON);
                    i++;
                }

                if (i == beta.size() - 1 && first.get(beta.get(i)).contains(Simbolo.EPSILON)) {
                    rhs.add(Simbolo.EPSILON);
                }

                int oldLength = first.get(r.getLHS()).size();
                first.get(r.getLHS()).addAll(rhs);
                diff = diff || oldLength < first.get(r.getLHS()).size();
            }
        }
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
                Set<Terminale> trailer = new HashSet<>(follow.get(r.getLHS()));

                List<Simbolo> beta = r.getRHS();
                for (int i = beta.size() - 1; i >= 0; i--) {
                    if (beta.get(i) instanceof NonTerminale) {
                        int oldLength = follow.get(beta.get(i)).size();
                        follow.get(beta.get(i)).addAll(trailer);
                        diff = diff || oldLength < follow.get(beta.get(i)).size();
                        if (first.get(beta.get(i)).contains(Simbolo.EPSILON)) {
                            trailer.addAll(first.get(beta.get(i)));
                            trailer.remove(Simbolo.EPSILON);
                        } else {
                            trailer = new HashSet<>(first.get(beta.get(i)));
                        }
                    } else {
                        trailer = new HashSet<>(first.get(beta.get(i)));
                    }
                }
            }
        }
    }

    public void calcPredict() {
        firstp = new HashMap<>();
        for (Produzione r : grammatica.getRules()) {
            Set<Terminale> firstSymbols = new HashSet<>(first.get(r.getRHS().get(0)));
            int i = 1;
            while (i < r.getRHS().size() - 1 && first.get(r.getRHS().get(i)).contains(Simbolo.EPSILON)) {
                firstSymbols.addAll(first.get(r.getRHS().get(i)));
                i++;
            }

            firstp.put(r, firstSymbols);
            if (firstSymbols.contains(Simbolo.EPSILON)) {
                firstp.get(r).addAll(follow.get(r.getLHS()));
            }
        }
    }

    @Override
    public Map<Simbolo, Set<Terminale>> getFirst() {
        return first;
    }

    @Override
    public Map<NonTerminale, Set<Terminale>> getFollow() {
        return follow;
    }

    @Override
    public Map<Produzione, Set<Terminale>> getPredict() {
        return firstp;
    }

    @Override
    public boolean isLL1() {
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
        return true;
    }
}