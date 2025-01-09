package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


    public void SelectRock(View view) {
        verificarGanhador("pedra");

    }

    public void SelectPaper(View view) {
        verificarGanhador("papel");
    }

    public void SelectScissors(View view) {
        verificarGanhador("tesoura");
    }

    private String gerarescolhaaleatoriaApp() {

        // criando escolha aletoria app
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        //configurando imagem do aplicativo
        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;

        }

        return escolhaApp;
    }

    // verificador de item selecioanado abaixo
    private void verificarGanhador(String escolhaUser) {
        String escolhaApp = gerarescolhaaleatoriaApp();
        TextView textResult = findViewById(R.id.text_result);

        if (
                (escolhaApp == "pedra" && escolhaUser == "tesoura") ||
                        (escolhaApp == "papel" && escolhaUser == "pedra") ||
                        (escolhaApp == "tesoura" && escolhaUser == "papel")
        ) {
            textResult.setText("voce perdeu");

        } else if (
                (escolhaUser == "pedra" && escolhaApp == "tesoura") ||
                        (escolhaUser == "papel" && escolhaApp == "pedra") ||
                        (escolhaUser == "tesoura" && escolhaApp == "papel")
        ) { textResult.setText("voce ganhou");

        } else {
            textResult.setText("empatou");


            //System.out.println("item clicado foi " + escolhaUser);
        }
    }
}

