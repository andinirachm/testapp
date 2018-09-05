package id.testapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import id.testapp.R;
import id.testapp.model.CityModel;
import id.testapp.ui.fragment.FragmentItemPagerAdapter;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        ViewPager viewPager = findViewById(R.id.pager_view);
        TabLayout tabSelector= findViewById(R.id.tab_selector);

        int currentPosition = getIntent().getIntExtra("position", 0);
        List<CityModel> cityList = getIntent().getParcelableArrayListExtra("city_list");

        FragmentItemPagerAdapter fragmentItemPagerAdapter = new FragmentItemPagerAdapter(getSupportFragmentManager(), cityList);
        viewPager.setAdapter(fragmentItemPagerAdapter);
        viewPager.setCurrentItem(currentPosition);

        tabSelector.setupWithViewPager(viewPager);
    }
}
