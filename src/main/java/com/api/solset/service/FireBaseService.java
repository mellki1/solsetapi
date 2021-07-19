package com.api.solset.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;

@Service
public class FireBaseService {

    private static ResourceBundle rb = ResourceBundle.getBundle("application");

    public UserRecord verifyUser(String uid) {
        try {
            FileInputStream serviceAccount = new FileInputStream(rb.getString("firebase.json.path"));
            FirebaseOptions options =  new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://solset-646d1-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            UserRecord user = FirebaseAuth.getInstance().getUser(uid);
            return user;
        } catch (IOException | FirebaseAuthException e) {
            e.printStackTrace();
            return null;
        }
    }
}
