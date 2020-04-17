package br.com.adalbertofjr.appium.core;

import org.junit.After;

public class BaseTest {

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
