public class GoodDay {

    public static void main(String[] args) {

        double time = 22.58; // format  hh.mm

        int hours = (int) time;
        int minutes = (int) ((time - hours) * 100);

        // time validation
        if (minutes >= 60) {
            System.out.println("Invalid time: Minutes should be less than 60.");
            return;
        }

        if (time < 12.00) {
            System.out.println("Good morning!");
        } else if (time < 18.00) {
            System.out.println("Good day!");
        } else if (time < 23.00) {
            System.out.println("Good evening!");
        } else {
            System.out.println("Time to sleep!");
        }
    }
}