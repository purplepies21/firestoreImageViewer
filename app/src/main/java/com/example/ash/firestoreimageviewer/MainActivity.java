package com.example.ash.firestoreimageviewer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
private FirebaseStorage storage= FirebaseStorage.getInstance();
  private StorageReference storageRef;



    private StorageReference tomato1;
    private StorageReference tomato2;
    private StorageReference tomato3;
    final long ONE_MEGABYTE = 1024 * 1024;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storageRef= storage.getReference();

        tomato1= storageRef.child("tomato1.jpg");
        tomato2= storageRef.child("tomato2.jpg");
        tomato3= storageRef.child("tomato3.jpg");

    }


public void download(View view){

        switch(view.getId()) {
            case R.id.tomato1button:
                tomato1.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed

                        ImageView image = (ImageView) findViewById(android.R.id.icon);
                        Bitmap bMap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        image.setImageBitmap(bMap);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });
                break;
            case R.id.button2:
                tomato2.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });
                break;
            case R.id.tomato3:
                tomato3.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // Data for "images/island.jpg" is returns, use this as needed
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });
                break;


        }
}

}
