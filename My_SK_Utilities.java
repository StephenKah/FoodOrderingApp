/** 
* Program Name: My_SK_Utilities.java
* Purpose: Methods utilized in SK_Tasty_Bytes_Order.java
* Coder: Stephen Kah
* Date: Apr 11, 2018
*/

import java.util.*;


public class My_SK_Utilities
{
	// create scanner for any inputs in all methods
	static Scanner input = new Scanner(System.in);
	
/**
* Method Name: dinerSelection()
* Purpose: diner chooses item from any of the sub-menus
* Accepts: -a mealArray of type String to hold the selected items
* 					-runningTotal of type double to hold cost of selected items
* 					-foodPriceArray of type double to reference cost of selected items
* Returns: returns runningTotalof type double
 */
public static double dinerSelection(ArrayList<String> mealArray, double runningTotal,  String [] foodList, double [] foodPriceArray)
	{
		// boolean flag to stop do-while loop on selected situations
		boolean badSelectionFlag = true;
		
		do
		{
			// diner's input selection from given menu
			System.out.print("\nPlease enter your selection #: ");
  		int choice = input.nextInt();
  
  		// clear buffer
  		input.nextLine();
  		
  		// validates diner's choice to be included in given menu 
			if (1 < choice && choice <= foodList.length)
			{
				// choice is 1 less index position to match input selection with index selection
				String foodServed = foodList[choice - 1]; 
				// add the selection food item from menu and hold it in mealArray
				mealArray.add(foodServed);
				// choice, again, is 1 less index position 
				runningTotal = runningTotal + foodPriceArray[choice - 1];
				badSelectionFlag = false;
			}
			// if #1 is chosen; nothing is done 
			else if (choice == 1)
			{
				badSelectionFlag = false;
				break;
			}
			// if #0 is chosen; repeat until valid input
			else if (choice == 0)
			{
				System.out.printf("You've entered #%d as an option which is invalid. Please re-enter", choice);
				badSelectionFlag = true;
				continue;
			}
			// error message to handle any invalid input
			else
			{
				System.out.printf("You've entered #%d as an option which is invalid. Please re-enter", choice);
				badSelectionFlag = true;
				continue;
			}
		} while(badSelectionFlag);
		
		// return accumulated amount of cost in the order
		return runningTotal;
	} // end method

/**
* Method Name: sumBillingCosts()
* Purpose: to calculate the costs of all selected items
* Accepts: the array of prices of all selected items
* Returns: returns a variable sum of type double as the sum cost of all selected items
*/
public static double sumBillingCosts(double[] array)
	{
		double sum = 0;
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}//end loop
		return sum;		
	}//end method
	
/**
* Method Name: hstTax()
* Purpose: to calculated the HST tax in dollars
* Accepts: a variable of type double holding the total cost amount of selected items
* Returns: a variable type double with the HST Tax in dollars
*/
public static double hstTax(double totalBill)
	{
		double tax = 0.13;
		double sum = 0;
		
		sum = totalBill * tax;
	
		return sum;		
	}//end method


/**
* Method Name: tipDecision()
* Purpose: to handle the tip decision of the diner and execute accordingly 
* Accepts: -type String variable that holds the diner's response to tip
* 				 -type double variable that holds the diner's total before tax
* Returns: executes according to diner's selection
*/
public static void tipDecision(String tipAnswer, double totalBeforeTax)
	{
		double tax = 0.13;
		
		if (tipAnswer.trim().toLowerCase().equals("y"))
		{
			System.out.print("Enter the percentage tip as a whole number (ex. 15 for 15%): ");
			int tipAmount = input.nextInt();
			double tipDollAmount = (tipAmount * 0.01) * totalBeforeTax;
			double totalAfterTax = totalBeforeTax + (totalBeforeTax * tax);
			double totalAfterTaxTip = totalAfterTax + tipDollAmount;
			System.out.printf("\nThank you. With a %d%% tip of $%.2f, your total bill comes to $%.2f" , 
												tipAmount, tipDollAmount,  totalAfterTaxTip );
	
		}
		else if (tipAnswer.trim().toLowerCase().equals("n")) 
		{
			double totalAfterTax = totalBeforeTax + (totalBeforeTax * tax);
			System.out.printf("Thank you, you've selected 'NO TIP'. Your total including tax and no tip comes to $%.2f",
												 totalAfterTax);
		}
		else
		{
			double totalAfterTax = totalBeforeTax + (totalBeforeTax * tax);
			System.out.printf("You did not select (Y/N) valid tip input. Thank you, your total including tax and no "
												+ "tip comes to $%.2f", totalAfterTax);
	
		}
	} // end method


/**
* Method Name: billingDecision()
* Purpose: to execute pending on diner's decision to take one or separate bills
* Accepts: -accepts billingCode of type int to determine one or separate bills
* 					-accepts billingArray of type double of all costs of selected items
* 					-accepts dinerNamesArray to track each diner's order
* Returns: - returns nothing; but executes instructions based on diner's input
*/
public static void billingDecision(int billingCode, double [] billingArray, String [] dinerNamesArray)
	{
		if (billingCode == 1)
		{
			// sumBilingCosts method sums the cost of items (used to sum the costs of items on billingArray)
			// flip flag having validated the bill print-out decision
			double totalBeforeTax =  My_SK_Utilities.sumBillingCosts(billingArray);
			System.out.printf("\nThe total for your bill for your group comes to $%.2f before taxes." , totalBeforeTax);
			double taxedAmount = My_SK_Utilities.hstTax(totalBeforeTax);
			
			System.out.printf("\nHST (13%%) total is $%.2f" , taxedAmount);
			System.out.print("\n\nWould you like to leave a tip (Enter Y/N): ");
			String tipAnswer = input.next();

			// clear buffer
			input.nextLine();
			
			// String answer for diner tip;
			My_SK_Utilities.tipDecision(tipAnswer, totalBeforeTax);
			
		}
		// else if statement for diner's choice of separate bills
		else if (billingCode == 2)
		{
			// nested for loop for the separate diner bills
			for (int c = 0; c < dinerNamesArray.length; c++)
			{
				System.out.printf("\n\n%s, your total for your bill comes to $%.2f before taxes." , 
													dinerNamesArray[c], billingArray[c] );

				// declare and initialized variables for self-describing reasons
				double totalBeforeTax = billingArray[c];
				double taxedAmount = My_SK_Utilities.hstTax(totalBeforeTax);
				
				System.out.printf("\nHST (13%%) total is $%.2f" , taxedAmount);
				System.out.print("\nWould you like to leave a tip (Enter Y/N): ");
				String tipAnswer = input.next();

				// clear buffer
				input.nextLine();
				
				// String answer for diner tip;
				My_SK_Utilities.tipDecision(tipAnswer, totalBeforeTax);
				
			} // end for loop
		} // end else if condition
		else
		{
			System.out.print("Error 404: invalid entry. Re-enter 1 or 2 for billing options: ");
		}
	} // end method 
	
/**
* Method Name: printMenuContents()
* Purpose: to print out the menu contents with their prices to user
* Accepts: -String type array strArray holding the String elements from the selected menu
* 				 -double type array priceArray holding the double elements (prices) from the selected menu
* Returns: nothing; but prints out contents
*/
public static void printMenuContents(String [] strArray, double [] priceArray)
	{
		for(int i = 0; i < strArray.length; i++)
		{
			System.out.printf("\n %d.  %s   $%.2f" , (i + 1), strArray[i] , priceArray[i]);
		}//end for
	}//end method
	
}  // end class