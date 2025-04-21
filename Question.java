/**
 * Base class for a question
 * @param
 * @return
*/
abstract class Question implements Scorable, Displayable
{
    protected String questionText;
    protected String correctAnswer;

    public Question(String questionText, String correctAnswer)
    {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}