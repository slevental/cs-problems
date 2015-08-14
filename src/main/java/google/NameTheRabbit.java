package google;

import java.util.Arrays;

/**
 * Created by Stas on 8/14/15.
 */
public class NameTheRabbit {

    public static String[] answer(String[] strings) {
        Name[] names = new Name[strings.length];
        for (int i = 0; i < strings.length; i++) names[i] = new Name(strings[i]);
        Arrays.sort(names);
        for (int i = 0; i < strings.length; i++) strings[i] = names[i].str;
        return strings;
    }

    static class Name implements Comparable<Name> {
        final String str;
        int score;

        Name(String str) {
            this.str = str;
        }

        int score() {
            if (score == 0) {
                for (int i = 0; i < str.length(); i++) {
                    score += str.charAt(i) - 'a' + 1;
                }
            }
            return score;
        }

        public int compareTo(Name o) {
            int cmp = o.score() - score();
            if (cmp != 0) return cmp;
            return o.str.compareTo(str);
        }
    }
}
