package cn.fxlcy.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by fxlcy
 * on 2017/1/22
 *
 * @author fxlcy
 * @version 1.0
 */
public class MD5 {
    private static final String ALGORITHM = "MD5";

    private static final char[] HEX = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    private static final String TAG = "MD5";

    private MD5() {
        throw new RuntimeException("Stub");
    }

    public static String MD5(String str) {
        try {
            return MD5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.e(TAG, "Md5 Fail");
            return null;
        }
    }

    public static String MD5(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] digest = md.digest(data);
            return toHex(digest);
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "Md5 Fail");
        }
        return null;
    }

    private static String toHex(byte[] b) {
        StringBuilder builder = new StringBuilder();
        for (byte v : b) {
            builder.append(HEX[(0xF0 & v) >> 4]);
            builder.append(HEX[0x0F & v]);
        }
        return builder.toString();
    }

    /**
     * 计算io流的md5值
     * */
    public static byte[] getMD5Bytes(InputStream inputStream) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[2048];
        int read = inputStream.read(buffer);
        while (read > -1) {
            digest.update(buffer, 0, read);
            read = inputStream.read(buffer);
        }

        return digest.digest();
    }

    public static String MD5(InputStream inputStream) throws Exception {
        return toHex(getMD5Bytes(inputStream));
    }

}
