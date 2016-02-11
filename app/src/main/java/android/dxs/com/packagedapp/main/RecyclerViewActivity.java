package android.dxs.com.packagedapp.main;

import android.dxs.com.packagedapp.R;
import android.dxs.com.packagedapp.base.ui.activities.BaseActivity;
import android.dxs.com.packagedapp.main.adapter.RecyclerAdapter;
import android.dxs.com.packagedapp.main.interfaces.IClickable;
import android.dxs.com.packagedapp.main.model.RecyclerDataModel;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by NovoTemp on 1/27/2016.
 */
public class RecyclerViewActivity extends BaseActivity implements IClickable{

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public IClickable iClickable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<RecyclerDataModel> data = new ArrayList<>();
        for (int i=0; i<50; i++)
        {
            data.add(new RecyclerDataModel((i+1), false));
        }
        mRecyclerAdapter = new RecyclerAdapter(RecyclerViewActivity.this);
        mRecyclerAdapter.setData(data, R.layout.recycler_item, new RecyclerAdapter.IClickable() {
            @Override
            public void init(View view) {

            }

            @Override
            public void execute(View view, Object object) {
            //    Toast.makeText(RecyclerViewActivity.this, "Click performed", Toast.LENGTH_SHORT).show();

                final RecyclerDataModel model = (RecyclerDataModel)object;

                RelativeLayout row = (RelativeLayout)view.findViewById(R.id.row);
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RecyclerViewActivity.this, "Row clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                ImageView imgIcon = (ImageView)view.findViewById(R.id.imageView);
                imgIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RecyclerViewActivity.this, "Image clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked)
                        {
                            model.setIsChecked(true);
                        }
                        /*else
                        {
                            model.setIsChecked(false);
                        }*/
                    }
                });
            }
        });
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void init(View view) {

    }

    @Override
    public void execute(View view, Object object) {

    }
}
