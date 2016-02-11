package android.dxs.com.packagedapp.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Deepak Sharma on 1/27/2016.
 */
public class RecyclerDataModel implements Parcelable{
    private int index;
    private boolean isChecked;
    private List<SubModel> mList;

    private RecyclerDataModel(Parcel in) {
        index = in.readInt();
        isChecked = in.readByte() != 0;
    }

    public RecyclerDataModel(int index, boolean isChecked)
    {
        this.index     = index;
        this.isChecked = isChecked;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<RecyclerDataModel> CREATOR
            = new Parcelable.Creator<RecyclerDataModel>() {
        public RecyclerDataModel createFromParcel(Parcel in) {
            return new RecyclerDataModel(in);
        }

        public RecyclerDataModel[] newArray(int size) {
            return new RecyclerDataModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeInt(isChecked ? 0 : 1 );
    }
}
