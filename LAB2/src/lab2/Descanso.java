package lab2;

/** 
 * A classe Descanso informa o descanço do aluno durante as semanas e retorna seu status. O tempo mínimo semanal para o aluno descansar é de 26 horas. O usuário também pode informar um emoji, que será válido até o momento que seu status mude.
 * 
 * @author Igor Arthur Ferreira Rmamos
 */ 
public class Descanso {
    
    private String status = "cansado";
    private String ultimo = "";
    private String emoji = "";
    
    private int horas;
    private int semanas;
    
    /**
     * Define um emoji a ser exibido juntamente com o status do aluno. Caso o estado mude, o emoji deverá ser informado novamente.
     * @param valor emoji que deverá ser exibido.
     */
    public void definirEmoji(String valor) {
        emoji = valor;
    }

    /**
     * Informa o status do aluno. Caso o alunho tenha informado um emoji, o mesmo será exibido até que o status de cansaço do aluno mude.
     * @return cansado, caso não tenha atingido 26 horas semanais, descansado caso o tenha atingido. Também pode retornar um emoji informado, até que seu status mude.
     */
    public String getStatusGeral() {
        
        ultimo = status;

        if (semanas > 0) {
            if ((horas / semanas) >= 26) {
                status = "descansado";
            } else {
                status = "cansado";
            }
        }
        
        if (status.equals(ultimo)) {

            return status + " " + emoji;

        } else {

            emoji = "";
            return status;

        }
        
    }

    /**
     * Define as horas de descanso que seŕao calculadas.
     * @param valor quantidae de horas descansadas.
     */
    public void defineHorasDescanso(int valor) {
        horas = valor;
    }

    /**
     * Define o número de semanas que seráo calculadas.
     * @param valor quantidade de semanas.
     */
    public void defineNumeroSemanas(int valor) {
        semanas = valor;
    }
}