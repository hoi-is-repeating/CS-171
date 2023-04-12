import java.io.*;
import java.util.*;

/* THIS CODE WAS MY (OUR) OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR ONLINE RESOURCES.
oLiViA kIm*/

/*
* self-referential class to represent a position in a path
*/
class Position {
    public int i; // row
    public int j; // column
    public char val; // 1, 0, or 'X'
    // reference to the previous position (parent) that leads to this position on a
    // path
    Position parent;

    Position(int x, int y, char v) {
        i = x;
        j = y;
        val = v;
    }

    Position(int x, int y, char v, Position p) {
        i = x;
        j = y;
        val = v;
        parent = p;
    }
}

public class PathFinder {
    // main method: reads in maze file and finds path using both stackSearch and
    // queueSearch
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("***Usage: java PathFinder maze_file");
            System.exit(-1);
        }
        char[][] maze;
        maze = readMaze(args[0]);
        printMaze(maze);
        Position[] path = stackSearch(maze);
        if (path == null) {
            System.out.println("Maze is NOT solvable (no valid path identified in stackSearch).");
        } else {
            System.out.println("stackSearch Solution:");
            printPath(path);
            printMaze(maze);
        }
        char[][] maze2 = readMaze(args[0]);
        path = queueSearch(maze2);
        if (path == null) {
            System.out.println("Maze is NOT solvable (no valid path identified in queueSearch).");
        } else {
            System.out.println("queueSearch Solution:");
            printPath(path);
            printMaze(maze2);
        }
    }

    // TODO: implement the method queueSearch
    public static Position[] queueSearch(char[][] maze) {

        // pathfind
        /*
         * /
         * ArrayDeque<Position> search = new ArrayDeque<Position>() ;
         * int N = maze[0].length;
         * for (int i = 0; i < N; i++) {
         * for (int j = 0; j < N; j++) {
         * if (maze[i][j] == '0') {
         * search.addLast(new Position(i, j, maze[i][j]));
         * }
         * }
         * }
         * search.addLast(new Position(0, 0, maze[0][0]));
         * while(!search.isEmpty()){
         * Position examine = search.removeFirst();
         * if(search.getLast().i==N-1&&search.getLast().j==N-1)break;
         * search.addLast(new Position(examine.i,examine.j,'X'));
         * Position parent = search.getLast();
         * if (examine.i < N - 1) {
         * if (maze[examine.i + 1][examine.j] == '0')
         * search.addLast(new Position(examine.i + 1, examine.j, 'X', parent));
         * }
         * if (examine.i > 0) {
         * if (maze[examine.i - 1][examine.j] == '0')
         * search.addLast(new Position(examine.i - 1, examine.j, 'X', parent));
         * }
         * if (examine.j < N - 1) {
         * if (maze[examine.i][examine.j + 1] == '0')
         * search.addLast(new Position(examine.i, examine.j + 1, 'X', parent));
         * }
         * if (examine.i > 0) {
         * if (maze[examine.i][examine.j- 1] == '0')
         * search.addLast(new Position(examine.i, examine.j - 1, 'X', parent));
         * }
         * }
         * 
         * Position current = new Position(0,0,'X');
         * 
         * 
         */
        /*
         * Queue<Position> q = new LinkedList<>();
         * int N = maze[0].length;
         * for (int i = 0; i < N; i++) {
         * for (int j = 0; j < N; j++) {
         * if (maze[i][j] == '0') {
         * q.add(new Position(i, j, maze[i][j]));
         * }
         * }
         * }
         * 
         * while (!q.isEmpty()) {
         * Position check = q.poll();
         * if (check.i == N - 1 && check.j == N - 1) {
         * q.add(check);
         * break;
         * }
         * boolean notdeadend = false;
         * if (check.i < N - 1) {
         * if (maze[check.i + 1][check.j] == '0')
         * notdeadend = true;
         * }
         * if (check.i > 0) {
         * if (maze[check.i - 1][check.j] == '0')
         * 
         * notdeadend = true;
         * }
         * if (check.j < N - 1) {
         * if (maze[check.i][check.j + 1] == '0')
         * 
         * notdeadend = true;
         * }
         * if (check.i > 0) {
         * if (maze[check.i][check.j - 1] == '0')
         * 
         * notdeadend = true;
         * }
         * if (notdeadend) {
         * q.add(check);
         * if (check.i < N - 1) {
         * if (maze[check.i + 1][check.j] == '0')
         * q.add(new Position(check.i + 1, check.j, maze[check.i + 1][check.j], check));
         * notdeadend = true;
         * }
         * if (check.i > 0) {
         * if (maze[check.i - 1][check.j] == '0')
         * q.add(new Position(check.i - 1, check.j, maze[check.i - 1][check.j], check));
         * notdeadend = true;
         * }
         * if (check.j < N - 1) {
         * if (maze[check.i][check.j + 1] == '0')
         * q.add(new Position(check.i, check.j + 1, maze[check.i][check.j + 1], check));
         * notdeadend = true;
         * }
         * if (check.i > 0) {
         * if (maze[check.i][check.j - 1] == '0')
         * q.add(new Position(check.i, check.j - 1, maze[check.i][check.j - 1], check));
         * notdeadend = true;
         * }
         * }
         * 
         * }
         * Position[] path = new Position[q.size()];
         * for (int i = 0; i < path.length; i++) {
         * path[i] = q.poll();
         * }
         * return path;
         */

        // new maze to see if I visited that place or not
        char[][] mine = maze;
        ArrayDeque<Position> search = new ArrayDeque<Position>();
        search.add(new Position(0, 0, 'X'));
        mine[0][0] = 'X';

        // length of maze
        int N = mine[0].length;

        while (!search.isEmpty()) {
            // shortcuts
            Position check = search.peekLast();
            int i = check.i;
            int j = check.j;
            mine[i][j] = 'X';

            if (i == N - 1 && j == N - 1)
                break;

            boolean blocked = true;

            // check down
            if (i < N - 1 && mine[i + 1][j] == '0') {
                search.addLast(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // check up
            if (i > 0 && mine[i - 1][j] == '0') {
                search.addLast(new Position(i - 1, j, '0', check));
                blocked = false;
            }
            // check right
            if (j < N - 1 && mine[i][j + 1] == '0') {
                search.addLast(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // check left
            if (j > 0 && mine[i][j - 1] == '0') {
                search.addLast(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // if it's a dead end
            if (blocked)
                search.removeLast();

        }

        Position[] path = new Position[search.size()];
        for (int i = 0; i < search.size(); i++) {
            path[i] = search.pollFirst();
        }
        return path;
    }

    // TODO: implement the method stackSearch
    public static Position[] stackSearch(char[][] maze) {
        Stack<Position> pancakes = new Stack<>();
        char[][] mine = maze;
        pancakes.add(new Position(0, 0, 'X'));
        mine[0][0] = 'X';

        // length of maze
        int N = mine[0].length;

        while (!pancakes.isEmpty()) {
            // shortcuts
            Position check = pancakes.peek();
            int i = check.i;
            int j = check.j;
            mine[i][j] = 'X';

            if (i == N - 1 && j == N - 1)
                break;

            boolean blocked = true;

            // check down
            if (i < N - 1 && mine[i + 1][j] == '0') {
                pancakes.add(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // check up
            if (i > 0 && mine[i - 1][j] == '0') {
                pancakes.add(new Position(i - 1, j, '0', check));
                blocked = false;
            }
            // check right
            if (j < N - 1 && mine[i][j + 1] == '0') {
                pancakes.add(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // check left
            if (j > 0 && mine[i][j - 1] == '0') {
                pancakes.add(new Position(i + 1, j, '0', check));
                blocked = false;
            }
            // if it's a dead end
            if (blocked)
                pancakes.pop();
        }

        Position[] path = new Position[pancakes.size()];
        for (int i = pancakes.size() - 1; i >= 0; i++) {
            path[i] = pancakes.pop();
        }
        return path;
    }

    // prints path through maze
    public static void printPath(Position[] path) {
        System.out.print("Path: ");
        for (Position p : path) {
            System.out.print("(" + p.i + "," + p.j + ") ");
        }
        System.out.println();
    }

    // reads in maze from file
    public static char[][] readMaze(String filename) throws IOException {
        char[][] maze;
        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(filename));
        } catch (IOException ex) {
            System.err.println("*** Invalid filename: " + filename);
            return null;
        }
        int N = scanner.nextInt();
        scanner.nextLine();
        maze = new char[N][N];
        int i = 0;
        while (i < N && scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            int j = 0;
            for (; j < tokens.length; j++) {
                maze[i][j] = tokens[j].charAt(0);
            }
            if (j != N) {
                System.err.println("*** Invalid line: " + i + " has wrong columns: " + j);
                return null;
            }
            i++;
        }
        if (i != N) {
            System.err.println("*** Invalid file: has wrong number of rows: " + i);
            return null;
        }
        return maze;
    }

    // prints maze array
    public static void printMaze(char[][] maze) {
        System.out.println("Maze: ");
        if (maze == null || maze[0] == null) {
            System.err.println("*** Invalid maze array");
            return;
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}