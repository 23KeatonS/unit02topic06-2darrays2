import java.util.Arrays;
public class DiceRolls {

    public static int rollDie(){
        return ((int)(Math.random()*6)+1);
    }

    public static void twoD6Probabilities(){
        double nTrials = 100000.0;
        int [] frequencies = new int[13];
        for (int i =0; i<nTrials;i++){
            int num1 = rollDie();
            int num2 = rollDie();
            int sum = num1+num2;
            frequencies[sum]++;
        }
        double[] probabilities = new double[13];
        for (int k = 1; k<13;k++){
            probabilities[k] = frequencies[k]/nTrials;

        }
        for(int i = 2;i<13;i++){
            System.out.println(i+": "+probabilities[i]);
        }
    }




    public static void main(String[] args) {
        twoD6Probabilities();
        
        /* 
        
        int[] frequencies = new int[13];
        
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i+j]++;
            }
        }
        
        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            probabilities[k] = frequencies[k] / 36.0;
        }
        System.out.println(Arrays.toString(probabilities));
         */
    }
}
