package Array;

public class Exercises {

    public static  int[] dailyTemperatures(int[] temperatures) {

        int high =0;
        int[] daysWarmer = new int[temperatures.length];

        for(int low =0; low < temperatures.length;low++){
            high = low;
            while( high < temperatures.length && temperatures[low]>= temperatures[high]) {
                high ++;
                System.out.println(high);
            }
            System.out.println("out");

            if(high >= temperatures.length) daysWarmer[low] =0;
            else  daysWarmer[low] = high-low;


        }

        return daysWarmer;

    }

    public static void main(String args[]) {

    System.out.println(dailyTemperatures(new int []{73,74,75,71,69,72,76,73}));

    }

}
