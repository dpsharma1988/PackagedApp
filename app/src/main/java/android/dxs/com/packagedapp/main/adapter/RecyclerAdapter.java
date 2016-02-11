package android.dxs.com.packagedapp.main.adapter;

import android.content.Context;
import android.dxs.com.packagedapp.R;
import android.dxs.com.packagedapp.main.model.RecyclerDataModel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deepak Sharma on 1/27/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<RecyclerDataModel> mItems;
    private Context context;
    private int mLayout;
    IClickable iClickable;

    public RecyclerAdapter(Context context)
    {
        this.context = context;
    }
    public void setData(List<RecyclerDataModel> items, int layout, IClickable iClickable)
    {
        mItems = items;
        this.mLayout = layout;
        this.iClickable = iClickable;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(mLayout, viewGroup, false);
        iClickable.init(view);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mRow = (RelativeLayout)view.findViewById(R.id.row);
        viewHolder.mCheckBox = (CheckBox)view.findViewById(R.id.checkBox);
        viewHolder.mRow.setTag(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
          viewHolder.mCheckBox.setChecked(mItems.get(i).isChecked());
          iClickable.execute((View)viewHolder.mRow.getTag(), mItems.get(i));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;
        private CheckBox mCheckBox;
        private RelativeLayout mRow;

        ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.list_item);
        }
    }

    public interface IClickable<T> {
        public void init(View view);
        public void execute(View view, T object);
    }

}