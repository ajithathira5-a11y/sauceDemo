package com.saucedemo.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SauceHomePgae {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	WebElement productText;
	
	@FindBy(tagName="a")
	List<WebElement> listLink;
	
	@FindBy(name = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
	WebElement filterButton;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	WebElement clickCartButton;
	
	
	public SauceHomePgae(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String productTextF()
	{
		return productText.getText();
	}
	
	public int linkCountF()
	{
		return listLink.size();
	}
	
	public String addToCartTextF()
	{
		return addToCartButton.getText();
	}
	
	public void filterclickF()
	{
//		filterButton.click();
		System.out.println("filetr clock====");
		Select sel = new Select(filterButton);
		sel.selectByVisibleText("Price (low to high)");
//		//sel.selectByValue("");
//		sel.selectByIndex(2);
	}
	public void addToCartClickF()
	{
		addToCartButton.click();
		System.out.println("clicked add to cart==");

	}
	
	public void clickCartF()
	{
		clickCartButton.click();
	}

}
