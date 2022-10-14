//import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Comparator;
// import java.io.FileNotFoundException;


public class Menu {
	
	ArrayList <Recipe> container;
	
	public Menu(){
		this.container = new ArrayList<Recipe>(); // a container that contains a list of recipe objects
	}
	

	//Option 1.	Add a recipe
	public void addRecipe(Recipe newRecipe) {
		// TODO Auto-generated method stub
		try{
			FileWriter myWriter = new FileWriter("recipes.txt", true);
			myWriter.write("Name:\n");
			myWriter.write(newRecipe.name + "\n");
			myWriter.write("description:\n");
			myWriter.write(newRecipe.description + "\n");
			myWriter.write("ingredients:\n");
			for(String ingredient: newRecipe.ingredientList){
				myWriter.write(ingredient + "\n");
			}
			myWriter.write("instructions:\n");
			for(String instruction: newRecipe.instructions){
				myWriter.write(instruction + "\n");
			}
			myWriter.write("======================\n");
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		this.container.add(newRecipe);
		System.out.println("New recipe added.");
	}

	//a method that displays all Recipe objects 
	public void displayAll(){
		for(int i =0; i < this.container.size(); i++){
			System.out.println("Recipe number"+ (i+1));
			System.out.println("Recipe Name: "+this.container.get(i).getName());
			System.out.println("Recipe Description: "+this.container.get(i).getDescription());
			System.out.println("Here is a list of ingredients");
			this.container.get(i).printIngredientList();
			System.out.println("Here are the instructions");
			this.container.get(i).printInstructions();
			System.out.println();

		}
	}

	public Recipe findMatchingRecipe(String name){
		if (this.container== null || this.container.size()==0){
			return null;
		}
		for (int i =0; i < this.container.size();i++){
			String n = this.container.get(i).getName();
			if(name.equals(n)){
				return this.container.get(i);
			}
		}

		return null;
	}

	public void readInAllRecipes() throws FileNotFoundException{
		//reading recipes from txt file, converting to recipe objects and adding all recipes to local menu object
		Scanner recipeFile = new Scanner(new File("recipes.txt"));
		while(recipeFile.hasNextLine()) {
			String line = recipeFile.nextLine();
			if(line.equals("Name:")){
				String name;
				String description;
				ArrayList<String> ingredientList = new ArrayList<String>(); 				//Ingredient list
				ArrayList<String> instructions = new ArrayList<String>();

				name = recipeFile.nextLine();
				name = name.toUpperCase();
				recipeFile.nextLine();
				description = recipeFile.nextLine();
				recipeFile.nextLine();
				String rest = recipeFile.nextLine();
				while(!rest.equals("instructions:")){
					ingredientList.add(rest);
					rest = recipeFile.nextLine();
				}
				rest = recipeFile.nextLine();
				while(!rest.equals("======================")){
					instructions.add(rest);
					rest = recipeFile.nextLine();
				}

				Recipe newRecipe = new Recipe(name, description, ingredientList, instructions);
				container.add(newRecipe);
			}
		}	
		
		//sort the array
		Collections.sort(container, Comparator.comparing(Recipe::getName));
	}

	
	
}


