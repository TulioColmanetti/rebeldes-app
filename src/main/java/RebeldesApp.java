import br.com.letscode.rebeldes.Raça;
import br.com.letscode.rebeldes.Rebelde;

public class RebeldesApp {
    public static void main(String[] args) {
        Rebelde rebelde = Rebelde.builder()
                .Nome("Joao")
                .Idade(33)
                .Raça(Raça.HUMANO).build();
        System.out.println(rebelde.toString());
    }
}
