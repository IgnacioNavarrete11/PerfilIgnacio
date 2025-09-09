package com.example.programmerprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LanguageDetailActivity extends AppCompatActivity {

    private ImageView languageImage;
    private TextView languageName, knowledgeLevel, knowledgeDescription;
    private Button hireButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_detail);

        initializeViews();

        Intent intent = getIntent();
        String name = intent.getStringExtra("language_name");
        int imageRes = intent.getIntExtra("language_image", 0);
        String level = intent.getStringExtra("knowledge_level");
        String description = intent.getStringExtra("knowledge_description");

        configureViews(name, imageRes, level, description);

        configureHireButton(name);

        // Configurar ActionBar
        configureActionBar(name);
    }

    private void initializeViews() {
        languageImage = findViewById(R.id.detail_language_image);
        languageName = findViewById(R.id.detail_language_name);
        knowledgeLevel = findViewById(R.id.knowledge_level);
        knowledgeDescription = findViewById(R.id.knowledge_description);
        hireButton = findViewById(R.id.hire_button);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void configureViews(String name, int imageRes, String level, String description) {
        languageImage.setImageResource(imageRes);
        languageName.setText(name);
        knowledgeLevel.setText("Nivel: " + level);
        knowledgeDescription.setText(description);

        setProgressBarLevel(level);
    }

    private void setProgressBarLevel(String level) {
        switch (level) {
            case "Experto":
                progressBar.setProgress(90);
                break;
            case "Avanzado":
                progressBar.setProgress(80);
                break;
            case "Intermedio-Avanzado":
                progressBar.setProgress(65);
                break;
            case "Intermedio":
                progressBar.setProgress(50);
                break;
            case "Básico-Intermedio":
                progressBar.setProgress(30);
                break;
            case "Básico":
                progressBar.setProgress(20);
                break;
            default:
                progressBar.setProgress(50);
        }
    }

    private void configureHireButton(String name) {
        hireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHireDialog(name);
            }
        });
    }

    private void configureActionBar(String name) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(name);
        }
    }

    private void showHireDialog(String languageName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Contratación Exitosa! 🎉");
        builder.setMessage("Has solicitado contratar mis servicios de " + languageName +
                "\n\n¡Gracias por tu confianza! Me pondré en contacto contigo dentro de las próximas 24 horas.");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.accent));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}