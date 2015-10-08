package cs101;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/8/15.
 */
public class CircusTest {

    @Test
    public void test_circus() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(65, 100));
        list.add(new Circus.Person(70, 150));
        list.add(new Circus.Person(56, 90));
        list.add(new Circus.Person(75, 190));
        list.add(new Circus.Person(60, 95));
        list.add(new Circus.Person(68, 110));
        assertEquals(6, Circus.tower(list));
    }

    @Test
    public void test_circus2() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(100, 100));
        list.add(new Circus.Person(100, 100));
        list.add(new Circus.Person(90, 90));
        list.add(new Circus.Person(80, 80));
        list.add(new Circus.Person(70, 70));
        list.add(new Circus.Person(70, 70));
        assertEquals(3, Circus.tower(list));
    }
}