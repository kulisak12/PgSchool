import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Zip {

	public static void main(String[] args) throws IOException {
		Parameters params = new Parameters(args);
		ZipFile zipFile = new ZipFile(params.zipFilename);
		
		if (params.listFiles) {
			printZipContent(zipFile, params.showExtraInfo);
		}
		
	}
	
	public static void printZipContent(ZipFile zipFile, boolean showExtraInfo) {
		Enumeration<? extends ZipEntry> content = zipFile.entries();
		while (content.hasMoreElements()) {
			printFileInfo(content.nextElement(), showExtraInfo);
		}
	}
	
	public static void printFileInfo(ZipEntry file, boolean showExtraInfo) {
		System.out.print(file.getName());
		if (showExtraInfo) {
			Date date = new Date(file.getTime());
			System.out.printf(" - %s", date.toString());
			double size = (double) file.getSize();
			System.out.printf(" - %s", formatFileSize(size));
			
		}
		System.out.println();
	}
	
	public static String formatFileSize(double size) {
		final double step = 1000;
		String[] units = {"B", "kB", "MB", "GB", "TB"};
		int prefixIndex = 0;
		while (size > step && prefixIndex < 4) {
			size /= step;
			prefixIndex++;
		}
		
		return String.format("%.2f %s", size, units[prefixIndex]);
	}
	
	// parsing and storing of parameters
	private static class Parameters {
		String zipFilename;
		boolean listFiles = false;
		boolean showExtraInfo = false;
		boolean unzip = false;
		int unzipType = 0; // 0 = here, 1 = folder here, 2 = custom
		String unzipLoc;
		
		Parameters(String[] params) {
			zipFilename = params[0];
			int nextParamType = 0; // 0 = parameter, 1 = value
			for (int i = 1; i < params.length; i++) {
				nextParamType = parseParameter(params[i], nextParamType);
			}
		}
		
		private int parseParameter(String param, int paramType) {
			if (paramType == 0) {
				if (param.equals("-t")) {
					listFiles = true;
					return 0;
				}
				else if (param.equals("-l")) {
					showExtraInfo = true;
					return 0;
				}
				else if (param.equals("-x")) {
					unzip = true;
					return 0;
				}
				else if (param.equals("-D")) {
					unzipType = 1;
					return 0;
				}
				else if (param.equals("-d")) {
					unzipType = 2;
					return 1;
				}
			}
			if (paramType == 1) {
				unzipLoc = param;
			}
			return 0;
		}
	}
}
