package demo;

import org.testng.annotations.Test;

public class groups {
	@Test(priority=0,groups = {"smoke testing"})
	public void tc1() {
		System.out.println("hello");
	}
	@Test(priority=1,groups={"regression testing"})
	public void tc2() {
		System.out.println("hi");
	}
	@Test(priority=0,groups = {"smoke testing"})
	public void tc3() {
		System.out.println("good morning");
	}
	@Test(priority=1,groups={"regression testing"})
	public void tc4() {
		System.out.println("bye");
	}
}
