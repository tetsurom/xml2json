package xml2json;

import java.io.PrintStream;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Converter extends DefaultHandler {
	public void startDocument() {
		stream.println("{ \"name\": \"@document\", \"contents\": [");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		stream.print("{ \"name\": \"");
		stream.print(qName);
		stream.print("\", \"attributes\": {");
		int n = attributes.getLength();
		for(int i = 0; i < n; ++i){
			stream.print("\"");
			stream.print(attributes.getLocalName(i));
			stream.print("\": \"");
			stream.print(attributes.getValue(i));
			stream.print("\"");
			if(i+1 < n){
				stream.print(",");
			}
		}
		stream.println("}, \"contents\": [");
	}

	public void characters(char[] ch, int offset, int length) {
		String text = new String(ch, offset, length).trim();
		if(text.length() > 0){
			stream.print("{ \"name\": \"@text\", \"value\": \"");
			stream.print(text);
			stream.print("\" }");
		}
	}

	public void endElement(String uri, String localName, String qName) {
		stream.println("] },");
	}

	public void endDocument() {
		stream.println("] }");
	}
	
	PrintStream stream;

	public void setPrintStream(PrintStream fileoutStream) {
		this.stream = fileoutStream;
	}
}
