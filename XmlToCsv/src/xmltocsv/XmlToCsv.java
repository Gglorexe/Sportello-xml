/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmltocsv;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author spinelli_loris
 */
public class XmlToCsv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        // TODO code application logic here
        String daScrivere = "";
        File file = new File("Circolari_1419_2015-2016.140 Avvio Sportelli didattici - Integrazione.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());

        NodeList nList = root.getElementsByTagName("tr");
        
        int lung = nList.getLength();
        int count = 0;
        for (int i = 0; i < lung; i++) {
            if(nList.item(i).getFirstChild().getTextContent().equals("DISCIPLINA")){
                count = i;
                break;
            }
        }
        
        WriteCsv write = new WriteCsv();
        StrutturaProf professore = new StrutturaProf();
        for (int i = count+1; i < lung; i +=2) {
            NodeList tagTd = tagTd = nList.item(i).getChildNodes();
            if(tagTd.item(1).getTextContent().contains("N.B.")){
                break;
            }
            else{
            professore.nome[0] = tagTd.item(1).getTextContent();
            professore.giorno[0] = tagTd.item(2).getTextContent();
            professore.ora[0] = tagTd.item(3).getTextContent();
            
            tagTd = nList.item(i+1).getChildNodes();
            professore.nome[1] = tagTd.item(1).getTextContent();
            professore.giorno[1] = tagTd.item(2).getTextContent();
            professore.ora[1] = tagTd.item(3).getTextContent();
            
            daScrivere = professore.toString() + "\r\n";
            write.SalvaSuFile(daScrivere);
            }
        }       
        System.out.println("finish");   
    }

}

