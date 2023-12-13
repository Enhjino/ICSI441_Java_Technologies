import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GasStationSimulation {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

        FillingDeviceThread[] deviceThreads = new FillingDeviceThread[4];
        for (int i = 0; i < 4; i++) {
            deviceThreads[i] = new FillingDeviceThread(gasStation, i + 1);
            deviceThreads[i].start();
        }
        MaintenanceThread maintenanceThread = new MaintenanceThread(gasStation);
        maintenanceThread.start();

        try {
            Thread.sleep(4 * 60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (FillingDeviceThread thread : deviceThreads) {
            thread.interrupt();
        }
        maintenanceThread.interrupt();

        try {
            for (FillingDeviceThread thread : deviceThreads) {
                thread.join();
            }
            maintenanceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalCarsServiced = gasStation.getTotalCarsServiced();
        System.out.println("Total number of cars serviced in 4 hours: " + totalCarsServiced);
        for (int i = 0; i < 4; i++) {
            int carsServiced = gasStation.getCarsServicedByDevice(i + 1);
            System.out.println("Device " + (i + 1) + " serviced " + carsServiced + " cars.");
        }
    }
}

class GasStation {
    private int totalCarsServiced = 0;
    private int[] carsServicedByDevice = new int[4];
    private Lock lock = new ReentrantLock();

    public void serviceCar(int deviceNumber) {
        lock.lock();
        try {
            totalCarsServiced++;
            carsServicedByDevice[deviceNumber - 1]++;
        } finally {
            lock.unlock();
        }
    }

    public int getTotalCarsServiced() {
        return totalCarsServiced;
    }

    public int getCarsServicedByDevice(int deviceNumber) {
        return carsServicedByDevice[deviceNumber - 1];
    }

    public void performMaintenance(int deviceNumber) {
        try {
            Thread.sleep(getMaintenanceTime(deviceNumber));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private long getMaintenanceTime(int deviceNumber) {
        switch (deviceNumber) {
            case 1:
                return 10 * 60 * 1000; // 10 minutes in milliseconds
            case 2:
                return 15 * 60 * 1000; // 15 minutes in milliseconds
            case 3:
                return 5 * 60 * 1000;  // 5 minutes in milliseconds
            case 4:
                return 13 * 60 * 1000; // 13 minutes in milliseconds
            default:
                return 0;
        }
    }
}

class FillingDeviceThread extends Thread {
    private GasStation gasStation;
    private int deviceNumber;

    public FillingDeviceThread(GasStation gasStation, int deviceNumber) {
        this.gasStation = gasStation;
        this.deviceNumber = deviceNumber;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            gasStation.serviceCar(deviceNumber);
        }
    }
}

class MaintenanceThread extends Thread {
    private GasStation gasStation;

    public MaintenanceThread(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            for (int i = 1; i <= 4; i++) {
                gasStation.performMaintenance(i);
            }
        }
    }
}
