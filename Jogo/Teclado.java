import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Teclado {

  private static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

  public static int getUmInt () throws Exception {

    int ret=0;

    try{
      ret = Integer.parseInt(teclado.readLine());
    }
    catch (IOException erro){}
    catch (NumberFormatException erro){
      throw new Exception ("Int inválido!");
    }

    return ret;
  }
}
