import java.io.File;
 
public class Stromecek {
    public static void main(String[] args) {
        printFiles(new File("."), "");
    }
 
    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles();
        int numFiles = files.length;
        for (int i = 0; i < numFiles; i++) {
        	File f = files[i];
        	
        	String newIndent = indent + "   ";
        	if (i < numFiles - 1) {
        		newIndent += "|";
        	}
        	else {
        		newIndent += "\\";
        	}
            System.out.printf("%s%s%s\n", newIndent, "-- ", f.getName());
            if (f.isDirectory()) {
            	//newIndent += spaces(f.getName().length() - 1);
                printFiles(f, newIndent);
            }
        }
    }
    
    private static String spaces(int count) {
    	String result = "";
    	for (int i = 0; i < count; i++) {
    		result += " ";
    	}
    	return result;
    }
}