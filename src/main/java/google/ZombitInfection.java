package google;

/**
 * Created by Stas on 8/14/15.
 */
public class ZombitInfection {
    public static int[][] answer(int[][] population, int x, int y, int strength) {
        int curr = population[y][x];
        if (curr == -1)
            return population;

        if (curr <= strength) {
            population[y][x] = -1;
            if (x > 0) answer(population, x - 1, y, strength);
            if (y > 0) answer(population, x, y - 1, strength);
            if (y < population.length - 1) answer(population, x , y+1, strength);
            if (x < population[0].length - 1) answer(population, x+1, y, strength);
        }

        return population;
    }
}
