package com.github.fhms;


import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.*;


/**
 * Session Bean implementation class OutPutRequesterBean
 */
@Stateless
@LocalBean
public class OutPutRequesterBean {
	
	@Resource(mappedName="java:/JmsXA")
	private ConnectionFactory jmsFactory;
	@Resource(mappedName="java:/jms/queue/FachschaftOutput")
	private Queue outputQueue;
	        
	 public void sendMessage(String nachricht)   
	 
	 {
		 try(JMSContext context= jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)){
			 TextMessage message = context.createTextMessage();
			 message.setStringProperty("DocType", "Letter");
			 message.setText(nachricht);
			 context.createProducer().send(outputQueue, message);
			 
		 }
		 catch (JMSException e){
		 throw new EJBException(e);
		 }
	 }
}
