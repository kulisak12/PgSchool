import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Zip {

	public static void main(String[] args) throws IOException {
		ZipFile zipFile = new ZipFile(args[0]);
		
		int argIndex = 1;
		if (args[argIndex].equals("-t")) {
			printZipContent(zipFile, false);
			argIndex++;
			if (argIndex >= args.length) {
				return;
			}
			if (args[argIndex].equals("-l")) {
				printZipContent(zipFile, true);
				argIndex++;
				if (argIndex >= args.length) {
					return;
				}
			}
		}
		
	}
	
	public static void printZipContent(ZipFile zipFile, boolean printAdditionalData) {
		Enumeration<? extends ZipEntry> content = zipFile.entries();
		while (content.hasMoreElements()) {
			printFileInfo(content.nextElement(), printAdditionalData);
		}
	}
	
	public static void printFileInfo(ZipEntry file, boolean printAdditionalData) {
		System.out.print(file.getName());
		if (printAdditionalData) {
			System.out.printf(" %d", file.getTime());
		}
		System.out.println();
	}
}
