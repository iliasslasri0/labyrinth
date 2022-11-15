package graph;

public class MainTest {

	public static void main(String[] args) {
		Maze maze = new Maze(10,10);
		maze.initFromTextFile("data\\labyrinthe.maze");

	}
}
