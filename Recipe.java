
import java.util.Comparator;

public class Recipe{
	
	
	String name; //name
	String description; //description
	String ingredientList; //Ingredient list
	String[] instructions; //instructions

	
	
	//constructor
	public Recipe(String n, String d, String ingList, String[] ins) {
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

	public String getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(String ingredientList) {
		this.ingredientList = ingredientList;
	}

	public String[] getInstructions() {
		
		return instructions;
	}

	public void printInstructions(){
		for(int i =0; i < this.instructions.length;i++){
			System.out.println(this.instructions[i]);
		}
	}

	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}


	//return string representation
	public String toString() {
		
		return name+ "\t"+ description + "\t" + ingredientList + "\t" + instructions +"\t";
	}


	 
	

}