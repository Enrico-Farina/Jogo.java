import java.util.Random;

public class Jogador {

  private String nome;
  private Integer vida=10;
  private Integer posicao;
  private Boolean validar = false; 


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

  
  public Integer spawnHeart (Integer posicao1, Integer posicao2) {

    Integer position_heart = 10;

    Random generator = new Random(); 

    do{
      position_heart = generator.nextInt(10);

    } while (position_heart == posicao1 || position_heart == posicao2);


    return position_heart;
  }


  public void movePlayer (Jogador jogador, Integer posicaoOutroJogador) throws Exception {
    Integer direcao = 0;

    while (true){

     
      System.out.println("------------------------");
      System.out.println("1. Mover para a esquerda");
      System.out.println("2. Mover para a direita");
      System.out.println("3. Voltar ação");
      direcao = Teclado.getUmInt();
      
      if (direcao == 3) break;

      try{

        if (direcao == 1 && jogador.getPosicao()-1 >= 1 && jogador.getPosicao()-1 != posicaoOutroJogador){
          jogador.setPosicao(jogador.getPosicao()-1);
          jogador.setValidar(true);
          break;
        } else if (direcao == 2 && jogador.getPosicao()+1 <= 10 && jogador.getPosicao()+1 != posicaoOutroJogador) {
          jogador.setPosicao(jogador.getPosicao()+1);
          jogador.setValidar(true);
          break;
        } else System.out.println("Opção inválida!");

      } catch (Exception erro) {
        System.out.println(erro.getMessage());
      }
    
  }
  }

  public Integer selectAction () throws Exception {
    
    Integer action=2;

    System.out.println("Escolha sua ação:");
    System.out.println("1. Efetuar um disparo");
    System.out.println("2. Se locomover");
    action = Teclado.getUmInt();
    
    return action;
  }

}

