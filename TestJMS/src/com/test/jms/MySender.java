package com.test.jms;

import java.util.Hashtable;


import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MySender {

	private static InitialContext ctx = null;
	private static QueueConnectionFactory qcf = null;
	private static QueueConnection qc = null;
	private static QueueSession qsess = null;
	private static Queue q = null;
	private static QueueSender qsndr = null;
	private static TextMessage message = null;

	private static final String DEFAULT_QCF_NAME = "CFQueue";
	private static final String DEFAULT_QUEUE_NAME = "queue1";

	private static final String DEFAULT_URL = "t3://lt-00006774:7002";
	private static final String DEFAULT_USER = "weblogic";
	private static final String DEFAULT_PASSWORD = "weblogic1";

	public static void main(String[] args) {
		String message = "Hello from JMS";
		try {
			sendMessage(message);
		} catch (NamingException | JMSException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void sendMessage(String msg) throws NamingException, JMSException {
		sendMessage(MySender.DEFAULT_URL, MySender.DEFAULT_USER, MySender.DEFAULT_PASSWORD, MySender.DEFAULT_QCF_NAME,
				MySender.DEFAULT_QUEUE_NAME, msg);
	}

	private static void sendMessage(String url, String user, String password, String cf, String queue,
			String messageText) throws NamingException, JMSException  {
		
		Hashtable<String, String> properties = new Hashtable<>();
		
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.PROVIDER_URL, url);
		properties.put(Context.SECURITY_PRINCIPAL, user);
		properties.put(Context.SECURITY_CREDENTIALS, password);
		
		ctx = new InitialContext(properties);
		System.out.println("Got InitialContext " + ctx.toString());
		
		qcf = (QueueConnectionFactory) ctx.lookup(cf);
		System.out.println("Got QueueConnectionFactory " + qcf.toString());
		
		qc =  qcf.createQueueConnection();
		System.out.println("Got QueueConnection " + qc.toString());
		
		qsess = qc.createQueueSession(false, 0);
		System.out.println("Got QueueConnection Session " + qsess.toString());
		
		q = (Queue)ctx.lookup(queue);
		System.out.println("Got Queue" + q.toString());
		
		qsndr = qsess.createSender(q);
		System.out.println("Got QueueSender " + qsndr.toString());
		
		message = qsess.createTextMessage();
	    System.out.println("Got TextMessage " + message.toString());
	    
	    message.setText(messageText);
	    System.out.println("Set text in TextMessage " + message.toString());
	    
	    qsndr.send(message);
	    System.out.println("Sent message ");
	    
	    message = null;
        qsndr.close();
        qsndr = null;
        q = null;
        qsess.close();
        qsess = null;
        qc.close();
        qc = null;
        qcf = null;
        ctx = null;
        System.out.println("Cleaned up and done.");
	}

}
