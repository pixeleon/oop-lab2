package net.pixeleon.khpi.oop.labtwo.saxdom;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Saxing extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Opening document...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Closing document...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Opening tag: " + localName);
        if (attributes.getLength() > 0) {
            System.out.println("Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + '=' + attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Closing tag: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch).substring(start, start + length).trim();
        if (s.length() > 0) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            if (saxParser != null)
                saxParser.parse("files6\\studgroup.xml", new Saxing());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
