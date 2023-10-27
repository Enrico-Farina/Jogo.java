import java.util.Random;

public class Jogador {

  private String nome;
  private Integer vida=3;
  private Integer posicao;
  private Boolean validar = false; 
  Random random = new Random(); 


  public Jogador (String nome , Integer posicao) {
    this.nome = nome;
    this.posicao = posicao;
  }

  public String getNome(){
    return nome;
  }

  public Integer getPosicao(){
    return posicao;
  }

  public Integer getVida(){
    return vida;
  }

  public Boolean getValidar(){
    return validar;
  }

  public void setValidar (Boolean validar){
    this.validar = validar;
  }

  public void setNome (String nome){
    this.nome = nome;
  }

  public void setVida  (Integer vida){
    this.vida = vida;
  }

  public void setPosicao (Integer posicao){
    this.posicao = posicao;
  }

  
  //public Integer spawnHeart (Integer posicaoOutroJogador) {
//
  //  Integer position_heart = 10;
  //  do{
  //    position_heart = random.nextInt(10);
//
  //  } while (position_heart == posicao1 || position_heart == posicao2);
  //  return position_heart;
  //}
//
  
  public void gunShot (Jogador outroJogador) throws Exception {
    //chance to hit the enemy 
    Double prob = (double) (10 - Math.abs((this.getPosicao() - outroJogador.getPosicao())));


    System.out.println("------------------------");
    System.out.println("Sua chance de acerto é: " + prob*10 + "%!! Tem certeza do disparo?");
    System.out.println("1. Sim");
    System.out.println("2. Não");
    
    if (Teclado.getUmInt() == 1 ){  
      this.setValidar(true);

      if (random.nextInt(10) <= prob) {
        System.out.println("Você acertou o alvo!!");
        outroJogador.setVida(outroJogador.getVida()-1);
      } else {
        System.out.println("Você errou o tiro.");
      }
    } else this.setValidar(false);

  }

  public void movePlayer (Integer posicaoOutroJogador) throws Exception {
    //define the direction to be moved 
    Integer direcao = 0;
    
    while (true){
      System.out.println("------------------------");
      System.out.println("1. Mover para a esquerda");
      System.out.println("2. Mover para a direita");
      System.out.println("3. Voltar ação");
      direcao = Teclado.getUmInt();
      
      if (direcao == 3) break;
      try{

        if (direcao == 1 && this.getPosicao()-1 >= 1 && this.getPosicao()-1 != posicaoOutroJogador){
          this.setPosicao(this.getPosicao()-1);
          this.setValidar(true);
          break;
        } else if (direcao == 2 && this.getPosicao()+1 <= 10 && this.getPosicao()+1 != posicaoOutroJogador) {
          this.setPosicao(this.getPosicao()+1);
          this.setValidar(true);
          break;
        } else System.out.println("Opção inválida!");

      } catch (Exception erro) {
        System.out.println(erro.getMessage());
      }
    
  }
  }

  public Integer selectAction () throws Exception {
    
    Integer action=0;

    do {
    System.out.println("Escolha sua ação:");
    System.out.println("1. Efetuar um disparo");
    System.out.println("2. Se locomover");
    System.out.println("9. Desistir");
    action = Teclado.getUmInt();
    } while (action != 1 && action != 2 && action != 9);
    
    return action;
  }

  public void atualScreen (Integer posicaoOutroJogador) {
    System.out.println("------------------------");
    System.out.println(this.getNome());
    System.out.println("Vida atual: " + this.getVida());
    System.out.println("Posição atual: " + this.getPosicao());
    System.out.println();
    for (Integer i=1; i<=10; i++){
      if (i == this.getPosicao()) System.out.print(" |(You) "); 
      else if (i == posicaoOutroJogador) System.out.print(" | ");
      else System.out.print("__");
    }
    System.out.println();
    System.out.println();
    System.out.println("------------------------");
  }

}

