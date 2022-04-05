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
            calculatePage.clickButtonOfCalc(buttonText);
        }

        calculatePage.checkMemoryLine("1 × 2 - 3 + 1")
                .checkResultLine("Ans = 0")
                .close();
    }
}
