import java.util.*;

//***********************************************  ATM INTERFACE   *****************************************************//

class AtmInterface
{   
    /***** FEILDS ******/
    long accountNumberInput;
    int pinInput;
    Scanner scanObj;
    

    //******************************* ACCOUNT NUMBER READER ******************************//
    long getAccountNumber()
    {   
        /**** TO CLEAR SCREEN ****/
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} 
        catch (Exception e) { e.printStackTrace();}

        /**** TO INPUT ****/
        scanObj=new Scanner(System.in);
        System.out.print("\n****************************************** ENTER YOUR DEATILS ******************************************\n" +"\n                                     ACCOUNT NUMBER :  ");
        long accountNumberInput=scanObj.nextInt();
        return accountNumberInput;
    }

    //******************************* PIN NUMBER READER **********************************//
    int getPin()
    {   
        /**** TO INPUT ****/
        System.out.print("                                     PIN NUMBER     :  "); 
        int pinInput=scanObj.nextInt();
        return pinInput;  
    }

    //*********************************** MAIN MENU **************************************//
    void mainMenu(UserAccount verifiedAccountRecivicer)
    {   
        /**** TO CLEAR SCREEN ****/
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} 
        catch (Exception e) { e.printStackTrace();}

        /**** BANK INTERFACE****/
        System.out.print("\n****************************************** WELCOME TO SBI BANK ******************************************\n");
                System.out.println("\n                                            LOGIN SUCCESSFUL!");

        boolean exit=false;
        while(exit==false)
        {       
            System.out.print("\n                                      1.CHECK BALANCE      2.WITHDRAW"
                            +"\n                                      3.DEPOSIT            4.EXIT\n\n"
                            +"                                      PLEASE SELECT AN OPTION: ");
            int inputForOption=scanObj.nextInt();
            switch (inputForOption) 
            {
                case 1:
                getBalance(verifiedAccountRecivicer);
                break;
                case 2:
                getWithdrawal(verifiedAccountRecivicer);
                break;

                case 3:
                getdeposit(verifiedAccountRecivicer);
                break;

                case 4:
                System.out.println("\n\n                                 Exiting.. Thank you for using SBI Bank! \n \n \n");
                exit = true;
                break;

                default:
                System.out.println("                                INVAILD OPTION PLEASE TRY AGAIN!");
                break;
            }    
            if (!exit) 
            {
                System.out.print("\n                                Press Enter to return to the main menu...\n\n");
                scanObj.nextLine();
                scanObj.nextLine();
            };
        }                                 
    }

    //******************************** TO GET BALANCE ************************************//
    void getBalance(UserAccount verifiedAccountRecivicer)
    {
        double balance=verifiedAccountRecivicer.balance;
        System.out.println("                                  YOUR CURRENT BALANCE IS:  " +balance);

    }

    //******************************** TO GET DEPOSIT ************************************//
    void getdeposit(UserAccount verifiedAccountRecivicer)
    {
        double balance=verifiedAccountRecivicer.balance;
        System.out.print("                                   ENTER AMOUNT TO DEPOSIT:  ");
        double inputForDeposit= scanObj.nextInt();
        double depositedBalance= balance+inputForDeposit;
        verifiedAccountRecivicer.balance = depositedBalance;
        System.out.println("                                        DEPOSIT SUCCESSFUL!");
        System.out.println("                                  YOUR CURRENT BALANCE IS:  " +depositedBalance);
    }

    //******************************** TO GET WITHDRAW ************************************//
    void getWithdrawal(UserAccount verifiedAccountRecivicer)
    {   
        double balance=verifiedAccountRecivicer.balance;
        System.out.print("                                   ENTER AMOUNT TO WITHDRAW:  ");
        double inputForWithdraw= scanObj.nextInt();
        double withdrawenBalance= balance-inputForWithdraw;
        verifiedAccountRecivicer.balance = withdrawenBalance;
        System.out.println("\n                                        WITHDRAW SUCCESSFUL!"
                            +"\n                                  YOUR CURRENT BALANCE IS:  " +withdrawenBalance);
    }
    

}


//**********************************************  ATM USERACCOUNT  *****************************************************//

class UserAccount
{
    /***** FEILDS ******/
    long    accountNumber;
    int     pin;
    double  balance;

    //*************************** TO RECIVIE DATA/ARGUMENT **********************************//
    UserAccount(long accountNumberRecivier, int pinRecivier, double balanceRecivier)
    {
        accountNumber=accountNumberRecivier;
        pin=pinRecivier;
        balance=balanceRecivier;
    }

    //***************************** TO RETURN VERIFIED USER *********************************//
    Boolean verify(long useraccNum,int userpinNum)
    {
        return (accountNumber==useraccNum && pin==userpinNum);
    }



}


//***********************************************  ATM MAIN CLASS  *****************************************************//

public class AtmMain
{
    //******************************* MAIN METHOD ***********************************//
    public static void main(String[] args) 
    {   
        /*** OBJECTS FOR USERACCOUNT ***/ 
        UserAccount person1= new UserAccount(111222333, 7898, 11225);
        UserAccount person2= new UserAccount(444555666, 8987, 12225);
        UserAccount person3= new UserAccount(777888999, 9878, 13225);

                /*** ARRAY ***/ 
                UserAccount[] customerData={person1,person2,person3};
        
        /*** OBJECTS FOR ATM INTERFACE ***/ 
        AtmInterface atmUI=new AtmInterface();
                long returnedAccNum=atmUI.getAccountNumber();
                int  returnedPinNum=atmUI.getPin();

        /*** LOOP FOR IDENTIFYING PERSON ***/ 
        boolean     found= false;
        UserAccount verifiedAccount=null;
        for(UserAccount persons :customerData )
        {
            if(found=persons.verify(returnedAccNum,returnedPinNum)) 
            {   
                found = true;  
                verifiedAccount=persons;
                break;
            }
        }
        if(found)   atmUI.mainMenu(verifiedAccount); 
        else        System.out.println( "\n\n                                              LOGIN FAILED."
                                        +"\n                                     Invalid account number or PIN.\n\n\n"); 
        
        
                                    


        
        
    }
}