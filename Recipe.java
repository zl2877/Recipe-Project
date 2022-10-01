
import java.util.Comparator;
import java.util.*;

public class Recipe{
	
	
	String name; //name
	String description; //description
	ArrayList<String>ingredientList; //Ingredient list
	ArrayList<String> instructions; //instructions

	
	
	//constructor
	public Recipe(String n, String d, ArrayList<String> ingList, ArrayList<String> ins) {
		name = n;
		description =d;
		ingredientList = ingList;
		instructions = ins ;
	}
	
	//getters and setters
	 public String getName() {
			return name;
		}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<String> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public void printIngredientList(){
		for(int i =0; i < this.ingredientList.size();i++){
			System.out.println(this.ingredientList.get(i));
		}
	}

	public ArrayList<String> getInstructions() {
		
		return instructions;
	}

	public void printInstructions(){
		for(int i =0; i < this.instructions.size();i++){
			System.out.println(this.instructions.get(i));
		}
	}

	public void setInstructions(ArrayList<String> instructions) {
		this.instructions = instructions;
	}


	//return string representation
	public String toString() {
		
		return name+ "\t"+ description + "\t" + ingredientList + "\t" + instructions +"\t";
	}

	public void displayOne(){
		
		System.out.println("Recipe Name: " + this.getName());
		System.out.println("Recipe description: "+ this.getDescription());
		System.out.println("This is a list of ingredients");
		this.printIngredientList();	
		System.out.println("This is a list of instructions");
		this.printInstructions();

	}


	 
	

}