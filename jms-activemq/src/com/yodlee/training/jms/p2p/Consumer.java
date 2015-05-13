package com.yodlee.training.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class Consumer implements MessageListener {
	// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	// Name of the queue we will receive messages from
	private static String subject = "example.MyQueue";

	public static void main(String[] args) throws JMSException {
		BasicConfigurator.configure();
		// Getting JMS connection from the server
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Creating session for seding messages
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// Getting the queue
		Destination destination = session.createQueue(subject);

		// MessageConsumer is used for receiving (consuming) messages
		MessageConsumer consumer = session.createConsumer(destination);

		// Here we receive the message.
		// By default this call is blocking, which means it will wait
		// for a message to arrive on the queue.
		consumer.setMessageListener(new Consumer());

		// Message message = consumer.receive();
		//
		// // There are many types of Message and TextMessage
		// // is just one of them. Producer sent us a TextMessage
		// // so we must cast to it to get access to its .getText()
		// // method.
		// if (message instanceof TextMessage) {
		// TextMessage textMessage = (TextMessage) message;
		// System.out.println("Received message '" + textMessage.getText()
		// + "'");
		// }
//		connection.close();
		
//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Received message '" + textMessage.getText()
						+ "'");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
