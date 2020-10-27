package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Run_First {
	
	
  @Test
  public void TC_01() {
	  System.out.println("TC_01");

  }
  
  @Test
  public void TC_02() {
	  System.out.println("TC_02");

  }
  
  @Test
  public void TC_03() {
	  System.out.println("TC_03");

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("beforeMethod");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("beforeClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("beforeTest");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuit");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuit");

  }

}
