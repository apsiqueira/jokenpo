package br.com.jokenpo;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import br.com.jokenpo.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imagemUM;
    private ImageView imagemDois;
    private Button botaoPedra;
    private Button botaoPapel;
    private Button botaoTesoura;
    private TextView txtPlacar;
    private Toast toast;
    final int duracao = Toast.LENGTH_SHORT;
    private String jogadaPessoa;
    private String jogadaPc;
    String[] jogadasPossiveis = {"pedra", "papel", "tesoura"};
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imagemUM = findViewById(R.id.imagemUm);
        this.imagemDois = findViewById(R.id.imagemDois);
        this.botaoPedra = findViewById(R.id.btnPedra);
        this.botaoPapel = findViewById(R.id.btnPapel);
        this.botaoTesoura = findViewById(R.id.btntesoura);

        botaoPedra.setOnClickListener(this);
        botaoPapel.setOnClickListener(this);
        botaoTesoura.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btnPedra:
                jogadaPessoa = jogadasPossiveis[0];

                testaJogada(jogadaPessoa);


                break;

            case R.id.btnPapel:

                jogadaPessoa = jogadasPossiveis[1];
                 testaJogada(jogadaPessoa);


                break;

            case R.id.btntesoura:

                jogadaPessoa = jogadasPossiveis[2];
                testaJogada(jogadaPessoa);


                break;


        }


    }

    public void testaJogada(String jogadaPessoa) {


        jogadaPc = jogadasPossiveis[random.nextInt(3)];



        if (jogadaPessoa == "pedra" && jogadaPc == "papel") {

            toast = Toast.makeText(getApplicationContext(), "Papel embrulha pedra!Robo Venceu!!!", duracao);
            toast.show();
        } else if (jogadaPessoa == "papel" && jogadaPc == "pedra") {


            toast = Toast.makeText(getApplicationContext(), "Papel embrulha pedra!Você Venceu!!!", duracao);
            toast.show();

        } else if (jogadaPessoa == "pedra" && jogadaPc == "tesoura") {


            toast = Toast.makeText(getApplicationContext(), "Pedra quebra tesoura!Você Venceu!!!", duracao);
            toast.show();
        } else if (jogadaPessoa == "tesoura" && jogadaPc == "pedra") {



            toast = Toast.makeText(getApplicationContext(), "Pedra quebra tesoura!Robo Venceu!!!", duracao);
            toast.show();
        } else if (jogadaPessoa == "papel" && jogadaPc == "tesoura") {


            toast = Toast.makeText(getApplicationContext(), "Tesoura corta Papel!Robo venceu!!!", duracao);
            toast.show();
        } else if (jogadaPessoa == "tesoura" && jogadaPc == "papel") {


            toast = Toast.makeText(getApplicationContext(), "Tesoura corta Papel!Voce Venceu!!!", duracao);
            toast.show();
        }


    }


}


