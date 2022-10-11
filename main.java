
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 
public class main{

	public static void main(String[] args) throws IOException 
	{
		
		Scanner scan = new Scanner(System.in);
		String recipeName;
		String recipeDescription;//description
		String recipeIng;//Ingredient list
		String recipeInstruction;//instruction
		
		
		//Welcome message 
		
		System.out.println("Welcome to the Recipe book!");
		Menu recipeBook = new Menu();
		displayOptions();
		int userChoice = Integer.parseInt(scan.nextLine());

		 
		while(userChoice != -1 ){
			if(userChoice == -1){
				System.out.println("Thank you for using the recipe book. Goodbye!");
				break;
			}

			if(userChoice == 1){
				System.out.println("Thank you for choosing to add a recipe!");
				System.out.println("Please tell us the name of your recipe: ");
				recipeName = scan.nextLine();
				

				System.out.println("Please use a few sentences to describe your recipe: ");
				recipeDescription = scan.nextLine();
				

				ArrayList <String> ingredient = new ArrayList<>();
				boolean flag = true;
				while(flag){
					System.out.println("Please add one ingredient");
					recipeIng= scan.nextLine();
					ingredient.add(recipeIng);
					System.out.println("Enter any number to continue adding. Enter 0 to stop");
					int answer =  Integer.parseInt(scan.nextLine());
					if(answer == 0){
						flag = false;
					}
				}

				ArrayList <String> instructions = new ArrayList<>();
				boolean in_flag = true;
				while(in_flag){
					System.out.println("Please add one instruction");
					recipeInstruction= scan.nextLine();
					instructions.add(recipeInstruction);
					System.out.println("Enter any number to continue adding. Enter 0 to stop");
					int answer =  Integer.parseInt(scan.nextLine());
					if(answer == 0){
						in_flag = false;
					}
				}

			
				System.out.println("Great! Give us a moment...Creating your recipe...");
				Recipe newR = new Recipe(recipeName, recipeDescription, ingredient, instructions);
				recipeBook.addRecipe(newR);
				//TODO: decide on how/when we wanna query all recipies and when to add newly created ones to the container
				//recipeBook.container.add(newR);
				System.out.println("Your recipe has been created and it has now been added to the recipe book!");
				
			}
			
			//search for recipe
			else if (userChoice ==2) {
				//check if recipe.txt exists
				File fileName = new File("recipes.txt");
				boolean exists = fileName.exists();
				if (exists==false) {
					System.out.println("Recipe book doesn't yet exist, you need to create a recipe first.");
				}
				
				//if exists then the user can search
				System.out.println("Please enter a recipe name to search");
				File f1=new File("recipes.txt"); //Input file name
				String recipeToFind= scan.nextLine();
			      String[] words=null; 
			      FileReader fr = new FileReader(f1);  //Creation of File Reader object
			      BufferedReader br = new BufferedReader(fr); 
			      String s;     
			      String input=recipeToFind;   // Input word to be searched
			      int count=0;   //Intialize the word to zero
			      while((s=br.readLine())!=null)   //Reading Content from the file
			      {
			         words=s.split(" "); 
			          for (String word : words) 
			          {
			                 if (word.equals(input))   //Search for the recipe
			                 {
			                   System.out.println(s);
			                   count++;    //count number of times present
			                 }
			          }
			      }
			      if(count>1)  //If more than one recipe found
			      {
			         System.out.println( count + " recipes came up matching the term you entered");
			         //Since more than one recipe with this name came up, ask the user to specify which one to view
			         System.out.println("Enter the name of the recipe that you want to see");
			         String recipeToView= scan.nextLine();
			         //Ask which way to view
			         System.out.println("How would you like to view this recipe?");
			    	  System.out.println("Option 1: View entire recipe");
			    	  System.out.println("Option 2: View one step at a time");
			    	  System.out.println("Enter 1 or 2");
			    	  int viewOption= scan.nextInt();
			    	  if (viewOption ==1) {
			    		  recipeBook.viewEntireRecipe(input);
			    	  }
			    	  else if (viewOption ==2) {
			    		  recipeBook.viewStepByStep(input);
			    	  }
			         
			      }
			      else if (count==1) {//Only one found
			    	  System.out.println("Recipe found");
			    	  //Ask which way to view
			    	  System.out.println("How would you like to view this recipe?");
			    	  System.out.println("Option 1: View entire recipe");
			    	  System.out.println("Option 2: View one step at a time");
			    	  System.out.println("Enter 1 or 2");
			    	  int viewOption= scan.nextInt();
			    	  if (viewOption ==1) {
			    		  recipeBook.viewEntireRecipe(input);
			    	  }
			    	  else if (viewOption ==2) {
			    		  recipeBook.viewStepByStep(input);
			    	  }
			      }
			      else
			      {
			         System.out.println("The recipe does not yet exist");
			      }
			}

			
			//display all recipe
			else if (userChoice ==3) {
				File fileName = new File("recipes.txt");
				boolean exists = fileName.exists();
				if (exists==false) {
					System.out.println("Recipe book doesn't yet exist, you need to create a recipe first.");
				}
				else {
					System.out.println("Here are the recipes");
					Scanner scan2 = new Scanner(new File("recipes.txt"));
					//print out all the recipes
					while(scan2.hasNextLine()){
						String recipeRead = scan2.nextLine();
						System.out.println(recipeRead);
				      
					}
					System.out.println("Which recipe would you like to see in detail?");
					String recipeOption= scan.nextLine();
			    	  //Ask which way to view
			    	  System.out.println("How would you like to view this recipe?");
			    	  System.out.println("Option 1: View entire recipe");
			    	  System.out.println("Option 2: View one step at a time");
			    	  System.out.println("Enter 1 or 2");
			    	  int viewOption= scan.nextInt();
			    	  if (viewOption ==1) {
			    		  recipeBook.viewEntireRecipe(recipeOption);//view entire recipe
			    	  }
			    	  else if (viewOption ==2) {
			    		  recipeBook.viewStepByStep(recipeOption);//view step by step
			    	  }
					
				}
			}
			
			
			/*else if (userChoice == 2){
				if (recipeBook.container == null ||recipeBook.container.size() == 0){
					System.out.println("You have nothing in your recipe book yet. Please add a recipe!");
					
				}else{
					System.out.println("Please enter a recipe name to search");
					String recipeToFind = scan.nextLine();
					Recipe matching = recipeBook.findMatchingRecipe(recipeToFind);
					if(matching == null){
						System.out.println("Sorry, this recipe does not exist");
					}else{
						matching.displayOne();
						
					}

				}
				System.out.println("Press enter to continue");
				scan.nextLine();
				
				
				
			else if (userChoice == 3){

					//TODO: implement how to query/read-in recipes.txt
				
				

					if (recipeBook.container == null ||recipeBook.container.size() == 0){
						System.out.println("You have nothing in your recipe book yet. Please add a recipe!");
					}else{
						System.out.println("Here are all the recipes!");

					Collections.sort(recipeBook.container, new NameComparator());
					recipeBook.displayAll();

				}
				System.out.println("Press enter to continue");
				scan.nextLine();
			}
			*/

			displayOptions();
			userChoice =  Integer.parseInt(scan.nextLine());

		}
		

	}




	//Method for menu
	public static void displayOptions() {
		System.out.println("=======================================");

		System.out.println("Terminal Menu:");
		System.out.println("Choose one of the following options: ");
		System.out.println("(1) Add a new recipe.");
		System.out.println("(2) Search a recipe.");
		System.out.println("(3) See all recipe.");
		System.out.println("If you wish to exit the menu, please enter -1");
		System.out.print("Enter your choice: ");
	}



}
