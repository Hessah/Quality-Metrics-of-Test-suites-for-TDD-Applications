package samples.pages;

import wheel.testing.WheelTestCase;

public class NumberGuessingTest extends WheelTestCase {
    public void testHeadline() {
        setComponent(new NumberGuessing());
        render();
        assertXpath("Guess a number from 0 to 100", "//p[1]");
    }

    public void testNumberInput() {
        setComponent(new NumberGuessing());
        render();
        assertXpath("guess", "//input[@type='text']/@name");
    }

    public void testSubmitButton() {
        setComponent(new NumberGuessing());
        render();
        assertXpath("Guess", "//input[@type='submit']/@value");
    }

    public void testCorrectGuess() {
        NumberGuessing ng = new NumberGuessing();
        ng.setCorrectNumber(55);
        setComponent(ng);
        createForm("numberGuessForm");
        addFormField("guess", "55");
        submitForm();
        render();
        assertXpath("Yes, the answer was 55.", "//p[1]");
        assertXpath("You guessed it in 1 tries.", "//p[2]");
        assertXpath("start again", "//a[1]");
    }

    public void testInvalidInput() {
        setComponent(new NumberGuessing());
        createForm("numberGuessForm");
        addFormField("guess", "-55");
        submitForm();
        render();
        assertXpath("The guess is invalid.", "//p[2]");
    }

    public void testReset() {
        NumberGuessing ng = new NumberGuessing();
        ng.reset();
        assertEquals(-1, ng.getCorrectNumber());
    }

    public void testTooSmallInput() {
        NumberGuessing ng = new NumberGuessing();
        ng.setCorrectNumber(55);
        setComponent(ng);
        createForm("numberGuessForm");
        addFormField("guess", "54");
        submitForm();
        render();
        assertXpath("The answer is higher.", "//p[2]/i");

    }

    public void testTooLargeInput() {
        NumberGuessing ng = new NumberGuessing();
        ng.setCorrectNumber(55);
        setComponent(ng);
        createForm("numberGuessForm");
        addFormField("guess", "56");
        submitForm();
        render();
        assertXpath("The answer is lower.", "//p[2]/i");

    }

}
