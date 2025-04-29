/**
 * Multiple choice question class
*/
import java.util.*;
import java.io.*;
public class MultipleChoiceQuestion extends Question
{
    private ArrayList<String> options;

    /**
     * Constructor for MultipleChoiceQuestion
     * @param questionText The text of the question
     * @param correctAnswer The correct answer (as a string)
     * @param options The list of options for the question
     */
    public MultipleChoiceQuestion(String questionText, String correctAnswer, ArrayList<String> options)
    {
        super(questionText, correctAnswer);
        this.options = options;
    }
    /**
     * Displays the question to the user
     */
    public void display()
    {
        System.out.println(questionText + " (Enter the number of your selected answer)");
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

  public int getScore(String answer)
{
    try {
        int selectedIndex = Integer.parseInt(answer.trim());

        if (selectedIndex >= 1 && selectedIndex <= options.size()) {
            try {
                int correctIndex = Integer.parseInt(correctAnswer.trim());
                return (selectedIndex == correctIndex) ? 1 : 0;
            } catch (NumberFormatException e) {
                String selectedOption = options.get(selectedIndex - 1);
                return selectedOption.equalsIgnoreCase(correctAnswer) ? 1 : 0;
            }
        }
    } catch (NumberFormatException e) {
    }
    return 0;
}
}
