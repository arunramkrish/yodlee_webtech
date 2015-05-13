package com.yodlee.training.jms.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

public class Consumer {
 public Consumer() throws NamingException, JMSException {
  Connection connection;
  
  // Obtain a JNDI connection
  InitialContext jndi = new InitialContext();

  // Look up a JMS connection factory
  ConnectionFactory conFactory = (ConnectionFactory) jndi
    .lookup("connectionFactory");
  // Getting JMS connection from the server and starting it
  // ConnectionFactory connectionFactory = new
  // ActiveMQConnectionFactory(url);
  connection = conFactory.createConnection();

  // // Getting JMS connection from the server
  // ConnectionFactory connectionFactory = new
  // ActiveMQConnectionFactory(url);
  // Connection connection = connectionFactory.createConnection();
  try {
   connection.start();

   // Creating session for seding messages
   Session session = connection.createSession(false,
     Session.AUTO_ACKNOWLEDGE);

   // Getting the queue
   Destination destination = (Destination) jndi.lookup("MyQueue");

   // MessageConsumer is used for receiving (consuming) messages
   MessageConsumer consumer = session.createConsumer(destination);

   // Here we receive the message.
   // By default this call is blocking, which means it will wait
   // for a message to arrive on the queue.
   Message message = consumer.receive();

   // There are many types of Message and TextMessage
   // is just one of them. Producer sent us a TextMessage
   // so we must cast to it to get access to its .getText()
   // method.
   if (message instanceof TextMessage) {
    TextMessage textMessage = (TextMessage) message;
    System.out.println("Received message '" + textMessage.getText()
      + "'");
   }
  } finally {
   connection.close();
  }
 }

 public static void main(String[] args) throws JMSException {
  BasicConfigurator.configure();
  try {
   new Consumer();
  } catch (NamingException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

 }
}

