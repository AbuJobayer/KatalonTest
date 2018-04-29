package com.gmail.authentication

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class GmailAuthentication {

	@Keyword
	public void GmailLogin() {

		//Using global variable for the URL
		WebUI.openBrowser(GlobalVariable.GmailLoginPage)

		//Explicit wait till the page is lodded with timeout 30 sec
		WebUI.waitForPageLoad(GlobalVariable.Timeout)

		WebUI.maximizeWindow()

		'Verify the Email Input field'
		WebUI.verifyElementPresent(findTestObject('GmailLoginPage/EmailField'), GlobalVariable.Timeout)

		//Enter the email address
		WebUI.sendKeys(findTestObject('GmailLoginPage/EmailField'), findTestData('ExcelDataSource/ExcelGmailLogin').getValue(
				2, 1))

		//Delay for 2 sec
		WebUI.delay(GlobalVariable.DelayLow)

		//Click on Next Button
		WebUI.click(findTestObject('GmailLoginPage/NextButton'))

		//Explicit wait till the page is lodded with timeout 30 sec
		WebUI.waitForPageLoad(GlobalVariable.Timeout)

		//Verify Password Input Field
		WebUI.verifyElementPresent(findTestObject('GmailLoginPage/PasswordField'), GlobalVariable.Timeout)

		//Add Password from Excel Data source in Password Field
		WebUI.sendKeys(findTestObject('Object Repository/GmailLoginPage/PasswordField'), findTestData('ExcelDataSource/ExcelGmailLogin').getValue(
				3, 1))

		//Delay for 2 sec
		WebUI.delay(GlobalVariable.DelayLow)

		//Click on Next Button
		WebUI.click(findTestObject('GmailLoginPage/NextButton'))

	}

	@Keyword
	public void GmailLogout() {

		//Switch to default frame
		WebUI.switchToDefaultContent()

		//Switch to default window
		WebUI.switchToWindowIndex(0)

		'Click on the Account Button'
		WebUI.click(findTestObject('GmailHomePage/GmailAccountBttn'))

		//Click on the Signout button
		'Signout from Gmail account'
		WebUI.click(findTestObject('GmailHomePage/SignOutBttn'))

		WebUI.closeBrowser()




	}
}
