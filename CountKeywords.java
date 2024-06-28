import java.util.*;
import java.io.*;

public class CountKeywords {
public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Java source file: ");
    String filename = input.nextLine();

    File file = new File(filename);
    if (file.exists()) {
       System.out.println("The number of keywords in " + filename
         + " is " + countKeywords(file));
      }
      else {
        System.out.println("File " + filename + " does not exist");
      }
    }

    public static int countKeywords(File file) throws Exception {
      // Array of all Java keywords + true, false and null
      String[] keywordString = {"abstract", "assert", "boolean", 
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

      Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
      int count = 0;

      Scanner input = new Scanner(file);
      
      Boolean comment = false;
      while (input.hasNext()) {
        String line = input.nextLine();
        String[] words = line.split(" ");
        for (int i = 0; i <= words.length; i++) {
        	if (words[i].contains("//") || comment){
            	break;
        	} else if (words[i].contains("/*")){    
              comment = true;
            } else if (comment == true) {
              	if (words[i].contains("*/")) {
                  comment = false; 
                }
            } else if (keywordSet.contains(words[i]) && comment == false) {
          		count++;
        	}
        }
      }

      return count;
    }
}
