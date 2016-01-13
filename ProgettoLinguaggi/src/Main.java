import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;


public class Main {

	public static void main(String[] args) throws IOException {

	        int sc = 0;
	        GestoreFile gf;
	        GestoreFile gf2;
	        GestoreFile gf3;
	        GestoreFileEsterni gfe;
	        GestoreFileEsterni gfe2;
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
	                    	LinkedList<String> list = new LinkedList<>();
	                    	gf3 = new GestoreFile(list);
	                    	gfe = new GestoreFileEsterni(list);
	                        String uf;
	                    	int u;
	                    	String risp;
	                    	do{
	                    		System.out.println("Vuoi leggere da un file esterno? (s/n)");
	                    		risp = br.readLine();
	                    		if(!risp.equals("s") && !risp.equals("n")) System.out.println("Devi inserire i caratteri s/n!");
	                    	}while(!risp.equals("s") && !risp.equals("n"));
	                    	do{
	                    		System.out.println("Seleziona il file da cui leggere la grammatica (digitare l'indice): ");
	                    		if(risp.equals("s")){
	                    			list = gfe.visualizzaFileEsterno();
	                    			gfe.stampaFile(list);
	                    		}
	                    		else{
	                    			list = gf3.visualizzaFile();
		                    		gf3.stampaFile(list);
	                    		}
	                    		u = Integer.parseInt(br.readLine());
	                    		if(u>=list.size()) System.out.println("Numero non valido");
	                    	}while(u>=list.size());
	                        uf=list.get(u);
	                        Grammatica gr;
	                    	if(risp.equals("s")){
	                        	gfe2 = new GestoreFileEsterni(uf);
	                        	gr = gfe2.leggiFileEsterno();
	                        	gfe2.stampaFile(gr);
	                        } else{
	                        	gf2=new GestoreFile(uf);
	                        	gr = gf2.leggiFile();
		                    	gf2.stampaFile(gr);
		                    }
	                    	int sc1 = 0;
	                    	do{
	        	                System.out.println("1->Verifica se la grammatica selezionata è context-free \n"
	        	                        + "2->Verifica se la grammatica selezionata è LL(1) \n"
	        	                        + "3->Genera la tabella di parsing LL(1) \n"
	        	                        + "0-->Indietro");
	                    	sc1 = Integer.parseInt(br.readLine());
	    	                switch(sc1){
	    	                    case 1:
	    	                    	if(gr.getIsContextFree())
	    	                    		System.out.println("La grammatica è context-free!!!");
	    	                    	else System.out.println("La grammatica non è context-free!!!");
	    	                    	break;
	    	                    case 2:
	    	                    	ParserLL ll=new ParserLL(gr);
	    	                    	boolean x = ll.isLL1(gr.getRules());
	    	                    	if(x){
	    	                    		if(ll.LL1()) System.out.println("La grammatica è LL(1)");
    	                    			else System.out.println("La grammatica non è LL(1)");
	    	                    		ll.calcFirst();
	    	                    		System.out.println("L'insieme dei first e': " + ll.getFirst());
	    	                    		ll.calcFollow();
	    	                    		System.out.println("L'insieme dei follow e': " + ll.getFollow());
	    	                    		ll.calcPredict();
	    	                    		System.out.println("L'insieme dei predict e': " + ll.getPredict());
	    	                    	}
	    	                        break;
	    	                    case 3:
	    	                    	DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
	    	                        String svgNS = "http://www.w3.org/TR/SVG11/";
	    	                        Document document = domImpl.createDocument(svgNS, "svg", null);
	    	                        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
	    	                        CreaTabella table = new CreaTabella();
	    	                        table.paint(svgGenerator,gr);
	    	                        boolean useCSS = true;
	    	                        File f;
	    	                        if(risp.equals("s")){
	    	                        	f = new File("src\\GrammaticheEsterne\\"+uf+".svg");
	    	                        } else f = new File("src\\Grammatiche\\"+uf+".svg");
	    	                        OutputStream outputStream = new FileOutputStream(f);
	    	                        Writer out = new OutputStreamWriter(outputStream, "UTF-8");
	    	                        svgGenerator.stream(out, useCSS);  
	    	                        outputStream.flush();
	    	                        outputStream.close();
	    	                    	new ApriSVG(uf,risp);
	    	                    	break;
	    	                    case 0:
	    	                        break;
	    	                    default:
	    	                        System.out.println("Tasto non valido...riprovare ");
	    	                }
	    	            }while(sc1!=0);
	                    	break;
	                    case 2:
	                    	System.out.println("INSERIMENTO GRAMMATICA DA TASTIERA");
	                    	
	                    	LinkedList<Terminale> terminals = new LinkedList<>();
	                    	Terminale t;
	                    	int i=0, j=0, k=0, l=0;
	                    	int term = 0;
	                    	System.out.println("Inserire il numero di terminali della grammatica:");
	                    	term = Integer.parseInt(br.readLine());
	                    	for(i=0; i<term;i++){
	                    		String s;
	                    		do{
	                    			System.out.println("Inserisci il terminale:");
	                    			s=br.readLine();
	                    			t = new Terminale(s);
	                    			if(!t.checkTerminale()) 
	                    				System.out.println("Il terminale non può essere un carattere maiuscolo");
	                    		}while(!t.checkTerminale());
	                    		terminals.add(t);
	                    	}
	                    	
	                    	LinkedList<NonTerminale> nonTerminals = new LinkedList<>();
	                    	NonTerminale nt;
	                    	int nonTerm = 0;
	                    	System.out.println("Inserire il numero di non terminali della grammatica (escluso lo start symbol):");
	                    	nonTerm = Integer.parseInt(br.readLine());
	                    	for(j=0; j<nonTerm;j++){
	                    		String s;
	                    		do{
	                    			System.out.println("Inserisci il non terminale:");
	                    			s=br.readLine();
	                    			nt = new NonTerminale(s);
	                    			if(!nt.checkNonTerminale()) 
	                    				System.out.println("Il non terminale può essere solo un carattere maiuscolo");
	                    		}while(!nt.checkNonTerminale());
	                    		nonTerminals.add(nt);
		                    }
	                    	

	                    	System.out.println("Inserire lo start symbol: ");
	                    	NonTerminale s = new NonTerminale(br.readLine());
	                    	if(!nonTerminals.contains(s))
	                    		nonTerminals.addFirst(s);
	                    	
	                    	ArrayList<Produzione> regola = new ArrayList<Produzione>();
	                    	List<NonTerminale> lhss = new LinkedList<NonTerminale>();
	                    	Produzione production;
	                    	int rule = 0;
	                    	int right = 0;
	                    	NonTerminale lhs;
	                    	List<Simbolo> rhs = new LinkedList<Simbolo>();

	                    	System.out.println("Inserire il numero di produzioni della grammatica:");
	                    	rule = Integer.parseInt(br.readLine());
	                    	String noterm;
	                    	
	                    	for(k=0; k<rule;k++){
		                    	boolean b = true;
		                    	ListIterator<NonTerminale> iter;
		                    	do{
		                    		System.out.println("Inserisci il non terminale della parte sinistra (vedi lista):");
		                    		System.out.println(nonTerminals);
		                    		noterm = br.readLine();
		                    		lhs = new NonTerminale(noterm);
		                    		iter = nonTerminals.listIterator();
		                    		while(iter.hasNext()){
		                    			if(iter.next().equals(lhs)){
		                    				lhss.add(lhs);
		                    				b = false;
		                    			}
		                    		}
		                    		if(b) System.out.println("Non terminale non valido. Riprova");
		                    	}while(b);

		                    	System.out.println("Inserisci il numero di simboli presenti nella parte destra (0 se è epsilon):");
		                    	right = Integer.parseInt(br.readLine());
		                    	rhs = new LinkedList<Simbolo>();
		                    	if(right==0){
		                    		Terminale eps;
		                    		eps = Terminale.EPSILON;
		                    		rhs.add(eps);
		                    	} else{
		                    		for(l=0; l<right;l++){
		                    			String symbol;
		                    			NonTerminale ntsym;
		                    			Terminale tsym;
		                    		
		                    			do{
		                    				System.out.println("Inserisci il simbolo (vedi lista):");
		                    				System.out.println(terminals);
		                    				System.out.println(nonTerminals);
		                    				symbol = br.readLine();
		                    				ntsym = new NonTerminale(symbol);
		                    				tsym = new Terminale(symbol);
		                    				if(nonTerminals.contains(ntsym)){
		                    					rhs.add(ntsym);
		                    				} else if(terminals.contains(tsym)){
		                    					rhs.add(tsym);
		                    				} else System.out.println("Simbolo non esistente. Inserire un simbolo valido");
		                    			}while(!nonTerminals.contains(ntsym)&&!terminals.contains(tsym));
		                    		}
		                    	}
		                    	production = new Produzione(lhs,rhs);
		                    	lhss.add(lhs);
	                    		regola.add(production);
	                    		System.out.println("Produzione aggiunta con successo!");
	                    	}
	                    	
	                    	Grammatica g = new Grammatica(s,regola,lhss,nonTerminals,terminals);

	                    	System.out.println("Grammatica inserita con successo!");
	                    	System.out.println("Inserire il nome del file su cui salvare la grammatica(esclusa l'estensione): ");
	                    	String f = br.readLine();
	                    	gf=new GestoreFile(f + ".txt");
	                    	gf2=new GestoreFile(f);
	                    	gf.scriviFile(g);
	                    	gf2.scriviAltroFile(g);
	                    	System.out.println("Inserimento su file completato con successo!");
	                    	gf.stampaFile(g);
	                    	ParserLL ll1=new ParserLL(g);
	                    	boolean z = ll1.isLL1(g.getRules());
	                    	if(z){
	                    		ll1.calcFirst();
	                    		System.out.println("L'insieme dei first e': "+ll1.getFirst());
	                    		ll1.calcFollow();
	                    		System.out.println("L'insieme dei follow e': "+ll1.getFollow());
	                    		ll1.calcPredict();
	                    		System.out.println("L'insieme dei predict e': "+ll1.getPredict());
	                    		if(ll1.LL1()) {
	                    			System.out.println("La grammatica è LL(1)");
	                    			DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
	    	                        String svgNS = "http://www.w3.org/TR/SVG11/";
	    	                        Document document = domImpl.createDocument(svgNS, "svg", null);
	    	                        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
	    	                        CreaTabella table = new CreaTabella();
	    	                        table.paint(svgGenerator,g);
	    	                        boolean useCSS = true;
	    	                        File f2 = new File("src\\Grammatiche\\"+f+".svg");
	    	                        OutputStream outputStream = new FileOutputStream(f2);
	    	                        Writer out = new OutputStreamWriter(outputStream, "UTF-8");
	    	                        svgGenerator.stream(out, useCSS);  
	    	                        outputStream.flush();
	    	                        outputStream.close();
	    	                    	new ApriSVG(f,"n");
	                    		}else System.out.println("La grammatica non è LL(1)");
	                    	}
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