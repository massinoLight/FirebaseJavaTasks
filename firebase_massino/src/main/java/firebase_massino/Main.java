package firebase_massino;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import util.FirebaseSettings;

public class Main {
	
	
	
	
	public static void main(String[] args) throws Exception {
		FirebaseConnect conn=new FirebaseConnect();
		String oui=conn.addDocumentToFirebase();
		
		

	}

}
