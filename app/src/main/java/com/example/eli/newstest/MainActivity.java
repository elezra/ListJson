package com.example.eli.newstest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MainActivity extends Activity {
    private ListAdapter adapter;
    private ArrayList<ItemNews> newsItems;
    private ArrayList<ItemNews> adapterNewsItems;
    private Button btnAdd;
    private ListView myListView;
    private String formula_value;
    private String url_value;
    private int listPos;
    private ItemNews newItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btn_add);
        myListView = (ListView) findViewById(R.id.listView);

        adapterNewsItems = new ArrayList<ItemNews>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("formules");

            newsItems = new ArrayList<>();

            for (int i = 0; i < m_jArry.length(); i++) {

                JSONObject jo_inside = m_jArry.getJSONObject(i);
                formula_value = jo_inside.getString("formule");
                url_value = jo_inside.getString("url");


                newsItems.add(new ItemNews(formula_value, url_value));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrayList.add(new ItemNews(formula_value,url_value));
                //adapter.notifyDataSetChanged();

                if (newsItems.size()>listPos) {
                    newItem = newsItems.get(listPos);
                    if (newItem.getUrl().equals("qp5")){
                        adapterNewsItems.remove(1);
                    }


                    if (!newItem.getUrl().equals("qp6")){
                        adapterNewsItems.add(new ItemNews(newItem.getFormule(), newItem.getUrl()));
                        adapter.notifyDataSetChanged();
                    }
                    else {
                        ItemNews indexItem = new ItemNews(newItem.getFormule(),newItem.getUrl());
                        adapterNewsItems.add(0,indexItem);
                        adapter.notifyDataSetChanged();
                    }
                    listPos++;
                }
            }
        });



        adapter = new ListAdapter(MainActivity.this, adapterNewsItems);
        myListView.setAdapter(adapter);

    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
