package pe.com.distriluz.app.binding;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.ui.custom.TextDrawable;
import pe.com.distriluz.app.utils.Utils;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by troy379 on 15.03.16.
 */
public final class BindingAdapterUtils {
    private BindingAdapterUtils() {
        throw new AssertionError();
    }


    @BindingAdapter({"paddingLaterales"})
    public static void paddingLaterales(View view,float dimensions) {
        view.setPadding((int) (dimensions),
                view.getPaddingTop(),
                (int) (dimensions),
                view.getPaddingBottom());
    }

    @BindingAdapter({"paddingTopBotton"})
    public static void paddingTopBotton(View view,float dimensions) {
        view.setPadding(view.getPaddingLeft(),
                (int) (dimensions),
                view.getPaddingRight(),
                (int) (dimensions));
    }
    @BindingAdapter({"condition_margin"})
    public static void ConditionMargin(View view,float dimensions) {
        view.setPadding((int) (dimensions),
                (int) (dimensions),
                (int) (dimensions),
                (int) (dimensions));
    }
    @BindingAdapter({"relative_height"})
    public static void setHeight(View view,float height) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.height = (int)height;
        view.setLayoutParams(params);
    }

    @BindingAdapter({"tipo"})
    public static void setBackgroundTipe(View view,String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }

    @BindingAdapter({"drawableRight"})
    public static void drawableRight(AppCompatTextView view,int idIcon) {
        view.setCompoundDrawablesWithIntrinsicBounds(0,0,idIcon,0);
        view.setCompoundDrawablePadding(24);
    }

    @BindingAdapter({"error"})
    public static void errorEditText(AppCompatEditText view, String error) {
        view.setError(error);
    }

    @BindingAdapter({"animation_collapse"})
    public static void AnimationcollapseView(LinearLayout view, boolean open) {
        if(open){
            Utils.collapse(view);
        }else{
            Utils.expand(view);
        }
    }

    @BindingAdapter({"imgprofile"})
    public static void SetImagProfile(ImageView imageView , String url){
        if(url!=null && !url.isEmpty()) {
            if(url.length()!=2) {
                Glide.with(imageView.getContext())
                        .load(url)
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageView);
            }else{
                TextDrawable drawable = TextDrawable.builder()
                        .buildRect(url, Color.RED);
                imageView.setImageDrawable(drawable);
            }
        }
    }

    @BindingAdapter({"imgpost"})
    public static void SetImagePost(ImageView imageView , String url){
        if(url!=null && !url.isEmpty()) {
            Uri uri = Uri.parse(url);
            getConstructorLoaded(imageView.getContext())
                    .load(uri)
                    .into(imageView);
        }
    }

    @BindingAdapter({"base64"})
    public static void setImageBase64(CircleImageView imageView , String base64){
        if(base64!=  null  && !base64.isEmpty()) {
            String imageDataBytes = base64.substring(base64.indexOf(",")+1);
            byte[] imageByteArray = Base64.decode(imageDataBytes, Base64.DEFAULT);
            Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(imageByteArray)
                    .placeholder(R.drawable.ic_defaul_logo_app)
                    .into(imageView);
        }
    }

    private static RequestBuilder<PictureDrawable> getConstructorLoaded(Context context) {
        return Glide.with(context)
                .as(PictureDrawable.class)
                .placeholder(R.drawable.ic_defaul_logo_app)
                .error(R.drawable.ic_defaul_logo_app)
                .transition(withCrossFade());
    }

    @BindingAdapter({"imgpostConcurso"})
    public static void SetImagePostConcurso(LinearLayout linearLayout , String url){
        if(url!=null && !url.isEmpty()) {
            linearLayout.removeAllViews();
            ImageView imageView =  new ImageView(linearLayout.getContext());
            LinearLayout.LayoutParams params =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(params);
            linearLayout.addView(imageView);
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }

    @BindingAdapter({"img_uri"})
    public static void SetImagePostUri(ImageView imageView , String absolutePath){
        if(absolutePath!=null && !absolutePath.isEmpty()) {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(imageView.getContext())
                    .load(Uri.fromFile(new File(absolutePath)))
                    .into(imageView);
        }else{
            imageView.setVisibility(View.GONE);
        }
    }
    @BindingAdapter({"imgFile"})
    public static void setimageFromFile(ImageView imageView , File file){
        if(file!=null) {
            imageView.setVisibility(View.VISIBLE);
            Glide.with(imageView.getContext())
                    .load(Uri.fromFile(file))
                    .into(imageView);
        }
    }
    @BindingAdapter({"backgroundButtomServices"})
    public static void backgroundButtomServices(MaterialButton materialButton , boolean isActive){
        if(isActive){
            materialButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#62b523")));
          //  materialButton.setText(ApplicationContext.getRes().getString(R.string.emmit_active));
        }else{
            materialButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8c00")));
          //  materialButton.setText(ApplicationContext.getRes().getString(R.string.emmit_disable));
        }
    }
}


















