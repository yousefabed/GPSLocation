package edu.cgu.ist380.GPSLocation;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class GPSLocationActivity extends Activity {
	 Button sendBtn;
	 TextView txt;
	 TextView loading;
	 ProgressBar bar;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /* Use the LocationManager class to obtain GPS locations */

        // get needed UI object
        sendBtn = (Button) findViewById(R.id.btn);
       loading = (TextView) findViewById(R.id.loading);
       txt = (TextView) findViewById(R.id.gpsInfo);
        bar = (ProgressBar) findViewById(R.id.progressBar);
 
        bar.setVisibility(View.INVISIBLE);
        loading.setVisibility(View.INVISIBLE);
        
      
        //  create a click listener for the send button
        sendBtn.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {                
            	  LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
                  LocationListener mlocListener = new MyLocationListener(getApplicationContext(),txt,loading,bar);
            
            	   mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

                bar.setVisibility(View.VISIBLE);
                loading.setVisibility(View.VISIBLE);
            }
        });	
        
        
        
    }
}
/* Class My Location Listener */

 class MyLocationListener implements LocationListener{
	 TextView phoneTxt;
	 TextView loading;
	 ProgressBar bar;
	 Context context;
	 
	 public MyLocationListener (Context context,TextView phoneTxt,
	 TextView loading,
	 ProgressBar bar)
	 {
		 this.context = context;
		 this.phoneTxt = phoneTxt;
		 this.loading = loading;
		 this.bar = bar;
		 
		 
	 }
	 

@Override

public void onLocationChanged(Location loc)

{

loc.getLatitude();

loc.getLongitude();

String Text = "My current location is: " +

"\nLatitud = " + loc.getLatitude() +

"\nLongitud = " + loc.getLongitude();

 // show location to user
bar.setVisibility(View.INVISIBLE);
loading.setVisibility(View.INVISIBLE);

phoneTxt.setText(Text);
}


@Override

public void onProviderDisabled(String provider)

{

Toast.makeText( context,

"Gps Disabled",

Toast.LENGTH_SHORT ).show();

}


@Override

public void onProviderEnabled(String provider)

{

Toast.makeText( context,

"Gps Enabled",

Toast.LENGTH_SHORT).show();

}


@Override

public void onStatusChanged(String provider, int status, Bundle extras)

{




}
/* End of Class MyLocationListener */

}/* End of UseGps Activity */