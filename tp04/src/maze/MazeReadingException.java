package maze;

public class MazeReadingException extends Exception {
	private static final long serialVersionUID = 1L;

	public MazeReadingException(String fileName, int lineNum , String Msg) {
		super("Error detected while reading the maze from the directory "+fileName + "at the line" +lineNum + ":"+Msg );
		
	}

}
