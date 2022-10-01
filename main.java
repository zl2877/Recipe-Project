
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String n;//name
		String d;//description
		String ing;//Ingredient list
		String ins;//instructions

				
		//Creating array list name houseEntry of type House
		//ArrayList<Recipe>menu = new ArrayList<Recipe>();
		Recipe newRec = new Recipe("Oranges", "description", "ngList",new String[]{"pour water","cook"});
		Recipe newRec2 = new Recipe("Zebra", "description", "ngList",new String[]{"pour water","cook"});

		Recipe newRec1 = new Recipe("Account", "description", "ngList",new String[]{"pour water","cook"});
	
		Menu menu = new Menu();
		menu.Add(newRec2);
		menu.Add(newRec1);
		menu.Add(newRec);
		menu.displayAll();
		Collections.sort(menu.container, new NameComparator());
		menu.displayAll();
		
		
				
					

// 			while(true) {
// 					options();
// 					int choice = sc.nextInt();
					
// 					//Option 1.	Add a house
// 					if (choice == 1) {
// 						System.out.println("Add a new recipe:");
// 						System.out.print("Enter name: ");
// 						n = sc.next();
// 						System.out.print("Enter decription: ");
// 						d = sc.next();
// 						System.out.print("Enter ingredient list: ");
// 						ing = sc.next();
// 						System.out.print("Enter instructions: ");
// 						ins = sc.next();
// 						Menu a =new Menu();
// 						//Using method from HouseInventory
// 						a.Add(menu, n,d,ing,ins);
						
// 				}
// 					//Option 3. Display all contact
// 					else if (choice == 3) {
// 						System.out.println("Display All");
// 						System.out.println("Name\tDescription\tIngredients\tInstructions");
// 						Collections.sort(menu, new NameComparator());;
// 						for(Recipe recipe:menu) {
// 							System.out.println(recipe.toString());
// 						}
						
// 					}


// }
				
	}

	//Method for menu
	// public static void options() {
	// 	System.out.println("Main Window:");
	// 	System.out.println("=============");
	// 	System.out.println("Choose one of the following options: ");
	// 	System.out.println("(1) Add a new recipe.");
	// 	System.out.println("(2) Search a recipe.");
	// 	System.out.println("(3) See all recipe.");
	// 	System.out.print("Enter your choice: ");
	// }

}