import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

public class MainSVG {

  public void paint(Graphics2D g2d) {
	  
	g2d.setPaint(Color.black);
	int x = 20, y = 40, w = 25;
	List<Integer> l = new LinkedList<>();	//nonterminali
	List<Double> f = new LinkedList<>();	//terminali
	Set<Double> d = new HashSet<>();		//set<terminali>
    Map<Integer, Set<Double>> predict = new HashMap<>();	//predict
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

  public static void main(String[] args) throws IOException {

    // Get a DOMImplementation.
    DOMImplementation domImpl =
      GenericDOMImplementation.getDOMImplementation();

    // Create an instance of org.w3c.dom.Document.
    String svgNS = "http://www.w3.org/TR/SVG11/";
    Document document = domImpl.createDocument(svgNS, "svg", null);
    
    // Create an instance of the SVG Generator.
    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
    // Ask the test to render into the SVG Graphics2D implementation.
    MainSVG test = new MainSVG();
    test.paint(svgGenerator);

    // Finally, stream out SVG to the standard output using
    // UTF-8 encoding.
    boolean useCSS = true; // we want to use CSS style attributes
    File f = new File("svgFile.svg");
    OutputStream outputStream = new FileOutputStream(f);
    Writer out = new OutputStreamWriter(outputStream, "UTF-8");
    svgGenerator.stream(out, useCSS);  
    outputStream.flush();
    outputStream.close();
  }
}