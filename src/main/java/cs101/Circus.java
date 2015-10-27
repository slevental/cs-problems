package cs101;

import java.util.Collections;
import java.util.List;

/**
 * Created by Stas on 10/8/15.
 */
public class Circus {
    public static int tower(List<Person> persons) {
        Collections.sort(persons);

        Person[] path = new Person[persons.size()];
        int len = 1;
        path[0] = persons.get(0);
        for (int i = 1; i < persons.size(); i++) {
            Person el = persons.get(i);
            if (el.less(path[0]))
                path[0] = el;
            else if (path[len - 1].less(el))
                path[len++] = el;
            else {
                int pos = ceil(path, -1, len - 1, el);
                if (pos < 0) continue;
                path[pos] = el;
            }
        }
        return len;
    }

    static int ceil(Person path[], int l, int r, Person key) {
        int m;
        while (r - l > 1) {
            m = l + (r - l) / 2;
            if (key.less(path[m])) r = m;
            else if (path[m].less(key)) l = m;
            else return -1;
        }
        return -1;
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

        public boolean less(Person p) {
            return this.height - p.height < 0 && this.weight - p.weight < 0;
        }
    }
}
