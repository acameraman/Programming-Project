/**
 * A quiz application that covers a variety of topics through multiple choice and true/false questions.
 * @author Alex Camera
 * @version Spring 2025
*/
import java.util.*;
import java.io.*;
public class QuizApplication
{
	public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);
		Quiz quiz = new Quiz();
        
        String topic = "";
        while (true)
        {
            System.out.println("What topic of questions would you like? (Enter 'food', 'geography', or 'animal') ");
            topic = in.next();
        
            try
            {
                if (topic.equalsIgnoreCase("food"))
                {
                    quiz.addQuestion(new MultipleChoiceQuestion("What is the common name for dried plums?", "3",
                        new ArrayList<>(Arrays.asList("Raisins", "Apricots", "Prunes", "Figs"))));
                    quiz.addQuestion(new TrueFalseQuestion("Welsh rarebit contains rabbit.", "False"));
                    quiz.addQuestion(new MultipleChoiceQuestion("What is a baker's dozen.", "4",
                        new ArrayList<>(Arrays.asList("12 items", "15 items", "10 items", "13 items"))));
                    quiz.addQuestion(new TrueFalseQuestion("Apples and pears are a part of the rose family.", "True"));
                    quiz.addQuestion(new MultipleChoiceQuestion("Which of the following puddings is not sweet?", "1",
                        new ArrayList<>(Arrays.asList("Yorkshire pudding", "Christmas pudding", "Sticky toffee pudding", "Bread and butter pudding"))));
                    break;
                }
                else if (topic.equalsIgnoreCase("geography"))
                {
                    quiz.addQuestion(new TrueFalseQuestion("Mexico is south of the equator.", "False"));
                    quiz.addQuestion(new MultipleChoiceQuestion("What is the smallest country in the world?", "3",
                        new ArrayList<>(Arrays.asList("Andorra", "Luxembourg", "Vatican City", "Belgium"))));
                    quiz.addQuestion(new TrueFalseQuestion("The longest above-water mountain range in the world is the Andes.", "True"));
                    quiz.addQuestion(new MultipleChoiceQuestion("What is the capital of Italy?", "3",
                        new ArrayList<>(Arrays.asList("Venice", "Florence", "Rome", "Naples"))));
                    quiz.addQuestion(new TrueFalseQuestion("The largest lake in the world is Lake Superior.", "False"));
                    break;
                }
                else if (topic.equalsIgnoreCase("animal"))
                {
                    quiz.addQuestion(new TrueFalseQuestion("Whales are not fish.", "True"));
                    quiz.addQuestion(new MultipleChoiceQuestion("Which of the following is the largest rodent?", "1",
                        new ArrayList<>(Arrays.asList("Capybara", "Red squirrel", "Porcupine", "Marmot"))));
                    quiz.addQuestion(new TrueFalseQuestion("Camels store water in their humps.", "False"));
                    quiz.addQuestion(new MultipleChoiceQuestion("Why do many frogs and toads blow up their chin skin like a balloon?", "2",
                        new ArrayList<>(Arrays.asList("To cool down", "To make their calls louder", "To frighten adversaries", "To help breathe out of water"))));
                    quiz.addQuestion(new TrueFalseQuestion("Buffalo and bison are different animals.", "True"));
                    break;
                }
                else
                {
                    throw new IllegalArgumentException("Invalid topic. Please choose from 'food', 'geography', or 'animal'.");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }

		quiz.start();
	}
}