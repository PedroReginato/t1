import java.util.ArrayList;

public class CadastroPartido {
	private ArrayList<Partido> partidos;

	public CadastroPartido() {
		partidos = new ArrayList<>();
	}

	public boolean cadastraPartido(Partido p) {
		for (Partido partido : partidos) {
			if(partido.getNumero() == p.getNumero()) return false;
		}
		return partidos.add(p);
	}

	public Partido consultaPartido(String nome) {
		for (Partido p : partidos) {
			if (p.getNome().equals(nome)) return p;
		}
		return null;
	}

	public Partido consultaPartido(int numero) {
		for (Partido p : partidos) {
			if (p.getNumero() == numero) return p;
		}
		return null;
	}

	public ArrayList<Partido> getPartidos() {return partidos;}
}
