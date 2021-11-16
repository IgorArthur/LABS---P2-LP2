package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteAgenda() {


    public class ContatoTest {

        private Contato contatoBase;

        @BeforeEach
        void preparaContatos() {
            this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
        }
        @Test
        void testNomeCompleto() {
            String msg = "Esperando obter o nome completo";
            assertEquals( "Matheus Gaudencio", this.contatoBase.nomeCompleto(), msg);
        }
    }


}