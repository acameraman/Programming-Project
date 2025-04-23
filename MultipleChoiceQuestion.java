/**
 * Multiple choice question class
 * @param
 * @return
*/
import java.util.*;
import java.io.*;
public class MultipleChoiceQuestion extends Question
{
    private ArrayList<String> options;

    public MultipleChoiceQuestion(String questionText, String correctAnswer, ArrayList<String> options)
    {
        super(questionText, correctAnswer);
        this.options = options;
    }

    @Override
    public void display()
    {
        System.out.println(questionText + " (Enter the number of your selected answer)");
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    @Override
    public int getScore(String answer)
    {
        try {
            int selectedIndex = Integer.parseInt(answer.trim());
            if(selectedIndex >= 1 && selectedIndex <= options.size()){
                String selectedOption = option.get(selectedIndex - 1);
                return selectedOption.equalsIgnoreCase(correctAnswer)? 1 : 0;}
        }
        catch (NumberFormatException e) { 
        } return 0;
    }
}
