import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ACMEVoting {
	private Scanner in;
	private int opcao = 1;
	private Candidatura candidatura;
	private CadastroPartido cadastroPartido;

	public ACMEVoting() {
		this.in = new Scanner(System.in);
		this.candidatura = new Candidatura();
		this.cadastroPartido = new CadastroPartido();
	}

	public void numero1() {
		System.out.println("Digite o nome do partido");
		String nomePartido = this.in.nextLine();
		System.out.println("Digite o número do partido");
		int numeroPartido = this.in.nextInt();
		this.in.nextLine();
		Partido p = new Partido(numeroPartido, nomePartido);
		if (this.cadastroPartido.consultaPartido(nomePartido) == null) {
			if (this.cadastroPartido.consultaPartido(numeroPartido) == null) {
				System.out.printf("Cadastro de Partido %s de número %d realizado com sucesso!\n", nomePartido, numeroPartido);
				this.cadastroPartido.cadastraPartido(p);
			} else {
				System.out.println("Número de Partido já existente.");
			}
		} else {
			System.out.println("Nome de Partido já existente.");
			if (this.cadastroPartido.consultaPartido(numeroPartido) != null) {
				System.out.println("Número de Partido já existente.");
			}
		}
	}

	public void numero2() {
		System.out.println("Digite o nome do candidato");
		String nomeCandidato = in.nextLine();

		System.out.println("Digite o número do candidato");
		int numeroCandidato = in.nextInt();
		in.nextLine();

		System.out.println("Digite o município do candidato");
		String municipioCandidato = in.nextLine();

		System.out.println("Digite o nome do partido do candidato");
		String nomePartidoCandidato = in.nextLine();

		if (cadastroPartido.consultaPartido(nomePartidoCandidato) == null) {
			System.out.println("Partido não existente");
		} else {
			boolean candidatoExistente = false;
			for (Candidato cand : candidatura.consultaPorMunicipio(municipioCandidato)) {
				if (cand.getNumero() == numeroCandidato) {
					candidatoExistente = true;
					break;
				}
			}

			if (candidatoExistente) {
				System.out.println("Número de candidato já existente");
			} else {
				Candidato c = new Candidato(numeroCandidato, nomeCandidato, municipioCandidato);
				candidatura.cadastraCandidato(c);
				System.out.printf("Cadastro de candidato %d,%s,%s realizado com sucesso!\n", numeroCandidato, nomeCandidato, municipioCandidato);
			}
		}
	}

	public void numero3() {
		System.out.println("Digite o número do candidato");
		int numeroCandidato = this.in.nextInt();
		System.out.println("Digite a quantidade de votos");
		int votos = this.in.nextInt();
		Candidato candidato = this.candidatura.consultaCandidato(numeroCandidato);
		if (candidato != null) {
			candidato.adicionaVotos(votos);
			System.out.printf("Votos cadastrados com sucesso: %d,%s,%d\n", candidato.getNumero(), candidato.getMunicipio(), candidato.getVotos());
		} else {
			System.out.println("Candidato não encontrado.");
		}
	}

	public void numero4() {
		System.out.println("Digite o número do partido");
		int numeroPartido = this.in.nextInt();
		this.in.nextLine();
		Partido partido = this.cadastroPartido.consultaPartido(numeroPartido);
		if (partido == null) {
			System.out.println("Nenhum partido encontrado.");
		} else {
			System.out.printf("Partido encontrado! Partido %s número %d\n", partido.getNome(), partido.getNumero());
		}
	}

	public void numero5() {
		System.out.println("Digite o número do candidato");
		int numeroCandidato = this.in.nextInt();
		this.in.nextLine();

		System.out.println("Digite o município do candidato");
		String municipioCandidato = this.in.nextLine();

		Candidato candidato = this.candidatura.consultaCandidatoPorMunicipio(numeroCandidato);
		if (candidato != null) {
			System.out.printf("Dados do candidato: %d,%s,%s,%d\n", candidato.getNumero(), candidato.getNome(), candidato.getMunicipio(), candidato.getVotos());
		} else {
			System.out.println("Nenhum candidato encontrado.");
		}
	}

	public void numero6() {
		System.out.println("Digite o nome do partido");
		String nomePartido = this.in.nextLine();
		Partido partido = this.cadastroPartido.consultaPartido(nomePartido);
		if (partido == null) {
			System.out.println("Nenhum partido encontrado.");
		} else {
			ArrayList<Candidato> prefeitos = this.candidatura.consultaPorMunicipio("Prefeito");
			for (Candidato prefeito : prefeitos) {
				if (prefeito.getMunicipio().equals(nomePartido)) {
					System.out.printf("%s,%d,%s,%s,%d\n", partido.getNome(), prefeito.getNumero(), prefeito.getNome(), prefeito.getMunicipio(), prefeito.getVotos());
				}
			}
		}
	}

	public void numero7() {
		Partido partidoComMaisCandidatos = null;
		int maxCandidatos = 0;

		for (Partido partido : cadastroPartido.getPartidos()) {
			int candidatosCount = candidatura.contaCandidatosPorPartido(partido.getNome());
			if (candidatosCount > maxCandidatos) {
				maxCandidatos = candidatosCount;
				partidoComMaisCandidatos = partido;
			}
		}

		if (partidoComMaisCandidatos != null) {
			System.out.printf("Partido com mais candidatos: %s, número %d, candidatos %d\n",
					partidoComMaisCandidatos.getNome(), partidoComMaisCandidatos.getNumero(), maxCandidatos);
		} else {
			System.out.println("Nenhum partido encontrado.");
		}
	}

	public void numero8() {
		Candidato prefeitoMaisVotado = null;
		Candidato vereadorMaisVotado = null;

		ArrayList<Candidato> candidatos = candidatura.getCandidatos();
		for (Candidato candidato : candidatos) {
			if (prefeitoMaisVotado == null || (candidato.getMunicipio().equals("Prefeito") && candidato.getVotos() > prefeitoMaisVotado.getVotos())) {
				prefeitoMaisVotado = candidato;
			}
			if (vereadorMaisVotado == null || (candidato.getMunicipio().equals("Vereador") && candidato.getVotos() > vereadorMaisVotado.getVotos())) {
				vereadorMaisVotado = candidato;
			}
		}

		if (prefeitoMaisVotado != null) {
			System.out.printf("Prefeito mais votado: %d, %s, %s, %d votos\n",
					prefeitoMaisVotado.getNumero(), prefeitoMaisVotado.getNome(), prefeitoMaisVotado.getMunicipio(), prefeitoMaisVotado.getVotos());
		} else {
			System.out.println("Nenhum prefeito encontrado.");
		}

		if (vereadorMaisVotado != null) {
			System.out.printf("Vereador mais votado: %d, %s, %s, %d votos\n",
					vereadorMaisVotado.getNumero(), vereadorMaisVotado.getNome(), vereadorMaisVotado.getMunicipio(), vereadorMaisVotado.getVotos());
		} else {
			System.out.println("Nenhum vereador encontrado.");
		}
	}

	public void executar() {
		while (this.opcao != 0) {
			System.out.println("\n[1] Digite 1 para cadastrar partido");
			System.out.println("[2] Digite 2 para cadastrar candidato");
			System.out.println("[3] Digite 3 para cadastrar votos de candidatos");
			System.out.println("[4] Digite 4 para mostrar os dados de um determinado partido pelo número");
			System.out.println("[5] Digite 5 para mostrar os dados de um determinado candidato");
			System.out.println("[6] Digite 6 para mostrar os votos dos prefeitos de um determinado partido");
			System.out.println("[7] Digite 7 para mostrar os dados do partido com mais candidatos");
			System.out.println("[8] Digite 8 para mostrar os dados do prefeito e do vereador mais votados");
			this.opcao = this.in.nextInt();
			this.in.nextLine();
			switch (this.opcao) {
				case 1:
					System.out.println("Cadastrar partido");
					this.numero1();
					break;
				case 2:
					System.out.println("Cadastrar candidato");
					this.numero2();
					break;
				case 3:
					System.out.println("Cadastrar voto");
					this.numero3();
					break;
				case 4:
					System.out.println("Mostrar os dados de um determinado partido pelo número");
					this.numero4();
					break;
				case 5:
					System.out.println("Mostrar os dados de um determinado candidato");
					this.numero5();
					break;
				case 6:
					System.out.println("Mostrar os votos dos prefeitos de um determinado partido");
					this.numero6();
					break;
				case 7:
					System.out.println("Mostrar os dados do partido com mais candidatos");
					this.numero7();
					break;
				case 8:
					System.out.println("Mostrar os dados do prefeito e do vereador mais votados");
					this.numero8();
					break;
				default:
					System.out.println("Digite um número válido");
			}
		}
	}
}
