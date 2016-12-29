/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */ 

// O(m^2*n^2) BFS

class cellInfo {
    int i; 
    int j; 
    int distance; 
    public cellInfo(int i, int j, int distance){
        this.i = i; 
        this.j = j; 
        this.distance = distance; 
    }
}

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; 
        int rows = grid.length, cols=grid[0].length, countBuilding=0; 
        int[][] distanceMatrix = new int[rows][cols], buildingAccessCountMatrix = new int[rows][cols];  
        final int[] dx = {-1,0,1,0}; 
        final int[] dy = {0,-1,0,1}; 
        for(int i=0; i<=rows-1; i++) {
            for(int j=0; j<=cols-1; j++){
                if(grid[i][j] == 1){
                    countBuilding++; 
                    Queue<cellInfo> queue = new LinkedList<cellInfo>();
                    boolean[][] visited = new boolean[rows][cols]; 
                    queue.offer(new cellInfo(i,j,0));
                    visited[i][j] = true; 
                    while(!queue.isEmpty()){ // BFS starts for here
                        cellInfo currCell = queue.poll(); 
                        // Now lets add all the neighbors of this cell
                        for(int k=0; k<=3; k++){
                            int x = currCell.i + dx[k], y = currCell.j + dy[k];    
                            if(x >=0 && x <=rows-1 && y >=0 && y <=cols-1 && grid[x][y] == 0 && !visited[x][y]){
                                distanceMatrix[x][y] += (currCell.distance+1);
                                buildingAccessCountMatrix[x][y]++; 
                                visited[x][y] = true; 
                                queue.offer(new cellInfo(x,y,currCell.distance+1)); 
                            }
                        }    
                    }
                }
            }
        }
        int minDistance = Integer.MAX_VALUE; 
        for(int i=0; i<=rows-1; i++){
            for(int j=0; j<=cols-1; j++){
                if(grid[i][j] == 0 && buildingAccessCountMatrix[i][j] == countBuilding)
                    minDistance = Math.min(minDistance,distanceMatrix[i][j]); 
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance; 
    }
}