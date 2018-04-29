import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Using global variable for the URL
'Open the Gmail URL'
WebUI.openBrowser(GlobalVariable.GmailLoginPage)

WebUI.maximizeWindow()

//Explicit wait till the page is lodded with timeout 30 sec
WebUI.waitForPageLoad(GlobalVariable.Timeout)

'Verify the Email Input field'
WebUI.verifyElementPresent(findTestObject('GmailLoginPage/EmailField'), GlobalVariable.Timeout)

'Enter the email address'
WebUI.sendKeys(findTestObject('GmailLoginPage/EmailField'), GlobalVariable.EmailAccount)

//Delay for 2 sec
WebUI.delay(GlobalVariable.DelayLow)

'Click on Next Button'
WebUI.click(findTestObject('GmailLoginPage/NextButton'))

//Explicit wait till the page is lodded with timeout 30 sec
WebUI.waitForPageLoad(GlobalVariable.Timeout)

'Verify Password Input Field'
WebUI.verifyElementPresent(findTestObject('Object Repository/GmailLoginPage/PasswordField'), GlobalVariable.Timeout)

'Add Password from Excel Datasource in Password Field'
WebUI.sendKeys(findTestObject('Object Repository/GmailLoginPage/PasswordField'), findTestData('ExcelDataSource/ExcelGmailLogin').getValue(
        3, 1))

//Delay for 2 sec
WebUI.delay(GlobalVariable.DelayLow)

'Click on Next Button'
WebUI.click(findTestObject('GmailLoginPage/NextButton'))



