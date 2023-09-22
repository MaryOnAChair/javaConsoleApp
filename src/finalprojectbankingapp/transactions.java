/*
          *******************************************************************************************************************************
     ********       This class is used for calculations and input of transactions from users                                           ********
************        This class stores, calculates and sets/gets price and cash given via user input.As well as checking user input.     ************
     ********        This class also compiles all results from a transaction into an array for easier management                       *********                                     
         ********************************************************************************************************************************    
 */
package finalprojectbankingapp;
import java.util.Scanner;


public class transactions {
    //  Fields  //
    private double subTotal,amountGiven,taxTotal,taxRate,total,change;
    private double transactionSummary [];
    Scanner sc = new Scanner(System.in);    //User Input
    
    //  Constructors    //
    public transactions(){
        amountGiven = 0;
        taxTotal = 0;
        taxRate = 0;
        subTotal = 0;
        total = (subTotal + (subTotal*taxRate));
        transactionSummary = new double[6];
    }    //Initializes fields with 0 if no values
    public transactions(double price,double given,double setTaxRate){
        subTotal = price;
        amountGiven = given;
        taxRate = setTaxRate;
    }   
 
    //  Modifiers & Accessors   //
//---------------------------------------------------------------------------------------------//
    //   Gets input from User    //
    public void inputPrice (){
        System.out.println("\n------------------------------------------------------------\n"
                           + "      Enter Price:  ");
        while (!sc.hasNextDouble())     //Checks entered value type
            {  
            sc.next(); 
            System.out.println("    Enter valid price value ): \n");
            }
        subTotal = sc.nextDouble();
    }
    
    public void inputAmountGiven(){
        System.out.println(  "      Enter Amount Given: ");
        while (!sc.hasNextDouble())     //Checks entered value type
            {  
            sc.next(); 
            System.out.println("    Enter valid amount value ): \n");
            }
            
        amountGiven = sc.nextDouble();   
    }
//---------------------------------------------------------------------------------------------//
    //  Sets    //
    public void setSubTotal(double price){
        subTotal = price;
    }
    
    public void setTaxRate(double taxEntered){
        taxRate = taxEntered;
    }
    
    public void setAmountGiven(double amount){
        amountGiven = amount;
    }
//---------------------------------------------------------------------------------------------// 
    //  Calculates  //
    public void calcTaxTotal(){
        taxTotal = subTotal*taxRate;
    }   //Total amount of tax
   
    public void calcTotal(){
        total = taxTotal + subTotal;
    }       //Total price (Subtotal + tax)
    
    public void calcChange(){
        change = amountGiven - total;
    }      //Amount of money owed back to user 
//---------------------------------------------------------------------------------------------//
    // Gets //
    public double[] getSummary(){
        
        return transactionSummary;
    }   //Array of results
    
    public double getTotal(){
        return total;
    }       //Total price (Subtotal + tax)
//---------------------------------------------------------------------------------------------//
    //  Verifies User Input //
    public int checkAmountGiven(){
        if(amountGiven < total){    
            return ( 6);
        } 
        else{return (0);      
    }
    }   //Checks if the user didn't pay/enter enough money
//---------------------------------------------------------------------------------------------//
    //  Summary //
    public void makeSummary(){
        transactionSummary[0] = subTotal;
        transactionSummary[1] = taxRate;
        transactionSummary[2] = taxTotal;
        transactionSummary[3] = total;
        transactionSummary[4] = amountGiven;
        transactionSummary[5] = change;

    }   //Adds all results of calculations to an array
    


     
            
}
