import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.comment("Test Case Id: " + TestCaseId)

Mobile.comment("Given: User Input Data (Title: '" + Title + "' & Content: '" + Content + "')")

Mobile.delay(GlobalVariable.Delay)

Mobile.takeScreenshot()

Mobile.setText(findTestObject('Object Repository/Android_Room_Page_Add_Task/EditTextTaskTitle'), Title, GlobalVariable.Timeout)

Mobile.setText(findTestObject('Object Repository/Android_Room_Page_Add_Task/EditTextTaskContent'), Content, GlobalVariable.Timeout)

Mobile.comment("When: User Tap Button Save")

Mobile.delay(GlobalVariable.Delay)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('Object Repository/Android_Room_Page_Add_Task/ButtonSave'), GlobalVariable.Timeout)

Mobile.comment("Then: " + Expected)

Mobile.delay(GlobalVariable.Delay)

Mobile.takeScreenshot()

if(Title == "") {
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_Add_Task/ImageButtonTitleError'), GlobalVariable.Timeout)
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_Add_Task/TextViewTitleEmpty'), GlobalVariable.Timeout)
}else if(Title != "" && Content == "") {
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_Add_Task/ImageButtonContentError'), GlobalVariable.Timeout)
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_Add_Task/TextViewContentEmpty'), GlobalVariable.Timeout)
}else {
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskTitle'), GlobalVariable.Timeout)
	
	Mobile.verifyElementText(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskTitle'), Title)
	
	Mobile.verifyElementExist(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskContent'), GlobalVariable.Timeout)
	
	Mobile.verifyElementText(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskContent'), Content)
	
	//Delete Data
	
	Mobile.tap(findTestObject('Object Repository/Android_Room_Page_List_Task/ButtonDeleteAll'), GlobalVariable.Timeout)
	
	Mobile.tap(findTestObject('Object Repository/Android_Room_Page_Alert/ButtonOkAlert'), GlobalVariable.Timeout)
	
	Mobile.verifyElementNotExist(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskTitle'), GlobalVariable.Delay)
	
	Mobile.verifyElementNotExist(findTestObject('Object Repository/Android_Room_Page_List_Task/TextViewTaskContent'), GlobalVariable.Delay)
}

