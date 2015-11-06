package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class URLify {
    public static String urlEncode(String str) {
        char[] chars = str.toCharArray();
        int from = -1;
        int to = chars.length;

        while (from < chars.length - 1 && chars[++from] == ' ') ;
        while (to > 0 && chars[--to] == ' ') ;

        if (from >= to)
            return "";

        int spaces = 0;
        for (int i = from; i <= to; i++) if (chars[i] == ' ') spaces++;

        int requiredLen = to - from + 1 + spaces * 2;

        if (requiredLen != chars.length) {
            char[] newChars = new char[requiredLen];
            System.arraycopy(chars, from, newChars, 0, to - from + 1);
            chars = newChars;
        }

        for (int i = chars.length - 1, offset = to - from; i >= 0; offset--, i--) {
            if (chars[offset] != ' ')
                chars[i] = chars[offset];
            else {
                chars[i] = '0';
                chars[i - 1] = '2';
                chars[i - 2] = '%';
                i -= 2;
            }
        }

        return new String(chars);
    }
}
