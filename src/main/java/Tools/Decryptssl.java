package Tools;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Decryptssl {
    public static byte[] hexStringToByteArray(String hex) {
        int l = hex.length();
        byte[] data = new byte[l/2];
        for (int i = 0; i < l; i += 2) {
            data[i/2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }
    public static void ssl() throws IOException {
        InputStream cipherInputStream = null;
        try {
            final StringBuilder output = new StringBuilder();
            final byte[] secretKey = hexStringToByteArray("0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF");
            final byte[] initVector = hexStringToByteArray("00000000000000000000000000000000");
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey, "AES"), new IvParameterSpec(initVector, 0, cipher.getBlockSize()));
            cipherInputStream = new CipherInputStream(new FileInputStream("C:\\Users\\ermias\\Documents\\220198_20180310_180102_SOCRA_01.xml.aes"), cipher);

            final String charsetName = "UTF-8";

            final byte[] buffer = new byte[8192];
            int read = cipherInputStream.read(buffer);

            while (read > -1) {
                output.append(new String(buffer, 0, read, charsetName));
                read = cipherInputStream.read(buffer);
            }

            System.out.println(output);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } finally {
            if (cipherInputStream != null) {
                cipherInputStream.close();
            }
        }
    }
}