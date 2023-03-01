public class Minesweeper {


    public static boolean[][] makeMinesweeperBoard(int m, int n, double p){
        boolean[][] mineBoard = new boolean[m][n];
        for (int r =0;r<m;r++){
            for (int c =0;c<n;c++){
                if(Math.random()<p){
                    mineBoard[r][c] = true;
                }
            }
        }
        return mineBoard;
    }

    public static void printMinesweeperBoard(boolean[][] mineBoard){
        for (boolean[] row: mineBoard){
            for (boolean value:row){
                if (value){
                    System.out.print("* ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] makeNeighborBoard(boolean[][] mineBoard){
        
        int [][] neighborBoard = new int[mineBoard.length][mineBoard[0].length];
        
        
        for (int r = 0; r<mineBoard.length;r++){
            for (int c = 0; c<mineBoard[0].length;c++){

                if(mineBoard[r][c]){
                    neighborBoard[r][c] = -1;
                    if(r<mineBoard.length-1 && neighborBoard[r+1][c]!= -1){
                        neighborBoard[r+1][c]++;
                    }
                    if(r!=0 && neighborBoard[r-1][c]!= -1){
                        neighborBoard[r-1][c]++;
                    }
                    if(r!=0 && c!=0 && neighborBoard[r-1][c-1]!= -1){
                        neighborBoard[r-1][c-1]++;
                    }
                    if(r!=0 && c<mineBoard[r].length && neighborBoard[r-1][c+1]!= -1){
                        neighborBoard[r-1][c+1]++;
                    }
                    if(r<mineBoard.length-1&&c!=0 && neighborBoard[r+1][c-1]!= -1){
                        neighborBoard[r+1][c-1]++;
                    }
                    if(r<mineBoard.length-1&&c<mineBoard[r].length-1 && neighborBoard[r+1][c+1]!= -1){
                        neighborBoard[r+1][c+1]++;
                    }
                    if(c<mineBoard[r].length-1 && neighborBoard[r][c+1]!= -1){
                        neighborBoard[r][c+1]++;
                    }
                    if(c!=0 && neighborBoard[r][c-1]!= -1){
                        neighborBoard[r][c-1]++;
                    }
                }


                }  
            }
        
        
        return neighborBoard;
    }

    public static void printNeighborBoard(int[][] neighborBoard){
        for(int[] row:neighborBoard){
            for(int value: row){
                if (value == -1){
                    System.out.print("* ");
                }else{
                    System.out.print(value);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        boolean[][] bruhBoard = makeMinesweeperBoard(3,5,0.5);
        printMinesweeperBoard(bruhBoard);
        System.out.println();
        printNeighborBoard(makeNeighborBoard(bruhBoard));



    }
}
