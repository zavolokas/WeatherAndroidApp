package layout;

import android.app.LauncherActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zavolokas.tryapp.tryapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastFragment extends Fragment {


    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] data = new String[] {"Today - Sunny - 88/63", "Tomorrow - Cloudy - 45/56",
                "Wed - Sunny - 45/32", "Thu - Sunny - 46/34", "Fri - Cloudy - 34/34",
                "Sat - Cloudy - 324/24", "Sun - Sunny - 65/23"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, data);

        ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(adapter);

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_refresh) {
            FetchWeatherTask task = new FetchWeatherTask();
            task.execute("94043");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}