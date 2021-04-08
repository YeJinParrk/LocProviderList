package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Provider;
import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mtextView;
    LocationManager lm; // locationmanager
    List<String> locProvList; // LocationProvider
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextView = findViewById(R.id.txtOuput);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm = (LocationManager) getSystemService(LOCATION_SERVICE);

                locProvList = lm.getAllProviders();
                String s = "";
                for (String locProvList : locProvList){
                    s += "Loc.Provider: " + locProvList + "\n"
                            + "Status:" + lm.isProviderEnabled(locProvList) + "\n\n";
                }
                mtextView.setText(s);
            }
        });
    }
}