public class Labyrinth {
    private final int FILL = -1;
    private final int START1 = 3;
    private final int START2 = 4;

    int[][] matrix;
    boolean[][] visited;

    public Labyrinth() {
        matrix = new int[6][6];
        visited = new boolean[6][6];
        this.fillMatrix();
    }

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == FILL) {
                    output += "  #";
                } else if (i == START1 && j == START2) {
                    output += "  @";
                } else if (matrix[i][j] == 0) {
                    output += "  U";
                } else {
                    output += String.format("%3d", matrix[i][j]);
                }
            }
            output += "\n";
        }
        return output;
    }

    public void solve() {
        solve(START1, START2, 0);
    }

    public void solve(int x, int y, int counter) {
        if(x < 0 || x > matrix.length-1 || y < 0 || y > matrix[0].length-1) {
            return;
        }
        if(counter < matrix[x][y]) {
            visited[x][y] = false;
        }
        if(visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if(matrix[x][y] == FILL) {
            return;
        }
        solve(x-1, y, counter+1);
        solve(x, y-1, counter+1);
        solve(x, y+1, counter+1);
        solve(x+1, y, counter+1);
        
        matrix[x][y] = counter;
    }

    private void printVisted() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", visited[i][j] ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void fillMatrix() {
        matrix[0][3] = FILL;
        matrix[0][5] = FILL;
        matrix[1][1] = FILL;
        matrix[1][3] = FILL;
        matrix[1][5] = FILL;
        matrix[2][2] = FILL;
        matrix[2][4] = FILL;
        matrix[3][1] = FILL;
        matrix[4][3] = FILL;
        matrix[4][4] = FILL;
        matrix[5][3] = FILL;
        matrix[5][5] = FILL;
    }

    public static void main(String[] args) {
        Labyrinth lab = new Labyrinth();
        System.out.println(lab);
        lab.solve();
        System.out.println(lab);
    }
}