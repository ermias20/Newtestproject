package Tools;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ReadXMLFile {
    public static double WfRightSphere;
    public static double WfLeftSphere;
    public static double WfRightCyl;
    public static double WfLeftCyl;
    public static double WfRightAxis;
    public static double WfLeftAxis;
    public static double FinalRightSphere;
    public static double FinalLeftSphere;
    public static double FinalRightCyl;
    public static double FinalLeftCyl;
    public static double FinalRightAxis;
    public static double FinalLeftAxis;
    public static double LmRightSphere;
    public static double LmLeftSphere;
    public static double LmRightCyl;
    public static double LmleftCyl;
    public static double LmRightAxis;
    public static double LmLeftAxis;

    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    public Document doc;

    public  ReadXMLFile(String xmlpath) throws IOException, ParserConfigurationException, SAXException {
        this.dbFactory = DocumentBuilderFactory.newInstance();
        this.dBuilder = dbFactory.newDocumentBuilder();
        this.doc = dBuilder.parse(xmlpath);
        doc.getDocumentElement().normalize();
    }


    public Double Xmlread( String xmldata,String eye, String data) throws IOException, ParserConfigurationException, SAXException {
        Double value=null;
        NodeList wf_right = doc.getElementsByTagName(xmldata);
        for (int temp = 0; temp < wf_right.getLength(); temp++) {
            Node nNode = wf_right.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                NodeList children = eElement.getElementsByTagName(eye);

                for (int i = 0; i < children.getLength(); i++) {
                    Node nNode1 = children.item(i);
                    if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement1 = (Element) nNode1;
                         value = Double.parseDouble(eElement1.getElementsByTagName(data).item(0).getTextContent());


                    }
                }
            }
        }
        return value;
    }

   public void WfxmlData () throws ParserConfigurationException, SAXException, IOException {
        try {
            this.WfRightSphere = Xmlread("objective_mesurement","wf_right", "sphere");
            this.WfRightCyl = Xmlread("objective_mesurement","wf_right", "cylinder");
            this.WfRightAxis = Xmlread("objective_mesurement","wf_right", "axis");
            this.WfLeftSphere = Xmlread("objective_mesurement","wf_left", "sphere");
            this.WfLeftCyl = Xmlread("objective_mesurement","wf_left", "cylinder");
            this.WfLeftAxis = Xmlread("objective_mesurement","wf_left", "axis");
        }catch (NumberFormatException e){

        }

   }
    public void FinalxmlData()throws ParserConfigurationException, SAXException, IOException {
        try {
            this.FinalRightSphere = Xmlread("subjective_mesurement","ref_right", "sphere");
            this.FinalRightCyl = Xmlread("subjective_mesurement","ref_right", "cylinder");
            this.FinalRightAxis = Xmlread("subjective_mesurement","ref_right", "axis");
            this.FinalLeftSphere = Xmlread("subjective_mesurement","ref_left", "sphere");
            this.FinalLeftCyl = Xmlread("subjective_mesurement","ref_left", "cylinder");
            this.FinalLeftAxis = Xmlread("subjective_mesurement","ref_left", "axis");
        }catch (NumberFormatException e){

        }

    }

    public void LmxmlData()throws ParserConfigurationException, SAXException, IOException {
        try {

            this.LmRightSphere = Xmlread("LSM_mesurement","ref_right", "sphere");
            this.LmRightCyl = Xmlread("LSM_mesurement","ref_right", "cylinder");
            this.LmRightAxis = Xmlread("LSM_mesurement","ref_right", "axis");
            this.LmLeftSphere = Xmlread("LSM_mesurement","ref_left", "sphere");
            this.LmleftCyl = Xmlread("LSM_mesurement","ref_left", "cylinder");
            this.LmLeftAxis = Xmlread("LSM_mesurement","ref_left", "axis");

        }catch (NumberFormatException e){

        }

    }


}


