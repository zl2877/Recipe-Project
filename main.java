
import java.io.*;
import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
import java.util.Scanner;
// import java.io.FileNotFoundException;


public class main {

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
		File fileName = new File("recipes.txt");
		if (!fileName.exists()) {
			System.out.println("Recipe book doesn't yet exist, you need to create a recipe first.");
			return;
		}

		System.out.println("Here are the recipes");
		Scanner recipeFile = new Scanner(new File("recipes.txt"));
		//print out all the recipes
		while(recipeFile.hasNextLine()) {
			System.out.println(recipeFile.nextLine());
		}
		//Ask which way to view
		System.out.println("Do you want to view ? (enter any number to continue. -1 to exit) ");
		int answer = Integer.parseInt(scan.nextLine());
		if(answer == -1){
			return;
		}else{
			viewRecipe(scan, recipeBook);
		}
		
	}

	public static void viewEntireRecipe(Menu recipeBook, String recipeOption) {
		int size = recipeBook.container.size();
		if (size > 0){
			for(int i = 0; i < size; i++){
				String name = recipeBook.container.get(i).getName();
				if(name.equals(recipeOption)){
					recipeBook.container.get(i).displayOne();
					break;
				}

			}
		}
	}

	public static void viewStepByStepRecipe(Scanner scan, Menu recipeBook, String recipeOption) {
		int size = recipeBook.container.size();
		for(int i = 0; i < size; i++){
			Recipe item = recipeBook.container.get(i);
			String name = item.getName();
			System.out.println("Viewing " + item.name);
			if(name.equals(recipeOption)) {
				for(int j = 0; j < item.instructions.size(); j++){
					System.out.println(item.instructions.get(j));
					System.out.println("View next step ? (Enter any number to continue. 0 break)");
					int answer = Integer.parseInt(scan.nextLine());
					if(answer == 0) {
						System.out.println("Bye");
						break;
					}
				}
			}
		}
	}

	public static void viewRecipe(Scanner scan, Menu recipeBook) {
		System.out.println("Enter the name of the recipe that you want to see");
		String recipeOption = scan.nextLine();
		System.out.println("We want to see" + recipeOption);
		System.out.println("How would you like to view this recipe?");
		System.out.println("Option 1: View entire recipe");
		System.out.println("Option 2: View one step at a time");
		System.out.println("Enter 1 or 2");

		int viewOption = Integer.parseInt(scan.nextLine());
		if (viewOption == 1) {
			viewEntireRecipe(recipeBook, recipeOption);
		}
		if (viewOption == 2) {
			viewStepByStepRecipe(scan, recipeBook, recipeOption);
		}
	}

	public static void searchRecipes(Scanner scan, Menu recipeBook) throws IOException {
		//check if recipe.txt exists
		File fileName = new File("recipes.txt");
		if (!fileName.exists()) {
			System.out.println("Recipe book doesn't yet exist, you need to create a recipe first.");
			return;
		}

		//if exists then the user can search
		System.out.println("Please enter a recipe keyword to search");
		String recipeToFind = scan.nextLine();
		String[] words;
		FileReader fr = new FileReader(fileName);  //Creation of File Reader object
		BufferedReader br = new BufferedReader(fr);
		String s;
		int count=0;   //Intialize the word to zero
		while((s=br.readLine())!=null) {  //Reading Content from the file
			words=s.split(" ");
			for (String word : words) {
				if (word.equals(recipeToFind)) { //Search for the recipe
					System.out.println(s);
					count++;    //count number of times present
				}
			}
		}
		System.out.println(count);
		System.out.println();

		if (count < 1) {
			System.out.println("The recipe does not yet exist");
			return;
		}

		System.out.println( count + " recipes came up matching the term you entered");
		System.out.println("View recipe ? Enter any number to continue. -1 to break");

		int answer = Integer.parseInt(scan.nextLine());
		if(answer == -1){
			return;
		}else{
			viewRecipe(scan, recipeBook);
		}
		//Ask which way to view
		// viewRecipe(scan, recipeBook);
	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		Menu recipeBook = new Menu();

		//Welcome message 
		System.out.println("Welcome to the Recipe book!");

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

