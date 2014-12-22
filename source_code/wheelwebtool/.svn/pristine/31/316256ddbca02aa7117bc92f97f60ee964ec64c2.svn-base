package samples.components;

import wheel.components.StandaloneComponent;
import wheel.components.Form;
import wheel.annotations.Persist;
import wheel.annotations.ActionMethod;
import wheel.persistence.Scope;

import java.util.Random;

public class NumberGuessingComponent extends StandaloneComponent {
    @Persist(Scope.component)
    private int correctNumber = -1;
    @Persist(Scope.component)
    private int guess;
    @Persist(Scope.component)
    private int tries = 1;

    public NumberGuessingComponent(String componentId) {
        super(componentId);
        config().setReusable(true);
    }

    public void preBuild() {
        if (correctNumber == -1)
            correctNumber = (new Random()).nextInt(100);

        config().useAsset("NumberGuessingComponent.css");
        config().initialFieldValue("guess", "give a number");
    }

    public void buildComponent() {
        if (guess == correctNumber) {
            p("Yes, the answer was " + guess + ".");
            p("You guessed it in " + tries + " tries.");
            a("start again").actionBinding("this.reset");
        }
        else {
            p("Guess a number from 0 to 100");

            if (!isValid("guess"))
                p("The guess is invalid.");

            if (isRewinding()) {
                tries++;

                if (guess < correctNumber)
                    p().i("The answer is higher.");
                else
                    p().i("The answer is lower.");

            }

            Form form = create().form("numberGuessForm", action("this.onSubmit"));
            form.textInput("guess").fieldBinding("guess").validationRule("isInt(value) && value >= 0 && value <= 100");
            form.br();
            form.submit("numberGuessSubmit").value("Guess");
            add(form);
        }

        br();
        a("Back").actionBinding("Home");
    }

    @ActionMethod
    public void onSubmit() {

    }

    @ActionMethod
    public void reset() {
        correctNumber = -1;
        tries = 1;
        guess = 0;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public void setCorrectNumber(int correctNumber) {
        this.correctNumber = correctNumber;
    }

}
