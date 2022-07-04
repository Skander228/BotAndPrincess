import java.util.*;

public class Main {

    /* Head ends here */
    static void nextMove(int m, String [] grid){
        if( m < 0 )
            return;

        int princess = -1;
        int bot = -1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(((Character)grid[i].charAt(j)).equals('p'))
                    princess = i*m + j;
                else if(!((Character)grid[i].charAt(j)).equals('-'))
                    bot = i*m +j;
            }
        }
        int pX = princess % m;
        int pY = princess / m;
        int bX = bot % m;
        int bY = bot / m;

        nextMove(m, grid, pX, pY, bX, bY);

    }
    static void nextMove(int m, String[] grid, int pX, int pY, int bX, int bY){
        if(pX == bX && pY == bY)
            return;

        if (pX < bX){
            System.out.println("LEFT");
            nextMove(m, grid, pX, pY, bX-1, bY);
        }
        else if (pX > bX){
            System.out.println("RIGHT");
            nextMove(m, grid, pX, pY, bX+1, bY);
        }
        else if (pY < bY){
            System.out.println("UP");
            nextMove(m, grid, pX, pY, bX, bY-1);
        }
        else {
            System.out.println("DOWN");
            nextMove(m, grid, pX, pY, bX, bY+1);
        }
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        System.out.println("Pleas number grid: ");
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        nextMove(m,grid);
    }
}