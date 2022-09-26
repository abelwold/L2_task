package Pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.openqa.selenium.By;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.Keys;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class WelcomePage {

    By uniqueElement = By.xpath("//button[@class='start__button']");
    By clickHere = By.xpath("//a[@class='start__link']");
    By numberOneCardElement = By.xpath("//div[@class='page-indicator']");
    By numberTwoCardElement = By.xpath("//div[@class='page-indicator']");
    By numberThreeCardElement = By.xpath("//div[@class='page-indicator']");
    By numberOneCardPassword = By.xpath("//div[@class='login-form__field-row']//input");
    By numberOneCardEmail = By.xpath("//input[@placeholder='Your email']");
    By numberOneCardDomain = By.xpath("//input[@placeholder='Domain']");
    By checkBox = By.xpath("//span[@class='icon icon-check checkbox__check']");
    By option = By.xpath("//div[@class='dropdown__field']");
    By selectCom = By.xpath("//div[@class='dropdown__list-item'][8]");
    By nextFirstCard = By.xpath("//a[@class='button--secondary']");
    By uploadImg = By.xpath("//a[@class='avatar-and-interests__upload-button']");
    By deselect = By.xpath("//span[@class='checkbox small']//label[@for='interest_unselectall']");
    By purple = By.xpath("//label[@for='interest_purple']");
    By cinnamon = By.xpath("//label[@for='interest_cinnamon']");
    By windows = By.xpath("//label[@for='interest_windows']");
    By nextSecondCard = By.xpath("//button[@class='button button--stroked button--white button--fluid']");
    By cookiesSendToBottom = By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']");
    By secondCardCancel = By.xpath("//button[@class='button button--solid button--green']");
    By alertConfirm = By.xpath("//a[@class='button button--solid button--red']");
    By acceptCookiesSecondPage = By.xpath("//button[@class='button button--solid button--transparent']");
    By timerText = By.xpath("//div[@class='timer timer--white timer--center']");



    public boolean MainPage() {
        IElement mainPageOpen = AqualityServices.getElementFactory().getLink(uniqueElement, "Main Page");
        return mainPageOpen.state().isDisplayed();

    }
    public String numberOneCard() {
        IElement cardOne = AqualityServices.getElementFactory().getLink(clickHere, "Click Here");
        cardOne.click();
        IElement cardNumber = AqualityServices.getElementFactory().getTextBox(numberOneCardElement, "Card Number");
        String val = cardNumber.getText();
        IElement cancel = AqualityServices.getElementFactory().getLink(cookiesSendToBottom, "Send To Bottom");
        cancel.click();
        IElement inputPassword = AqualityServices.getElementFactory().getTextBox(numberOneCardPassword, "Input Password");
        inputPassword.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputPassword.sendKeys("Mypasswordisthis1brain");
        IElement inputEmail = AqualityServices.getElementFactory().getTextBox(numberOneCardEmail, "Input Email");
        inputEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputEmail.sendKeys("brain");
        IElement inputDomain = AqualityServices.getElementFactory().getTextBox(numberOneCardDomain, "Input Domain");
        inputDomain.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        inputDomain.sendKeys("gmail");
        IElement chooseDomain = AqualityServices.getElementFactory().getCheckBox(option, "Select");
        chooseDomain.click();
        IElement comDomain = AqualityServices.getElementFactory().getCheckBox(selectCom, "Select Domain");
        comDomain.click();
        IElement uncheckBox = AqualityServices.getElementFactory().getCheckBox(checkBox, "Check Box");
        uncheckBox.click();
        IElement nextCard = AqualityServices.getElementFactory().getLink(nextFirstCard, "Next");
        nextCard.click();
        return val;
     }
    public String uploadImageSecondCard() throws AWTException {
        Robot robot = new Robot();
        IElement image = AqualityServices.getElementFactory().getLink(uploadImg,"Image");
        image.click();
        robot.setAutoDelay(4000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\abel\\Downloads\\logo_page-0001.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        robot.setAutoDelay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);


        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        IElement deselectAll = AqualityServices.getElementFactory().getCheckBox(deselect,"Deselect All");
        deselectAll.click();
        IElement cardNumberTwo = AqualityServices.getElementFactory().getLabel(numberTwoCardElement, "Card Number Two");
        String valTwo = cardNumberTwo.getText();
        IElement selectPurple = AqualityServices.getElementFactory().getCheckBox(purple,"Select Purple");
        selectPurple.click();
        IElement selectCinnamon = AqualityServices.getElementFactory().getCheckBox(cinnamon,"Select Cinnamon");
        selectCinnamon.click();
        IElement selectWindows = AqualityServices.getElementFactory().getCheckBox(windows,"Select Windows");
        selectWindows.click();
        IElement SecondCard = AqualityServices.getElementFactory().getLink(nextSecondCard,"Next Second Card");
        SecondCard.click();
        return valTwo;
    }
    public String thirdCardPage() {
        IElement cardNumberThree = AqualityServices.getElementFactory().getLabel(numberThreeCardElement, "Card Number Three");
        String valThree = cardNumberThree.getText();
        IElement clickCancel = AqualityServices.getElementFactory().getLink(secondCardCancel, "Third Card Cancel");
        clickCancel.click();
        IElement confirmAlert = AqualityServices.getElementFactory().getLink(alertConfirm, "Confirm Cancel");
        confirmAlert.click();
        IElement cardOne = AqualityServices.getElementFactory().getLink(clickHere, "Click Here");
        cardOne.click();
        IElement acceptCookies = AqualityServices.getElementFactory().getLink(acceptCookiesSecondPage, "Accept Cookies");
        acceptCookies.click();
        Browser browser = AqualityServices.getBrowser();
        browser.refresh();
        IElement getTimer = AqualityServices.getElementFactory().getTextBox(timerText, "Accept Cookies");
        String timer = getTimer.getText();
        return valThree + timer;
    }
}