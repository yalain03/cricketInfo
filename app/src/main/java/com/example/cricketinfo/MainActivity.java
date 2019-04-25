package com.example.cricketinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PlayerAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PlayerAdapter();
        listView = (ListView) findViewById(R.id.list_item);

        adapter.addItem("Sachin Rana", 33757);
        adapter.addItem("Sachin Tendulkar", 35320);
        adapter.addItem("Madawa Warnapura", 359200);
        adapter.addItem("Sachin Baby", 432783);
        adapter.addItem("Sachin Peiris", 507904);
        adapter.addItem("Sachin Mylavarapy", 646869);
        adapter.addItem("Sachini de Silva", 684479);
        adapter.addItem("Sachini Sewwandi", 684611);
        adapter.addItem("Sachin Jayawardena", 729669);
        adapter.addItem("Sachin Jha", 913833);
        adapter.addItem("Sachini Nisansala", 924289);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String playerId = Integer.toString(((PlayerItemView)view).getPlayerId());
//                Toast.makeText(getApplicationContext(), playerId, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
                intent.putExtra("id", playerId);
                startActivity(intent);
            }
        });
    }

    class PlayerAdapter extends BaseAdapter {
        ArrayList<PlayerItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            PlayerItemView view = new PlayerItemView(getApplicationContext());

            PlayerItem item = items.get(position);
            view.setValue(item.getName());
            view.setPlayerId(item.getId());

            return view;
        }

        public void addItem(String value, int id) {
            items.add(new PlayerItem(value, id));
        }

        public ArrayList<PlayerItem> getItems() {
            return items;
        }
    }
}
