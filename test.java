

public class test{
     static int[][] maze = new int[][] { // maze built
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, -1}
    };


    public static void main(String[] args) {

        print();


        if (search(0, 0)) {
            System.out.println("SOLVED maze");
        } else {
            System.out.println("could NOT SOLVE maze");
        }

    }

    private static void print() {
        System.out.println("-----------------------");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == -1) { // -1 exit
                    System.out.print("[]");
                } else if (maze[i][j] == 3) { // 3 cells or current spot
                    System.out.print("@ ");
                } else if (maze[i][j] == 1) { //1 is walls
                    System.out.print("*");
                }
                    else if (maze[i][j]== 4){ //4 is  the way the cells has been
                        System.out.print(".");


                } else {
                    System.out.print("  "); // empty = 0, mean empty spot
                }
            }
            System.out.println();
        }

    }

    public static boolean isValidSpot(int r, int c) {
        if (r < 0 || r > 9 || c < 0  || c > 9) {
            return false; // if cells is outside of the boundaries return falls
        }
            else if( maze[r][c] == 0 ||  maze[r][c] == -1){
            return true; // if cells is in empty spot or cells in the exit, return true

        }
        return false;
    }

    public static boolean search( int r, int c) {
        boolean found = false;
        if (maze[r][c] == -1) {
            maze[r][c] = 3;
            print(); // cell is in the exit spot return true

            return true;
        }
        maze[r][c] = 3;
        print();
        maze[r][c] = 4;
        if (isValidSpot(r - 1, c)) { // if up is valid and not visited
            found = search(r - 1, c);
        }
        if (!found && isValidSpot(r, c - 1)) { //left
            found = search(r, c - 1);
        }
        if (!found && isValidSpot(r, c + 1)) { // right
            found = search(r, c + 1);
        }
        if (!found && isValidSpot(r + 1, c)) {
            found = search(r + 1, c); //down
        }
        return found; //if couldn't find solution return false
    }
    }

// time complexity O(n^4) due to print statement
// BFS search suggest for future

