package com.example2.lrudemo.lrudemo.present;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example2.lrudemo.lrudemo.R;

import com.example2.lrudemo.lrudemo.class4test.*;
import com.example2.lrudemo.lrudemo.class4test.B;
import com.example2.lrudemo.lrudemo.class4test.G;
import com.example2.lrudemo.singletonfactory.Signle.InstanceFctrory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InstanceFctrory.getInsFactory().getInstance(Apple.class);
        InstanceFctrory.getInsFactory().getInstance(A.class);
        InstanceFctrory.getInsFactory().getInstance(B.class);
        InstanceFctrory.getInsFactory().getInstance(C.class);
        InstanceFctrory.getInsFactory().getInstance(D.class);
        InstanceFctrory.getInsFactory().getInstance(E.class);
        InstanceFctrory.getInsFactory().getInstance(F.class);
        InstanceFctrory.getInsFactory().getInstance(G.class);
        InstanceFctrory.getInsFactory().getInstance(H.class);
        InstanceFctrory.getInsFactory().getInstance(I.class);
        InstanceFctrory.getInsFactory().setLruCacheSize(5);
        InstanceFctrory.getInsFactory().getInstance(J.class);
    }
}
