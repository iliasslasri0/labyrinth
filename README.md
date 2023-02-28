## Labyrinth Project
The Labyrinth Project is a simple application that allows users to create and solve mazes. Users can customize the maze by designating which boxes are walls, and they can set a departure and arrival box to solve the maze.

## Getting Started
To use the Labyrinth Project, simply open and run the Main.java file in an IDE that supports the latest version of Java. This will load the application and display a default clean maze.

## Using the Application
The user interface is very simple. The maze is displayed on the screen, and users can click on boxes to turn them into walls. To set a departure or arrival box, simply click on the "Departure" or "Arrival" button below the panel and then click on the desired box. The departure box will appear in green, and the arrival box will appear in red.

To solve the maze, click on the "Solve" button. The application will use Dijkstra algorithm to find the shortest path between the departure and arrival boxes, and it will display the solution on the screen with white boxes.

To import a customized maze please use the Menu Bar and make sure your maze represent the path with the characters '.',Arrival box with 'A' and Departure box with 'D' the wall boxes with 'W' and the empthy ones with 'E'.In the Menu Bar you can find a save option as well.

### THE PROJECT STURCTURE

I suppareted the IHM from the part that calculates the shortest path to respect the software engineering practice called "separation of concerns", separating concerns will make my project more modular, easier to maintain, and more flexible to change over time.