package com.yodlee.training.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JmxDemo {

	/**
	 * @param args
	 * @throws NullPointerException 
	 * @throws MalformedObjectNameException 
	 * @throws NotCompliantMBeanException 
	 * @throws MBeanRegistrationException 
	 * @throws InstanceAlreadyExistsException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedObjectNameException, NullPointerException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
		// TODO Auto-generated method stub
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		MyJmx j = new MyJmx();
		ObjectName n = new ObjectName("com.hp", "type", "MyJmx");
		server.registerMBean(j, n);
		
		Thread.sleep(Long.MAX_VALUE);
	}

}
