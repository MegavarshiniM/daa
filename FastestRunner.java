import java.util.*;
public class FastestRunner {
    static boolean race(int a, int b) {
        return a > b; 
    }
    public static int findFastestRunner(int[] runners) {
        List<Integer> currentRound = new ArrayList<>();
        for (int runner : runners) {
            currentRound.add(runner);
        }
        while (currentRound.size() > 1) {
            List<Integer> nextRound = new ArrayList<>();
            int i = 0;
            while (i + 1 < currentRound.size()) {
                int runnerA = currentRound.get(i);
                int runnerB = currentRound.get(i + 1);
                if (race(runnerA, runnerB)) {
                    nextRound.add(runnerA);
                } else {
                    nextRound.add(runnerB);
                }
                i += 2;
            }
            if (i < currentRound.size()) {
                nextRound.add(currentRound.get(i));
            }
            currentRound = nextRound;
        }
        return currentRound.get(0);
    }
    public static void main(String[] args) {
        int[] runners = new int[100];
        for (int i = 0; i < 100; i++) {
            runners[i] = i + 1;
        }
        int fastest = findFastestRunner(runners);
        System.out.println("The fastest runner is: " + fastest);
    }
}
