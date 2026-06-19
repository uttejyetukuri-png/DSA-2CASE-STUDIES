class Delivery {
    int over;
    int ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }
}

public class CricketCountingSort {

    static void countingSortByBall(Delivery[] arr, int maxBall) {
        int n = arr.length;
        Delivery[] output = new Delivery[n];
        int[] count = new int[maxBall + 1];

        for (int i = 0; i < n; i++)
            count[arr[i].ball]++;

        for (int i = 1; i <= maxBall; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].ball] - 1] = arr[i];
            count[arr[i].ball]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void countingSortByOver(Delivery[] arr, int maxOver) {
        int n = arr.length;
        Delivery[] output = new Delivery[n];
        int[] count = new int[maxOver + 1];

        for (int i = 0; i < n; i++)
            count[arr[i].over]++;

        for (int i = 1; i <= maxOver; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].over] - 1] = arr[i];
            count[arr[i].over]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void main(String[] args) {

        Delivery[] deliveries = {
            new Delivery(2,4),
            new Delivery(1,1),
            new Delivery(3,6),
            new Delivery(1,5),
            new Delivery(2,2),
            new Delivery(3,1),
            new Delivery(1,3),
            new Delivery(2,6),
            new Delivery(3,4),
            new Delivery(1,2)
        };

        System.out.println("Unsorted Deliveries:");
        for (Delivery d : deliveries)
            System.out.print("(" + d.over + "," + d.ball + ") ");

        System.out.println();

        countingSortByBall(deliveries, 6);
        countingSortByOver(deliveries, 3);

        System.out.println("\nSorted Deliveries:");
        for (Delivery d : deliveries)
            System.out.print("(" + d.over + "," + d.ball + ") ");
    }
}