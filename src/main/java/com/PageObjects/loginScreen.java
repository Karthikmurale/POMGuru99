package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginScreen {
	
	public WebDriver ldriver;
	
	public loginScreen(WebDriver rdriver)
	{
//		driver = this.driver;
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(how=How.NAME,using="uid")
	@CacheLookup
	private WebElement txtUID;
	
	
	@FindBy(how=How.NAME ,using="password")
	@CacheLookup
	private WebElement txtPassword;
	
	
	@FindBy(how=How.NAME ,using="btnLogin")
	@CacheLookup
	private WebElement btnLogin;
	
	
	public void uidEnterText(String uName)
	{
		txtUID.sendKeys(uName);
	}
	
	public void passEnterText(String Pass)
	{
		txtPassword.sendKeys(Pass);
	}
	
	public void loginClick()
	{
		btnLogin.click();
	}
	
	

}
