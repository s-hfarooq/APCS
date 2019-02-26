package novemberClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WriteFile {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("outputFile.txt");
		PrintStream ps = new PrintStream(f);
		
		for(int i = 0; i < 50; i++)
			ps.println("LINE " + i);
	}
}