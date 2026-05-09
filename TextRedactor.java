/*
 * Name: Angel Vazquez
 * Date: 05/08/26
 * Purpose: Name redactor for pasted text

*/


import java.util.Scanner;

public class TextRedactor 
{
    public static void main(String[] args) 
    {
        // activating text input 
        Scanner input = new Scanner(System.in); 

        // prompting user to input/paste text body
        System.out.println("Enter the text to be processed:");

        String text = input.nextLine();

        // check to make sure the program starts/keeps going
        boolean continueRunning = true;  

        while (continueRunning) 
            {
            // prompting user to input
            System.out.print("\nEnter name to find (Case sensitive): ");  
            String target = input.nextLine();

            // loop used to count how many times name entered is found when reading each value of text
            int count = 0;
            int searchIndex = text.indexOf(target);
            while (searchIndex != -1) {
                count++;
                searchIndex = text.indexOf(target, searchIndex + target.length());
            }

            // outputting how many times requested name found
            System.out.println("\nFound '" + target + "' " + count + " time(s).");

            if (count > 0) 
                {
                // prompting user to input text replacement
                System.out.print("\nEnter replacement: ");
                String replacement = input.nextLine();

                // while loop to make sure name found is not missed due to being part of a missed space in text
                int foundIndex = text.indexOf(target);
                while (foundIndex != -1) {
                    // reading each word from the start to first letter
                    String prefix = text.substring(0, foundIndex);
                    
                    // everything after word is found
                    String suffix = text.substring(foundIndex + target.length());
                    
                    // final word with replacement
                    text = prefix + replacement + suffix;

                    // double checking to make sure there isnt a missed part
                    foundIndex = text.indexOf(target, foundIndex + replacement.length());
                }
                
                // outputting the final name
                System.out.println("\nUpdated Text: " + text);
            }

            // prompting user if another name is needed and if not stopping program
            System.out.print("\nScan another name? (yes/no): ");
            if (input.nextLine().equalsIgnoreCase("no")) {
                continueRunning = false;
            }
        }
        System.out.println("End of Redacting");

        input.close();
    }
}