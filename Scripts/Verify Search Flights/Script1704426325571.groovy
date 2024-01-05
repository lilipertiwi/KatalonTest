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

Mobile.comment('Story: Verify Flight Search Form')

Mobile.comment('Given that user has started Traveloka application')

Mobile.startExistingApplication('com.traveloka.android')

Mobile.comment('When user click on Flight menu')

Mobile.tap(findTestObject('Object Repository/Application/Flight/FlightMenu'), 0)

Mobile.comment('And user input From location "Jakarta"')

Mobile.tap(findTestObject('Object Repository/Application/Flight/Origin'), 0)

Mobile.sendKeys(findTestObject('Object Repository/Application/Flight/SearchCityField'), 
    '"Jakarta"')

Mobile.tap(findTestObject('Object Repository/Application/Flight/SearchedCity'), 0)

Mobile.comment('And user input To location "Padang"')

Mobile.tap(findTestObject('Object Repository/Application/Flight/Destination'), 0)

Mobile.sendKeys(findTestObject('Object Repository/Application/Flight/SearchCityField'), 
    '"padang"')

Mobile.tap(findTestObject('Object Repository/Application/Flight/SearchedCity'), 0)

Mobile.comment('And user input Departure Date "Tuesday, 9 Jan 2024"')

Mobile.tap(findTestObject('Object Repository/Application/Flight/DepartureDate'), 0)

Mobile.tap(findTestObject('Object Repository/Application/Flight/Date'), 0)

Mobile.comment('And user verify the number of passenger is 1')

def numberOfPassenger = Mobile.getText(findTestObject('Object Repository/Application/Flight/Passenger'), 
    0)

Mobile.verifyEqual(numberOfPassenger, '1 passenger')

Mobile.comment('And user verify the seat class is economy')

def seatClass = Mobile.getText(findTestObject('Object Repository/Application/Flight/SeatClass'), 
    0)

Mobile.verifyEqual(seatClass, 'Economy')

Mobile.comment('And user click on Search button')

Mobile.tap(findTestObject('Object Repository/Application/Flight/SearchButton'), 0)

Mobile.comment('Then user verify the search result')

def flight = Mobile.getText(findTestObject('Object Repository/Application/Flight/Origin-Destination'), 
    0)

def flightDetail = Mobile.getText(findTestObject('Object Repository/Application/Flight/FlightDetail'), 
    0)

def flightDate = Mobile.getText(findTestObject('Object Repository/Application/Flight/FlightDate'), 
    0)

Mobile.verifyEqual(flight, 'Jakarta (JKTA)   Padang (PDG)')

Mobile.verifyEqual(flightDetail, 'Tue, 16 Jan • 1 pax • Economy')

Mobile.verifyEqual(flightDate, 'Tue, 16 Jan')

Mobile.closeApplication()

