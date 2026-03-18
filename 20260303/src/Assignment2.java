import java.util.*;

public class Assignment2 {

    public static void simulate(int memorySize) {
        int total = 200;
        int change = 100;

        Queue<Integer> memory = new LinkedList<>();
        int adaptTime = -1;
        int stubborn = 0;
        int gratitude = 0;

        for (int round = 0; round < total; round++) {
            int best = (round < change) ? 1 : 0;

            double avg = memory.stream()
                    .mapToInt(i -> i)
                    .average()
                    .orElse(0.5);

            int action = (avg >= 0.5) ? 1 : 0;
            int reward = (action == best) ? 1 : 0;

            if (memory.size() >= memorySize) {
                memory.poll();
            }

            memory.offer(reward);

            if (round >= change) {
                if (action == 1) {
                    stubborn++;
                }

                if (action == 0 && adaptTime == -1) {
                    adaptTime = round - change;
                }
            }

            if (round >= total - 20 && action == 1) {
                gratitude++;
            }
        }

        System.out.println("====================================");
        System.out.println("Memory Size: " + memorySize);
        System.out.println("Adapt Time: " + adaptTime);
        System.out.println("Stubborn Score: " + (double) stubborn / (total - change));
        System.out.println("Gratitude Score: " + (double) gratitude / 20);
        System.out.println("====================================\n");
    }

    public static void main(String[] args) {
        System.out.println("===== Assignment 2: What is the KEY in Learning? =====\n");

        simulate(3);    // Short Memory
        simulate(10);   // Medium Memory
        simulate(50);   // Long Memory
    }
}