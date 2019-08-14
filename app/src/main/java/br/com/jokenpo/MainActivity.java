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

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imagemUM;
    private ImageView imagemDois;
    private Button botaoPedra;
    private Button botaoPapel;
    private Button botaoTesoura;
    private TextView txtPlacar;
    private Toast toast;
    final String  textoPedra = "Pedra";
    final String textoPapel = "Papel";
    final String textotresoura = "tesoura";
    int duracao = Toast.LENGTH_SHORT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imagemUM=findViewById(R.id.imagemUm);
        this.imagemDois=findViewById(R.id.imagemDois);
        this.botaoPedra=findViewById(R.id.btnPedra);
        this.botaoPapel=findViewById(R.id.btnPapel);
        this.botaoTesoura=findViewById(R.id.btntesoura);

        botaoPedra.setOnClickListener(this);
        botaoPapel.setOnClickListener(this);
        botaoTesoura.setOnClickListener(this);












    }


    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnPapel:
                toast = Toast.makeText(getApplicationContext(), textoPapel, duracao);
                toast.show();


                break;

            case R.id.btnPedra:
                toast = Toast.makeText(getApplicationContext(), textoPedra, duracao);
                toast.show();


                break;

            case R.id.btntesoura:
                toast = Toast.makeText(getApplicationContext(), textotresoura, duracao);
                toast.show();


                break;


        }



    }



}