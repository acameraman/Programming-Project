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
        
        System.out.println("Do you want to enter your own questions or use ours? (Enter 'mine' or 'ours')");
        String questionOwner = in.next();
        if (questionOwner.equalsIgnoreCase("mine"))
        {
            boolean valid = false;
        
            int numQuestions = 0;
            while (!valid) {
                System.out.println("How many questions would you like to enter?");
                String input = in.nextLine();
                try {
                    numQuestions = Integer.parseInt(input);
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid number.");
                }
            }
    
            for (int i = 0; i < numQuestions; i++) {
                System.out.println("\nEnter question " + (i + 1) + ":");
    
                System.out.println("Is this a True/False question? (yes/no):");
                String isTrueFalse = in.nextLine().trim().toLowerCase();
                while (!isTrueFalse.equals("yes") && !isTrueFalse.equals("no")) {
                    System.out.println("Please answer 'yes' or 'no'.");
                    isTrueFalse = in.nextLine().trim().toLowerCase();
                }
    
                System.out.print("Enter the question text: ");
                String questionText = in.nextLine();
    
                if (isTrueFalse.equals("yes")) {
                    System.out.print("Enter the correct answer (True/False): ");
                    String correctAnswer = in.nextLine().trim();
    
                    while (!correctAnswer.equalsIgnoreCase("true") && !correctAnswer.equalsIgnoreCase("false")) {
                        System.out.println("Please enter 'True' or 'False' for the answer: ");
                        correctAnswer = in.nextLine().trim();
                    }
    
                    quiz.addQuestion(new TrueFalseQuestion(questionText, correctAnswer));
                } else {
                    ArrayList<String> options = new ArrayList<>();
                    int numOptions = 0;
                    while (true) {
                        System.out.print("Enter the number of options: ");
                        try {
                            numOptions = Integer.parseInt(in.nextLine().trim());
                            if (numOptions < 2) {
                                System.out.println("Please enter at least 2 options.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }
    
                    for (int j = 0; j < numOptions; j++) {
                        System.out.print("Option " + (j + 1) + ": ");
                        options.add(in.nextLine());
                    }
    
                    int correctAnswerIndex = -1;
                    while (true) {
                        System.out.print("Enter the correct answer (as written in one of the options): ");
                        String correctAnswer = in.nextLine();
                        try {
                            correctAnswerIndex = Integer.parseInt(correctAnswer);
                            if (correctAnswerIndex >= 1 && correctAnswerIndex <= options.size()) {
                                break;
                            } else {
                                System.out.println("Please enter a number between 1 and " + options.size());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
    
                    String correctAnswer = options.get(correctAnswerIndex - 1);
                    quiz.addQuestion(new MultipleChoiceQuestion(questionText, correctAnswer, options));
                }
            }
        }
        else if (questionOwner.equalsIgnoreCase("ours"))
        {
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
        }

		quiz.start();
	}
}