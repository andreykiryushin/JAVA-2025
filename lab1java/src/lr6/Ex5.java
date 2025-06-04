package lr6;
import java.util.*;
public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер:");
        int size = in.nextInt();
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            array[i] = random.nextInt(1000);
        System.out.println(Arrays.toString(array));
        System.out.println("Максимальный элемент:");
        System.out.println(findMaxElement(array));
    }
    public static int findMaxElement (int[] array) throws InterruptedException
    {
        int cores = Runtime.getRuntime().availableProcessors()/2;
        List<Integer> arrmax = new ArrayList<>();
        int chunkSize = (array.length <cores )? 1 : array.length / cores;
        Thread[] threads = new Thread[cores];
        for (int i = 0; i < cores; i++) {
            if(i> array.length-1)
                continue;
            int start = i * chunkSize;
            int end = (i == cores - 1) ? array.length : start + chunkSize;
            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax)
                        localMax = array[j];
                }
                arrmax.add(localMax);
            });
            threads[i].start();
        }
        for (Thread t : threads)
            if(t != null)
                t.join();
        return Collections.max(arrmax);
    }
}