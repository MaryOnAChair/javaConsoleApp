/*
          ********************************************************************************************************************    
     ********        This class is contains methods that hold values and is meant to act as a virtual register.             ********
************        This class stores and sets/gets values for its current,start and end amount of cash                      ************
     ********        - tax rate,employee ID and the number of orders taken with the instance of the class.                  *********                                     
         *********************************************************************************************************************    
 */
package finalprojectbankingapp;
import java.util.Scanner;   //import for input

public class cashRegister {

    //  Fields    //
    private int employeeID,numOfOrders;
    private double startValue,taxRate,endValue,currentValue;
    
    
    Scanner sc = new Scanner(System.in);    //For user input

   //   Constructors    //
    public cashRegister(){
        taxRate = 0.085;
        startValue = 75;
        currentValue = startValue;
        endValue = currentValue;
        numOfOrders = 0;
        employeeID = 0;
    }   //Initializes everything to 0 if nothing
    public cashRegister(double enteredStartValue,int enteredID){
        startValue = enteredStartValue;
        employeeID = enteredID;
    }
    
         //  Mutators & Accessors   //
    public void setUpRegister(){
        //local variables for checking
        String yesOrNo;
        String check;
        
        do{ //Runs atleast once
            System.out.println("    Enter User ID Number: \n");
            while (!sc.hasNextInt()) 
            {   sc.next(); 
                System.out.println("Enter valid integer value ): ");
            }
            
            employeeID = sc.nextInt();                //Gets user ID from user and sets it
            
            System.out.println("\n  Start amount is 75.00$ Do You Want To Change It? y/n \n");  //Alter default start amount of cash in drawer?
            yesOrNo = sc.next();
            if("y".equals(yesOrNo) || "Y".equals(yesOrNo))    //Alters the default start amount with user input
            {
                System.out.println("    Enter correct start amount: \n");
                while (!sc.hasNextDouble())     //Checks entered value type
            {        sc.next(); 
                     System.out.println("Enter valid number value ): ");
            }
            
                startValue = sc.nextDouble();
            } 
            
            System.out.println("\n  Change tax rate? ( CURRENT TAX RATE: " + (taxRate*100) + "% ) y/n \n");   //Alter the defualt tax amount?
            yesOrNo = sc.next();
            if("y".equals(yesOrNo) || "Y".equals(yesOrNo))                  //Alters the defautlt tax amount with user input
                    {
                System.out.println("\n  Enter new tax rate: (format as 8.50%) ");
                while (!sc.hasNextDouble())     //Checks entered value type
            {        sc.next(); 
                     System.out.println("Enter valid number value ): ");
            }
            
                taxRate = ((sc.nextDouble())/100);
                    }
            
            //  Prints a review of options selected by user for review  //
            System.out.println("\n      User ID:      " + employeeID + 
                               "\n      Start Amount: " + String.format("%.2f", startValue) +
                               "\n      Tax Rate:     " + String.format("%.2f",(taxRate*100))+ " %" +
                               "\n\n       Is this correct? y/n");
            check = sc.next();  
                
            
        }while(!("y".equals(check) || "Y".equals(check)));  //User confirmation
        System.out.println("\n-----------------------------------------------------------");
    }       //Gets user input to set up fields 

    //  Used to Set //
    public void setStartValue(double enteredValue){
        startValue = enteredValue;
    }   //Start value of cash 

    public void setTaxRate(double enteredTaxRate){
        taxRate = enteredTaxRate;
    }   //Current Tax Rate
    
    public void setEmployeeID(int enteredID){
        employeeID = enteredID; 
    }       //Employee ID 

    public double setCurrentValue(double value){
        currentValue = currentValue + value;
        numOfOrders = numOfOrders + 1;
        return currentValue;
    }   //The current amount of cash 

    
    // Used to Get  //
    public double getTaxRate(){
        return taxRate;
    }       //Tax Rate
    
    public double getStartValue(){
        return startValue;
    }    //Start value of cash
    
    public double getCurrentValue(){
        return currentValue;
    }   //Current value of cash
       
    public double getEndValue(){
        endValue = currentValue;
        return endValue;
    }       //End value of cash
    
    
    public int getEmployeeID(){
        return employeeID;
    }       //Employee ID 

    public int getNumberOfOrders(){
        return numOfOrders;
    }   //Number of transactions made 
    
    //  Checks to see if user would like to continue making transactions    //
    public String checkIfMoreTransactions(){
        System.out.println("\n  Would you like to process another transaction? y/n \n");
        return sc.next();
    }   
    
}
    
    
    
    