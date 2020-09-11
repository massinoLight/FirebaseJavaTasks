package firebase_massino;


import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime; 

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.v1.FirestoreClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import util.FirebaseSettings;

import util.FirebaseSettings;

public class FirebaseConnect {
	
	public int id=189;
	String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
	
	public FirebaseConnect()throws Exception{
		//les options de la base de données a modifier en cas de besoin dans la classe FirebaseSettings
		FirebaseSettings settings=new FirebaseSettings();

		FileInputStream serviceAccount =
		  new FileInputStream(settings.SERVICE_ACCOUNT_KEY);

		FirebaseOptions options = new FirebaseOptions.Builder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .setDatabaseUrl(settings.DATABASE_Url)
		  .build();

		FirebaseApp.initializeApp(options);

		System.out.println("bien connecté");
		
		Firestore db=com.google.firebase.cloud.FirestoreClient.getFirestore();
		
	}
	
	 
	 /***
	  * fonction qui permet d'ajouter un document a firebase 
	  * spécifier le nom de la collection ou il sera ajouté 
	  * si celle ci n'existe pas elle sera crée automatiquement 
	  * 
	  * **/
	 
	 
	 String addDocumentToFirebase() throws Exception {
		 Firestore db=com.google.firebase.cloud.FirestoreClient.getFirestore();
		 Map<String, Object> data = new HashMap<String, Object>();
		 
		 data.put("DateTime", currentDateTimeString);
		 data.put("id", id);		 
		 data.put("speech", "i love France");
		 ApiFuture<DocumentReference> addedDocRef = db.collection("speech").add(data);
		 System.out.println("Added document with ID: " + addedDocRef.get().getId());
		 id++;

		 return addedDocRef.get().getId();
		  }
	
	

}
