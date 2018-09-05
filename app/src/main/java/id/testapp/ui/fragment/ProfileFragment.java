package id.testapp.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.testapp.R;

public class ProfileFragment extends Fragment {
    private SharedPreferences loginPref;
    private String name, email, gender, phone;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPref = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

        name = loginPref.getString("name", "");
        email = loginPref.getString("email", "");
        gender = loginPref.getString("gender", "");
        phone = loginPref.getString("phone", "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView textViewName = view.findViewById(R.id.text_view_name);
        TextView textViewEmail = view.findViewById(R.id.text_view_email);
        TextView textViewPhone = view.findViewById(R.id.text_view_phone);
        TextView textViewGender = view.findViewById(R.id.text_view_gender);


        textViewName.setText(name);
        textViewEmail.setText(email);
        textViewGender.setText(gender);
        textViewPhone.setText(phone);
        return view;
    }
}
