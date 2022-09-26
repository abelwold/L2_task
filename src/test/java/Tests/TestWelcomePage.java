package Tests;

import Pages.WelcomePage;
import org.testng.annotations.Test;

import java.awt.*;

public class TestWelcomePage extends BaseTest {

    @Test
    public void testNavMain() {
        WelcomePage mainPageOpened = new WelcomePage();
        assert mainPageOpened.MainPage():"Main Page is not opened.";
    }
    @Test
    public void testNumberOneCard() {
        WelcomePage firstCardCheck = new WelcomePage();
        String val = firstCardCheck.numberOneCard();
        assert val.equals("1 / 4"):"Card No `1 / 4` is not open.";
    }
    @Test
    public void testUploadImageSecondCard() throws AWTException {
        WelcomePage checkUploadImageSecondCard = new WelcomePage();
        String checkValTwo = checkUploadImageSecondCard.uploadImageSecondCard();
        assert checkValTwo.equals("2 / 4"):"Card No `2 / 4` is not open.";
        WelcomePage checkThirdCard = new WelcomePage();
        String checkValThree = checkThirdCard.thirdCardPage();
        assert checkValThree.equals("3 / 4" + "00:00:00"): "Card No `3 / 4` is not open or Timer is not starting from `00:00:00`.";
    }
}