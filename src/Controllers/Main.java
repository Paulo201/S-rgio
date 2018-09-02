package Controllers;
import Models.Configuracao;
import Views.FrmTelaPrincipal;

/**
 *
 * @author willi
 */
public class Main {
   
    private static FrmTelaPrincipal principal;

    public static void main(String[] args) {
        try {
            Main.principal = new FrmTelaPrincipal(new Configuracao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
