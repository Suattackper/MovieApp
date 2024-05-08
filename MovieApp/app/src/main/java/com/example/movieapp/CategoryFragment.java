package com.example.movieapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.movieapp.adapter.MovieHomeCategoryAdapter;
import com.example.movieapp.adapter.MovieHomeCategoryNAdapter;
import com.example.movieapp.api.ApiService;
import com.example.movieapp.databinding.FragmentCategoryBinding;
import com.example.movieapp.databinding.FragmentHomeBinding;
import com.example.movieapp.model.MovieSearch;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    FragmentCategoryBinding binding;
    int currentPage = 1;
    String danhsach = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        // Lấy dữ liệu từ Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String category = bundle.getString("category");
            danhsach = bundle.getString("danhsach");

            binding.tvCate.setText(category);

            getData(danhsach);
            addEvents();

        }

        return view;
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getActionMasked();
//
//        switch(action) {
//            case MotionEvent.ACTION_DOWN:
//                // Xử lý khi người dùng chạm xuống màn hình
//                break;
//            case MotionEvent.ACTION_MOVE:
//                // Xử lý khi người dùng di chuyển trên màn hình
//                break;
//            case MotionEvent.ACTION_UP:
//                // Xử lý khi người dùng rời tay khỏi màn hình
//                break;
//            default:
//                return super.onTouchEvent(event);
//        }
//
//        return true; // Trả về true để báo cho hệ thống biết rằng sự kiện đã được xử lý
//    }
    private void addEvents() {
        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        binding.rcvCateN.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    // RecyclerView đã cuộn tới cuối danh sách
                    // Thực hiện các hành động bạn muốn ở đây
                    currentPage++;
                    getlistcategoryn(danhsach,binding.rcvCateN,currentPage);
                }

            }
        });
    }

    private void getData(String danhsach) {
        getlistcategoryd(danhsach,binding.rcvCateD);
        getlistcategoryn(danhsach,binding.rcvCateN,currentPage);
    }
    private void getlistcategoryn(String s, RecyclerView rcv, int page) {
        ApiService.apiService.getMovieListCategory(s,page).enqueue(new Callback<MovieSearch>() {
            @Override
            public void onResponse(Call<MovieSearch> call, Response<MovieSearch> response) {
                if (response.isSuccessful()) {
                    try {
                        MovieSearch movieSearch = response.body();

                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

                        MovieHomeCategoryNAdapter adapter = new MovieHomeCategoryNAdapter(movieSearch.getData().getItems(), getContext(),movieSearch.getData().getAPP_DOMAIN_CDN_IMAGE());

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
    private void getlistcategoryd(String s, RecyclerView rcv) {
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