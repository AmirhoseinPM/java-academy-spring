package ir.freeland.spring.usebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternetbankServices {
	CardServices cardService;
    DatabaseManagment database;
    
    @Autowired
    public InternetbankServices(
    		CardServices cardService, 
    		DatabaseManagment database) {
    	this.cardService = cardService;
    	this.database = database;
    }
    
  public void doCardToCard(String sourceCard, String destinationCard) {
    
    String result = cardService.cardToCard(sourceCard, destinationCard);
    database.save( result );
    
  }
}
