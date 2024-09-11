public class Candidato {

    private int numero, votos;
    private String nome, municipio;

    public Candidato(int numero, String nome, String municipio) {
        this.numero = numero;
        this.nome = nome;
        this.municipio = municipio;
        this.votos = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
}
