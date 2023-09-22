/**********************************************************************************
***  This class is used to print receipts and records of employee transactions. ***
***  This class creates and prints to files and prints the same to the terminal  ***
 ***********************************************************************************
 */
package finalprojectbankingapp;

//  Libraries   //
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintReceipt {
    //  Fields  //
    static int orderNumber;
    static int tillNumber;
    
    //  For Printing and Creating Files //
    public void printNew(int employeeNum,double summary[]) throws FileNotFoundException{
        orderNumber = orderNumber + 1;
        
            PrintWriter fileMade = new PrintWriter("order_" + orderNumber + ".txt");    //creates new file increasing by order number

            fileMade.print(
            "\n---------------------------------------------------\n" +
            "   Employee ID: " + employeeNum + " Order Number: " + orderNumber + "\n" +
            "   Subtotal:    " + String.format("%.2f",summary[0]) + " $ \n"  +
            "   Tax Rate:    " + String.format("%.2f",summary[1] * 100) + " % \n" +
            "   Tax Amount:  " + String.format("%.2f",summary[2]) + " $ \n" +
            "   Total:       "    + String.format("%.2f",summary[3]) + " $ \n" +
            "   Amount Paid: " + String.format("%.2f",summary[4]) + " $ \n" +
            "   Change Due:  " + String.format("%.2f",summary[5]) + " $ \n" +
            "---------------------------------------------------");
            fileMade.close();

                    System.out.println(                                             //Prints out to screen
            "\n---------------------------------------------------\n" +
            "   Employee ID: " + employeeNum + " Order Number: " + orderNumber + "\n" +
            "   Subtotal:    " +String.format("%.2f", summary[0]) + " $ \n"  +
            "   Tax Rate:    " + String.format("%.2f",summary[1] * 100 )+ " % \n" +
            "   Tax Amount:  " + String.format("%.2f",summary[2]) + " $ \n" +
            "   Total:       "    + String.format("%.2f",summary[3]) + " $ \n" +
            "   Amount Paid: " + String.format("%.2f",summary[4])+ " $ \n" +
            "   Change Due:  " + String.format("%.2f",summary[5])+ " $ \n" +
            "---------------------------------------------------");
    }   //Prints receipt per transaction to file & screen
    
    public void printTillHistory(int employeeNum,double startValue,double endValue,int numOrders) throws FileNotFoundException{
            tillNumber = tillNumber + 1;
            PrintWriter fileMade = new PrintWriter("Employee" + employeeNum  + "0" + tillNumber + ".txt");  //Creates file based on employee number and number of times theyve opened a register

            
            fileMade.print(                                                      //Prints to file    
            "\n---------------------------------------------------\n" +
            "       Employee Number:    " + employeeNum + "        \n" +
            "---------------------------------------------------\n" +
            "\t     Start Value of Till: " + String.format("%.2f",startValue)+ "$ \n" +
            "\t     End Value of Till:   " + String.format("%.2f",endValue) + "$ \n" +
            "\t     Transactions Completed: " + numOrders + "\n" +
            "\n---------------------------------------------------\n");
            fileMade.close();
            
            System.out.println(                                                  //Prints to screen
            "\n---------------------------------------------------\n" +
            "       Employee Number:    " + employeeNum + "        \n" +
            "---------------------------------------------------\n" +
            "\t     Start Value of Till: " + String.format("%.2f",startValue)+ "$ \n" +
            "\t     End Value of Till:   " + String.format("%.2f",endValue) + "$ \n" +
            "\t     Transactions Completed: " + numOrders + "\n" +
            "\n---------------------------------------------------\n");
        
            
    }   //Prints summary record at register close, file & screen
 
    
}
