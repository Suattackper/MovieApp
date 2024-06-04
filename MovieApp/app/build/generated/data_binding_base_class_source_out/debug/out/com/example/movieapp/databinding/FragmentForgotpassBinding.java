// Generated by view binder compiler. Do not edit!
package com.example.movieapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.movieapp.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentForgotpassBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton btnSignin;

  @NonNull
  public final TextInputEditText editEmail;

  @NonNull
  public final AppCompatImageView imvBack;

  @NonNull
  public final AppCompatImageView imvLogoApp;

  @NonNull
  public final ConstraintLayout lyDescIntro;

  @NonNull
  public final ConstraintLayout lySigninAuth;

  @NonNull
  public final ConstraintLayout lyToolbar;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView tvIntro;

  @NonNull
  public final TextView txtSigninLabel;

  private FragmentForgotpassBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton btnSignin, @NonNull TextInputEditText editEmail,
      @NonNull AppCompatImageView imvBack, @NonNull AppCompatImageView imvLogoApp,
      @NonNull ConstraintLayout lyDescIntro, @NonNull ConstraintLayout lySigninAuth,
      @NonNull ConstraintLayout lyToolbar, @NonNull ConstraintLayout main,
      @NonNull TextView tvIntro, @NonNull TextView txtSigninLabel) {
    this.rootView = rootView;
    this.btnSignin = btnSignin;
    this.editEmail = editEmail;
    this.imvBack = imvBack;
    this.imvLogoApp = imvLogoApp;
    this.lyDescIntro = lyDescIntro;
    this.lySigninAuth = lySigninAuth;
    this.lyToolbar = lyToolbar;
    this.main = main;
    this.tvIntro = tvIntro;
    this.txtSigninLabel = txtSigninLabel;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentForgotpassBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentForgotpassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_forgotpass, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentForgotpassBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSignin;
      AppCompatButton btnSignin = ViewBindings.findChildViewById(rootView, id);
      if (btnSignin == null) {
        break missingId;
      }

      id = R.id.editEmail;
      TextInputEditText editEmail = ViewBindings.findChildViewById(rootView, id);
      if (editEmail == null) {
        break missingId;
      }

      id = R.id.imvBack;
      AppCompatImageView imvBack = ViewBindings.findChildViewById(rootView, id);
      if (imvBack == null) {
        break missingId;
      }

      id = R.id.imvLogoApp;
      AppCompatImageView imvLogoApp = ViewBindings.findChildViewById(rootView, id);
      if (imvLogoApp == null) {
        break missingId;
      }

      id = R.id.lyDescIntro;
      ConstraintLayout lyDescIntro = ViewBindings.findChildViewById(rootView, id);
      if (lyDescIntro == null) {
        break missingId;
      }

      id = R.id.lySigninAuth;
      ConstraintLayout lySigninAuth = ViewBindings.findChildViewById(rootView, id);
      if (lySigninAuth == null) {
        break missingId;
      }

      id = R.id.lyToolbar;
      ConstraintLayout lyToolbar = ViewBindings.findChildViewById(rootView, id);
      if (lyToolbar == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.tvIntro;
      TextView tvIntro = ViewBindings.findChildViewById(rootView, id);
      if (tvIntro == null) {
        break missingId;
      }

      id = R.id.txtSigninLabel;
      TextView txtSigninLabel = ViewBindings.findChildViewById(rootView, id);
      if (txtSigninLabel == null) {
        break missingId;
      }

      return new FragmentForgotpassBinding((ConstraintLayout) rootView, btnSignin, editEmail,
          imvBack, imvLogoApp, lyDescIntro, lySigninAuth, lyToolbar, main, tvIntro, txtSigninLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
