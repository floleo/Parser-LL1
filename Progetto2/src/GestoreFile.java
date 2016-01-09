import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
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
	
	/*
	public Grammatica leggiFileEsterno(){
		String in;
		String str = null;
        Grammatica g = new Grammatica();
        try {
            BufferedReader br= new BufferedReader(new FileReader (f));
            
            while((in = br.readLine())!=null){
            	for(int index = 0; index<in.length();index++){
            	str = String.valueOf(in.charAt(index));
            	Terminale t = new Terminale(str);
                g.getTerminals().add(t);
            	}
            }
            while((in = br.readLine())!=null){
            	for(int j = 0; j<in.length();j++){
            	str = String.valueOf(in.charAt(j));
            	NonTerminale nt = new NonTerminale(str);
                g.getNonTerminals().add(nt);
            	}
            }
            NonTerminale st = new NonTerminale(br.readLine());
            g.getNonTerminals().add(st);
            
            NonTerminale lhs;
        	List<Simbolo> rhs = new LinkedList<Simbolo>();
        	Produzione p;
        	do{
        		in = br.readLine();
        		int count = 0;
            	for(int j = 0; j<in.length();j++){
        			if(str!="-"){
                	str = String.valueOf(in.charAt(j));
                	lhs = new NonTerminale(str);
                    g.getLhss().add(lhs);
                    count++;
        			} else{
        				if(count>1){
        					System.out.println("La grammatica selezionata non è context-free!");
        					break;
        				}
        				int k = j+1;
        				str = String.valueOf(in.charAt(k));
        				NonTerminale ntsym;
        				Terminale tsym;
        				rhs = new LinkedList<Simbolo>();
        				ntsym = new NonTerminale(str);
       					tsym = new Terminale(str);
       					if(g.getNonTerminals().contains(ntsym)){
      						rhs.add(ntsym);
       					} else if(g.getTerminals().contains(tsym)){
       						rhs.add(tsym);
       					}
       					p = new Produzione(g.getLhss().get(0), rhs);        					
       					g.getRules().add(p);
        			}
        		}
            }while(in!=null);
                
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return g;
	}*/

	/*
	public Grammatica leggiFileEsterno(){
		String in;
		
        Grammatica g = new Grammatica();
        try {
            BufferedReader br= new BufferedReader(new FileReader (f));
            
            while((in. = String.valueOf(br.read()))!=";"){
            	Terminale t = new Terminale(in);
                g.getTerminals().add(t);
            }
            while((in = String.valueOf(br.read()))!=";"){
            	NonTerminale nt = new NonTerminale(in);
                g.getNonTerminals().add(nt);
            }
            NonTerminale st = new NonTerminale(String.valueOf(br.read()));
            g.getNonTerminals().add(st);
            
            NonTerminale lhs;
        	List<Simbolo> rhs = new LinkedList<Simbolo>();
        	Produzione p;
        	do{
            while((in = String.valueOf(br.read()))!=";" && in!="."){
            	List<NonTerminale> lhss = new LinkedList<NonTerminale>();
            	String symbol;
            	NonTerminale ntsym;
            	Terminale tsym;
            	rhs = new LinkedList<Simbolo>();
            	int count = 0;
            	while((in = String.valueOf(br.read()))!="-"){
            		if(count>0){
            			System.out.println("La grammatica selezionata non è context-free!");
            			break;
            		}
                	lhs = new NonTerminale(in);
                	lhss.add(lhs);
                	count++;
                }
            	
            	br.read();
            	symbol = String.valueOf(br.read());
    			ntsym = new NonTerminale(symbol);
    			tsym = new Terminale(symbol);
    			if(g.getNonTerminals().contains(ntsym)){
    				rhs.add(ntsym);
    			} else if(g.getTerminals().contains(tsym)){
    				rhs.add(tsym);
                }
                p = new Produzione(lhss.get(0), rhs);
                g.getRules().add(p);
            }
        	}while(in==".");
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return g;
	}*/
}
