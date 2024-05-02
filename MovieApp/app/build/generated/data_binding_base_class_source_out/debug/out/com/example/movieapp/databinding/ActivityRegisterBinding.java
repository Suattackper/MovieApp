// Generated by view binder compiler. Do not edit!
package com.example.movieapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.movieapp.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final AppCompatButton btnSignup;

  @NonNull
  public final TextInputEditText editEmail;

  @NonNull
  public final TextInputEditText editPassword;

  @NonNull
  public final TextInputEditText editPhone;

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
  public final LinearLayout main;

  @NonNull
  public final AppCompatTextView txtSignin;

  @NonNull
  public final TextView txtSigninLabel;

  private ActivityRegisterBinding(@NonNull ScrollView rootView, @NonNull AppCompatButton btnSignup,
      @NonNull TextInputEditText editEmail, @NonNull TextInputEditText editPassword,
      @NonNull TextInputEditText editPhone, @NonNull AppCompatImageView imvBack,
      @NonNull AppCompatImageView imvLogoApp, @NonNull ConstraintLayout lyDescIntro,
      @NonNull ConstraintLayout lySigninAuth, @NonNull ConstraintLayout lyToolbar,
      @NonNull LinearLayout main, @NonNull AppCompatTextView txtSignin,
      @NonNull TextView txtSigninLabel) {
    this.rootView = rootView;
    this.btnSignup = btnSignup;
    this.editEmail = editEmail;
    this.editPassword = editPassword;
    this.editPhone = editPhone;
    this.imvBack = imvBack;
    this.imvLogoApp = imvLogoApp;
    this.lyDescIntro = lyDescIntro;
    this.lySigninAuth = lySigninAuth;
    this.lyToolbar = lyToolbar;
    this.main = main;
    this.txtSignin = txtSignin;
    this.txtSigninLabel = txtSigninLabel;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSignup;
      AppCompatButton btnSignup = ViewBindings.findChildViewById(rootView, id);
      if (btnSignup == null) {
        break missingId;
      }

      id = R.id.editEmail;
      TextInputEditText editEmail = ViewBindings.findChildViewById(rootView, id);
      if (editEmail == null) {
        break missingId;
      }

      id = R.id.editPassword;
      TextInputEditText editPassword = ViewBindings.findChildViewById(rootView, id);
      if (editPassword == null) {
        break missingId;
      }

      id = R.id.editPhone;
      TextInputEditText editPhone = ViewBindings.findChildViewById(rootView, id);
      if (editPhone == null) {
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

      id = R.id.main;
      LinearLayout main = ViewBindings.findChildViewById(rootView, id);
      if (main == null) {
        break missingId;
      }

      id = R.id.txtSignin;
      AppCompatTextView txtSignin = ViewBindings.findChildViewById(rootView, id);
      if (txtSignin == null) {
        break missingId;
      }

      id = R.id.txtSigninLabel;
      TextView txtSigninLabel = ViewBindings.findChildViewById(rootView, id);
      if (txtSigninLabel == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ScrollView) rootView, btnSignup, editEmail, editPassword,
          editPhone, imvBack, imvLogoApp, lyDescIntro, lySigninAuth, lyToolbar, main, txtSignin,
          txtSigninLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}