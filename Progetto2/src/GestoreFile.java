import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ListIterator;

public class GestoreFile {
	private String nameFile;
	private File f;
	
	public GestoreFile(String name) throws IOException{
		this.nameFile=name;
		f=new File(name);
		//f.createNewFile();
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
}
