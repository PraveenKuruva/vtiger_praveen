package utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLConfigNodes_UIelement {
	static String uiElementsFilePath;

	public ReadXMLConfigNodes_UIelement(String uiElementsFilePath) {
		this.uiElementsFilePath = uiElementsFilePath;
	}

	public static String GetLocatorFromUIelementsXml(String LocatorKeyValue) {
		String attributeValue = null;
		String attributeName;
		try {
			// File fXmlFile = new File("resources\\UIelements.xml");
			File fXmlFile = new File(uiElementsFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Entry");
			// System.out.println("nLists:" + nList.getLength());
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					attributeName = eElement.getAttribute("Key");
					// System.out.println("attribute Name" + attributeName);
					if (attributeName.equals(LocatorKeyValue)) {
						attributeValue = eElement.getAttribute("value");
						// System.out.println("attribute Value:" +
						// attributeValue);
					}
				}
			}
//			System.out.println("attribute value:" + attributeValue);
			return attributeValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
