
import java.io.*;
import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
// import java.io.FileNotFoundException;


public class Main {

	//Method for menu
	public static void displayOptions() {
		System.out.print("\033[H\033[2J");
		//Welcome message
		System.out.println("Welcome to the Kitchen Nightmare Recipe Book!");
		System.out.println("Main Menu");
		System.out.println("===========================================");
		System.out.println("You can choose from any of the following: ");
		System.out.println("(1) 😤 Add a new recipe");
		System.out.println("(2) 🧐 Search a recipe");
		System.out.println("(3) 🥺 See all recipes");
		System.out.println(" ⚠️ If you wish to exit the menu at any point, please enter -1 ⚠️");
		System.out.print("Enter your choice: ");
	}

	public static int getUserChoice(Scanner scan) {
		return Integer.parseInt(scan.nextLine());
	}
	public static void addRecipe(Scanner scan, Menu recipeBook) {
		System.out.println("Thank you for choosing to add a recipe!");
		System.out.println("Please tell us the name of your recipe: ");
		String recipeName = scan.nextLine();

		System.out.println("Please use a few sentences to describe your recipe: ");
		String recipeDescription = scan.nextLine();


		ArrayList <String> ingredient = new ArrayList<>();
		int answer = -1;
		while(answer != 0) {
			System.out.println("Please add one ingredient");
			String recipeIng = scan.nextLine();
			ingredient.add(recipeIng);
			System.out.println("Enter any number to continue adding. Enter 0 to stop");
			answer = Integer.parseInt(scan.nextLine());
		}

		ArrayList <String> instructions = new ArrayList<>();
		answer = -1;
		while(answer != 0){
			System.out.println("Please add one instruction");
			String recipeInstruction= scan.nextLine();
			instructions.add(recipeInstruction);
			System.out.println("Enter any number to continue adding. Enter 0 to stop");
			answer =  Integer.parseInt(scan.nextLine());
		}

		System.out.println("Great! Give us a moment...Creating your recipe...");
		Recipe newR = new Recipe(recipeName, recipeDescription, ingredient, instructions);
		recipeBook.addRecipe(newR);
		recipeBook.displayAll();

		//TODO: decide on how/when we wanna query all recipies and when to add newly created ones to the container
		//recipeBook.container.add(newR);

		System.out.println("Your recipe has been created and it has now been added to the recipe book!");
	}

	public static void displayRecipes(Scanner scan, Menu recipeBook) throws FileNotFoundException {
		int i;
		System.out.print("\033[H\033[2J");
		System.out.println("Here's the recipe book in full: ");


		for(i = 0; i < recipeBook.container.size(); i++){
			viewEntireRecipe(scan, recipeBook, recipeBook.container.get(i));
		}

		System.out.println("Press Enter to return to Main Menu!");
		scan.nextLine();
		
	}

	public static void viewEntireRecipe(Scanner scan, Menu recipeBook, Recipe recipe) {

		System.out.println("-----------------------------------------------------");
		System.out.println(recipe.name + " | " + recipe.description);
		System.out.println("-----------------------------------------------------");
		System.out.println(" ");

		System.out.println("Ingredients: ");
		int i;
		for(i=0; i<recipe.ingredientList.size(); i++){
			System.out.println("➡️ " + recipe.ingredientList.get(i));
		}

		System.out.println(" ");
		System.out.println("Instructions: ");
		for(i=0; i<recipe.instructions.size(); i++){
			System.out.println((i+1) + ". " + recipe.instructions.get(i));
		}
		System.out.println(" ");
		System.out.println("Press Enter to view next recipe!");
		scan.nextLine();
	}

	public static void viewStepByStepRecipe(Scanner scan, Menu recipeBook, Recipe recipe) {
		System.out.println("-----------------------------------------------------");
		System.out.println(recipe.name + " | " + recipe.description);
		System.out.println("-----------------------------------------------------");
		System.out.println(" ");

		System.out.println("Ingredients: ");
		int i;
		for(i=0; i<recipe.ingredientList.size(); i++){
			System.out.println("➡️ " + recipe.ingredientList.get(i));
		}
		System.out.println(" ");


		System.out.println("Press enter until done!");
		for(int j = 0; j < recipe.instructions.size(); j++){
			System.out.println((j+1) + ". " + recipe.instructions.get(j));
			scan.nextLine();
		}
	}

	public static void viewRecipe(Scanner scan, Menu recipeBook, Recipe recipe) {
		System.out.print("\033[H\033[2J");
		System.out.println("------------------------------------------");
		System.out.println("You chose: " + recipe.name);
		System.out.println("How would you like to view this recipe: ");
		System.out.println("(1) In full ");
		System.out.println("(2) Step by step");
		System.out.println("Please enter your choice: ");

		int viewChoice = Integer.parseInt(scan.nextLine());

		if(viewChoice == -1){
			scan.close();
			System.out.println("Thank you for using the recipe book. Goodbye!");
			System.exit(0);
		} else if(viewChoice == 1){
			System.out.print("\033[H\033[2J");
			System.out.println("Here's your full recipe: ");
			viewEntireRecipe(scan, recipeBook, recipe);
		} else if(viewChoice == 2){
			viewStepByStepRecipe(scan, recipeBook, recipe);
		}
	}

	public static void searchRecipes(Scanner scan, Menu recipeBook) throws IOException{
		//check if recipe.txt exists
		File fileName = new File("recipes.txt");
		if (!fileName.exists()) {
			System.out.println("Recipe book doesn't yet exist, you need to create a recipe first.");
			return;
		}

		int searchChoice;

		//if exists then the user can search
		System.out.print("\033[H\033[2J");
		System.out.println("------------------------------------------");
		System.out.println("🍳 Okay chef! Do you wanna find your recipe by: ");
		System.out.println("(1) Viewing all titles");
		System.out.println("(2) Searching by keyword");
		System.out.print("Enter your choice: ");

		Scanner scanSearchOptions = new Scanner(System.in);
		searchChoice =  Integer.parseInt(scanSearchOptions.nextLine());

		//display search options based on user input
		if(searchChoice == -1){
			scan.close();
			System.out.println("Thank you for using the recipe book. Goodbye!");
			System.exit(0);
		} 
		else if(searchChoice == 1){
			int menuSearchStatus = -2;
			while(menuSearchStatus < 0){
				System.out.print("\033[H\033[2J");
				if(menuSearchStatus == -1){
					System.out.println("⚠️ Invalid choice");
				}
				System.out.println("------------------------------------------");
				System.out.println("All available recipes: ");
				int i;
				for(i=0; i < recipeBook.container.size(); i++){
					System.out.print("(" + (i+1) + ") " + recipeBook.container.get(i).name);
					System.out.println(" | " + recipeBook.container.get(i).description);
				}
				System.out.println("Please enter the number of the recipe you would like to view: ");
				int requestedRecipe = Integer.parseInt(scanSearchOptions.nextLine());
				if(requestedRecipe == -1){
					scan.close();
					System.out.println("Thank you for using the recipe book. Goodbye!");
					System.exit(0);
				} else if(requestedRecipe > recipeBook.container.size() || requestedRecipe == 0){
					menuSearchStatus = -1;
				} else {
					menuSearchStatus = 4;
					viewRecipe(scan, recipeBook, recipeBook.container.get(requestedRecipe-1));
				}
			}

				
		} 
		else if(searchChoice == 2){
			// TO SEARCH RECIPE BY KEYWORD
			int keySearchStatus = -2;
			
			keySearchLoop:
			while(keySearchStatus == -2){
				System.out.println("Please enter a recipe keyword to search:");
				String recipeToFind = scan.nextLine();
				recipeToFind = recipeToFind.toUpperCase();
				ArrayList<Recipe> foundRecipes = new ArrayList<Recipe>();

				int i;

				for(i=0; i<recipeBook.container.size(); i++){
					if(recipeBook.container.get(i).name.contains(recipeToFind)){
						foundRecipes.add(recipeBook.container.get(i));
					}
				}

				int innerSearchStatus = -2;

				while(innerSearchStatus < 0){
					System.out.print("\033[H\033[2J");
					if(innerSearchStatus == -1){
						System.out.println("⚠️ Invalid choice, here are your previous search results: ");
					}
					if(foundRecipes.size() > 0){
						System.out.println("You looked up: " + recipeToFind);
						System.out.println("The following recipes contained your search: ");
						for(i=0; i<foundRecipes.size(); i++){
							System.out.println("(" + (i+1) + ") " + foundRecipes.get(i).name);
						}
					} else {
						System.out.print("\033[H\033[2J");
						System.out.println("No matches found containing your search ☹️");
						keySearchStatus = -2;
						System.out.println("Taking you back to the main menu...");
						break;
					}

					System.out.println("Enter the number of the recipe you want to view, or 0 to search again: ");
					int recipeToView = Integer.parseInt(scan.nextLine());
					if(recipeToView == -1){
						scan.close();
						System.out.println("Thank you for using the recipe book. Goodbye!");
						System.exit(0);
					}
					if(recipeToView == 0){
						continue keySearchLoop;
					} else if(recipeToView > 0){
						if(recipeToView > foundRecipes.size()){
							innerSearchStatus = -1;
						} else {
							innerSearchStatus = 4;
							keySearchStatus = 4;
							viewRecipe(scan, recipeBook, foundRecipes.get(recipeToView-1));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		Menu recipeBook = new Menu();
		recipeBook.readInAllRecipes();

		int userChoice = -2;
		while(true){
			if (userChoice == -1) {
				scan.close();
				System.out.println("Thank you for using the recipe book. Goodbye!");
				System.exit(0);
			}
			//add recipe
			if(userChoice == 1) {
				addRecipe(scan, recipeBook);
			}
			//search for recipe
			if (userChoice == 2) {
				searchRecipes(scan, recipeBook);
			}
			//display all recipe
			if (userChoice == 3) {
				displayRecipes(scan, recipeBook);
			}

			displayOptions();
			userChoice = getUserChoice(scan);
		}
	}
}

