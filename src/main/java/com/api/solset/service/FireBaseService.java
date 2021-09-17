package com.api.solset.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.ResourceBundle;

@Service
public class FireBaseService {

    private static ResourceBundle rb = ResourceBundle.getBundle("application");

    @PostConstruct
    public void initialization() {

        try{
            FileInputStream inputStream = new FileInputStream(rb.getString("firebase.json.path"));
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .build();

            FirebaseApp.initializeApp(options);
        }
        catch (Exception error) {
            error.printStackTrace();
        }

    }
}
