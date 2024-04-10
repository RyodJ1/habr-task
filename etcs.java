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






public static void main(String[] args) {

        int n = 100;
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }

        double max = array[0]; // Массив не должен быть пустым
        double min = array[0];
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            if(max < array[i])
                max = array[i];
            if(min > array[i])
                min = array[i];
            avg += array[i]/array.length;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
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






public static int bruteForce(double[] array, double key) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == key)
            return i;
    }
    return -1;
}
public static int binarySearchRecursively(double[] sortedArray, double key) {
    return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
}
private static int binarySearchRecursively
                (double[] sortedArray, double key, int low, int high) {
    int middle = (low + high) / 2; 

    if (high < low) { 
        return -1;
    }

    if (key == sortedArray[middle]) { 
        return middle;
    } else if (key < sortedArray[middle]) { 
        return binarySearchRecursively(
                sortedArray, key, low, middle - 1);
    } else {
        return binarySearchRecursively( 
                sortedArray, key, middle + 1, high);
    }
}
private static double[] generateRandomArray(int length) {
    double[] array = new double[length];
    for (int i = 0; i < array.length; i++) {
        array[i] = Math.random();
    }
    return array;
}
public static void main(String[] args) {
    double[] array = generateRandomArray(100000000);
    Arrays.sort(array); 
    long time = System.currentTimeMillis(); 
    bruteForce(array, 0.5);
    System.out.println(System.currentTimeMillis() - time);

    time = System.currentTimeMillis();
    binarySearchRecursively(array, 0.5);
    System.out.println(System.currentTimeMillis() - time);
}





public class etcs {
    public static void main(String[] args) {
public static double func(double x){
    return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
}
public static double  solve(double start, double end){
    if(end - start <= 0.001){
        return start;
    }
    double x = start + (end - start) / 2;

    if(func(start) * func(x) > 0){
        return solve(x, end);
    } else {
        return solve(start, x);
    }
}
public static void main(String[] args) {
    System.out.println(solve(0, 10)); 
}
    }}






public class etcs {
    public static void main(String[] args) {
         void buildDictionaryWithMap(String text){
        text = text.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);

            if((ch >= 'а' && ch <= 'я') || ch == 'ё'){
                map.compute(ch, (character, integer)
                        -> integer == null ? 1 : integer + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries =
                new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }







  public static void compare2Lists() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        final int N = 1000000;
        final int M = 1000;
        for (int i = 0; i < N; i++) {
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            arrayList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            linkedList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }





public static <K> Map<K, Integer> countValues(K[] ks) {
        Map<K, Integer> map = new HashMap<>();
        for (K k : ks) {
            map.compute(k, new BiFunction<K, Integer, Integer>() {
                @Override
                public Integer apply(K k, Integer count) {
                    return count == null ? 1 : count + 1;
                }
            });
        }

        return map;
    }
