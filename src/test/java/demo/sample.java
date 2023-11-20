package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class sample {
	@Test(enabled=true,alwaysRun=true)
	public void alr() {
		System.out.println("always run");
		Assert.fail();
	}
	@Test(alwaysRun=true,dependsOnMethods = "alr")
	public void dm() {
	System.out.println("depends on method");
	}
}