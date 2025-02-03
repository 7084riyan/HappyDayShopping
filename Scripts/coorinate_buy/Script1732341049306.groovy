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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

// Start the application
Mobile.startApplication('C:\\Users\\HP\\Katalon Studio\\Happydays\\mobile\\Happy_Day_Shopping.apk', false)

// Tap "PROMOTIONS" button using object repository
Mobile.tap(findTestObject('Object Repository/BuyProd_positif/android.widget.TextView - PROMOTIONS'), 0)

WebUI.delay(5)

// Scroll to "Afficionado"
//Mobile.scrollToText('Afficionado', FailureHandling.STOP_ON_FAILURE)
//Mobile.scrollToText('Bread Sticks', FailureHandling.STOP_ON_FAILURE)
'Get Device Height and Store in device_height variable'
device_Height = Mobile.getDeviceHeight()

'Get Width Height and Store in device_Width variable'
device_Width = Mobile.getDeviceWidth()

'Storing the startX value by dividing device width by 2. Because x coordinates are constant for Vertical Swiping'
int startX = device_Width / 2

'Here startX and endX values are equal for vertical Swiping for that assigning startX value to endX'
int endX = startX

'Storing the startY value'
int startY = device_Height * 0.30

'Storing the endY value'
int endY = device_Height * 0.70

'Swipe Vertical from top to bottom'
Mobile.swipe(startX, endY, endX, startY)

WebUI.delay(5)

// Tap "Add to Bag" button using object repository
Mobile.tap(findTestObject('Object Repository/BuyProd_positif/android.widget.TextView - Add to Bag'), 0)

// Verify the notification exists
Mobile.verifyElementExist(findTestObject('Object Repository/BuyProd_positif/notif_add'), 3)

// Tap "Your Bag" button using object repository
Mobile.tap(findTestObject('Object Repository/BuyProd_positif/android.widget.TextView - Your Bag'), 0)

// Tap "Checkout" button using object repository
Mobile.tap(findTestObject('Object Repository/BuyProd_positif/android.widget.TextView - Checkout'), 0)

// Close the application
Mobile.closeApplication()

Mobile.checkElement(findTestObject(null), 0)

