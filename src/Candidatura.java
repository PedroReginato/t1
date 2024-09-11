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

	public Candidato consultaCandidato(int numero) {
		for (Candidato cand : candidatos) {
			if (cand.getNumero() == numero) {
				return cand;
			}
		}
		return null;
	}

	public ArrayList<Candidato> consultaPorMunicipio(String municipioCandidato) {
		ArrayList<Candidato> candidatosPorMunicipio = new ArrayList<>();
		for (Candidato cand : candidatos) {
			if (cand.getMunicipio().equals(municipioCandidato)) {
				candidatosPorMunicipio.add(cand);
			}
		}
		return candidatosPorMunicipio;
	}

	public Candidato consultaCandidatoPorMunicipio(int numeroCandidato) {
		for (Candidato cand : candidatos) {
			if (cand.getNumero() == numeroCandidato) {
				return cand;
			}
		}
		return null;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public int contaCandidatosPorPartido(String nomePartido) {
		int count = 0;
		for (Candidato candidato : candidatos) {
			if (candidato.getMunicipio().equals(nomePartido)) {
				count++;
			}
		}
		return count;
	}
}
