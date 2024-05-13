import android.Manifest;

import android.content.Context;

import android.content.pm.PackageManager;

import android.location.Location;

import android.location.LocationListener;

import android.location.LocationManager;

import android.os.Build;

import android.support.annotation.RequiresApi;

import android.support.v4.app.ActivityCompat;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    protected LocationManager locationManager;

    protected LocationListener locationListener;

    TextView txtLat;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtLat = (TextView) findViewById(R.id.loading);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=

                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,

                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;

        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override

    public void onLocationChanged(Location location) {

        txtLat = (TextView) findViewById(R.id.loading);

        txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());

    }

    @Override

    public void onStatusChanged(String s, int i, Bundle bundle) {

        Log.d("Latitude","status");

    }

    @Override

    public void onProviderEnabled(String s) {

        Log.d("Latitude","enable" );

    }

    @Override

    public void onProviderDisabled(String s) {

        Log.d("Latitude", "disable");

    }

}