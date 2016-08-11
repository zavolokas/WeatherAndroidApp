package com.zavolokas.tryapp.tryapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private static final String DETAIL_ACTIVITY_FRAGMENT_TAG = "DetActFrgmtLog";

    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "register options");
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();
        if (intent!=null && intent.hasExtra(Intent.EXTRA_TEXT) ){
            String forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView textView = (TextView) rootView.findViewById(R.id.forecast_text_detail);
            textView.setText(forecast);
        }

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "option selected");

        if (item.getItemId() == R.id.action_settings_menu_item){
            Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "settings selected");
            Intent intent = new Intent(getActivity(), SettingsActivity.class);
            startActivity(intent);
            Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "activity started");
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
