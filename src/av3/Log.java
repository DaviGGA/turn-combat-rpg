package av3;

import java.io.FileWriter;
import java.io.IOException;


public class Log {

	public static void registerLine(String line) throws IOException {
		FileWriter fileWriter = new FileWriter("battle-log.txt",true);
		fileWriter.write(line);
		fileWriter.close();
	}
}
