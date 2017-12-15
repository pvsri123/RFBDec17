package com.Ranfordbank.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTNG 
{
	@Test(priority=0)
	public void xyz()
	{
		Assert.assertEquals("Selenium", "Selenium");
	}
	@Test (priority=1)
public void pqr()
{
	Assert.assertEquals("testing", "testing");
}
	@Test (priority=2)
public void abc()
{
	Assert.assertEquals("testng", "testng");
}
}
