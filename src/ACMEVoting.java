import java.util.Scanner;

public class ACMEVoting {

	private Scanner in;
	private int opcao;
	private Candidatura candidatura;
	private CadastroPartido cadastroPartido;

	public ACMEVoting() {
		opcao = 1;
		in = new Scanner(System.in);
		candidatura = new Candidatura();
		cadastroPartido = new CadastroPartido();
	}

	public void numero1() {
		System.out.println("Digite o nome do partido");
		String nomePartido = in.nextLine();
		nomePartido = in.nextLine();

		System.out.println("Digite o número do partido");
		int numeroPartido = in.nextInt();

		Partido p = new Partido(numeroPartido, nomePartido);
		if (cadastroPartido.consultaPartido(nomePartido) == null) {
			if (cadastroPartido.consultaPartido(numeroPartido) == null) {
				System.out.printf("Cadastro de Partido %s de número %d realizado com sucesso!", nomePartido, numeroPartido);
				cadastroPartido.cadastraPartido(p);
			} else {
				System.out.println("Número de Partido já existente.");
			}
		} else {
			System.out.println("Nome de Partido já existente.");
			if (cadastroPartido.consultaPartido(numeroPartido) == null) {
			} else {
				System.out.println("Número de Partido já existente.");
			}
		}
	}

	public void numero2() {
		System.out.println("Digite o nome do candidato");
		String nomeCandidato = in.nextLine();
		nomeCandidato = in.nextLine();

		System.out.println("Digite o número do candidato");
		int numeroCandidato = in.nextInt();

		System.out.println("Digite o município do candidato");
		String municipioCandidato = in.nextLine();
		municipioCandidato = in.nextLine();

		System.out.println("Digite o nome do partido do candidato");
		String nomePartidoCandidato = in.nextLine();

		Candidato c = new Candidato(numeroCandidato, nomeCandidato, municipioCandidato);
		if (candidatura.consultaPorMunicipio(municipioCandidato) == null) {
			candidatura.cadastraCandidato(c);
			System.out.printf("Cadastro de candidato %s de número %d do município %s realizado com sucesso!", nomeCandidato, numeroCandidato, municipioCandidato);
		} else {
			for (Candidato cand : candidatura.consultaPorMunicipio(municipioCandidato)) {
				if (cand.getNumero() == numeroCandidato) {
					System.out.println("Numero de candidato já existente");
				} else {
					if (cadastroPartido.consultaPartido(nomeCandidato) == null) {
						System.out.println("Partido não existente");
					} else {
						candidatura.cadastraCandidato(c);
						System.out.printf("Cadastro de candidato %s de número %d do município %s realizado com sucesso!", nomeCandidato, numeroCandidato, municipioCandidato);
					}
				}
			}
		}
	} 

	public void numero4() {
		System.out.println("Digite o número do partido");
		int numeroPartido = in.nextInt();
		if (cadastroPartido.consultaPartido(numeroPartido) == null) {
			System.out.println("Nenhum partido encontrado.");
		} else {
			Partido partido = cadastroPartido.consultaPartido(numeroPartido);
			System.out.println("Partido encontrado! Partido " + partido.getNome() + " número " + partido.getNumero());
		}
	}

	public void executar() {
		while (opcao != 0) {
			System.out.println("\n[1] Digite 1 para cadastrar partido");
			System.out.println("[2] Digite 2 para cadastrar candidato");
			System.out.println("[3] Digite 3 para cadastrar votos de candidatos");
			System.out.println("[4] Digite 4 para mostrar os dados de um determinado partido pelo número");
			System.out.println("[5] Digite 5 para mostrar os dados de um determinado candidato");
			System.out.println("[6] Digite 6 para mostrar os votos dos prefeitos de um determinado partido");
			System.out.println("[7] Digite 7 para mostrar os dados do partido com mais candidatos");
			System.out.println("[8] Digite 8 para mostrar os dados do prefeito e do vereador mais votados");
			opcao = in.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Cadastrar partido");
					numero1();
					break;
				case 2:
					System.out.println("Cadastrar candidato");
					numero2();
					break;
				case 3:
					System.out.println("Cadastrar voto");
					break;
				case 4:
					System.out.println("Mostrar os dados de um determinado partido pelo número");
					numero4();
					break;
				case 5:
					System.out.println("Mostrar os dados de um determinado candidato");
					break;
				case 6:
					System.out.println("Mostrar os votos dos prefeitos de um determinado partido");
					break;
				case 7:
					System.out.println("Mostrar os dados do partido com mais candidatos");
					break;
				case 8:
					System.out.println("Mostrar os dados do prefeito e do vereador mais votados");
					break;
				default:
					System.out.println("Digite um número válido");
					break;
			}
		}
	}

}
