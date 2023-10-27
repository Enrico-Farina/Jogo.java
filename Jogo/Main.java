import java.util.Random;
import java.lang.Math;
import java.lang.Thread;

public class Main {

  public static void main (String[] args) throws Exception {
    //Cont round
    Integer round = 0;
    
    //Create the players 
    Jogador[] jogadores = new Jogador[2];

    System.out.print("Digite o nome do primeiro jogador: ");
    jogadores[0] = new Jogador(Teclado.getUmString() , 1);
    System.out.print("Digite o nome do segundo jogador: ");
    jogadores[1] = new Jogador(Teclado.getUmString() , 9);

    System.out.println();
    System.out.println("------------------------");
    System.out.println ("Bem vindo ao duelo!");
    System.out.println ("Quem eliminar o adversário primeiro ganha, boa sorte!");

    Integer action = 0;
    //Integer j = 0;
    try {

      while (jogadores[0].getVida() > 0 && jogadores[1].getVida() > 0) {
        round++;
        if (round == 3) //spawnHeart();
      for (Integer i = 0 , j = 1; i <= 1; i++ , j--){
        //i define the atual player
        //j define the another player
        
        //setValidar initialize the validate action to be check 
        jogadores[i].setValidar(false);

        do {

          jogadores[i].atualScreen(jogadores[j].getPosicao());
          action = jogadores[i].selectAction();
      

          if (action == 1){
            jogadores[i].gunShot(jogadores[j]);
          } else if (action == 2) {
            jogadores[i].movePlayer(jogadores[j].getPosicao());
          } else if (action == 9){
            jogadores[i].setValidar(true);
             System.out.println(jogadores[i].getNome() + " Desistiu.");
             jogadores[i].setVida(0);
            }
          
        } while (jogadores[i].getValidar() == false);
      }
    }

    System.out.println();
    if (jogadores[0].getVida() == 0){
      System.out.println(jogadores[1].getNome() + " Venceu!!");
    } else {
      System.out.println(jogadores[0].getNome() + " Venceu!!");
    }

    } catch (Exception erro) {
      System.err.println(erro.getMessage());
    }
  }
  
}
