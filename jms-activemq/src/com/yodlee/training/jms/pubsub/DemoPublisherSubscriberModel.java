package com.yodlee.training.jms.pubsub;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

import org.apache.log4j.BasicConfigurator;

public class DemoPublisherSubscriberModel implements javax.jms.MessageListener {
 private TopicSession pubSession;
 private TopicPublisher publisher;
 private TopicConnection connection;

 /* Establish JMS publisher and subscriber */
 public DemoPublisherSubscriberModel(String topicName, String username,
   String password) throws Exception {
  // Obtain a JNDI connection
  InitialContext jndi = new InitialContext();

  // Look up a JMS connection factory
  TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi
    .lookup("topicConnectionFactory");

  // Create a JMS connection
  connection = conFactory.createTopicConnection(username, password);
  connection.setClientID("Topic2");
  // Create JMS session objects for publisher and subscriber
  pubSession = connection.createTopicSession(false,
    Session.AUTO_ACKNOWLEDGE);
  TopicSession subSession = connection.createTopicSession(false,
    Session.AUTO_ACKNOWLEDGE);

  // Look up a JMS topic
  Topic chatTopic = (Topic) jndi.lookup(topicName);

  // Create a JMS publisher and subscriber
  publisher = pubSession.createPublisher(chatTopic);
  TopicSubscriber subscriber = subSession.createDurableSubscriber(chatTopic, "Topic2");

  // Set a JMS message listener
  subscriber.setMessageListener(this);

  // Start the JMS connection; allows messages to be delivered
  connection.start();

  // Create and send message using topic publisher
  TextMessage message = pubSession.createTextMessage();
  message.setText(username + ": Howdy Friends!");
  publisher.publish(message);

 }

 /*
  * A client can register a message listener with a consumer. A message
  * listener is similar to an event listener. Whenever a message arrives at
  * the destination, the JMS provider delivers the message by calling the
  * listener's onMessage method, which acts on the contents of the message.
  */
 public void onMessage(Message message) {
  try {
   TextMessage textMessage = (TextMessage) message;
   String text = textMessage.getText();
   System.out.println(text);
  } catch (JMSException jmse) {
   jmse.printStackTrace();
  }
 }

 public static void main(String[] args) {
  BasicConfigurator.configure();
  try {
	  args = new String[3];
	  args[0] = "MyTopic";
	  args[1] = "";
	  args[2] = "";
   DemoPublisherSubscriberModel demo = new DemoPublisherSubscriberModel(
     args[0], args[1], args[2]);

   BufferedReader commandLine = new java.io.BufferedReader(
     new InputStreamReader(System.in));

   // closes the connection and exit the system when 'exit' enters in
   // the command line
   while (true) {
    String s = commandLine.readLine();
    if (s.equalsIgnoreCase("exit")) {
     demo.connection.close();
     System.exit(0);

    }
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
