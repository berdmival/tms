package lec_16.homework.task_1;

/*
 * Есть студенты. У каждого студента есть номер группы, имя, фамилия, факультет. Создать XML файл, в котором описать 3-4 студента.
 * Прочитать из файла студентов при помощи DOM и SAX парсера
 */

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// выноси большие куски в отдельные методы и тогда не нужно будет писать комментарий типа '//Parsing xml by DOM-parser'
// комментарии устаревают, за ними мало кто следит. А вот по названию метода сразу понятно будет что и как
public class Task_1 {

    private static final String inputXMLFilePath = "xml/university.xml";

    public static void main(String[] args) {
        //Parsing xml by DOM-parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            InputStream resource = ClassLoader.getSystemResourceAsStream(inputXMLFilePath);
            Document document = documentBuilder.parse(resource);

            List<Student> universityDOM = new ArrayList<>();
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node instanceof Element) {
                    Student student = new Student();

                    student.setGroup(node.getAttributes().getNamedItem("group").getNodeValue());

                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);

                        if (childNode instanceof Element) {
                            String content = childNode.getLastChild().getTextContent().trim();

                            switch (childNode.getNodeName()) {
                                case "firstName":
                                    student.setFirstName(content);
                                    break;
                                case "lastName":
                                    student.setLastName(content);
                                    break;
                                case "faculty":
                                    student.setFaculty(content);
                                    break;
                            }
                        }
                    }

                    universityDOM.add(student);
                }
            }

            System.out.println("University list after DOM parsing");

            universityDOM.forEach(student -> System.out.println(student));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parsing xml by SAX-parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();

            InputStream resource = ClassLoader.getSystemResourceAsStream(inputXMLFilePath);
            saxParser.parse(resource, saxHandler);

            List<Student> universityJSON = saxHandler.getStudentList();

            System.out.println("University list after SAX parsing");

            universityJSON.forEach(student -> System.out.println(student));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
