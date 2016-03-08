package kr.co.company.mapmarker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapMarkerActivity extends FragmentActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * 여기서 마커를 추가한다.
     */
    private void setUpMap() {
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(37.555, 126.970));
        marker.title("Marker");
        marker.draggable(true);
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant));
        mMap.addMarker(marker);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMap.setMyLocationEnabled(false);
    }
}
