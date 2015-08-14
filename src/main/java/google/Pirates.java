package google;

/**
 * Created by Stas on 8/13/15.
 */
public class Pirates {
    public static int answer(int[] numbers) {
        int i = 0, j = 0, ipos = 0, jpos = 0;
        do {
            ipos = numbers[numbers[ipos]];
            jpos = numbers[jpos];
            i += 2;
            j++;
        } while (ipos != jpos);
        return i - j;
    }

}
