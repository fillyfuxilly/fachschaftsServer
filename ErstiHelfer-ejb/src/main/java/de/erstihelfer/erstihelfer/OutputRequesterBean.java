package de.erstihelfer.erstihelfer;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 * Session Bean implementation class OutputRequesterBean
 * @author Amayda Dominguez
 */
@Stateless
@LocalBean
public class OutputRequesterBean {

	
	 @Resource(mappedName="java:/JmsXA")
	  private ConnectionFactory jmsFactory;
	  
	  @Resource(mappedName="java:/jms/queue/FachschaftOutput")
	  private Queue outputQueue;
	  
	  public void printLetter(String letter) {
			try (JMSContext context = jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)){
				TextMessage message = context.createTextMessage();
				message.setStringProperty("DocType", "Letter");
				message.setText(letter);
				context.createProducer().send(outputQueue, message);
			}
			catch (JMSException e) {
				throw new EJBException(e);
			}  
		  }

}
