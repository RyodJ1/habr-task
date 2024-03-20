public class etcs {
    public static void main(String[] args) {
        double[] array = {3.5, 2.0, 1.0, 4.0}; 

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}




public class etcs {
    public static void main(String[] args) {
for(int i = 2; i <= 100; i ++){
    boolean isPrime = true;

    for(int j = 2; j < i; j++){
        if(i % j == 0){
            isPrime = false;
            break;
        }
    }
    if(isPrime){
        System.out.println(i);
    }
}
   }
}




import java.util.Arrays;
public class etcs {
    public static void main(String[] args) {
        int test_array[] = {0,1,2,2,3,0,4,2};
       
        System.out.println(Arrays.toString(removeElement(test_array, 3)));
    }
    public static int[] removeElement(int[] nums, int val) {
        int offset = 0;
    
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == val){
                offset++;
            } else{
                nums[i - offset] = nums[i];
            }
        }
        return Arrays.copyOf(nums, nums.length - offset);
    }
}




import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ProgrammingCompetition {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int N = scanner.nextInt();
            int[] times = new int[N];
            for (int i = 0; i < N; i++) {
                times[i] = scanner.nextInt();
            }
            scanner.close();

            int[] senior = new int[N];
            int[] junior = new int[N];
            int[] freshman = new int[N];
            for (int i = 0; i < N; i++) {
                senior[i] = i;
                junior[i] = N - 1 - i;
                freshman[i] = i;
            }
            int seniorTime = calculateTime(senior, times);
            int juniorTime = calculateTime(junior, times);
            int freshmanTime = calculateTime(freshman, times);

            int winner = determineWinner(seniorTime, juniorTime, freshmanTime);
            
            FileWriter writer = new FileWriter("output.txt");
            writer.write(Integer.toString(winner));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int calculateTime(int[] order, int[] times) {
        int time = 0;
        int solved = 0;
        for (int i = 0; i < order.length; i++) {
            time += times[order[i]];
            solved++;
            if (time > 300) {
                solved--;
                break;
            }
        }
        return time + solved * 20;
    }
    public static int determineWinner(int seniorTime, int juniorTime, int freshmanTime) {
        if (seniorTime < juniorTime && seniorTime < freshmanTime) {
            return 3; 
        } else if (juniorTime < freshmanTime) {
            return 2; 
        } else {
            return 1; 
        }
    }
}
