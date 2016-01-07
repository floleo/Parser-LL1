import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


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
	                    	
	                    	HashMap<NonTerm, ArrayList<Rule>> ruleMap = null;
	                    	LinkedList<Term> terminals = null;
	                    	Term t;
	                    	int i=0;
	                    	int term = 0;
	                    	System.out.println("Inserire il numero di terminali della grammatica:");
	                    	term = Integer.parseInt(br.readLine());
	                    	for(i=0; i<term;i++){
	                    	System.out.println("Inserisci il terminale:");
	                    	t = new Term(br.readLine());
	                    	terminals.add(t);
	                    	}
	                    	
	                    	LinkedList<NonTerm> nonTerminals = null;
	                    	NonTerm nt;
	                    	int nonTerm = 0;
	                    	System.out.println("Inserire il numero di non terminali della grammatica:");
	                    	nonTerm = Integer.parseInt(br.readLine());
	                    	for(i=0; i<nonTerm;i++){
		                    	System.out.println("Inserisci il non terminale:");
		                    	nt = new NonTerm(br.readLine());
		                    	nonTerminals.add(nt);
		                    	}
	                    	
	                    	System.out.println("Inserire lo start symbol:");
	                    	NonTerm s = new NonTerm(br.readLine());

	                    	ArrayList<Rule> rules = null;
	                    	List<NonTerm> lhss = null;
	                    	Rule production;
	                    	int rule = 0;
	                    	int right = 0;
	                    	NonTerm lhs;
	                    	List<Symbol> rhs = null;
	                    	System.out.println("Inserire il numero di produzioni della grammatica:");
	                    	rule = Integer.parseInt(br.readLine());
	                    	for(i=0; i<rule;i++){
		                    	System.out.println("Inserisci il non terminale nella parte sinistra:");
		                    	lhs = nonTerminals.get(nonTerminals.indexOf(br.readLine()));
		                    	System.out.println("Inserisci il numero di simboli presenti nella parte destra:");
		                    	right = Integer.parseInt(br.readLine());
		                    	for(i=0; i<right;i++){
		                    		String symbol;
		                    		do{
		                    			System.out.println("Inserisci il simbolo:");
		                    			symbol = br.readLine();
		                    			if(nonTerminals.contains(symbol)){
		                    				rhs.add(nonTerminals.get(nonTerminals.indexOf(symbol)));
		                    			} else if(terminals.contains(symbol)){
		                    				rhs.add(terminals.get(terminals.indexOf(symbol)));
		                    			} else System.out.println("Simbolo non esistente. Inserire un simbolo valido");
		                    		}while(!nonTerminals.contains(symbol)&&!terminals.contains(symbol));
		                    	}
		                    	production = new Rule(lhs,rhs);
		                    	lhss.add(lhs);
	                    		rules.add(production);
	                    	}
	                    	
	                    	Grammar g = new Grammar(s,rules,lhss,nonTerminals,terminals);
	                    		
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