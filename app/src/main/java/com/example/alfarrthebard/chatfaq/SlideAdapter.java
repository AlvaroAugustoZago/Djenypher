package com.example.alfarrthebard.chatfaq;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;


    public SlideAdapter(Context context) {

        this.context = context;
    }

    // img Array
    public int[] image_slide = {
            R.drawable.neogrid_menor,
            R.drawable.jennifer
    };

    // heading Array
    public String[] heading_slide = {
            "Neogrid",
            "Conheça Jennifer"
    };

    // description Array
    public String[] description_slide = {
            "Para colocar empresas no ritmo certo.",
            "A Neogrid criou a Jennifer para facilitar sua Vida"
    };


    @Override
    public int getCount() {

        return heading_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide, container, false);
        container.addView(view);

        ImageView slide_imageView = view.findViewById(R.id.slideimg);
        TextView slideHeading = view.findViewById(R.id.txttitle);
        TextView slideDescription = view.findViewById(R.id.txtdescription);

        view.setBackgroundColor(Color.rgb(0,38,60));

        slide_imageView.setImageResource(image_slide[position]);
        slideHeading.setText(heading_slide[position]);
        slideDescription.setText(description_slide[position]);

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}


