package de.erstihelfer.erstihelfer;

import javax.jms.*;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class OutputRequesterBean
 * @author Amayda Dominguez
 */
@Stateless
@LocalBean
public class OutputRequesterBean {

	
	 @Resource(mappedName="java:/JmsXA")
	  private ConnectionFactory jmsFactory;
	  
	  @Resource(mappedName="java:/jms/queue/Queue1")
	  private Queue outputQueue;
	  /**
	   * Sendet den Admin eine Nachricht
	   * @param letter
	   */
	  public void adminNotification(String letter) {
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
