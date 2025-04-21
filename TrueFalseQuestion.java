/**
 * True/False question class
 * @param
 * @return
*/
public class TrueFalseQuestion extends Question
{
    public TrueFalseQuestion(String questionText, String correctAnswer)
    {
        super(questionText, correctAnswer);
    }

    @Override
    public void display()
    {
        System.out.println(questionText + " (True/False)");
    }

    @Override
    public int getScore(String answer)
    {
        return answer.equalsIgnoreCase(correctAnswer) ? 1 : 0;
    }
}