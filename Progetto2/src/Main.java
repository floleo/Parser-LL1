import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Main {

	public static void main(String[] args) throws IOException {

	        int sc = 0;
	        
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        try{
	            do{
	                System.out.println("Menu': \n"
	                        + "1->Seleziona un file contenente la grammatica da analizzare \n"
	                        + "2->Inserisci la grammatica da tastiera \n"
	                        + "0-->Esci!");
	                sc = Integer.parseInt(br.readLine());
	                switch(sc){
	                    case 1:
	                       
	                        break;
	                    case 2:
	                    	System.out.println("INSERIMENTO GRAMMATICA DA TASTIERA:");
	                    	
	                    	LinkedList<Term> terminals = new LinkedList<>();
	                    	Term t;
	                    	int i=0, j=0, k=0, l=0;
	                    	int term = 0;
	                    	System.out.println("Inserire il numero di terminali della grammatica:");
	                    	term = Integer.parseInt(br.readLine());
	                    	for(i=0; i<term;i++){
	                    		System.out.println("Inserisci il terminale:");
	                    		t = new Term(br.readLine());
	                    		terminals.add(t);
	                    	}
	                    	
	                    	LinkedList<NonTerm> nonTerminals = new LinkedList<>();
	                    	NonTerm nt;
	                    	int nonTerm = 0;
	                    	System.out.println("Inserire il numero di non terminali della grammatica:");
	                    	nonTerm = Integer.parseInt(br.readLine());
	                    	for(j=0; j<nonTerm;j++){
		                    	System.out.println("Inserisci il non terminale:");
		                    	nt = new NonTerm(br.readLine());
		                    	nonTerminals.add(nt);
		                    	}
	                    	
	                    	System.out.println("Inserire lo start symbol:");
	                    	NonTerm s = new NonTerm(br.readLine());

	                    	ArrayList<Rule> rules = new ArrayList<Rule>();
	                    	List<NonTerm> lhss = new LinkedList<NonTerm>();
	                    	Rule production;
	                    	int rule = 0;
	                    	int right = 0;
	                    	NonTerm lhs;
	                    	List<Symbol> rhs = new LinkedList<Symbol>();
	                    	System.out.println("Inserire il numero di produzioni della grammatica:");
	                    	rule = Integer.parseInt(br.readLine());
	                    	String noterm;
	                    	
	                    	for(k=0; k<rule;k++){
		                    	boolean b = true;
		                    	ListIterator<NonTerm> iter;
		                    	do{
	                    		System.out.println("Inserisci il non terminale nella parte sinistra:");
		                    	noterm = br.readLine();
		                    	lhs = new NonTerm(noterm);
		                    	iter = nonTerminals.listIterator();
		                    	while(iter.hasNext()){
		                    		if(iter.next().equals(lhs)){
		                    			lhss.add(lhs);
		                    			b = false;
		                    		}
		                    	}
	                    		if(b) System.out.println("Non terminale non valido. Riprova");
		                    	}while(b);

		                    	System.out.println("Inserisci il numero di simboli presenti nella parte destra:");
		                    	right = Integer.parseInt(br.readLine());
		                    	for(l=0; l<right;l++){
		                    		String symbol;
		                    		NonTerm ntsym;
		                    		Term tsym;
		                    		
		                    		do{
		                    			System.out.println("Inserisci il simbolo:");
		                    			symbol = br.readLine();
		                    			ntsym = new NonTerm(symbol);
		                    			tsym = new Term(symbol);
		                    			if(nonTerminals.contains(ntsym)){
		                    				rhs.add(ntsym);
		                    			} else if(terminals.contains(tsym)){
		                    				rhs.add(tsym);
		                    			} else System.out.println("Simbolo non esistente. Inserire un simbolo valido");
		                    		}while(!nonTerminals.contains(ntsym)&&!terminals.contains(tsym));
		                    	}
		                    	
		                    	production = new Rule(lhs,rhs);
		                    	lhss.add(lhs);
	                    		rules.add(production);
	                    		System.out.println("Produzione aggiunta con successo!");
	                    	}
	                    	
	                    	Grammar g = new Grammar(s,rules,lhss,nonTerminals,terminals);
	                    	System.out.println("Grammatica inserita con successo!");
	                    	
	                        break;
	                    case 0:
	                        System.out.println("Programma terminato");
	                        break;
	                    default:
	                        System.out.println("Tasto non valido...riprovare ");
	                }
	            }while(sc!=0);
	        }
	        catch(IOException e){
	            e.printStackTrace();
	        }
	        finally{
	            br.close();
	        }
	    }
	}