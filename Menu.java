//import java.util.Arrays;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;

public class Menu {
	

	//Option 1.	Add a recipe
	public void Add(ArrayList<Recipe>menu , String n, String d, String ingredientList, String in ) {
		// TODO Auto-generated method stub
Recipe newRecipe = new Recipe(n, d, ingredientList, in);
			menu.add(newRecipe);
			System.out.println("New contact added.");
			
	}

	
			
		

}
