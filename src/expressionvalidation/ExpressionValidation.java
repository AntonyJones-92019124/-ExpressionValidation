/*
 * Program should ask the user to enter an expression 
 * to validate and the type of bracket characters to match
 * then print out correct or incorrect message to user.
 *
 */

package expressionvalidation;

//imports.
import java.util.Scanner;
import java.util.Stack;

/**
 * @Date 23/6/2019.
 * @author Antony Jones.
 */

public class ExpressionValidation {
    
    
    //Create scanner.
    private static Scanner scannerIn 
    = new Scanner(System.in);
    //set to String type.
    private static String usersInput;

    
    /**
     * @param args the command line arguments.
     */
    
    public static void main(String[] args) {
         
        
        //Print out message to user.
        
        System.out.println ("Enter your expression: \n");

        //Set variable usersInput to nextline.      //Expression.
        
        usersInput = scannerIn.nextLine();
        
    
        /*If usersInput in method 
        charactersToMatch is true.*/
        
        if (charactersDoMatch()) {
            System.out.println
            ("Expression is validated as Correct.");
	} 
        
        /*If usersInput in method 
        charactersToMatch is false.*/
        
        else {
            System.out.println
            ("Expression is validated Incorrect.");
        }
           
    }// End of main method.
        
    
    /* Method to accept user input of the expression
    to validate and a pair of characters.*/
    
    public static boolean charactersDoMatch() {
          
        
        System.out.println
            ("Enter the opening character "
                    + "to validate: \n");
        
        //Set variable inputOpening to nextline.    //Opening Character.
        
        Scanner reader = new Scanner(System.in);
        char inputOpening = reader.next().charAt(0);
        
        System.out.println
            ("Enter the closing character "
                    + "to validate: \n");
        
        
        //Set variable inputClosing to nextline.     //Closing Character.
        
        char inputClosing = reader.next().charAt(0);
        
        //Set boolean validate to false.
        
        boolean validate = false;  
        
        //Stack set to validationList.
        
        Stack<Character> validationList = new Stack();
       
        //Increment through the userInput expression.
        
	for (int c = 0; c < usersInput.length(); c++) {
            
            /* If current charAt in the expression is a 
            opening brace, is equal to inputOpening and
            inputClosing push it to the stack.*/
            
            if (usersInput.charAt(c) == '(' 
                    && inputOpening == '('
                    && inputClosing == ')'|| 
                usersInput.charAt(c) == '{' 
                    && inputOpening == '{'
                    && inputClosing == '}'|| 
                usersInput.charAt(c) == '[' 
                    && inputOpening == '['
                    && inputClosing == ']'|| 
                usersInput.charAt(c) == '<'
                    && inputOpening == '<'
                    && inputClosing == '>')
                
                //Push to satck validationList.
                
            {
                validationList.push(usersInput.charAt(c));
	    }
            
            // If current charAt in expression is a closing brace.
            
            else if(usersInput.charAt(c) == ')' ||
                    usersInput.charAt(c) == '}' || 
                    usersInput.charAt(c) == ']' || 
                    usersInput.charAt(c) == '>')
                     
            {
                
            /* Return false if mismatch is found.
               Or stack validationList is empty.*/
            
                
            if (!validationList.empty()) {
            } 
            
            else 
                
            {
                return validate;
            }
            
            // Pop char from the stack.
            
            Character firstOfffList = validationList.pop();

            /* if the popped character if not an opening 
            brace or does not pair with current character 
            of the expression return false.*/
            
            if ((firstOfffList == '(' 
               && usersInput.charAt(c) != ')') 
               || (firstOfffList == '{' 
               && usersInput.charAt(c) != '}')
               || (firstOfffList == '[' 
               && usersInput.charAt(c) != ']') 
               ||(firstOfffList == '<' 
               && usersInput.charAt(c) != '>')) 
            
                {
                    return validate;//return false.
		}
	    }
            
	}//End of for loop.

            /* Expression balanced only 
            if stack is empty below.*/
            
            return validationList.empty();
                
    }//End of charactersDoMatch Mmethod.
    
}//End of ExpressionValidation class.