package com.example.programmerprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView languagesGrid;
    private List<Language> languagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLanguages();
        setupGridView();
    }

    private void initializeLanguages() {
        languagesList = new ArrayList<>();

        languagesList.add(new Language("HTML", R.drawable.html,
                "Avanzado", "2 años de experiencia desarrollando sitios web responsivos y accesibles. Especializado en HTML5, semántica web y accesibilidad."));

        languagesList.add(new Language("JavaScript", R.drawable.js,
                "Avanzado", "Experiencia en desarrollo frontend con React, Vue.js y backend con Node.js. Conocimiento en ES6+, TypeScript y frameworks modernos."));

        languagesList.add(new Language("Java", R.drawable.java,
                "Experto", "4 años desarrollando aplicaciones Android nativas y sistemas empresariales con Spring Boot. Certificado Oracle Java Professional."));

        languagesList.add(new Language("Kotlin", R.drawable.kotlin,
                "Intermedio-Avanzado", "1 año desarrollando aplicaciones Android modernas. Experiencia con Coroutines, Flow y arquitecturas MVVM/MVI."));

        languagesList.add(new Language("C#", R.drawable.csharp,
                "Intermedio", "Experiencia en desarrollo de aplicaciones de escritorio con .NET Framework y .NET Core. Conocimiento en Unity para desarrollo de juegos."));

        languagesList.add(new Language("C++", R.drawable.cpp,
                "Intermedio", "Conocimiento en desarrollo de software de sistemas, aplicaciones de alto rendimiento y desarrollo de motores gráficos."));

        languagesList.add(new Language("C", R.drawable.c,
                "Básico-Intermedio", "Conocimientos académicos y desarrollo de proyectos pequeños. Experiencia en programación嵌入式系统 y desarrollo de drivers básicos."));

        languagesList.add(new Language("Python", R.drawable.python,
                "Avanzado", "4 años desarrollando scripts de automatización, análisis de datos con Pandas, aplicaciones web con Django y Flask, y machine learning básico."));
    }

    private void setupGridView() {
        languagesGrid = findViewById(R.id.languages_grid);

        LanguageAdapter adapter = new LanguageAdapter(this, languagesList);
        languagesGrid.setAdapter(adapter);

        languagesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Language selectedLanguage = languagesList.get(position);

                Intent intent = new Intent(MainActivity.this, LanguageDetailActivity.class);
                intent.putExtra("language_name", selectedLanguage.getName());
                intent.putExtra("language_image", selectedLanguage.getImageId());
                intent.putExtra("knowledge_level", selectedLanguage.getKnowledgeLevel());
                intent.putExtra("knowledge_description", selectedLanguage.getKnowledgeDescription());

                startActivity(intent);

                // Añadir animación de transición
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}