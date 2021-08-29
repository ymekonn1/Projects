
import java.util.Random;

public class Maze {

    int[][] maze;
    private static final int SIZE = 20;

    public Maze() {
        this.maze = new int[SIZE][SIZE]; 
    }

    public void randMaze() {
        Random generate = new Random();
        for (int i = 0; i < SIZE; i++) {
            if (i % 2 != 0 && i != SIZE - 1) {
                int cp = SIZE;
                while (cp-- != 0)
                    this.maze[i][generate.nextInt(SIZE)] = 1;
            } else if (i != 0 && i != SIZE - 1){
                int rand = generate.nextInt(SIZE/4);
                while (rand-- != 0)
                    this.maze[i][generate.nextInt(SIZE)] = 1;
                
            }
        }
    }
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0 ; i < SIZE+2; i++)
            ret.append('-');
        ret.append('\n');

        for (int i = 0; i < SIZE; i++) {
            ret.append('|');
            for (int j = 0; j < SIZE; j++) {
                ret.append(this.maze[i][j]);
            }
            ret.append('|');
            ret.append('\n');
        }

        for (int i = 0 ; i < SIZE+2; i++)
            ret.append('-');
        ret.append('\n');

        return ret.toString();
    }
}