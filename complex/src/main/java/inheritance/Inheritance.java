import java.util.StringTokenizer;

public class Inheritance {
	
	private boolean classFound;
	String word;
	int Ci;
	
	public boolean isClassFound() {
		return classFound;
	}


	public void setClassFound(boolean classFound) {
		this.classFound = classFound;
	}


	public int calculateCi(String line) {
	StringTokenizer stTokenizer = new StringTokenizer(line);
    while (stTokenizer.hasMoreTokens()) {

        //break words in each line
        word = stTokenizer.nextToken();
        System.out.println(word);
        if(word.equals("Class")) {
        	this.setClassFound(true);
        }
        if(word.equals("extends") && classFound == true) {
        	++Ci;
        }
    }
    return Ci;
}
}
