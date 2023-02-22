public class SelfAvoidingWalk {
    
    public static boolean walk(int dim){

        boolean[][] map = new boolean[dim][dim];
        int x = dim/2;
        int y = dim/2;
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
        
        
        }
        if (x>=dim || x<0 || y>=dim || y<0){
            return true;
        }else{
            return false;
        }

    }



    public static void printPathLengths(int dim, int nTrials){

        boolean[][] map = new boolean[dim][dim];
        int x = dim/2;
        int y = dim/2;
        int dist = 0;
        int deadEnds = 0;
        for (int i = 0; i<nTrials;i++){
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
        
        }
        if(x>=0 && x<dim && y>=0 && y<dim){
            deadEnds++;
        }
    }
    System.out.println((double)dist/nTrials);
    System.out.println((double)deadEnds/nTrials);
        

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

        printPathLengths(5,100);

    }
}
