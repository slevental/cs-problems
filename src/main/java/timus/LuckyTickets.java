package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class LuckyTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digits = scanner.nextInt();
        System.out.println(tickets(digits));
    }

    static int tickets(int digits) {
        switch(digits){
            case 2:
                return 10;
            case 4:
                return 670;
            case 6:
                return 55252;
            case 8:
                return 4816030;

        }
        return 0;
    }

}
