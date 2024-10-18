import java.util.*;

class NumberGame
{   
    /*** FEILDS ***/
    Scanner scanObj;
    Random randomObj;
    int randomInput;
    int userInput;
    int numberOfAttempts;

  
    /*** MAIN INTERFACE ***/
    void getGameInterface()
    {
        /**** TO CLEAR SCREEN ****/
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} 
        catch (Exception e) { e.printStackTrace();}

        System.out.println("\n\n======================================  WELCOME TO NUMBER GUESSING GAME  =====================================\n\n");
        scanObj=new Scanner(System.in);
        
        randomObj= new Random();
        randomInput=randomObj.nextInt(100)+1;
        numberOfAttempts=10;
    } 

    /*** LOGIC INTERFACE ***/
    boolean getNumberGameLogic()
    {
    
        while(numberOfAttempts>0 )
        {   System.out.println("\n                                         Total Number Of Attemps :  " +numberOfAttempts);
            System.out.print("                                      Enter your Guess Between 1 to 100: ");
            int userInput=scanObj.nextInt();
            
            numberOfAttempts--;
            
            if(userInput>randomInput)    System.out.println("\n                                              ' Your Guess Is High '\n");
            if(userInput<randomInput)    System.out.println("\n                                              ' Your Guess Is Low '\n");
            if(userInput==randomInput) { System.out.println("\n                                        ' Correct! You guessed the number '\n\n"); return true; }
            System.out.println("________________________________________________________________________________________________________________");
        }
           
        
        if(numberOfAttempts==0) System.out.println("\n                                        ' YOU HAVE LOST! THE NUMBER WAS "  +randomInput +" '"+"\n\n");
        return false;
    }

}


public class NumberGameMain
{
    /*** MAIN METHOD ***/
    public static void main(String[] args) 
    {  
        /*** OBJECTS ***/
        Scanner scanObj = new Scanner(System.in);
        NumberGame gameObj = new NumberGame();

        /*** VARIABLES ***/
        boolean returnedVal;
        String playAgain;
        
        /*** LOOP FOR GAME***/
        do {        
            /**** TO CLEAR SCREEN ****/
            try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} 
            catch (Exception e) { e.printStackTrace(); }
            
            /* METHOD CALLINGS */
            gameObj.getGameInterface();
            returnedVal = gameObj.getNumberGameLogic();

            /* RETURNED VALUE CASES */
            if (returnedVal) { System.out.print("\n                                       Do You Want To Play Again? (Yes/No): "); } 
            else {             System.out.print("\n                                       Do You Want To Try Again? (Yes/No): ");  }
            playAgain = scanObj.nextLine();

        } while (playAgain.equalsIgnoreCase("yes"));
       
        System.out.println("\n                                         Thank You For Playing! Goodbye! \n\n");
    }
}