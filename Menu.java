//import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {
	
	ArrayList <Recipe> container;
	
	public Menu(){
		this.container = new ArrayList<Recipe>(); // a container that contains a list of recipe objects
		
	}
	

	//Option 1.	Add a recipe
	public void Add(Recipe newRecipe) {
		// TODO Auto-generated method stub
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

	
}
