package graph;

public class MazeReadingException extends Exception {
	public MazeReadingException(String fileName, int lineNum , String Msg) {
		super("Error detected while reading the maze from the directory "+fileName + "at the line" +lineNum + ":"+Msg );
		
	}

}
