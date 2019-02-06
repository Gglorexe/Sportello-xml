package nbparsexml;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List listLink;

    public Parser() {
        listLink = new ArrayList();
    }

    public List parseLink(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        LinkClass link;
        
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("a");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                link = getLink(element);
                if(link.getTitolo() != "") 
                    listLink.add(link);  
            } 
        }
        return listLink;
    }
    
    private LinkClass getLink(Element element) {
        LinkClass r;
        String link = element.getAttribute("href");
        String titoloLink = element.getFirstChild().getNodeValue();
        r = new LinkClass(titoloLink, link);
        return r;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
//    private String getTextValue(Element element, String tag) {
//        String value = null;
//        NodeList nodelist;
//        nodelist = element.getElementsByTagName(tag);
//        if (nodelist != null && nodelist.getLength() > 0) {
//            value = nodelist.item(0).getFirstChild().getNodeValue();
//        }
//        return value;
//    }
    
    // restituisce il valore intero dell’elemento figlio specificato
//    private int getIntValue(Element element, String tag) {
//        return Integer.parseInt(getTextValue(element, tag));
//    }
//    
//    // restituisce il valore numerico dell’elemento figlio specificato
//    private float getFloatValue(Element element, String tag) {
//        return Float.parseFloat(getTextValue(element, tag));
//    }
    
}