package com.example.programmerprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class LanguageAdapter extends BaseAdapter {

    private Context context;
    private List<Language> languages;

    public LanguageAdapter(Context context, List<Language> languages) {
        this.context = context;
        this.languages = languages;
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public Object getItem(int position) {
        return languages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_language, null);
        }

        ImageView languageImage = convertView.findViewById(R.id.language_image);
        TextView languageName = convertView.findViewById(R.id.language_name);

        Language language = languages.get(position);

        languageImage.setImageResource(language.getImageId());
        languageName.setText(language.getName());

        return convertView;
    }
}