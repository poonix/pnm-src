package com.example.saifullah_albasrie.pnm.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.ui.customview.WorkaroundMapFragment;
import com.example.saifullah_albasrie.pnm.utils.PermissionUtil;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

/**
 * Created by saifullahalbasrie on 6/5/17.
 */

public class MapViewFragment extends Fragment implements OnMapReadyCallback{

    private int formMode;
    private LatLng markerLatlng;
    private LatLng gpsLatLng;

    private MapView mMapView;
    private GoogleMap googleMap;
    private View ll_btn_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_layout, container, false);
        ll_btn_search = rootView.findViewById(R.id.ll_btn_search);
        ll_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAutocompleteActivity();
            }
        });

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(this);

        TouchableWrapper frameLayout = new TouchableWrapper(getActivity());

        frameLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        ((ViewGroup) rootView).addView(frameLayout,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMapView != null) {
            mMapView.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMapView != null) {
            mMapView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMapView != null) {
            mMapView.onPause();
        }
    }


    @Override
    public void onDestroy() {
        if (mMapView != null) {
            mMapView.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mMapView != null) {
            mMapView.onLowMemory();
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.googleMap = map;
        LatLng markerPosition = new LatLng(-6.1875635, 106.8206277); //Jakarta
        if (markerLatlng != null) {
            markerPosition = markerLatlng;
        }
        setMarkerPosition(markerPosition);

        if (formMode == FormMode.VIEW)
            setEnableMap(false);
        else
            setEnableMap(true);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (formMode != FormMode.VIEW) {
                    markerLatlng = latLng;
                    setMarkerPosition(latLng);
                }

            }
        });

    }

    public void setEnableMap(boolean enable) {
        if (!enable) {
            formMode = FormMode.VIEW;
            if (ll_btn_search != null) {
                ll_btn_search.setVisibility(View.GONE);
            }
        } else {
            formMode = FormMode.EDIT;
            if (ll_btn_search != null) {
                ll_btn_search.setVisibility(View.VISIBLE);
            }
        }

        if (getContext() != null && !PermissionUtil.isPermissionGpsGranted(getContext())) {
            //PermissionUtil.checkGPSPermission(getActivity());
            //return;
        }

        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
            googleMap.getUiSettings().setRotateGesturesEnabled(enable);
            googleMap.getUiSettings().setMyLocationButtonEnabled(enable);
        }
    }

    public LatLng getGpsLatLng() {
        return gpsLatLng;
    }

    public LatLng getMarkerLatlng() {
        return markerLatlng;
    }

    public void setMarkerLatlng(LatLng markerLatlng) {
        this.markerLatlng = markerLatlng;
        setMarkerPosition(markerLatlng);
    }

    private void setMarkerPosition(LatLng markerPosition) {
        setMarkerPosition(markerPosition, true);
    }

    private void setMarkerPosition(LatLng markerPosition, boolean fetchAddress) {

        if (googleMap != null) {
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions()
                    .position(markerPosition)
                    .title("Lokasi"));

            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(markerPosition)
                    .zoom(16)
                    .bearing(0)
                    .tilt(45)
                    .build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1000, null);
            if (fetchAddress) {
                fetchAddress(markerPosition);
            }

        }

    }

    private void fetchAddress(final LatLng mLatLng){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Geocoder gcd = new Geocoder(getActivity(), Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = gcd.getFromLocation(mLatLng.latitude, mLatLng.longitude, 1);
                    if (addresses!= null) {
                        Log.d("fetchAddress", addresses.toString());
                    }
                    /*if(tvLokasiUsaha!=null) {
                        if (addresses != null && addresses.size() > 0) {
                            String alamat = addresses.get(0).getAddressLine(0);

                            tvLokasiUsaha.setText(alamat);
                        } else {
                            tvLokasiUsaha.setText("");
                        }
                    }*/

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    private LocationManager locationManager;

    private void initGps() {
        locationManager = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);

        if (!PermissionUtil.isPermissionGpsGranted(getContext())) {
            PermissionUtil.checkGPSPermission(getActivity());
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 3, gpsListener);

    }

    private LocationListener gpsListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            gpsLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (markerLatlng == null) {
                setMarkerPosition(gpsLatLng);
            }

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private static final int REQUEST_CODE_AUTOCOMPLETE = 601;
    private void openAutocompleteActivity() {
        if (getActivity() == null)
            return;

        try {
            // The autocomplete activity requires Google Play Services to be available. The intent
            // builder checks this and throws an exception if it is not the case.
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .build(getActivity());
            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
        } catch (GooglePlayServicesRepairableException e) {
            // Indicates that Google Play Services is either not installed or not up to date. Prompt
            // the user to correct the issue.
            GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), e.getConnectionStatusCode(),
                    0 /* requestCode */).show();
        } catch (GooglePlayServicesNotAvailableException e) {
            // Indicates that Google Play Services is not available and the problem is not easily
            // resolvable.
            String message = "Google Play Services is not available: " +
                    GoogleApiAvailability.getInstance().getErrorString(e.errorCode);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Called after the autocomplete activity has finished to return its result.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that the result was from the autocomplete widget.
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == getActivity().RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                Log.i("LOG", "Place Selected: " + place.getName());

                if(place!=null) {
                    setMarkerPosition(place.getLatLng());
                    /*if (tvLokasiUsaha != null) {
                        tvLokasiUsaha.setText(place.getAddress());
                    } else {
                        tvLokasiUsaha.setText("");
                    }*/
                }

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getContext(), data);
                Log.e("LOG", "Error: Status = " + status.toString());
            } else if (resultCode == getActivity().RESULT_CANCELED) {
                // Indicates that the activity closed before a selection was made. For example if
                // the user pressed the back button.
            }
        }
    }

    private OnTouchListener mListener;

    public void setListener(OnTouchListener listener) {
        mListener = listener;
    }

    public interface OnTouchListener {
        public abstract void onTouch();
    }

    public class TouchableWrapper extends FrameLayout {

        public TouchableWrapper(Context context) {
            super(context);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mListener.onTouch();
                    break;
                case MotionEvent.ACTION_UP:
                    mListener.onTouch();
                    break;
            }
            return super.dispatchTouchEvent(event);
        }
    }
}
