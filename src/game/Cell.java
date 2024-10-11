package game;

public class Cell{
    protected final int x;
    protected final int y;
    protected  boolean status;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.status = false;
    }
  

    public boolean checkStatus() {
        return status;
    }

    public void isAlive() {
        this.status = true;
    }

    public void isDead() {
        this.status = false;
    }
    

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getNeighbour(Cell [][] grid){
        int rows = grid.length;
        int columns = grid[0].length;
        int numNeighbour = 0;
        //System.out.printf("CHECK for ROW:%d COL:%d STA:%b\n",this.x,this.y,this.status);
                        
        for(int idx_x = this.x - 1; idx_x < this.x + 2; idx_x++){
            for(int idx_y = this.y - 1; idx_y < this.y + 2; idx_y++){
                if(idx_x >= 0 && idx_y >=0 && idx_x < rows && idx_y < columns){
                    if(this.x != idx_x || this.y !=idx_y){
                        Cell cell = grid[idx_x][idx_y];
                        if(cell.checkStatus()){
                            numNeighbour++;
                        }
                        //System.out.printf("ROW:%d COL:%d STA:%b Num: %d\n",idx_x,idx_y,cell.checkStatus(),numNeighbour);
                    }
                }
            }
        }
        //System.out.println(" ");
        return numNeighbour;
    }

}