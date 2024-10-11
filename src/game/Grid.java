package game;

import java.util.ArrayList;

public class Grid {
    protected Cell[][] gridCells;
    private int rows;
    private int columns;
    private int startRow;
    private int startCol;
    private int numAlive;

    public Grid(){
        this.gridCells = new Cell[0][0];
        
    }

    public void createGrid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.gridCells = new Cell[rows][columns];
        for(int idx_x = 0; idx_x < rows ; idx_x++){
            for(int idx_y = 0; idx_y<columns ; idx_y++){
                Cell cell = new Cell(idx_x, idx_y);
                this.gridCells[idx_x][idx_y] = cell;
            }
        }
        System.out.println("Grid created");

    }

    
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    public void startCell(String line, int counter){
        String[] lines = line.split("");
        for(int idx = 0 ; idx < lines.length ;idx++){
            if(lines[idx].equals("*")){
                Cell cell = gridCells[counter][idx];
                cell.isAlive();
                //System.out.printf("INDEX row %d, col %d status %b\n",counter,idx,cell.checkStatus());
            }
        }
    }

    public void showCell(){
        for(int idx_x = 0; idx_x < this.rows ; idx_x++){
            System.out.print("|");
            for(int idx_y = 0; idx_y<this.columns ; idx_y++){
                Cell cell = this.gridCells[idx_x][idx_y];
                if(cell.checkStatus()){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("|\n");
        }
        System.out.println("  ");
    }


    public void run(){
        ArrayList<Cell> aliveCell = new ArrayList<>();
        ArrayList<Cell> deadCell = new ArrayList<>();
        for(int idx_x = 0; idx_x < this.rows ; idx_x++){
            for(int idx_y = 0; idx_y<this.columns ; idx_y++){
                Cell cell = this.gridCells[idx_x][idx_y];
                //System.out.println(cell.checkStatus());
                if (cell.getNeighbour(this.gridCells) <= 1 ){
                    deadCell.add(cell);
                }else if (cell.getNeighbour(this.gridCells) == 3 ){
                    aliveCell.add(cell);
                }else if (cell.getNeighbour(this.gridCells) == 2 ){
                    continue;
                }else if (cell.getNeighbour(this.gridCells) >= 4){
                    deadCell.add(cell);
                }
            }
        }

        for(Cell cells: aliveCell){
            int x = cells.getX();
            int y = cells.getY();
            Cell changeCell = this.gridCells[x][y];
            changeCell.isAlive();
        }

        for(Cell cells: deadCell){
            int x = cells.getX();
            int y = cells.getY();
            Cell changeCell = this.gridCells[x][y];
            changeCell.isDead();
        }
        
    }
}

