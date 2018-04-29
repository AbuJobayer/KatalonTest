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

CustomKeywords.'com.gmail.authentication.GmailAuthentication.GmailLogin'()

'Verrify the Email Compose Button'
WebUI.verifyElementPresent(findTestObject('Object Repository/GmailHomePage/ComposeBttn'), GlobalVariable.Timeout)

'Click on the Compose Button'
WebUI.click(findTestObject('Object Repository/GmailHomePage/ComposeBttn'))

'Verify Recipients Field'
WebUI.verifyElementPresent(findTestObject('Object Repository/GmailHomePage/RecipientsField'), GlobalVariable.Timeout)

'Add the Recipient\'s Email address from Excel Data Source'
WebUI.sendKeys(findTestObject('Object Repository/GmailHomePage/RecipientsField'), findTestData('ExcelDataSource/GmailContents').getValue(
        1, 1))

'Add the Subject of the email'
WebUI.sendKeys(findTestObject('GmailHomePage/SubjectField'), findTestData('ExcelDataSource/GmailContents').getValue(2, 1))

'Add Email content'
WebUI.sendKeys(findTestObject('GmailHomePage/TextField'), findTestData('ExcelDataSource/GmailContents').getValue(3, 1))

WebUI.delay(GlobalVariable.DelayLow)

'Click on the Send Button'
WebUI.click(findTestObject('Object Repository/GmailHomePage/SendBttn'))

WebUI.delay(GlobalVariable.DelayHigh)

'Click on the Inbox'
WebUI.click(findTestObject('Object Repository/GmailHomePage/InboxLink'))

//Explicit wait till the page is lodded with timeout 30 sec
WebUI.waitForPageLoad(GlobalVariable.Timeout)

WebUI.delay(GlobalVariable.DelayLow)

'Verify the Email is showing in the Inbox'
WebUI.verifyElementVisible(findTestObject('GmailHomePage/EmailContent'))

'Select the Email from Inbox'
WebUI.check(findTestObject('Object Repository/GmailHomePage/CheckBox'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(GlobalVariable.DelayLow)

WebUI.focus(findTestObject('Object Repository/GmailHomePage/MenuBar'))

WebUI.click(findTestObject('Object Repository/GmailHomePage/DeleteBttn'))

CustomKeywords.'com.gmail.authentication.GmailAuthentication.GmailLogout'()


