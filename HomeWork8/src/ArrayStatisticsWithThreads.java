import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class ArrayStatisticsWithThreads {
    public static void main(String[] args) {
        int[] numericArray = {5, 12, 9, 3, 21, 6, 15, 17};


        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);

        Thread[] threads = new Thread[numericArray.length];
        for (int i = 0; i < numericArray.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                int value = numericArray[index];
                max.updateAndGet(currentMax -> Math.max(currentMax, value));
                min.updateAndGet(currentMin -> Math.min(currentMin, value));
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);

        for (int i = 0; i < numericArray.length; i++) {
            writeArrayToBinaryFile(new int[]{numericArray[i]}, "array_" + i + ".bin");
        }

        AtomicIntegerArray sums = new AtomicIntegerArray(numericArray.length);
        Thread[] readThreads = new Thread[numericArray.length];
        for (int i = 0; i < numericArray.length; i++) {
            final int index = i;
            readThreads[i] = new Thread(() -> {
                int sum = readArrayFromBinaryFile("array_" + index + ".bin")[0];
                sums.set(index, sum);
            });
            readThreads[i].start();
        }

        for (Thread thread : readThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalSum = 0;
        for (int i = 0; i < numericArray.length; i++) {
            totalSum += sums.get(i);
        }

        System.out.println("Total Sum: " + totalSum);
    }

    private static void writeArrayToBinaryFile(int[] array, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            for (int value : array) {
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readArrayFromBinaryFile(String fileName) {
        int[] result = new int[1]; // Assuming each binary file contains a single integer
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            result[0] = dataInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
