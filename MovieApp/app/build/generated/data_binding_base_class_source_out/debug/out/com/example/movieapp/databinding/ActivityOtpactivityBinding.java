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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.movieapp.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOtpactivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton btnVerify;

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
  public final AppCompatTextView txtForgotPass;

  @NonNull
  public final TextView txtSigninLabel;

  private ActivityOtpactivityBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton btnVerify, @NonNull TextInputEditText editEmail,
      @NonNull AppCompatImageView imvBack, @NonNull AppCompatImageView imvLogoApp,
      @NonNull ConstraintLayout lyDescIntro, @NonNull ConstraintLayout lySigninAuth,
      @NonNull ConstraintLayout lyToolbar, @NonNull ConstraintLayout main,
      @NonNull AppCompatTextView txtForgotPass, @NonNull TextView txtSigninLabel) {
    this.rootView = rootView;
    this.btnVerify = btnVerify;
    this.editEmail = editEmail;
    this.imvBack = imvBack;
    this.imvLogoApp = imvLogoApp;
    this.lyDescIntro = lyDescIntro;
    this.lySigninAuth = lySigninAuth;
    this.lyToolbar = lyToolbar;
    this.main = main;
    this.txtForgotPass = txtForgotPass;
    this.txtSigninLabel = txtSigninLabel;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOtpactivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOtpactivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_otpactivity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOtpactivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnVerify;
      AppCompatButton btnVerify = ViewBindings.findChildViewById(rootView, id);
      if (btnVerify == null) {
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

      id = R.id.txtForgotPass;
      AppCompatTextView txtForgotPass = ViewBindings.findChildViewById(rootView, id);
      if (txtForgotPass == null) {
        break missingId;
      }

      id = R.id.txtSigninLabel;
      TextView txtSigninLabel = ViewBindings.findChildViewById(rootView, id);
      if (txtSigninLabel == null) {
        break missingId;
      }

      return new ActivityOtpactivityBinding((ConstraintLayout) rootView, btnVerify, editEmail,
          imvBack, imvLogoApp, lyDescIntro, lySigninAuth, lyToolbar, main, txtForgotPass,
          txtSigninLabel);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
