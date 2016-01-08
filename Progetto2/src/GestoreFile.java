import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GestoreFile {
	private String nameFile;
	private File f;
	
	public GestoreFile(String name) throws IOException{
		this.nameFile=name;
		f=new File(name);
		f.createNewFile();
	}
	
	public void scriviFile(LinkedList<Terminale> terminals,LinkedList<NonTerminale> nonTerminals,ArrayList<Regola> regola){
		PrintWriter w;
		try {
			w = new PrintWriter(new FileWriter(f));
	        for(Terminale t: terminals) w.println(t.toString());
	        for(NonTerminale nt: nonTerminals) w.println(nt.toString());
	        for(Regola r: regola) w.println(r.toString());
	        w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public Grammatica leggiFile(){
		
	}*/
}
