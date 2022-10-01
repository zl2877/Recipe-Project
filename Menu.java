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
			System.out.println(this.container.get(i).getName());
			System.out.println(this.container.get(i).getDescription());
			System.out.println(this.container.get(i).getIngredientList());
			this.container.get(i).printInstructions();

		}
	}

	
			
		

}
