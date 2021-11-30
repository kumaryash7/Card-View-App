package com.example.cardview;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import com.bumptech.glide.load.engine.Resource;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cardview.databinding.ActivityScrollingBinding;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
 private List<AppsModel> appList;
 private AppsAdapter adapter;
 private RecyclerView recyclerView;

    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView =findViewById(R.id.recycler_view);
        appList = new ArrayList<>();
        adapter = new AppsAdapter(this,appList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setAdapter(adapter);


        // PREPARING THE CARDS
        InsertDataIntoCards();
    }

    private void InsertDataIntoCards() {

        int [] appscovers = new int[]{
  R.drawable.imageeee,R.drawable.interstellar_poster,R.drawable.sajna_poster,R.drawable.play_date_poster,R.drawable.sky,R.drawable.sky2,R.drawable.tujhe_kitna_chahne_lage_hum_postee
        };

        AppsModel a = new AppsModel("Master Song App",800000,appscovers[0]);
        appList.add(a);

        a= new AppsModel("Master Song Pro",800,appscovers[1]);
        appList.add(a);

        a = new AppsModel("Master Java ", 450,appscovers[2]);
        appList.add(a);

        a = new AppsModel("Naviation",71000,appscovers[3]);
        appList.add(a);

        a = new AppsModel("Subscribe",235482,appscovers[4]);
        appList.add(a);

        a = new AppsModel("Like",1000000,appscovers[5]);
        appList.add(a);


        //Don't Miss to  notify the data change

        adapter.notifyDataSetChanged();



    }

    private int dpToPx(int dp) {                 // SIMPLE METHOD TO CONVERT DP TO PIXELS
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount,int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.includeEdge=includeEdge;
            this.spacing=spacing;

        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {


            int positon = parent.getChildAdapterPosition(view);
            int column = positon%spanCount;
            if(includeEdge){
                outRect.left=spacing -column *spacing/spanCount;
                outRect.right = (column+1)*spacing/spanCount;

                if(positon<spanCount){
                    outRect.top=spacing;
                }
                outRect.bottom=spacing;

            }else {
                outRect.left= column*spacing/spanCount;
                outRect.right= spacing-(column+1)*spacing/spanCount;
                if (positon>=spanCount){
                    outRect.top=spacing;

                }
            }


        }
    }
}