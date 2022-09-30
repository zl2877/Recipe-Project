
import java.util.Comparator;

class NameComparator implements Comparator<Recipe>{  
	public int compare(Recipe o1,Recipe o2){  
	Recipe s1=(Recipe)o1;  
	Recipe s2=(Recipe)o2;  
	  
	return s1.name.compareTo(s2.name);  
	}  
	}  
