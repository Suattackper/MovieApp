// Generated by view binder compiler. Do not edit!
package com.example.movieapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.movieapp.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMovieDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView btnBookmark;

  @NonNull
  public final LinearLayout btnDownload;

  @NonNull
  public final LinearLayout btnPlay;

  @NonNull
  public final ImageView btnShare;

  @NonNull
  public final NestedScrollView contentLayout;

  @NonNull
  public final LinearLayout genresLayout;

  @NonNull
  public final ConstraintLayout imgLayoutBannerTop;

  @NonNull
  public final ImageView imvBackButton;

  @NonNull
  public final ImageView imvBackDrop;

  @NonNull
  public final LinearLayout layoutsingle;

  @NonNull
  public final RecyclerView rcvDanhSachTap;

  @NonNull
  public final TabLayout tabLayoutMore;

  @NonNull
  public final View tabLine;

  @NonNull
  public final TextView titleMovieName;

  @NonNull
  public final ConstraintLayout toolbar;

  @NonNull
  public final TextView tvActor;

  @NonNull
  public final TextView tvDanhSachTap;

  @NonNull
  public final TextView tvDirector;

  @NonNull
  public final TextView tvGenreMovie;

  @NonNull
  public final ReadMoreTextView tvOverViewMore;

  @NonNull
  public final TextView tvTime;

  @NonNull
  public final TextView tvTypeMovie;

  @NonNull
  public final ViewPager2 viewPager;

  private FragmentMovieDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView btnBookmark, @NonNull LinearLayout btnDownload,
      @NonNull LinearLayout btnPlay, @NonNull ImageView btnShare,
      @NonNull NestedScrollView contentLayout, @NonNull LinearLayout genresLayout,
      @NonNull ConstraintLayout imgLayoutBannerTop, @NonNull ImageView imvBackButton,
      @NonNull ImageView imvBackDrop, @NonNull LinearLayout layoutsingle,
      @NonNull RecyclerView rcvDanhSachTap, @NonNull TabLayout tabLayoutMore, @NonNull View tabLine,
      @NonNull TextView titleMovieName, @NonNull ConstraintLayout toolbar,
      @NonNull TextView tvActor, @NonNull TextView tvDanhSachTap, @NonNull TextView tvDirector,
      @NonNull TextView tvGenreMovie, @NonNull ReadMoreTextView tvOverViewMore,
      @NonNull TextView tvTime, @NonNull TextView tvTypeMovie, @NonNull ViewPager2 viewPager) {
    this.rootView = rootView;
    this.btnBookmark = btnBookmark;
    this.btnDownload = btnDownload;
    this.btnPlay = btnPlay;
    this.btnShare = btnShare;
    this.contentLayout = contentLayout;
    this.genresLayout = genresLayout;
    this.imgLayoutBannerTop = imgLayoutBannerTop;
    this.imvBackButton = imvBackButton;
    this.imvBackDrop = imvBackDrop;
    this.layoutsingle = layoutsingle;
    this.rcvDanhSachTap = rcvDanhSachTap;
    this.tabLayoutMore = tabLayoutMore;
    this.tabLine = tabLine;
    this.titleMovieName = titleMovieName;
    this.toolbar = toolbar;
    this.tvActor = tvActor;
    this.tvDanhSachTap = tvDanhSachTap;
    this.tvDirector = tvDirector;
    this.tvGenreMovie = tvGenreMovie;
    this.tvOverViewMore = tvOverViewMore;
    this.tvTime = tvTime;
    this.tvTypeMovie = tvTypeMovie;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMovieDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMovieDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_movie_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMovieDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBookmark;
      ImageView btnBookmark = ViewBindings.findChildViewById(rootView, id);
      if (btnBookmark == null) {
        break missingId;
      }

      id = R.id.btnDownload;
      LinearLayout btnDownload = ViewBindings.findChildViewById(rootView, id);
      if (btnDownload == null) {
        break missingId;
      }

      id = R.id.btnPlay;
      LinearLayout btnPlay = ViewBindings.findChildViewById(rootView, id);
      if (btnPlay == null) {
        break missingId;
      }

      id = R.id.btnShare;
      ImageView btnShare = ViewBindings.findChildViewById(rootView, id);
      if (btnShare == null) {
        break missingId;
      }

      id = R.id.contentLayout;
      NestedScrollView contentLayout = ViewBindings.findChildViewById(rootView, id);
      if (contentLayout == null) {
        break missingId;
      }

      id = R.id.genresLayout;
      LinearLayout genresLayout = ViewBindings.findChildViewById(rootView, id);
      if (genresLayout == null) {
        break missingId;
      }

      id = R.id.imgLayoutBannerTop;
      ConstraintLayout imgLayoutBannerTop = ViewBindings.findChildViewById(rootView, id);
      if (imgLayoutBannerTop == null) {
        break missingId;
      }

      id = R.id.imvBackButton;
      ImageView imvBackButton = ViewBindings.findChildViewById(rootView, id);
      if (imvBackButton == null) {
        break missingId;
      }

      id = R.id.imvBackDrop;
      ImageView imvBackDrop = ViewBindings.findChildViewById(rootView, id);
      if (imvBackDrop == null) {
        break missingId;
      }

      id = R.id.layoutsingle;
      LinearLayout layoutsingle = ViewBindings.findChildViewById(rootView, id);
      if (layoutsingle == null) {
        break missingId;
      }

      id = R.id.rcvDanhSachTap;
      RecyclerView rcvDanhSachTap = ViewBindings.findChildViewById(rootView, id);
      if (rcvDanhSachTap == null) {
        break missingId;
      }

      id = R.id.tabLayout_More;
      TabLayout tabLayoutMore = ViewBindings.findChildViewById(rootView, id);
      if (tabLayoutMore == null) {
        break missingId;
      }

      id = R.id.tabLine;
      View tabLine = ViewBindings.findChildViewById(rootView, id);
      if (tabLine == null) {
        break missingId;
      }

      id = R.id.titleMovieName;
      TextView titleMovieName = ViewBindings.findChildViewById(rootView, id);
      if (titleMovieName == null) {
        break missingId;
      }

      id = R.id.toolbar;
      ConstraintLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvActor;
      TextView tvActor = ViewBindings.findChildViewById(rootView, id);
      if (tvActor == null) {
        break missingId;
      }

      id = R.id.tvDanhSachTap;
      TextView tvDanhSachTap = ViewBindings.findChildViewById(rootView, id);
      if (tvDanhSachTap == null) {
        break missingId;
      }

      id = R.id.tvDirector;
      TextView tvDirector = ViewBindings.findChildViewById(rootView, id);
      if (tvDirector == null) {
        break missingId;
      }

      id = R.id.tvGenreMovie;
      TextView tvGenreMovie = ViewBindings.findChildViewById(rootView, id);
      if (tvGenreMovie == null) {
        break missingId;
      }

      id = R.id.tvOverView_More;
      ReadMoreTextView tvOverViewMore = ViewBindings.findChildViewById(rootView, id);
      if (tvOverViewMore == null) {
        break missingId;
      }

      id = R.id.tvTime;
      TextView tvTime = ViewBindings.findChildViewById(rootView, id);
      if (tvTime == null) {
        break missingId;
      }

      id = R.id.tvTypeMovie;
      TextView tvTypeMovie = ViewBindings.findChildViewById(rootView, id);
      if (tvTypeMovie == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager2 viewPager = ViewBindings.findChildViewById(rootView, id);
      if (viewPager == null) {
        break missingId;
      }

      return new FragmentMovieDetailBinding((ConstraintLayout) rootView, btnBookmark, btnDownload,
          btnPlay, btnShare, contentLayout, genresLayout, imgLayoutBannerTop, imvBackButton,
          imvBackDrop, layoutsingle, rcvDanhSachTap, tabLayoutMore, tabLine, titleMovieName,
          toolbar, tvActor, tvDanhSachTap, tvDirector, tvGenreMovie, tvOverViewMore, tvTime,
          tvTypeMovie, viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
