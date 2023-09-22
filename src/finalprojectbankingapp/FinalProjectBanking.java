/***************************************************************************************************************************************************************    
 ***********    This program uses 3 java classes: cashRegister,transactions and PrintReceipt in order to set up an instance of a virtual register.         ******
 ***********    The program is based off of the idea of the registers I used at my previous job, there is basic functions for setting up the tax rate       ********* 
 ***********    as well as the starting cash in the till. The program prints a receipt to a new file for every transaction,                            ***********
 ***********    as well as printing the order summary in the terminal. The program also prints a record of the transactions made by the logged in employee, *********
 ***********     when no more transactions are wanted. The record shows the starting and ending values of cash as well as the number of transactions.      *******
***************************************************************************************************************************************************************
*/
package finalprojectbankingapp;
//  Libraries   //
import java.io.FileNotFoundException;

public class FinalProjectBanking {

    /**
     * @param args the command line arguments
     * 
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String check; //Variable for checking if more transactions are wanted
        
        //  Creating objects from classes & initializes  //
        cashRegister tillA = new cashRegister();          //Creates virtual register object
        tillA.setUpRegister();                           //initialize register
        transactions newPurchase = new transactions();   //Creates instance for transactions & calculations
        newPurchase.setTaxRate(tillA.getTaxRate());      //Sets confirmed tax rate to transaction instance for calculations
        
        PrintReceipt record = new PrintReceipt();        //Creates instance for printing records to screen and files
        
        
        do{ // loops atleast once   //
            newPurchase.inputPrice();           //Gets price 
            newPurchase.inputAmountGiven();     //Gets amount the customer gives
            
            //Calculations before checking amount given//
            newPurchase.calcTaxTotal();         
            newPurchase.calcTotal();
            
            //Checks amount of money the customer provides vs total
            int x = newPurchase.checkAmountGiven();
                while(x > 0)                        //If the costomer gives less than the total of the purchase
            {
                System.out.println("Not enough money for purchase! " + newPurchase.getTotal()+ "$ is needed" );
                newPurchase.inputAmountGiven();         //Gets money from the customer again
                x = newPurchase.checkAmountGiven();     //checks again

            }
            //  Calculations after enough money is confirmed    //
            newPurchase.calcTaxTotal();
            newPurchase.calcTotal();
            newPurchase.calcChange();
            
            //  Creates receipts    //
            newPurchase.makeSummary();  //Adds all results to an array
            record.printNew(tillA.getEmployeeID(),newPurchase.getSummary());    //Prints to screen & File

            tillA.setCurrentValue(newPurchase.getTotal());  // adds transaction to current count of money
            
         //  Checks if user would like to process more transactions    //
         check = tillA.checkIfMoreTransactions();
        }while("y".equals(check) || "Y".equals(check) );
        
        //  No more transactions selected   //
        record.printTillHistory(tillA.getEmployeeID(),tillA.getStartValue() ,tillA.getEndValue(), tillA.getNumberOfOrders());   //Prints summary of employees transactions and cash amount in register
        
    }
    
}
