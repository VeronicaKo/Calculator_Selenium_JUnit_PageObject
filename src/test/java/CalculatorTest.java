import core.Start;
import org.junit.jupiter.api.Test;


public class CalculatorTest extends Start {

    @Test
    public void calculator() {
        String[] textButtonForCalc = {"1", "×", "2", "−", "3", "+", "1"};
        mainPage.goTo()
                .fillTextSearch("Калькулятор")
                .clickSearchButton();

        for (String buttonText : textButtonForCalc) {
            resultOfSearchPage.clickButtonOfCalc(buttonText);
        }

        resultOfSearchPage.checkMemoryLineOfCalc("1 × 2 - 3 + 1")
                .checkResultLineOfCalc("Ans = 0")
                .close();
    }
}
