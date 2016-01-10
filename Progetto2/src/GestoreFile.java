import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GestoreFile {
	private String nameFile;
	private File f;
	private LinkedList<String> lis;
 	
	public GestoreFile(String name) throws IOException{
		this.nameFile=name;
		f=new File("src\\Grammatiche\\"+name);
		//f.createNewFile();
	}
	
	public GestoreFile(LinkedList<String> lis){
		this.lis=lis;
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
	
	public void scriviAltroFile(Grammatica g){
		ObjectOutputStream os= null;
        
        try{
            os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(g);
            os.flush();
            os.close();
        }
        catch(Exception e){
            System.out.println("Errore nella scrittura del file !!");
        }
	}
	
	public void scriviFile(Grammatica g){
		PrintWriter w= null;
        
        try{
        	w = new PrintWriter (new FileWriter(f), true);
			w.println(g.getTerminals());
			w.println(g.getNonTerminals());
			w.println(g.getStart());
			w.println(g.getRules());
        }
        catch(Exception e){
            System.out.println("Errore nella scrittura del file !!");
        }
	}
	
	public Grammatica leggiFile(){
        ObjectInputStream ois = null;
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
	
	public LinkedList<String> visualizzaFile(){
        File dir = new File("src\\Grammatiche\\");
        LinkedList<String> ll = new LinkedList<>();
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Directory errata");
        }else{
            for(int i=0;i<files.length;i++){
                String st = files[i].getName();
                if(!files[i].getName().endsWith("txt")){
                    ll.add(st);
                }
            }
        }
        return ll;
    } 
	
	public void stampaFile(LinkedList<String> ll){
        System.out.println("Lista delle grammatiche");
        for (int i=0; i<ll.size();i++){
            System.out.println(i + " - " + ll.get(i));
        }
    }
}
