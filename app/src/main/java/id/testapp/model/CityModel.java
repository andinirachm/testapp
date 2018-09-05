package id.testapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CityModel implements Parcelable {
    private int id;
    private String name;
    private String imageUrl;

    public CityModel(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public CityModel(Parcel in){
        this.id = in.readInt();
        this.name = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Creator<CityModel> CREATOR = new Creator<CityModel>() {
        @Override
        public CityModel createFromParcel(Parcel in) {
            return new CityModel(in);
        }

        @Override
        public CityModel[] newArray(int size) {
            return new CityModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(imageUrl);
    }
}
