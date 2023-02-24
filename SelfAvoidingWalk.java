public class SelfAvoidingWalk {
    
    public static int[] walk(int dim){

        boolean[][] map = new boolean[dim][dim];
        int x = dim/2;
        int y = dim/2;
        int dist = 0;
        int farRight = x;
        int farLeft = x;
        int top = y;
        int bot = y;
        while(x<dim && x>=0 && y<dim && y>=0 && map[y][x]==false){
            map[y][x] = true;
            double direction = Math.random();
            if (direction<0.25){
                y-=1;
            }else if (direction<0.5){
                y+= 1;
            }else if (direction<0.75){
                x-= 1;
            }else{
                x+=1;
            }
            dist++;
            if (x>farRight){
                farRight = x;
            }
            if (x<farLeft){
                farLeft = x;
            }
            if (y<top){
                top = y;
            }
            if(y>bot){
                bot = y;
            }
             
        
        
        }
        if (x>=dim || x<0 || y>=dim || y<0){
            return new int[] {1,dist};
        }else{
            return new int[] {0,dist,farRight,farLeft,top,bot};
        }

    }



    public static void printPathLengths(int dim, int nTrials){
        int totalDistDead = 0;
        int totalDistEscape = 0;
        int numEscapes = 0;
        int numDeadEnds = 0;
        for(int i = 0; i<nTrials;i++){
            int[] walkResults = walk(dim);
            if (walkResults[0]==0){
                numDeadEnds ++;
                totalDistDead+= walkResults[1];
            }else{
                totalDistEscape += walkResults[1];
                numEscapes ++;
            }
        }
        System.out.println((double)totalDistDead/numDeadEnds);
        System.out.println((double)totalDistEscape/numEscapes);
        System.out.println((double)numDeadEnds/nTrials);
    }


    public static double deadEndRectangleArea(int n, int nTrials){
        double totalArea=0;
        int numDeadEnds = 0;
        for (int i =0;i<nTrials;i++){
            int [] walkResults = walk(5);
            if (walkResults[0] == 0){
                int farRight = walkResults[2];
                int farLeft = walkResults[3];
                int top = walkResults[4];
                int bot = walkResults[5];
                numDeadEnds++;
                double area = ((Math.abs(farRight-farLeft)+1)*(Math.abs(top-bot)+1));
                totalArea+= area;
            }
        }
        return(totalArea/numDeadEnds);
        }
    
        
        



 
    



    
    public static void main(String[] args) {
        /* 
        int trials = 1000000;
        int escaped = 0;
        for(int i = 0;i<trials;i++){
            if (walk(5)==true){
                escaped++;
            }
        }
        System.out.println((double)escaped/trials);
        */

        printPathLengths(5,100000);
        System.out.println(deadEndRectangleArea(5,100000));

    }
}

