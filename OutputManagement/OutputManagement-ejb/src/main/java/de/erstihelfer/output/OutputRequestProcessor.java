package de.erstihelfer.output;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

import de.erstihelfer.output.OutputRequestProcessor;

/** @author Amayda Dominguez
 * 
 * Message-Driven Bean implementation class for: OutputRequestProcessor
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Queue1"), 
				@ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Queue1")
public class OutputRequestProcessor implements MessageListener {

private static final Logger logger = Logger.getLogger(OutputRequestProcessor.class);
	
	@Override
	public void onMessage(Message message) {
       try {
    	  TextMessage msg = (TextMessage) message;
          logger.info("Received message from jms/queue/Queue1: " + msg.getText());
       }
       catch (JMSException e) {
            throw new EJBException(e);
       }
    }

}
