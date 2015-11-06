package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class Compress {
    public static String compress(String in) {
        if (in.isEmpty())
            return in;

        StringBuilder res = new StringBuilder();
        for (int i = 1, counter = 1; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == in.charAt(i - 1)) counter++;

            if (i == in.length() - 1 || c != in.charAt(i - 1)) {
                res.append(in.charAt(i - 1)).append(counter);
                counter = 1;
            }
        }
        if (res.length() < in.length())
            return res.toString();

        return in;
    }

}
