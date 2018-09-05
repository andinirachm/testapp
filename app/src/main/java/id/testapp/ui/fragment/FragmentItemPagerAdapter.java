package id.testapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.testapp.R;
import id.testapp.model.CityModel;

public class FragmentItemPagerAdapter extends FragmentStatePagerAdapter {
    private List<CityModel> data;

    public FragmentItemPagerAdapter(FragmentManager fm, List<CityModel> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(PageFragment.NAME, data.get(position).getName());
        args.putString(PageFragment.IMAGEURL, data.get(position).getImageUrl());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public static class PageFragment extends Fragment {
        public static final String NAME = "name";
        public static final String IMAGEURL = "imageurl";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_item, container, false);
            ImageView imageView = view.findViewById(R.id.image_view);
            Picasso.get()
                    .load(getArguments().getString(IMAGEURL))
                    .into(imageView);

            return view;
        }
    }
}
