package problems.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KNearestCabs {
    public static class Car {
        int x;
        int y;
        String id;

        public Car(int x, int y, String id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public Integer getDistance() {
            return (x * x) + (y * y);
        }
    }

    static class CarComparator implements Comparator<Car> {

        @Override
        public int compare(Car A, Car B) {
            return -(A.getDistance().compareTo(B.getDistance()));

        }
    }

    public static void printNearestCars(ArrayList<Car> cars, int k) {
        PriorityQueue<Car> maxHeapCar = new PriorityQueue<>(k, new CarComparator());
        for (int i = 0; i < k; i++) {
            maxHeapCar.add(cars.get(i));
        }

        for (int i = k; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            if (currentCar.getDistance() < maxHeapCar.peek().getDistance()) {
                maxHeapCar.remove();
                maxHeapCar.add(currentCar);
            }
        }

        for (Car c : maxHeapCar) {
            System.out.println(c.id);
        }
    }

    public static void main(String[] args) {
        ArrayList<KNearestCabs.Car> cars = new ArrayList<>();
        KNearestCabs.Car c1 = new KNearestCabs.Car(4, 4, "C1");
        cars.add(c1);
        KNearestCabs.Car c2 = new KNearestCabs.Car(2, 1, "C2");
        cars.add(c2);
        KNearestCabs.Car c3 = new KNearestCabs.Car(3, 2, "C3");
        cars.add(c3);
        KNearestCabs.Car c4 = new KNearestCabs.Car(0, 1, "C4");
        cars.add(c4);
        KNearestCabs.Car c5 = new KNearestCabs.Car(0, 0, "C5");
        cars.add(c5);

        KNearestCabs.printNearestCars(cars, 3);

    }
}
