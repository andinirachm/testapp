package id.testapp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.testapp.R;
import id.testapp.model.CityModel;
import id.testapp.presenter.HomePresenter;
import id.testapp.ui.activity.PagerActivity;
import id.testapp.ui.adapter.ListAdapter;
import id.testapp.view.HomeView;

public class HomeFragment extends Fragment implements HomeView, ListAdapter.ClickListener {
    private HomePresenter presenter;
    private RecyclerView recyclerView;
    private ArrayList<CityModel> cityList = new ArrayList<>();
    private ListAdapter adapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        adapter = new ListAdapter(getActivity(), cityList);
        adapter.setOnItemClickListener(this);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        presenter = new HomePresenter();
        presenter.onAttachView(this);
        presenter.createDummyData();
        return view;
    }

    @Override
    public void onCreateDummyData(List<CityModel> cityList) {
        this.cityList.addAll(cityList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position, View v) {
        Intent i = new Intent(getActivity(), PagerActivity.class);
        i.putExtra("position", position);
        i.putExtra("city_list", cityList);
        startActivity(i);

    }
}
