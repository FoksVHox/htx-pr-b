import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtilities {
    public static void main(String[] args) {
        System.out.println("MD5: " + MD5Hash("Hej med dig!"));
        System.out.println("SHA512: " + SHA512Hash("Hej med dig!"));
    }

    public static String SHA512Hash(String s)
    {
        String result = "";
        try {
            MessageDigest Digest = MessageDigest.getInstance("SHA512");
            Digest.update(s.getBytes());
            result = new BigInteger(1,Digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String MD5Hash(String s)
    {
        String result = "";
        try {
            MessageDigest Digest = MessageDigest.getInstance("MD5");
            Digest.update(s.getBytes());
            result = new BigInteger(1,Digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    // make a function for returning a hexadecimal string s

}
