package cs101;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.fill;

/**
 * Created by Stas on 10/8/15.
 */
public class Circus {
    public static int tower(List<Person> persons) {
        Collections.sort(persons);

        int[] ints = new int[persons.size()];
        fill(ints, -1);

        longest(persons, 0, ints);

        return IntStream.of(ints).max().getAsInt();
    }

    private static int longest(List<Person> persons, int from, int[] memo) {
        int res = memo[from];
        if (res >= 0) return res;
        if (from == persons.size() - 1) return 1;
        int longest = longest(persons, from + 1, memo);
        int l = 0;
        if (persons.get(from).compareTo(persons.get(from + 1)) < 0)
            l = longest + 1;
        memo[from] = l;
        return l;
    }

    static class Person implements Comparable {
        final int height;
        final int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Person that = (Person) o;
            int h = this.height - that.height;
            if (h != 0) return h;
            int w = this.weight - that.weight;
            if (w != 0) return w;
            return 0;
        }
    }
}
