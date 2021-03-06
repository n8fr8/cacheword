
package sample.cacheword;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import javax.crypto.SecretKey;

/**
 * This is a part of the CacheWord sample app. Code here is just part of the
 * demonstration, and has nothing to do with CacheWord. This class takes a
 * message, encrypts it and stores it in SharedPreferences. You can attempt to
 * retrieve the message latter by providing the same password.
 */
public class SecretMessage {
    private static final String TAG = "SecretMessage";

    static public void saveMessage(Context context, SecretKey key, String message) {
        SharedPreferences prefs = context.getSharedPreferences(TAG, 0);

        Editor editor = prefs.edit();
        String ciphertext = FakeEncryptor.encrypt(key, message);

        editor.putString("secret_message", ciphertext);
        editor.commit();
    }

    static public String retrieveMessage(Context context, SecretKey key) {
        SharedPreferences prefs = context.getSharedPreferences(TAG, 0);
        String ciphertext = prefs.getString("secret_message", null);
        return FakeEncryptor.decrypt(key, ciphertext);
    }

}
