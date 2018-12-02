/** 
* Program Name: SK_Tasy_Bytes_Order.java
* Purpose: To serve diner guests and their orders up and including their bills
* Coder: Stephen Kah
* Date: Apr 10, 2018
*/

import java.util.*;

public class SK_Tasy_Bytes_Order
{

	

	public static void main(String[] args)
	{
		// Display Title 
		System.out.println("*****************************");
		System.out.println("*   Welcome to Tasty Bytes! *");
		System.out.println("*****************************");
		
		// create scanner for input 
		Scanner input = new Scanner(System.in);
		
		
		// Asks the user to enter the number of people in the group
		// If invalid data type entry; re-enter until valid int data type entered
		// utilizing the boolean validGroupNum
		int groupNumber = 0;
		boolean validGroupNum = true;
		do
		{
		System.out.print("First tell me how many people are in your group: ");
		
		if (input.hasNextInt())
		{
			groupNumber = input.nextInt();
			break;
		}
		else 
		{
			System.out.println("Error 400: Not an integer. Please re-enter");
		}
		// clear buffer
		input.nextLine();
		} while (validGroupNum); // end do-while loop
		
		// An array to store diner customer names
		// declaring and initiating customerCounter to track loop number for customers & their orders
		String[] dinerNamesArray = new String[groupNumber];
		int customerCounter = 0;
		
		// Ask for First name of each diner
		// If left input string is less than 3 characters; prints error & asks for data re-entry
		// Use groupNumber to limit names
		do 
		{
			System.out.print("Please enter the name of diner #" + (customerCounter + 1) + ": ");
			String dinerName = input.next();
			
			if (2 < dinerName.length()) 
			{
				dinerNamesArray [customerCounter] = dinerName;
				customerCounter++;
				
			}
			else 
			{
				System.out.println("Error 401: Enter your first name.");
			}
		} while (customerCounter < groupNumber); // end do-while loop
		
		// Output to user explaining the selection
		System.out.print("\n\nNow each person will need to order an item from " +
											"\neach category, Including apppetizer, main course," +
											"\ndesert & beverage.");
		
		System.out.println("\n\nI will ask each diner for all their menu selections\n");
		
	
		// Create and populate eight arrays 
		// Create an ArrayList to store Strings
		// Create appetizer List 
		 String [] appList = new String [5];//creates a list with 10 elements
		
		appList [0] = "**No Selection**";
		appList [1] = "Deep Fried Calamari";
		appList [2] = "Soup du Jour";
		appList [3] = "Garden Salad";
		appList [4] = "Garlic Bread";
		
		
		// create appetizer price list
		double [] appPriceArray = new double[5];
		
		appPriceArray [0] = 0.00;
		appPriceArray [1] = 7.50;
		appPriceArray [2] = 4.99;
		appPriceArray [3] = 3.99;
		appPriceArray [4] = 4.50;
		
		// Create appetizer List 
		String [] mainList = new String [6];
		
		mainList [0] = "**No Selection**";
		mainList [1] = "Rib-Steak";
		mainList [2] = "Fettuccini Alfredo";
		mainList [3] = "Pan-Fried Sole";
		mainList [4] = "Mediterranean Platter";
		mainList [5] = "Vegetarian Lasagna";

		
		// create appetizer price list
		double [] mainPriceArray = new double[6];
		
		mainPriceArray [0] = 0.00;
		mainPriceArray [1] = 15.95;
		mainPriceArray [2] = 11.25;
		mainPriceArray [3] = 17.95;
		mainPriceArray [4] = 13.50;
		mainPriceArray [5] = 9.00;
	

		// Create appetizer List 
		String[] dessertList = new String [5];
		
		dessertList [0] = "**No Selection**";
		dessertList [1] = "Ice Cream";
		dessertList [2] = "Cheesecake";
		dessertList [3] = "Chocolate Truffle Cake";
		dessertList [4] = "Rasberry Mousse";
		
		
		// create appetizer price list
		double [] dessertPriceArray = new double[5];
		
		dessertPriceArray [0] = 0.00;
		dessertPriceArray [1] = 2.95;
		dessertPriceArray [2] = 5.00;
		dessertPriceArray [3] = 6.00;
		dessertPriceArray [4] = 4.50;

		// Create drink List 
		String[] drinkList = new String [7];
		
		drinkList [0] = "**No Selection**";
		drinkList [1] = "Water";
		drinkList [2] = "Juice";
		drinkList [3] = "Pop";
		drinkList [4] = "Milk";
		drinkList [5] = "Coffee";
		drinkList [6] = "Tea";
				
		// create appetizer price list
		double [] drinkPriceArray = new double[7];
		
		drinkPriceArray [0] = 0.00;
		drinkPriceArray [1] = 0.00;
		drinkPriceArray [2] = 2.00;
		drinkPriceArray [3] = 2.00;
		drinkPriceArray [4] = 2.00;
		drinkPriceArray [5] = 1.75;
		drinkPriceArray [6] = 1.75;

		// billingArray: costs for each cumulative meal selection per diner
		double [] billingArray = new double [groupNumber];
		
		
		// for loop collects each selection from each meal for each customer 
		// proceeding with outer-for-loop to collect order from each diner
		for (int dinerIndex = 0; dinerIndex < dinerNamesArray.length; dinerIndex++)
		{
			System.out.println("\n" + dinerNamesArray[dinerIndex] + ", please make your selection from the "
													+ "following menu");
			
			// runningTotal: Total cost per diner summed with each selection made by diner
			double runningTotal = 0.0;
			
			// mealArray list: Cumulative meal selection for each customer 
			ArrayList <String> mealArray = new ArrayList<String>();//creates a list with 10 elements

			
			// ** APPETIZER MENU **
			System.out.println("\nPlease select one item from the Appetizer menu.");

			// print out listing out the appetizer menu with pricing
			My_SK_Utilities.printMenuContents(appList, appPriceArray);

			// dinerSelectiion for appetizer item
			// returns cumulative cost of order and stored in variable runningTotal
			runningTotal = My_SK_Utilities.dinerSelection(mealArray, runningTotal, appList, appPriceArray);

			
  		// **MAIN MENU**
			System.out.println("\nPlease select one item from the Main menu.");
				
			// print out listing out the Main menu with pricing 
			My_SK_Utilities.printMenuContents(mainList, mainPriceArray);
			
			// dinerSelectiion for main item
			// returns cumulative cost of order and stored in variable runningTotal
			 runningTotal = My_SK_Utilities.dinerSelection(mealArray, runningTotal, mainList, mainPriceArray);
  		
			 
			// **DESERT MENU**
			System.out.println("\nPlease select one item from the Dessert menu.");
			
			// print out listing out the Dessert menu
			My_SK_Utilities.printMenuContents(dessertList, dessertPriceArray);

			// dinerSelectiion for dessert item
			// returns cumulative cost of order and stored in variable runningTotal
			runningTotal = My_SK_Utilities.dinerSelection(mealArray, runningTotal, dessertList, dessertPriceArray);
  		
  		
			// **DRINK MENU**
			System.out.println("\nPlease select one item from the Drink menu.");
			
	  	// print out listing out the drink menu
			My_SK_Utilities.printMenuContents(drinkList, drinkPriceArray);
			
			// dinerSelectiion for drink item
			// returns cumulative cost of order and stored in variable runningTotal
  		runningTotal = My_SK_Utilities.dinerSelection(mealArray, runningTotal, drinkList, drinkPriceArray);
  		
			
  	  // Thank you message for diner and a print out summary of selected items
			System.out.println("\nThank you " + dinerNamesArray[dinerIndex] + ". Your order consists of:");
			for (int r = 0; r < mealArray.size(); r++)
			{
				System.out.println(mealArray.get(r));
			}
			
			// assigning running total cost for each diner and stores with the amount with the diner index number
			billingArray[dinerIndex] = runningTotal;			
		
		} // end for loop dinerNames.length
		
		// boolean flag: validCode used in do-while loop as diner makes decision for one bill 
		// or separate bills 
		boolean validCode = true;
		
		// do-while loop to handle diner decision for one bill or separate bills
		do
		{
		System.out.println("\n\nAll orders have been completed.");
		System.out.println("\nFor just one bill, enter number 1. ");
		System.out.println("For seperate bills, enter number 2. ");
		System.out.print("Enter billing code. ");
		int billingCode = input.nextInt();
		
		// clear buffer
		input.nextLine();

		// billingDecision method executes pending on diner's input
		My_SK_Utilities.billingDecision(billingCode, billingArray, dinerNamesArray);
		
		// conclusion message
		System.out.println("\n\nThank you for your patronage, and please come again!");
		break;
		} while (validCode); // end do-while loop 

	
		// housekeeping
		input.close();
	} // end main method


} // end class