//package train.pooyan.consumee.soap;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class CountryConf {
//
//	 @Bean
//	  public Jaxb2Marshaller marshaller() {
//	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//	    // this package must match the package in the <generatePackage> specified in
//	    // pom.xml
//	    marshaller.setContextPath("com.example.consumingwebservice.wsdl");
//	    return marshaller;
//	  }
//
//	  @Bean
//	  public CountryService countryClient(Jaxb2Marshaller marshaller) {
//		  CountryService client = new CountryService();
//	    client.setDefaultUri("http://localhost:8080/ws");
//	    client.setMarshaller(marshaller);
//	    client.setUnmarshaller(marshaller);
//	    return client;
//	  }
//}
