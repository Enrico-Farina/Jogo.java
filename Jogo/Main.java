import java.util.Random;

public class Main {

  public static void main (String[] args) {
    Random random = new Random();
    
    Jogador[] jogadores = new Jogador[2];

    Jogador jogador1 = new Jogador();
    Jogador jogador2 = new Jogador();

    jogadores[0] = jogador1;
    jogadores[1] = jogador2;

    jogadores[0].setNome("Enrico");
    jogadores[0].setPosicao(1);
    jogadores[1].setNome("Paras");
    jogadores[1].setPosicao(10);

    System.out.println ("Bem vindo ao duelo!");
    System.out.println ("Quem eliminar o adversário primeiro ganha, boa sorte!");
    Integer j = 0;

    try {

      while (jogadores[0].getVida() > 0 && jogadores[1].getVida() > 0) {
      for (Integer i = 0; i <= 1; i++){
        //j define the another player
        if (i == 0) j = 1; else j = 0;
        //setValidar initialize the validate action to be check 
        jogadores[i].setValidar(false);

        do {
          System.out.println("------------------------");
          System.out.println(jogadores[i].getNome());
          System.out.println("Vida atual: " + jogadores[i].getVida());
          System.out.println("Posição atual: " + jogadores[i].getPosicao());

          if (jogadores[i].selectAction() == 1){
            //gunShot
          } else {
            jogadores[i].movePlayer(jogadores[i] , jogadores[j].getPosicao());
          }
        } while (jogadores[i].getValidar() == false);
      }
    }

    } catch (Exception erro) {
      System.err.println(erro.getMessage());
    }
  }
  
}
