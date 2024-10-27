/**
 * Program Name: Score Classifier
 * Author:       Grace Dong
 * Date:         Oct 25, 2024
 * Course:       CPSC1150
 * Compiler:     JDK 22.0.2
 */

/**
 * This program classifies a series of scores entered by the users into ranges. The scores will be numbers between 0 and 100.
 */
import java.util.Scanner;
public class ClassifyScores{
    /**
     * If the score is within the range, count the range of it. If it is greater than 100, display error message. If it is less than 0, display result and terminate the program.
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int[] rangeGroup = new int[10];
        int score;

        //Create a while loop, end it when user enters value less than 0
        while(true){
            
            System.out.print("Please enter the score: ");
            score = scan.nextInt();

            //If score is greater than 100, print error message
            if(score > 100){
                System.out.println("Invalid input.");
            }

            //If score is within range, invoke method scoreClassify() 
            else if(score >= 0 && score <= 100){
                scoreClassify(rangeGroup, score);    
            }
            
            //If score is negative, invoke method printResult() and terminate
            else{
                printResult(rangeGroup);
                System.out.println("End of program.");
                break;
            }
        }
    }

    //This method receives the reference of array, and the score integer, classify the score accordingly
    public static void scoreClassify(int[] array, int score){

        //Add score 100 to the last category
        if(score == 100){
            array[array.length-1]++;
        //Decide the category and increment it
        }else{
            int index = score / 10; 
            array[index]++;
        }
    }

    //This method prints the ranges and number of scores in each range
    public static void printResult(int[] array){

        //Print result header
        System.out.println("Range " + " Number of scores");

        //Use for loop to display row 0 to row 8
        for(int i = 0; i < array.length-1; i++){
            System.out.println((i * 10) + "-" + (i * 10 + 9) + "\t\t" + array[i]); 
        }

        //Hardcode last row which is "90-100"
        System.out.println("90-100" + "\t\t" + array[array.length-1]);
    }
}