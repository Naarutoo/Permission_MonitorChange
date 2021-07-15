package com.example.permission_monitorchange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button mbtn;
final int code = 345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn = findViewById(R.id.btn1);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String []permissions ={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(MainActivity.this,permissions,code);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
DisplayToast("Storage & Location are granted");
        }
        else if (grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_DENIED){
            DisplayToast("Storage is Granted but Location is denied");

        }
        else if ((grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_GRANTED)){
            DisplayToast("Storage is Denied but Location is GRanted");
        }
        else{
            DisplayToast("Both are Denied");
        }
    }

    public void DisplayToast( String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}