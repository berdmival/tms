package lec_16.homework.task_1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Student> studentList = new ArrayList<>();
    // = null не обязательно
    private Student student = null;
    private String content = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "student":
                student = new Student();
                student.setGroup(attributes.getValue("group"));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "student":
                studentList.add(student);
                break;
// лишний пробел
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

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
