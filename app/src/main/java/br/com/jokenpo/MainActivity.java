package br.com.jokenpo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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
    private int placarPessoa = 0, placarPc = 0, rodadas = 0;
    private TextView textoPLacarGeral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imagemUM = findViewById(R.id.imagemUm);
        this.imagemDois = findViewById(R.id.imagemDois);
        this.botaoPedra = findViewById(R.id.btnPedra);
        this.botaoPapel = findViewById(R.id.btnPapel);
        this.botaoTesoura = findViewById(R.id.btntesoura);
        this.textoPLacarGeral =findViewById(R.id.textViewPlacarGeral);

        botaoPedra.setOnClickListener(this);
        botaoPapel.setOnClickListener(this);
        botaoTesoura.setOnClickListener(this);


    }
//  TODO implementar uma tela para pegar numero de partidas
    //  TODO mudar icone do app
    //TODO pegar nome do jogador e setar no lugar de player
    //TODO colocar tela de comemoração do vencedor
    //TODO botao sair caso necessario

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

        try {
            if (jogadaPessoa == "pedra" && jogadaPc == "papel") {
                imagemUM.setBackgroundResource(R.drawable.pedra);
                imagemDois.setBackgroundResource(R.drawable.papel);
                toast = Toast.makeText(getApplicationContext(), "Papel embrulha pedra!Robo Venceu!!!", duracao);
                toast.show();
                placarPc++;



            } else if (jogadaPessoa == "papel" && jogadaPc == "pedra") {
                imagemUM.setBackgroundResource(R.drawable.papel);
                imagemDois.setBackgroundResource(R.drawable.pedra);
                toast = Toast.makeText(getApplicationContext(), "Papel embrulha pedra!Você Venceu!!!", duracao);
                toast.show();
                placarPessoa++;


            } else if (jogadaPessoa == "pedra" && jogadaPc == "tesoura") {
                imagemUM.setBackgroundResource(R.drawable.pedra);
                imagemDois.setBackgroundResource(R.drawable.tesoura);
                toast = Toast.makeText(getApplicationContext(), "Pedra quebra tesoura!Você Venceu!!!", duracao);
                toast.show();
                placarPessoa++;



            } else if (jogadaPessoa == "tesoura" && jogadaPc == "pedra") {
                imagemUM.setBackgroundResource(R.drawable.tesoura);
                imagemDois.setBackgroundResource(R.drawable.pedra);
                toast = Toast.makeText(getApplicationContext(), "Pedra quebra tesoura!Robo Venceu!!!", duracao);
                toast.show();
                placarPc++;



            } else if (jogadaPessoa == "papel" && jogadaPc == "tesoura") {
                imagemUM.setBackgroundResource(R.drawable.papel);
                imagemDois.setBackgroundResource(R.drawable.tesoura);
                toast = Toast.makeText(getApplicationContext(), "Tesoura corta Papel!Robo venceu!!!", duracao);
                toast.show();
                placarPc++;



            } else if (jogadaPessoa == "tesoura" && jogadaPc == "papel") {
                imagemUM.setBackgroundResource(R.drawable.tesoura);
                imagemDois.setBackgroundResource(R.drawable.papel);


                toast = Toast.makeText(getApplicationContext(), "Tesoura corta Papel!Voce Venceu!!!", duracao);
                toast.show();
                placarPessoa++;
                toast.show();

            }else  if(jogadaPessoa=="pedra" && jogadaPc=="pedra") {
                    imagemUM.setBackgroundResource(R.drawable.pedra);
                    imagemDois.setBackgroundResource(R.drawable.pedra);
                    toast = Toast.makeText(getApplicationContext(), "Houve em empate :Pedra",duracao);
                    toast.show();
                textoPLacarGeral.setText(textoPLacarGeral.toString());
                }
            else if(jogadaPessoa=="papel" && jogadaPc=="papel"){
                    imagemUM.setBackgroundResource(R.drawable.papel);
                    imagemDois.setBackgroundResource(R.drawable.papel);
                    toast = Toast.makeText(getApplicationContext(), "Houve em empate :Papel",duracao);
                    toast.show();


                }
                else  {
                    imagemUM.setBackgroundResource(R.drawable.tesoura);
                    imagemDois.setBackgroundResource(R.drawable.tesoura);
                    toast = Toast.makeText(getApplicationContext(), "Houve em empate" +
                            ":Tesoura",duracao);
                    toast.show();




            }

        } catch (Exception e) {

            //TODO tirar esta menssagem para o usuario
            toast = Toast.makeText(getApplicationContext(), "Houve uma excessao precisa ser tratada" + e.toString(), duracao);
            toast.show();


        }finally {
            textoPLacarGeral.setText("Você: "+placarPessoa+" VS  "+"Robo: "+placarPc);
        }


    }


}


