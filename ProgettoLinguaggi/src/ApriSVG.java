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
        // Forces the canvas to always be dynamic even if the current
        // document does not contain scripting or animation.
        canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        canvas.addSVGLoadEventDispatcherListener
            (new SVGLoadEventDispatcherAdapter() {
                    public void svgLoadEventDispatchStarted
                        (SVGLoadEventDispatcherEvent e) {
                        // At this time the document is available...
                        document = canvas.getSVGDocument();
                        // ...and the window object too.
                        window = (Window) canvas.getUpdateManager().
                            getScriptingEnvironment().getWindow();
                        // Registers the listeners on the document
                        // just before the SVGLoad event is
                        // dispatched.
                        registerListeners();
                        // It is time to pack the frame.
                        frame.pack();
                    }
                });

        frame.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                    // The canvas is ready to load the base document
                    // now, from the AWT thread.
                	if(risp.equals("s")){
                		canvas.setURI("src\\GrammaticheEsterne\\" + file + ".svg");
                	} else canvas.setURI("src\\Grammatiche\\" + file + ".svg");
                }
            });

        frame.getContentPane().add(canvas);
        frame.setSize(800, 600);
        frame.show();
    }

    public void registerListeners() {
        // Gets an element from the loaded document.
        Element elt = document.getElementById("elt-id");
        EventTarget t = (EventTarget)elt;

        // Adds a 'onload' listener
        t.addEventListener("SVGLoad", (org.w3c.dom.events.EventListener) new OnLoadAction(), false);

        // Adds a 'onclick' listener
        t.addEventListener("click", (org.w3c.dom.events.EventListener) new OnClickAction(), false);
    }

    public class OnLoadAction implements EventListener {
        public void handleEvent(Event evt) {
            // Perform some actions here...

            // ...for example start an animation loop:
            ((org.apache.batik.bridge.Window) window).setInterval(new Animation(), 50);
        }
    }

    public class OnClickAction implements EventListener {
        public void handleEvent(Event evt) {
            // Perform some actions here...

            // ...for example schedule an action for later:
            ((org.apache.batik.bridge.Window) window).setTimeout(new DelayedTask(), 500);
        }
    }

    public class Animation implements Runnable {
        public void run() {
            // Insert animation code here...
        }
    }

    public class DelayedTask implements Runnable {
        public void run() {
            // Perform some actions here...

            // ...for example displays an alert dialog:
            ((org.apache.batik.bridge.Window) window).alert("Delayed Action invoked!");
        }
    }
}

