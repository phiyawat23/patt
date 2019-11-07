package bank.ruts.ac.th.patt;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class GPSTracker extends Service implements LocationListener {
    private final Context context;
    public GPSTracker(Context context) {
        this.context = context;
    }
    boolean gpsenable = false;
    boolean networkenable = false;
    boolean getlocation = false;

    Location location;
    protected LocationManager locationmanager;

    public Location getLocation(){
        try{
            locationmanager = (LocationManager)context.getSystemService(LOCATION_SERVICE);
            gpsenable = locationmanager.isProviderEnabled(locationmanager.GPS_PROVIDER);
            networkenable = locationmanager.isProviderEnabled(locationmanager.NETWORK_PROVIDER);

            if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED||ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                //found
                if(gpsenable){
                    if(location == null){
                        locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,100000, 10, this);
                        // not found
                        if(locationmanager != null){
                            location = locationmanager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }
                    }
                }

                if(location == null){
                    if(networkenable){
                        locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 10, this);
                        if(locationmanager != null){
                            location = locationmanager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }
        return location;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
