public class TrueFalseQuestion extends Question
{
    public TrueFalseQuestion(String questionText, String correctAnswer)
    {
        super(questionText, correctAnswer);
    }

    public void display()
    {
        System.out.println(questionText + " (True/False)");
    }

    public int getScore(String answer)
    {
        return answer.equalsIgnoreCase(correctAnswer) ? 1 : 0;
    }
}
