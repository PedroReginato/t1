import java.util.ArrayList;

public class Candidatura {

	private ArrayList<Candidato> candidatos;

	public Candidatura() {
		candidatos = new ArrayList<>();
	}

	public boolean cadastraCandidato(Candidato c) {
		candidatos.add(c);
		return true;
	}

	public Candidato consultaCandidatos(Candidato c) {
		for (Candidato cand : candidatos) {
			if (cand.getNome().equals(c.getNome())) {
				return cand;
			}
		}
		return null;
	}

	public ArrayList<Candidato> consultaPorMunicipio(String municipio) {
		ArrayList<Candidato> candidatosDaqueleMunicipio = new ArrayList<>();
		for (Candidato cand : candidatos) {
			if (cand.getMunicipio().equals(municipio)) {
				candidatosDaqueleMunicipio.add(cand);
			}
		}
		return candidatosDaqueleMunicipio;
	}
}
