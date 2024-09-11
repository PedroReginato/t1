import java.io.*;

public class ACMEVoting {

    private BufferedReader reader;
    private Candidatura candidatura;
    private CadastroPartido cadastroPartido;

    public ACMEVoting() {
        try {
            reader = new BufferedReader(new FileReader(new File("./input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
        } catch (FileNotFoundException e) {}
        candidatura = new Candidatura();
        cadastroPartido = new CadastroPartido();
        executar();
    }

    public void cadastrarPartidoFuncao() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if(line.equals("-1")) break;
                    int numeroPartido = Integer.parseInt(line.trim());
                    String nomePartido = reader.readLine();
                    System.out.println(cadastroPartido.cadastraPartido(new Partido(numeroPartido, nomePartido)) ?
                    String.format("1:%d,%s", numeroPartido, nomePartido)
                    :
                    "Erro ao cadastrar partido");
            }
        } catch (IOException e) {}
    }

    public void cadastrarCandidadoFuncao() {
        String line;
        try {
            int numeroCandidato = Integer.parseInt(line = (reader.readLine().trim()));
            while (numeroCandidato != -1) {
                if(line.equals("-1")) break;
                    String nomeCandidato = reader.readLine();
                    String municipio = reader.readLine();
                    System.out.println(candidatura.cadastraCandidato(new Candidato(numeroCandidato, nomeCandidato, municipio)) ?
                    String.format("2:%d,%s,%s", numeroCandidato,nomeCandidato,municipio)
                    :
                    "Erro ao cadastrar candidato"
                    );
                    numeroCandidato = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {}
    }

    public void cadastrarVotosCandidato() {
        try {
            int numeroCandidato = Integer.parseInt((reader.readLine().trim()));
            while (numeroCandidato != -1) {
                String cidadeCandidato = reader.readLine();
                int votos = Integer.parseInt(reader.readLine());
                Candidato candidato = candidatura.consultaCandidatoPorMunicipio(numeroCandidato, cidadeCandidato);
                candidato.setVotos(votos);
                System.out.println((votos > 0 && candidato != null) ? String.format("3:%d,%s,%d", numeroCandidato, cidadeCandidato, votos) : "Erro");
                numeroCandidato = Integer.parseInt((reader.readLine().trim()));
            }

        }catch(Exception e){}
    }

    public void mostrarPartidosPeloNumero() {
        String line;
        try {
            while ((line = reader.readLine()) != null && !line.equals("-1")) {
                if (line.equals("-1")) break;
                    
            }
        } catch (IOException e) {}
    }

    public void mostrar() {
        String line;
        try {
            line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                    int numeroPartido = Integer.parseInt(line); 
                    Partido partido = cadastroPartido.consultaPartido(numeroPartido);
                    if (partido == null) {
                        System.out.println("4:Nenhum partido encontrado.\n");
                    } else {
                        System.out.println(String.format("4:%d,%s\n", partido.getNumero(), partido.getNome()));
                    }
            } else {
                System.out.println("Erro: Linha vazia ou nula encontrada ao tentar ler o número do partido.\n");
            }
        } catch (IOException e) {}
    }

	public void executar() {
        cadastrarPartidoFuncao();
        cadastrarCandidadoFuncao();
        cadastrarVotosCandidato();
        mostrarPartidosPeloNumero();
        mostrar();
    }
}
