package com.example.demo.service;

import com.example.demo.object.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {
    public String saveUserDetails(Person person) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collection=dbFirestore.collection("users").document(person.getName()).set(person);
        return collection.get().getUpdateTime().toString();
    }
    public Person getUserDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        DocumentReference documentReference=dbFirestore.collection("users").document(name);
        ApiFuture<DocumentSnapshot> future=documentReference.get();
        DocumentSnapshot document=future.get();
        Person person=null;
        if(document.exists())
        {
            person=document.toObject(Person.class);
            return person;
        }else {
            return null;
        }
    }
    public String updateUserDetails(Person person) throws ExecutionException, InterruptedException {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collection=dbFirestore.collection("users").document(person.getName()).set(person);
        return collection.get().getUpdateTime().toString();
    }
    public String deleteUser(String name)
    {
        Firestore dbFirestore= FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult=dbFirestore.collection("users").document(name).delete();
        return "Document with id "+name+" has been deleted";
    }
}

