import core.Start;
import org.junit.jupiter.api.Test;

public class SavePictureTest extends Start {
    @Test
    public void savePicture() {
        mainPage.goTo()
                .fillTextSearch("Калькулятор")
                .clickSearchButton();

        resultOfSearchPage.clickButtonTypeOfResult("CAEQBQ");

        picturePage.clickOnPictureNumber(1)
        .savePicture()
        .close();

    }
}
