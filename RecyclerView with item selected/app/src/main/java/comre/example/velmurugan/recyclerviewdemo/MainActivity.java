package comre.example.velmurugan.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerTouchListener recycleCTouchListener;
    private RecyclerviewItemAdapter recyclerviewItemAdapter;

    private List<Items> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycleView);

        recyclerviewItemAdapter = new RecyclerviewItemAdapter(itemsList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),itemsList.get(position).getName()+" selected ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(),itemsList.get(position).getName()+" long pressed ",Toast.LENGTH_SHORT).show();
            }
        }));
        prepareItems();
    }

    private void prepareItems(){
        Items items = new Items("Pen",20);
        itemsList.add(items);
        items = new Items("Pencil",5);
        itemsList.add(items);
        items = new Items("Book",30);
        itemsList.add(items);
        items = new Items("ink",15);
        itemsList.add(items);
        items = new Items("scale",10);
        itemsList.add(items);
        recyclerviewItemAdapter.notifyDataSetChanged();
    }
}
