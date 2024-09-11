import java.util.ArrayList;

public class Partido {
	private int numero;
	private String nome;
	private ArrayList<Candidato> listaCandidatos;

	public Partido(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
		listaCandidatos = new ArrayList<>();
	}

	public boolean cadastraCandidato(Candidato c) {
		for (Candidato cand : listaCandidatos) {
			if (cand.getNumero() == c.getNumero() && cand.getMunicipio().equals(c.getMunicipio())) {
				return false;
			}
		}
		return listaCandidatos.add(c);
	}

	public int getNumero() {return numero;}
	public String getNome() {return nome;}

}
