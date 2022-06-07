import java.util.Scanner;
public class CandidateChecker {
    public static int sampleFinder(int n){
        double[] probabilityOfCurrentBest = new double[n];
        double[] keepGoingMetric = new double[n];
        keepGoingMetric[n-1] = 0;
        probabilityOfCurrentBest[n-1] = 1;
        for (int i = n-2; i >= 0 ; i--) {
            probabilityOfCurrentBest[i] = probabilityOfCurrentBest[i+1] - (float)1/n;
            keepGoingMetric[i] = (float) n / (n + 1) * keepGoingMetric[i+1]
                    + (float) 1/(n+1) * Math.max(probabilityOfCurrentBest[i+1], keepGoingMetric[i+1]);
        }
        for (int i = 0; i < n; i++) {
            if (probabilityOfCurrentBest[i] > keepGoingMetric[i]) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        // samples size
        int n = 5;
        //data array
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Name: ");
            String name = scnr.next();
            System.out.println("GPA: ");
            double GPA = scnr.nextDouble();
            double communication = Math.random() * 5;
            Candidate temp = new Candidate(name, GPA, communication);
            candidates[i] = temp;
        }
        //sample size maker
        int sampleSize;
        sampleSize = sampleFinder(n);
        System.out.println(sampleSize);
        Candidate max = new Candidate(null, 0, 0);
        //checking for sample max
        for (int i = 0; i < sampleSize; i++) {
            if (candidates[i].communication + candidates[i].GPA > max.communication + max.GPA) {
                max.communication = candidates[i].communication;
                max.GPA = candidates[i].GPA;
                max.name = candidates[i].name;
            }
        }
        // using sample max for rest of n
        boolean flag = true;
        System.out.println("All Candidates:");
        for (int i = 0; i < n; i++) {
            System.out.println("Name: " + candidates[i].name);
            System.out.println("GPA: " + candidates[i].GPA);
            System.out.println("Communication: " + candidates[i].communication);
        }
        for (int i = sampleSize; i < n; i++) {
            if (candidates[i].GPA + candidates[i].communication >= max.GPA + max.communication) {
                System.out.println("Chosen student: " + candidates[i].name);
                    flag = false;
                    break;
            }
        }
        if (flag) {
            System.out.println("Chosen Student: " + candidates[n-1].name);
        }
    }
}
