import java.awt.*;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventTarget;

import java.awt.event.*;
import java.io.*;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;

public class ApriSVG {

	JFrame frame;
    JSVGCanvas canvas;
    Document document;
    Window window;

    public ApriSVG(String file, String risp) {
        frame = new JFrame();
        canvas = new JSVGCanvas();

        canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        canvas.addSVGLoadEventDispatcherListener
            (new SVGLoadEventDispatcherAdapter() {
                    public void svgLoadEventDispatchStarted
                        (SVGLoadEventDispatcherEvent e) {
                        	document = canvas.getSVGDocument();
                        	frame.pack();
                    	}
            		});

        frame.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                	if(risp.equals("s")){
                		canvas.setURI("src\\GrammaticheEsterne\\" + file + ".svg");
                	} else canvas.setURI("src\\Grammatiche\\" + file + ".svg");
                }
            });

        frame.getContentPane().add(canvas);
        frame.setSize(1000, 1000);
        frame.show();
    }


}

