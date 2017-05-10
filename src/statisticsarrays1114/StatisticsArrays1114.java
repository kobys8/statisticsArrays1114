/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statisticsarrays1114;

/**
 *
 * @author kms080
 */
import java.io.File;
import java.util.Scanner;
import java.lang.Math;
public class StatisticsArrays1114 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File f = new File("numbers.txt");
            Scanner in = new Scanner(f);
            double[] nums = new double[(int)f.length()];
            int ind = 0;
            while(in.hasNext()) {
                nums[ind] = in.nextInt();
                ind++;
            }
            double average = 0;
            for(int i = 0; i <= nums.length - 1; i++) {
                average += nums[i];
            }
            average = average / ind;
            System.out.println("Average: " + average);
            double[] diffAverage = new double[nums.length - 1];
            for(int i = 0; i <= ind; i++) {
                diffAverage[i] = Math.pow(average - nums[i], 2);
            }
            double diffAverageSum = 0;
            for(int i = 0; i <= ind; i++) {
                diffAverageSum += diffAverage[i];
            }
            diffAverageSum /= (ind - 1);
            diffAverageSum = Math.sqrt(diffAverageSum);
            System.out.println("Standard Deviation: " + diffAverageSum);
            double[] modeOften = new double[ind];
            for(int i = 0; i <= modeOften.length - 1; i++) {
                modeOften[i] = 0;
            }
            for(int i = 0; i <= modeOften.length - 1; i++) {
                modeOften[(int)nums[i]]++;
            }
            double mostOften = 0;
            double highestVal = 0;
            for(int i = 0; i <= modeOften.length - 1; i++) {
                if(modeOften[i] > highestVal) {
                    highestVal = modeOften[i];
                    mostOften = i;
                }
            }
            System.out.print("Mode: ");
            for(int i = 0; i <= modeOften.length - 1; i++) {
                if(modeOften[i] == highestVal){
                    System.out.print(i + " ");
                }
            }
            
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
