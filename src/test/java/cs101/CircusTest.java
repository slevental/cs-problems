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
        assertEquals(4, Circus.tower(list));
    }

    @Test
    public void test_circus3() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(100, 100));
        list.add(new Circus.Person(90, 90));
        list.add(new Circus.Person(90, 90));
        list.add(new Circus.Person(80, 80));
        list.add(new Circus.Person(70, 70));
        list.add(new Circus.Person(70, 70));
        list.add(new Circus.Person(60, 60));
        list.add(new Circus.Person(50, 50));
        assertEquals(6, Circus.tower(list));
    }

    @Test
    public void test_circus4() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(1, 3));
        list.add(new Circus.Person(1, 2));
        list.add(new Circus.Person(1, 1));
        assertEquals(1, Circus.tower(list));
    }

    @Test
    public void test_circus7() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(1, 9));
        list.add(new Circus.Person(2, 8));
        list.add(new Circus.Person(3, 7));
        list.add(new Circus.Person(3, 6));
        list.add(new Circus.Person(3, 5));
        list.add(new Circus.Person(5, 4));
        list.add(new Circus.Person(4, 1));
        assertEquals(2, Circus.tower(list));
    }


    @Test
    public void test_circus6() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(1, 3));
        list.add(new Circus.Person(2, 4));
        list.add(new Circus.Person(3, 5));
        list.add(new Circus.Person(4, 5));
        list.add(new Circus.Person(5, 5));
        list.add(new Circus.Person(6, 5));
        assertEquals(3, Circus.tower(list));
    }

    @Test
    public void test_circus8() throws Exception {
        List<Circus.Person> list = new ArrayList<>();

        list.add(new Circus.Person(1, 1));
        list.add(new Circus.Person(1, 3));
        list.add(new Circus.Person(3, 1));
        list.add(new Circus.Person(2, 2));
        list.add(new Circus.Person(2, 2));
        list.add(new Circus.Person(3, 3));

        assertEquals(3, Circus.tower(list));
    }

    @Test
    public void test_circus5() throws Exception {
        List<Circus.Person> list = new ArrayList<>();
        list.add(new Circus.Person(2, 2));
        list.add(new Circus.Person(5, 1));
        list.add(new Circus.Person(3, 3));
        list.add(new Circus.Person(7, 1));
        list.add(new Circus.Person(11, 11));
        list.add(new Circus.Person(8, 8));
        list.add(new Circus.Person(10, 1));
        list.add(new Circus.Person(13, 13));
        list.add(new Circus.Person(6, 6));
        assertEquals(6, Circus.tower(list));
    }
}