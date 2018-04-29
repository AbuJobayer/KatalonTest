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
import org.openqa.selenium.Keys as Keys

CustomKeywords.'com.gmail.authentication.GmailAuthentication.GmailLogin'()

WebUI.waitForPageLoad(GlobalVariable.Timeout)

'Wait for the Google Apps button tobe appeard'
WebUI.waitForElementPresent(findTestObject('Object Repository/GmailHomePage/GoogleAppsBttn'), GlobalVariable.Timeout)

'Click on the Google Apps Button'
WebUI.click(findTestObject('Object Repository/GmailHomePage/GoogleAppsBttn'))

WebUI.delay(GlobalVariable.DelayLow)

'Click on the Google Apps Button'
WebUI.click(findTestObject('Object Repository/GmailHomePage/GoogleDriveBttn'))

WebUI.delay(GlobalVariable.DelayLow)

'Switch to new window'
WebUI.switchToWindowIndex(1)

'Clcik on the New Button'
WebUI.click(findTestObject('Object Repository/GoogleDrive/NewBttn'))

WebUI.delay(GlobalVariable.DelayLow)

WebUI.click(findTestObject('GoogleDrive/FileUpload'))

WebUI.delay(GlobalVariable.DelayLow)

'Run Autoit Script to handle Windows upload functionality'
Autoit_Fileupload = 'C:\\Autoit\\File_upload.exe'

Runtime.getRuntime().exec(Autoit_Fileupload)

Thread.sleep(3000)

WebUI.waitForPageLoad(GlobalVariable.Timeout)

'Wait for the image file to be loaded'
WebUI.waitForElementPresent(findTestObject('Object Repository/GoogleDrive/ImageFile'), GlobalVariable.Timeout)

WebUI.delay(GlobalVariable.DelayLow)

WebUI.rightClick(findTestObject('Object Repository/GoogleDrive/ImageFile'))

WebUI.delay(GlobalVariable.DelayLow)

WebUI.focus(findTestObject('Object Repository/GoogleDrive/Removebttn'))

WebUI.delay(GlobalVariable.DelayLow)

WebUI.click(findTestObject('Object Repository/GoogleDrive/Removebttn'))

CustomKeywords.'com.gmail.authentication.GmailAuthentication.GmailLogout'()




