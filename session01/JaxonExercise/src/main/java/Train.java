

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Train {
	public static void main(String... args) {
		XmlMapper xmlMapper = new XmlMapper();
		JsonMapper jsonMapper = new JsonMapper();
		SimpleBean simpleBean = new SimpleBean(3, 3);
		xmlMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		
		
		try {
			String xml = xmlMapper.writeValueAsString(simpleBean);
			System.out.println(xml);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		
		try {
			File file = new File("sample1.xml");
			xmlMapper.writeValue(file, simpleBean);
			Files.lines(file.toPath())
				.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();

		try {
			SimpleBean bean  = xmlMapper.readValue("<SimpleBean><Xnour>1</Xnour><y>1</y></SimpleBean>", SimpleBean.class);
			SimpleBean fileBean = xmlMapper.readValue(new File("sample1.xml"), SimpleBean.class);
			System.out.println("Strin Bean: " + bean);
			System.out.println("File Bean: " + fileBean);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Person person = new Person();
		person.setLastName("pooyan");
		person.setFirstName("pm ");
		person.addPhoneNumbers("09123456789");
		person.addPhoneNumbers("0987654321");
		
		person.addAddress("Tehran", "Mirdamad");
		person.addAddress("Mashhad" , "Azadi");
		System.out.println(person);
		

	    try {
		    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			xmlMapper.writeValue(byteArrayOutputStream, person);
		    System.out.println(byteArrayOutputStream.toString());
		    xmlMapper.writeValue(new File("sample.xml"), person);
		    
		    jsonMapper.writerWithDefaultPrettyPrinter().writeValue(
		    		new File("sample.json"), person
		    		);
			
			Person p = jsonMapper.readValue(new File("sample.json"), Person.class);
			System.out.println(p);
			
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    
		
	}
}
