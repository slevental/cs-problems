package google;

import java.util.*;

/**
 * Created by Stas on 8/15/15.
 */
public class StringCleaning {
    public static String answer(String chunk, String word) {
        ArrayList<String> candidates = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        answer(chunk, word, candidates, visited);
        return Collections.min(candidates);
    }

    private static void answer(String chunk, String word, List<String> candidates, Set<String> visited) {
        visited.add(chunk);
        int idx = 0;

        if (!chunk.contains(word)) candidates.add(chunk);
        else while ((idx = chunk.indexOf(word, idx)) >= 0) {
            String chunk1 = chunk.substring(0, idx) + chunk.substring(idx + word.length(), chunk.length());
            idx++;
            if (!visited.contains(chunk1))
                answer(chunk1, word, candidates, visited);
        }
    }
}
