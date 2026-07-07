import java.util.*;
public class bktrk3 {
    //assign direction arrays:
    private static final int[] rowDir = {1,0,0,-1}; //D,L,R,U
    private static final int[] colDir = {0,-1,1,0};
    private static final String[] move = {"D" ,"L" ,"R","U"};

    //final all valid path
    public List<String> findPaths(int[][] maze , int n){
        List<String> res = new ArrayList<>();
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0) return res;

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        backtrack(maze, n , 0 , 0 , new StringBuilde(), visited, res );
        return result;
    }
    private void backtrack(int[][] maze , int n, int row, int col ,StringBuilder path , boolean[] visited, List<String> res){
        if( row == n-1)
    }
}
