package com.yodlee.training.jmx;

public class MyJmx implements MyJmxMBean{

	@Override
	public String getAppName() {
		// TODO Auto-generated method stub
		return "My Jmx";
	}

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}
	
}
