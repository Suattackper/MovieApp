package com.example.movieapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.movieapp.CategoryFragment;
import com.example.movieapp.R;
import com.example.movieapp.adapter.MovieHomeAdapter;
import com.example.movieapp.adapter.MovieHomeCategoryAdapter;
import com.example.movieapp.adapter.MovieSearchItemAdapter;
import com.example.movieapp.api.ApiService;
import com.example.movieapp.databinding.FragmentHomeBinding;
import com.example.movieapp.databinding.FragmentSearchBinding;
import com.example.movieapp.model.Item;
import com.example.movieapp.model.MovieList;
import com.example.movieapp.model.MovieSearch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        addEvents();
        getData();

        return view;
    }

    private void addEvents() {
        binding.btnPhimBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Fragment và truyền dữ liệu nếu cần
                CategoryFragment fragment = new CategoryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("category", "Phim bộ");
                bundle.putString("danhsach", "phim-bo");
                fragment.setArguments(bundle);

                // Truy cập FragmentManager từ FragmentActivity hoặc AppCompatActivity và thực hiện giao dịch
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment); // frameLayout là id của container cho Fragment
                transaction.addToBackStack(null); // (Optional) Đưa Fragment vào Stack để quay lại
                transaction.commit();
            }
        });
        binding.btnPhimLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Fragment và truyền dữ liệu nếu cần
                CategoryFragment fragment = new CategoryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("category", "Phim lẻ");
                bundle.putString("danhsach", "phim-le");
                fragment.setArguments(bundle);

                // Truy cập FragmentManager từ FragmentActivity hoặc AppCompatActivity và thực hiện giao dịch
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment); // frameLayout là id của container cho Fragment
                transaction.addToBackStack(null); // (Optional) Đưa Fragment vào Stack để quay lại
                transaction.commit();
            }
        });
        binding.btnTVShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Fragment và truyền dữ liệu nếu cần
                CategoryFragment fragment = new CategoryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("category", "TVShows");
                bundle.putString("danhsach", "tv-shows");
                fragment.setArguments(bundle);

                // Truy cập FragmentManager từ FragmentActivity hoặc AppCompatActivity và thực hiện giao dịch
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment); // frameLayout là id của container cho Fragment
                transaction.addToBackStack(null); // (Optional) Đưa Fragment vào Stack để quay lại
                transaction.commit();
            }
        });
        binding.btnAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Fragment và truyền dữ liệu nếu cần
                CategoryFragment fragment = new CategoryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("category", "Anime");
                bundle.putString("danhsach", "hoat-hinh");
                fragment.setArguments(bundle);

                // Truy cập FragmentManager từ FragmentActivity hoặc AppCompatActivity và thực hiện giao dịch
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment); // frameLayout là id của container cho Fragment
                transaction.addToBackStack(null); // (Optional) Đưa Fragment vào Stack để quay lại
                transaction.commit();
            }
        });
    }

    private void getData() {
        getlistnewupdate(binding.rcvPhimMoiCatNhat);
        getlistcategory("phim-le",binding.rcvPhimLe);
        getlistcategory("phim-bo",binding.rcvPhimBo);
        getlistcategory("tv-shows",binding.rcvTVShow);
        getlistcategory("hoat-hinh",binding.rcvAnime);
    }

    private void getlistnewupdate(RecyclerView rcv) {
        ApiService.apiService.getMovieList(1).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if (response.isSuccessful()) {
                    try {
                        MovieList movielist = response.body();

                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

                        MovieHomeAdapter adapter = new MovieHomeAdapter(movielist.getItems(), getContext());
                        rcv.setLayoutManager(manager);
                        rcv.setAdapter(adapter);

                    }
                    catch (Exception e){
                        Log.e("HomeFragment", e.getMessage());
                    }
                } else {
                    Toast.makeText(getContext(), "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MovieList> call, Throwable throwable) {
                Toast.makeText(getContext(), "Có lỗi xảy raa", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getlistcategory(String s, RecyclerView rcv) {
        ApiService.apiService.getMovieListCategory(s,1).enqueue(new Callback<MovieSearch>() {
            @Override
            public void onResponse(Call<MovieSearch> call, Response<MovieSearch> response) {
                if (response.isSuccessful()) {
                    try {
                        MovieSearch movieSearch = response.body();

                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

                        MovieHomeCategoryAdapter adapter = new MovieHomeCategoryAdapter(movieSearch.getData().getItems(), getContext(),movieSearch.getData().getAPP_DOMAIN_CDN_IMAGE());

                        rcv.setLayoutManager(manager);
                        rcv.setAdapter(adapter);

                    }
                    catch (Exception e){
                        Log.e("HomeFragment", e.getMessage());
                    }
                } else {
                    Toast.makeText(getContext(), "Có lỗi xảy ra1", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MovieSearch> call, Throwable throwable) {
                Toast.makeText(getContext(), "Có lỗi xảy raa1", Toast.LENGTH_SHORT).show();
            }
        });
    }
}