package com.example.myprofileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button gotoMaps, gotoCall, gotoMail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoMaps = findViewById(R.id.addressButton);
        gotoCall = findViewById(R.id.callButton);
        gotoMail = findViewById(R.id.mailButton);




        gotoMaps.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=6°53'08.2\"S 109°42'15.0\"E");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(Intent.createChooser(mapIntent, "Choose app.."));
                if(mapIntent.resolveActivity(getPackageManager())!=null)
                    startActivity(mapIntent);
            }
        });

        gotoCall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:089688809038"));
                startActivity(callIntent);
            }
        });

        gotoMail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","sgunawan228@gmail.com", null));
                startActivity(Intent.createChooser(intent, "Send mail.."));
            }
        });
    }
}