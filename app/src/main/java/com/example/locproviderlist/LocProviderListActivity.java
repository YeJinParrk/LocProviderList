package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                for (int i = 0; i < locProvList.size(); i++) {
                    s += "Loc.Provider: " + locProvList.get(i) + "\n" + "Status: "
                            + lm.isProviderEnabled(locProvList.get(i)) + "\n\n";
                }
                mtextView.setText(s);
            }
        });
    }
}