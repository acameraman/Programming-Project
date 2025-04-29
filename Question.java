/**
  * Base class for a question
 */
abstract class Question implements Scorable, Displayable
{
    protected String questionText;
    protected String correctAnswer;

    /**
     * Constructor for Question
     * @param questionText The text of the question
     * @param correctAnswer The correct answer
     */
    public Question(String questionText, String correctAnswer)
    {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}
