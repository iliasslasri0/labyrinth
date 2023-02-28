package maze;

import java.io.File;

public class MazeReadingException extends Exception {
	private static final long serialVersionUID = 1L;

	public MazeReadingException(File file, int lineNum , String Msg) {
		super("Error detected while reading the maze from the directory "+file + "at the line" +lineNum + ":"+Msg );
		
	}

}
