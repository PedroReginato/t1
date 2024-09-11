public class Candidato {
	private int numero;
	private String nome;
	private String municipio;
	private int votos;

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

	public void adicionaVotos(int votos) {
		this.votos += votos;
	}
}
