import java.util.ArrayList;

public class Candidatura {
    private ArrayList<Candidato> candidatos;

    public Candidatura() {
        candidatos = new ArrayList<>();
    }

    public boolean cadastraCandidato(Candidato c) {
        for (Candidato cand : candidatos) {
            if (cand.getNumero() == c.getNumero() && cand.getMunicipio().equals(c.getMunicipio())) return false; 
        }
        return candidatos.add(c);
    }

    public Candidato consultaCandidato(int numero) {
        for (Candidato cand : candidatos) {
            if (cand.getNumero() == numero) return cand;
        }
        return null;
    }

    public ArrayList<Candidato> consultaPorMunicipio(String municipioCandidato) {
        ArrayList<Candidato> candidatosPorMunicipio = new ArrayList<>();
        for (Candidato cand : candidatos) {
            if (cand.getMunicipio().equals(municipioCandidato)) candidatosPorMunicipio.add(cand);
        }
        return candidatosPorMunicipio;
    }

    public Candidato consultaCandidatoPorMunicipio(int numeroCandidato, String municipio) {
        for (Candidato cand : candidatos) {
            if (cand.getNumero() == numeroCandidato && cand.getMunicipio().equals(municipio)) return cand;
        }
        return null;
    }
	
    // public int contaCandidatosPorPartido(String nomePartido) {
	// 	int count = 0;
    //     for (Candidato candidato : candidatos) {
	// 		if (candidato.getPartido().getNome().equals(nomePartido)) count++;
    //     }
    //     return count;
    // }

	public ArrayList<Candidato> getCandidatos() {return candidatos;}
}
