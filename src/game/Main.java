package game;


import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException,EOFException{
        File fileName = new File(args[0]);
        InputStream fis = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(fis);
        Grid grid = new Grid();
        int counter = 0;

        String line = "a";
        while(null != line){
            line = dis.readLine();
            if (null == line){
                break;
            }
            if (line.startsWith("#")){
                continue;
            }
            else{
                if(!line.contains("*")){
                    String[] lines = line.split(" ");
                    if(lines[0].equals("GRID")){
                        //Create the grid
                        grid.createGrid(Integer.parseInt(lines[1]), Integer.parseInt(lines[2]));
                    }
                    else if (lines[0].equals("START")){
                        //Set Starting point
                        grid.setStartRow(Integer.parseInt(lines[1]));
                        grid.setStartCol(Integer.parseInt(lines[2]));
                        continue;
                    }
                }else if(line.contains("*")) {
                    grid.startCell(line, counter);
                    counter++;
                }
            }
        }
        int count = 0;
        while(count < 5){
            grid.showCell();
            grid.run();
            count++;
        }
        dis.close();
        fis.close();
    }    
}
