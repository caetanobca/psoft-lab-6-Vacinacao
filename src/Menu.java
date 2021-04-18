import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Menu {

    private BancoVacinacao bancoVacinacao = new BancoVacinacao();

    public Menu() {
    }

    public void exibeMenu() {
        String menu =
                "\n\nMenu: \n" +
                        "1. Cadstrar Paciente\n" +
                        "2. Alterar Dados do Paciente\n" +
                        "3. Atualizar Situação da Vacinação do Paciente\n" +
                        "4. Verificar Situação da Vacinação do Paciente\n" +
                        "5. Cadastrar Comorbidade\n" +
                        "6. Cadastrar Profissão\n" +
                        "7. Definir Idade Minima\n" +
                        "8. fechar o programa\n";

        Scanner sc = new Scanner(System.in);
        String opcao;

        do {
            System.out.println(menu);
            opcao = sc.nextLine();

            if (opcao.equals("1")) {
                this.cadastrarPaciente();

            } else if (opcao.equals("2")) {
                this.alterarPaciente();

            } else if (opcao.equals("3")) {
                this.atualizarSituacaoPaciente();

            } else if (opcao.equals("4")) {
                this.verificarSituacaoPaciente();

            } else if (opcao.equals("5")) {
                this.cadastrarComorbidades();

            } else if (opcao.equals("6")) {
                this.cadastrarProfissao();

            } else if (opcao.equals("7")) {
                this.definirIdadeMinima();
            }

        } while (!(opcao.equals("8")));
    }

    private void cadastrarPaciente() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Nome: \n");
        String nome = sc.nextLine();

        System.out.printf("cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Endereço: \n");
        String endereco = sc.nextLine();

        System.out.printf("Cartão do sus: \n");
        String sus = sc.nextLine();

        System.out.printf("E-mail: \n");
        String email = sc.nextLine();

        System.out.printf("Telefone: \n");
        String telefone = sc.nextLine();

        System.out.printf("Profissão: \n");
        String profissao = sc.nextLine();

        System.out.printf("Comorbidades (digitar todas as comorbidades em uma linhas separando por ',''): \n");
        String comorbidadesString = sc.nextLine();
        HashSet<String> comorbidades = new HashSet<>();
        Collections.addAll(comorbidades, comorbidadesString.split(","));

        System.out.printf("Idade: \n");
        int idade = sc.nextInt();

        this.bancoVacinacao.cadastrarPaciente(nome, cpf, endereco, sus, email,
                telefone, profissao, comorbidades, idade);
    }

    private void alterarPaciente() {
        String menuAterarPaciente =
                "O que você deseja alterar: \n" +
                        "1. Nome\n" +
                        "2. Endereço\n" +
                        "3. Cartão do SUS\n" +
                        "4. E-mai\n" +
                        "5. Telefone\n" +
                        "6. Profissão\n" +
                        "7. Idade\n" +
                        "8. Comorbidade\n" +
                        "9. Dias desde a primeira dose\n";

        Scanner sc = new Scanner(System.in);
        String opcao;
        System.out.println(menuAterarPaciente);
        opcao = sc.nextLine();

        if (opcao.equals("1")) {
            this.alterarNome();

        } else if (opcao.equals("2")) {
            this.alterarEndereco();

        } else if (opcao.equals("3")) {
            this.alterarSus();

        } else if (opcao.equals("4")) {
            this.alterarEmail();

        } else if (opcao.equals("5")) {
            this.alterarTelefone();

        } else if (opcao.equals("6")) {
            this.alterarProfissao();

        } else if (opcao.equals("7")) {
            this.alterarIdade();

        } else if (opcao.equals("8")) {
            this.alterarComorbidade();
        }
        else if (opcao.equals("9")) {
            this.alterarDiasDesdePrimeiraDose();
        }
    }



    private void alterarNome() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Novo nome: \n");
        String nome = sc.nextLine();

        this.bancoVacinacao.setNome(cpf, nome);
    }

    private void alterarEndereco() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Novo endereço: \n");
        String endereco = sc.nextLine();

        this.bancoVacinacao.setEndereco(cpf, endereco);
    }

    private void alterarSus() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Novo Cartão do SUS: \n");
        String sus = sc.nextLine();

        this.bancoVacinacao.setSus(cpf, sus);
    }

    private void alterarEmail() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Novo e-maiç: \n");
        String email = sc.nextLine();

        this.bancoVacinacao.setEmail(cpf,email);
    }

    private void alterarTelefone() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Novo telefone: \n");
        String telefone = sc.nextLine();

        this.bancoVacinacao.setTelefone(cpf, telefone);
    }

    private void alterarProfissao() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Nova Profissão: \n");
        String profissao = sc.nextLine();

        this.bancoVacinacao.setProfissao(cpf, profissao);
    }

    private void alterarIdade() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Nova idade: \n");
        int idade = sc.nextInt();

        this.bancoVacinacao.setIdade(cpf, idade);
    }

    private void alterarComorbidade() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Nova comorbidade: \n");
        String comrbidade = sc.nextLine();

        this.bancoVacinacao.addComorbidades(cpf, comrbidade);
    }

    private void alterarDiasDesdePrimeiraDose() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf("Quantos dias desde a primeira dose: \n");
        int diasDesdePrimeira = sc.nextInt();

        this.bancoVacinacao.setDiasDesdePrimeiraDose(cpf, diasDesdePrimeira);
    }

    private void atualizarSituacaoPaciente() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        this.bancoVacinacao.atualizaEstadoVacinacao(cpf);
    }

    private void verificarSituacaoPaciente() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Cpf: \n");
        String cpf = sc.nextLine();

        System.out.printf(this.bancoVacinacao.getSituacaoVacinacao(cpf));
    }

    private void cadastrarComorbidades() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Comorbidade: \n");
        String comorbidade = sc.nextLine();

        this.bancoVacinacao.addComorbidadesCondicao(comorbidade);
    }

    private void cadastrarProfissao() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Profissão: \n");
        String profissao = sc.nextLine();

        this.bancoVacinacao.addProfissaoCondicao(profissao);
    }

    private void definirIdadeMinima() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Idade minima: \n");
        int idadeMinima = sc.nextInt();

        this.bancoVacinacao.setIdadeMinimaCondicao(idadeMinima);
    }

}
