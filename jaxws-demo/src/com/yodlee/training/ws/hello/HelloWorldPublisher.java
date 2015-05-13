package com.yodlee.training.ws.hello;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class HelloWorldPublisher{
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:8888/ws/hello", 
      		 new HelloWorldImpl());
}

	
}
