package net.pixeleon.khpi.oop.labtwo.saxdom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Doming {
    public static void main(String[] args) {
        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.parse(new File("files6\\studgroup.xml"));
            Node rootNode = doc.getDocumentElement();

            readXMLElement(rootNode);
            updateXMLData(rootNode);

            Element stud = doc.createElement("Student");
            stud.setAttribute("StudentID", "114");
            stud.setAttribute("Lastname", "Ggg");
            stud.setAttribute("Firstname", "Hh");

            //addXMLElement(rootNode, stud);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("files6//newstudgroup.xml")));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addXMLElement(Node node, Element element) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            if (node.getChildNodes().item(i).getNodeName().equals("Students")) {
                node.getChildNodes().item(i).appendChild(element);
                return;
            }
            addXMLElement(node.getChildNodes().item(i), element);
        }
    }

    private static void updateXMLData(Node node) {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            if (node.getChildNodes().item(i).getNodeName().equals("GroupInfo")) {
                node.getChildNodes().item(i).setTextContent("KN faulty, SEMIT department, Software Engineering (eng)");
                return;
            }
            updateXMLData(node.getChildNodes().item(i));
        }

    }

    private static void readXMLElement(Node node) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println(node.getNodeValue().trim());
        } else {
            System.out.println("Element: " + node.getNodeName());
            System.out.println("(attributes: ");
            if (node.hasAttributes()) {
                for (int i = 0; i < node.getAttributes().getLength(); i++) {
                    System.out.println(node.getAttributes().item(i).getNodeName() + '=' + node.getAttributes().item(i).getNodeValue());
                }
            }
            System.out.println(")");
            System.out.println("{data:");
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                readXMLElement(node.getChildNodes().item(i));
            }
            System.out.println("}");
        }
    }
}
