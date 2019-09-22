package inheritance;

import java.util.StringTokenizer;

public class Inheritance {

	String classFound;;
	String words, words2;
	String line = null;

	String[] extendsCheck = { "extends" };
	String[] implementsCheck = { "implements" };
	String[] commaCheck = { "," };

	int complexity = 1;
	int totalcomplexity = 0;
	int x = 0;

	public int CheckInheritance(String line) {

		// Read all lines and every read increase the line number by 1
		StringTokenizer stringToken = new StringTokenizer(line);
		while (stringToken.hasMoreTokens()) {
			words = stringToken.nextToken();
			for (int i = 0; i < extendsCheck.length; i++) {
				if (extendsCheck[i].equals("//")) {
					break;
				} else {
					if (extendsCheck[i].equals(words)) {
						complexity = complexity + 1;
					} else if (implementsCheck[i].equals(words)) {
						String line2 = line;
						complexity = complexity + 1;
						StringTokenizer stringToken2 = new StringTokenizer(line2);
						while (stringToken2.hasMoreTokens()) {
							words2 = stringToken2.nextToken();
							for (int x = 0; x < commaCheck.length; x++) {
								if (commaCheck[x].equals("{")) {
									break;
								} else {
									if (commaCheck[x].equals(words2)) {
										complexity = complexity + 1;
										//System.out.println(complexity);
									}
								}
							}
						}
					}
				}
			}
		}
		totalcomplexity = totalcomplexity + complexity;
		return totalcomplexity;
	}

}
