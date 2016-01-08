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
		List<Regola> lis = g.getRules();
		ListIterator<Regola> prod = lis.listIterator();
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
	
	public Grammatica leggiFile(){
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
    }
	/*
	public Grammatica leggiFile() throws FileNotFoundException{
		Scanner s=new Scanner(new FileReader(f));
		Pattern pattern = Pattern.compile("\\[\\,");
		//s.useDelimiter("\\[\\,");
		Grammatica g;
		String str;
		NonTerminale start= null;
		List<Regola> regola=new LinkedList<>();
		List<NonTerminale> lhss=new LinkedList<NonTerminale>();
		List<NonTerminale> nonTerminals= new LinkedList<>();
		List<Terminale> terminals=new LinkedList<>();
		while (s.hasNext()){
			do{
				Terminale t = new Terminale(str);
				terminals.add(t);
			}while(s.findInLine(pattern)=="]");
			while((str = s.next())!="]"){
				NonTerminale nt = new NonTerminale(str);
				nonTerminals.add(nt);
			}
			start = new NonTerminale(s.nextLine());
            
            Regola reg;
            while((str = s.next())!="]"){
				NonTerminale nt = new NonTerminale(str);
				LinkedList<Simbolo> rhs = new LinkedList<>();
				lhss.add(nt);
				s.next();
				s.next();
				Terminale t2;
				NonTerminale nt2;
				while((str = s.next())!="]"){
					Pattern patt = Pattern.compile("[a-z]");
					Matcher matcher = patt.matcher(str);
					if(matcher.matches()){
						t2 = new Terminale(str);
						rhs.add(t2);
					}else{
						nt2 = new NonTerminale(str);
						rhs.add(nt2);
					}
				}
				reg = new Regola(nt,rhs);
				regola.add(reg);
            }
		}
		s.close();
        g = new Grammatica(start, regola, lhss, nonTerminals, terminals);
		return g;
	}
	*/
}
