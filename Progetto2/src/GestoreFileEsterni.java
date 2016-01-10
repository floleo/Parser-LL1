import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GestoreFileEsterni {
	private String nameFile;
	private File f;
	private LinkedList<String> lis;
 	
	public GestoreFileEsterni(String name) throws IOException{
		this.nameFile=name;
		f=new File("src\\GrammaticheEsterne\\"+name);
		//f.createNewFile();
	}
	
	public GestoreFileEsterni(LinkedList<String> lis){
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
	
	public LinkedList<String> visualizzaFileEsterno(){
        File dir = new File("src\\GrammaticheEsterne\\");
        LinkedList<String> ll = new LinkedList<>();
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Directory errata");
        }else{
            for(int i=0;i<files.length;i++){
                String st = files[i].getName();
                if(files[i].getName().endsWith("txt")){
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
	

	public Grammatica leggiFileEsterno(){
		String in;
		String str = null;
        Grammatica g = new Grammatica();
        try {
            BufferedReader br= new BufferedReader(new FileReader (f));
            
            in = br.readLine();
            for(int index = 0; index<in.length();index++){
            	str = String.valueOf(in.charAt(index));
            	Terminale t = new Terminale(str);
                g.getTerminals().add(t);
            }
            in = br.readLine();
            for(int j = 0; j<in.length();j++){
            	str = String.valueOf(in.charAt(j));
            	NonTerminale nt = new NonTerminale(str);
                g.getNonTerminals().add(nt);
            }
            NonTerminale st = new NonTerminale(br.readLine());
            g.getNonTerminals().add(st);
            
            NonTerminale lhs;
        	List<Simbolo> rhs = new LinkedList<Simbolo>();
        	Produzione p;
        	while((in = br.readLine())!=null){
            			str = String.valueOf(in.charAt(0));
                		lhs = new NonTerminale(str);
                		g.getLhss().add(lhs);
    					if(!String.valueOf(in.charAt(1)).equals("-")){
        					System.out.println("La grammatica selezionata non è context-free!");
        					break;
        				} else{
        					rhs = new LinkedList<Simbolo>();
    						for(int j = 3; j<in.length();j++){
        						str = String.valueOf(in.charAt(j));
        						NonTerminale ntsym;
        						Terminale tsym;
        						ntsym = new NonTerminale(str);
        						tsym = new Terminale(str);
        						if(g.getNonTerminals().contains(ntsym)){
        							rhs.add(ntsym);
        						} else if(g.getTerminals().contains(tsym)){
        							rhs.add(tsym);
        						}
        	            	}
        					p = new Produzione(lhs, rhs);        					
        					g.getRules().add(p);
        				}
        		}                
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return g;
	}
}
