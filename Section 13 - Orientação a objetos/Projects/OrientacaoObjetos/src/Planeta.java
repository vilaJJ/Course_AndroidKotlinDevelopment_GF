public class Planeta {
    private final String nome;
    private String gentilico;

    public Planeta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getGentilico() {
        return gentilico;
    }

    public void setGentilico(String nome) {
        this.gentilico = nome;
    }
}
