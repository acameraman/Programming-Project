import java.util.*;
import java.io.*;
public class Quiz
{
    private ArrayList<Question> questions = new ArrayList<>();
    private int score = 0;

    public void addQuestion(Question q)
    {
        questions.add(q);
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions)
        {
            q.display();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            score += q.getScore(answer);
        }
        System.out.println("Final Score: " + score + "/" + questions.size());
        saveScore();
    }

    private void saveScore()
    {
        try (PrintWriter out = new PrintWriter("quiz_results.txt"))
        {
            out.write("Score: " + score + "/" + questions.size() + "\n");
        }
        catch (IOException e)
        {
            System.out.println("Error saving results: " + e.getMessage());
        }
    }
}
