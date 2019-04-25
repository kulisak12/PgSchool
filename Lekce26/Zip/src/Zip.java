

public class Zip {

	public static void main(String[] args) {
		Actions actions = new Actions();
		int state = 0; // 0 = argument, 1 = dir path
		for (String arg : args) {
			state = parseAction(actions, arg, state);
		}
		// TODO state == 1
		
		
	}
	
	public static int parseAction(Actions actionsList, String arg, int state) {
		if (state == 0) {
			if (arg == "-t") {
				actionsList.shouldPrintDir = true;
				return 0;
			}
			if (arg == "-l") {
				actionsList.shouldIncludeFileInfo = true;
				return 0;
			}
			if (arg == "-x") {
				actionsList.shouldUnzip = true;
				// TODO get current dir
				return 0;
			}
			if (arg == "-D") {
				actionsList.shouldPrintDir = true;
				return 0;
			}
			if (arg == "-d") {
				return 1;
			}
		}
		else { // state == 1
			actionsList.unzipDir = arg;
			return 0;
		}
	}
	
	private static class Actions {
		boolean shouldPrintDir = false;
		boolean shouldIncludeFileInfo = false;
		boolean shouldUnzip = false;
		String unzipDir;
	}

}
