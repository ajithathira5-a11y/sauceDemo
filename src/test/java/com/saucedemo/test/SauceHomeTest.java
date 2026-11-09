package com.saucedemo.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saucedemo.base.SauceBaseClass;

public class SauceHomeTest extends SauceBaseClass {

	
	@Test(priority =2)
	public void productTextVerify()
	{
//		test = extent.createTest("productTextVerify");

		String p_actual = ho.productTextF();
		
		System.out.println("text p ======"+p_actual);
		Assert.assertEquals(p_actual, "Products");
		Reporter.log("productTextVerify successs");

	}
	
	@Test(priority=3)
	public void linkCount()
	{
//		test = extent.createTest("linkCount");

		int count = ho.linkCountF();
		System.out.println("link count ========="+count);
		Assert.assertEquals(count, 30);
		Reporter.log("linkCount successs");

	}
	
	@Test(priority=4)
	public void addToCartTextVerify()
	{
//		test = extent.createTest("addToCartTextVerify");

		String cart = ho.addToCartTextF();
		System.out.println("cart text ===="+cart);

		Assert.assertEquals(cart, "Add to cart");
		Reporter.log("addToCartTextVerify successs");

	}
	
	@Test(priority=5)
	public void filterLowHigh()
	{
//		test = extent.createTest("filterLowHigh");

		ho.filterclickF();
		Reporter.log("filterLowHigh successs");

	}
	
	@Test(priority=6)
	public void ClickAddToCart()
	{
//		test = extent.createTest("ClickAddToCart");

		ho.addToCartClickF();
		Reporter.log("ClickAddToCart successs");

	}
	
	@Test(priority=7)
	public void clickCart()
	{
//		test = extent.createTest("clickCart");

		ho.clickCartF();
		Reporter.log("clickCart successs");

	}
}
