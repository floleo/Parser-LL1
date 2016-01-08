import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GestoreFile {
	private String nameFile;
	private File f;
	
	public GestoreFile(String name) throws IOException{
		this.nameFile=name;
		f=new File(name);
		f.createNewFile();
	}
	
	public void scriviFile(Grammatica g){
		PrintWriter pr;
		try {
			/*w = new PrintWriter(new FileWriter(f));
	        for(Terminale t: terminals) w.println(t.toString());
	        for(NonTerminale nt: nonTerminals) w.println(nt.toString());
	        for(Regola r: regola) w.println(r.toString());
	        w.close();*/
			pr = new PrintWriter (new FileWriter(f), true);
			pr.println("Terminali: " + g.getTerminals());
			            pr.println("Non terminali: " + g.getNonTerminals());
			             pr.println("Start Symbol: " + g.getStart());
			             List<Regola> lis = g.getRules();
			             ListIterator<Regola> prod = lis.listIterator();
			             while(prod.hasNext()){
			             pr.println(prod.next());
			            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public Grammatica leggiFile() throws FileNotFoundException{
		Scanner s=new Scanner(new FileReader(f));
		NonTerminale start;
		List<Regola> regola=new ArrayList<>();
		List<NonTerminale> lhss=new LinkedList<NonTerminale>();
		List<NonTerminale> nonTerminals= new LinkedList<>();
		List<Terminale> terminals=new LinkedList<>();
		while(s.hasNext(Pattern.compile("[a-z0-9]"))){
			String name=s.next();
			Terminale t=new Terminale(name);
			terminals.add(t);
		}
		while(s.hasNext(Pattern.compile("[A-Z]"))){
			String name=s.next();
			NonTerminale nt=new NonTerminale(name);
			nonTerminals.add(nt);
			start=nonTerminals.get(0);
		}
		
	}*/
}
