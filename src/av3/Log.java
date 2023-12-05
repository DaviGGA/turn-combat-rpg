package av3;

import java.io.FileWriter;
import java.io.IOException;


public class Log {

	public static void registerLine(String line) throws IOException {
		FileWriter fileWriter = new FileWriter("battle-log.txt",true);
		fileWriter.write(line);
		fileWriter.close();
	}
	
	public static void clearLog() throws IOException {
		FileWriter fileWriter = new FileWriter("battle-log.txt");
		fileWriter.write("");
		fileWriter.close();
	}
}
