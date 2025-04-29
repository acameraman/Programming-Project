/**
  * True/False question class
 */
public class TrueFalseQuestion extends Question
{
    /**
     * Constructor for TrueFalseQuestion
     * @param questionText The text of the question
     * @param correctAnswer The correct answer (True/False)
     */
    public TrueFalseQuestion(String questionText, String correctAnswer)
    {
        super(questionText, correctAnswer);
    }
    /**
     * Displays the question to the user
     */
  @Override
    public void display()
    {
        System.out.println(questionText + " (True/False)");
    }
    /**
     * Returns the score based on the user's answer
     * @param answer The user's answer
     * @return 1 if correct, 0 if incorrect
     */
 @Override
    public int getScore(String answer)
    {
        return answer.equalsIgnoreCase(correctAnswer) ? 1 : 0;
    }
}
