package layout;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.zavolokas.tryapp.tryapp.DetailActivity;
import com.zavolokas.tryapp.tryapp.R;
import com.zavolokas.tryapp.tryapp.SettingsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class ForecastFragment extends Fragment {

    ArrayAdapter<String> _adapter;

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

        ArrayList<String> lst = new ArrayList<String>(Arrays.asList(data));

        _adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, lst);

        ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String forecast = _adapter.getItem(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, forecast);
                startActivity(intent);
            }
        });

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
            FetchWeatherTask task = new FetchWeatherTask(_adapter);
            task.execute("94043");
            return true;
        }

        if (item.getItemId() == R.id.action_setting){
//            Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "settings selected");
            Intent intent = new Intent(getActivity(), SettingsActivity.class);
            startActivity(intent);
//            Log.e(DETAIL_ACTIVITY_FRAGMENT_TAG, "activity started");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
