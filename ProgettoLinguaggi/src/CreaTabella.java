import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CreaTabella {
	public void paint(Graphics2D g2d) {
	  	  
    	g2d.setPaint(Color.black);
    	int x = 20, y = 40, w = 25;
    	List<Integer> l = new LinkedList<>();	//nonterminali
    	List<Double> f = new LinkedList<>();	//terminali
    	Set<Double> d = new HashSet<>();		//set<terminali>
        Map<Integer, Set<Double>> predict = new HashMap<>();	//predict
        Iterator it = d.iterator();
    	for(int j=0;j<4;j++){
    		l.add(j);
    		l.add(j*5);
    		f.add(j*1.5);
    		d.add(f.get(j));
    		predict.put(j, d);
    	}
    	
    	//linee colonne
    	for(int k=0;k<f.size();k++){
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(0, 0, 0, 20*(l.size()+1));
    	    g2d.drawLine(w, 0, w, 20*(l.size()+1));
    	    g2d.drawLine(25+60*(f.size()), 0, 25+60*(f.size()), 20*(l.size()+1));
    	    //if(predict.containsValue(f.get(k)));
    	    //g2d.drawString(String.valueOf(l.get(i))+"->"+"rhs", 30, y);
    	    g2d.drawString(String.valueOf(f.get(k)), 30+w, 10);
    		w+=60;
    	}
    	
    	//linee righe
    	for(int i = 0; i<l.size(); i++){
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(0, x, 25+60*(f.size()), x);
    	    g2d.drawLine(0, 0, 0, 25+60*f.size());
    	    g2d.drawLine(0, 20*(l.size()+1), 25+60*(f.size()), 20*(l.size()+1));
    	    g2d.drawString(String.valueOf(l.get(i))+"->"+"rhs", 30, y);
    	    g2d.drawString(String.valueOf(l.get(i)), 4, y);
    		x+=20;
    		y+=20;
    	}
	}
}
