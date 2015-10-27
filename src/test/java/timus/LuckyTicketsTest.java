package timus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/21/15.
 */
public class LuckyTicketsTest {
    @Test
    public void test_tickets() throws Exception {
        assertEquals(10, LuckyTickets.tickets(2));
        assertEquals(670, LuckyTickets.tickets(4));
        assertEquals(55252, LuckyTickets.tickets(6));
        assertEquals(4816030, LuckyTickets.tickets(8));
    }
}