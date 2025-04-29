/**
  * Quiz class to manage questions and scoring
 */
import java.util.*;
import java.io.*;
public class Quiz
{
    private ArrayList<Question> questions = new ArrayList<>();
    private int score = 0;

    /**
     * Adds a question to the quiz
     * @param q The question to add
     */
    public void addQuestion(Question q)
    {
        questions.add(q);
    }

    /**
     * Starts the quiz
     */
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

    /**
     * Saves the score to a file
     */
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
