import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestoreFile {
	private String nameFile;
	private File f;
	
	public GestoreFile(String name) throws IOException{
		this.nameFile=name;
		f=new File(name);
		f.createNewFile();
	}
	
	public void stampaFile(Grammatica g){
		System.out.println("Terminali: " + g.getTerminals());
		System.out.println("Non terminali: " + g.getNonTerminals());
		System.out.println("Start Symbol: " + g.getStart());
		List<Produzione> lis = g.getRules();
		ListIterator<Produzione> prod = lis.listIterator();
		while(prod.hasNext()){
			System.out.println(prod.next());
		 }
	}
	
	public void scriviFile(Grammatica g){
		PrintWriter w;
		try {
			w = new PrintWriter (new FileWriter(f), true);
			w.println(g.getTerminals());
			w.println(g.getNonTerminals());
			w.println(g.getStart());
			w.println(g.getRules());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public Grammatica leggiFile(){
        ObjectInputStream ois;
        FileInputStream fp;
        Grammatica g = new Grammatica();
        try{
            fp= new FileInputStream(f);
            if(fp.read()!=-1){
                ois= new ObjectInputStream(new FileInputStream(f));
                g= (Grammatica) ois.readObject();
                ois.close();
            }
            fp.close();
        }
        catch(Exception e){
            System.out.println("Errore nella lettura del file!!");
        }
        
        return g;
    }*/
	
	
	 public Grammatica leggiFile(){
		String input;
		Grammatica g;
        NonTerminale start= null;
		List<Produzione> regola=new LinkedList<>();
		List<NonTerminale> lhss=new LinkedList<NonTerminale>();
		List<NonTerminale> nonTerminals= new LinkedList<>();
		List<Terminale> terminals=new LinkedList<>();
		try {
            BufferedReader br= new BufferedReader(new FileReader(f));
            
            while ((input=Integer.toString(br.read()))!="]"){
            	if(input!=","&&input!="["){
            		Terminale t = new Terminale(input);
            		terminals.add(t);
            	}
            }
            while ((input=Integer.toString(br.read()))!="]"){
            	if(input!=","&&input!="["){
            		NonTerminale nt = new NonTerminale(input);
            		nonTerminals.add(nt);
            	}
            }
            input=Integer.toString(br.read());
            NonTerminale st = new NonTerminale(input);
            nonTerminals.add(st);
            
            LinkedList<Simbolo> rhs = new LinkedList<Simbolo>();
            NonTerminale lhs = null;
            while ((input=Integer.toString(br.read()))!=null){
            	while ((input=Integer.toString(br.read()))!="]"){
            		while ((input=Integer.toString(br.read()))!="-"){
                            	if(input!=","&&input!="["){
                            		lhs = new NonTerminale(input);
                            		lhss.add(lhs);
                            	}
            		}
            		br.read();
            		
            		Produzione rule = null;
            		while ((input=Integer.toString(br.read()))!="]"){
            			if(input!=","&&input!="["){
            				NonTerminale ntsym = new NonTerminale(input);
                			Terminale tsym = new Terminale(input);
                			if(ntsym.checkNonTerminale()){
                				rhs.add(ntsym);
                			} else if(tsym.checkTerminale()){
                				rhs.add(tsym);
                			}
            			}
            		}
            		rule = new Produzione(lhs,rhs);
            		regola.add(rule);
            	}
            }
    		br.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		g = new Grammatica(start, regola, lhss, nonTerminals, terminals);
		return g;
    }
	
}
