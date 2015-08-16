package google;

/**
 * Created by Stas on 8/15/15.
 */
public class HashItOut {
    public static int[] answer(int[] digest) {
        int[] message = new int[digest.length];
        for (int i = 0; i < digest.length; i++)
            message[i] = ((digest[i] ^ (i > 0 ? message[i - 1] : 0)) * 129) % 256;
        return message;
    }

    public static int[] hash(int[] message) {
        int[] digest = new int[message.length];
        for (int i = 0; i < message.length; i++)
            digest[i] = ((129 * message[i]) % 256) ^ ((i > 0 ? message[i - 1] : 0) % 256);
        return digest;
    }

}
