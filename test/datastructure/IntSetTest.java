package datastructure;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class IntSetTest {

    @Test
    public final void test() {
        Random rng = new Random(System.nanoTime());

        IntSet set = new IntSet(1 << 20);

        for (int test = 0; test < 1e3; test++) {

            for (int i = 0; i < 1e3; i++) {
                int value = (int) ((1 << 20) * rng.nextDouble());
                set.add(value);
                assertEquals(true, set.contains(value));
            }
            for (int i = 0; i < 1e3; i++) {
                if (set.isEmpty()) {
                    continue;
                }
                int value = set.get((int) (set.size() * rng.nextDouble()));
                assertEquals(true, set.contains(value));
                set.remove(value);
                assertEquals(false, set.contains(value));
            }

        }

    }

}
