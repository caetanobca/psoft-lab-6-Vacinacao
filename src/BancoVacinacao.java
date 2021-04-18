import Paciente.PacienteController;
import condicoes.CondicoesPrimeiraDose;

import java.util.HashSet;

public class BancoVacinacao {

    private PacienteController pacienteController;

    private CondicoesPrimeiraDose condicoesPrimeiraDose;

    public BancoVacinacao(){
        this.pacienteController = new PacienteController();
        this.condicoesPrimeiraDose = new CondicoesPrimeiraDose();
    }

    public void cadastrarPaciente(String nome, String cpf, String endereco, String sus, String email,
                                  String telefone, String profissao, HashSet<String> comorbidades,
                                  int idade){

        this.pacienteController.cadastrarPaciente(nome, cpf, endereco, sus, email, telefone,
                profissao, comorbidades, idade, this.condicoesPrimeiraDose);
    }

    public void setNome(String cpf, String nome) {
        this.pacienteController.setNome(cpf, nome);
    }

    public void setEndereco(String cpf, String endereco) {
        this.pacienteController.setEndereco(cpf, endereco);
    }

    public void setSus(String cpf, String sus) {
        this.pacienteController.setSus(cpf, sus);
    }

    public void setEmail(String cpf, String email) {
        this.pacienteController.setEmail(cpf, email);
    }

    public void setTelefone(String cpf, String telefone) {
        this.pacienteController.setTelefone(cpf, telefone);
    }

    public void setProfissao(String cpf, String profissao) {
        this.pacienteController.setProfissao(cpf, profissao);
    }

    public void setIdade(String cpf, int idade) {
        this.pacienteController.setIdade(cpf, idade);
    }

    public void addComorbidades(String cpf, String comorbidade) {
        this.pacienteController.addComorbidades(cpf, comorbidade);
    }

    public void setDiasDesdePrimeiraDose(String cpf, int diasDesdePrimeira) {
        this.pacienteController.setDiasDesdePrimeiraDose(cpf, diasDesdePrimeira);
    }

    public void atualizaEstadoVacinacao(String cpf){
        this.pacienteController.atualizaEstadoVacinacao(cpf);
    }

    public String getSituacaoVacinacao(String cpf){
        return this.pacienteController.getSituacaoVacinacao(cpf);
    }

    public void addComorbidadesCondicao(String comorbidade){
        this.condicoesPrimeiraDose.addComorbidades(comorbidade);
        this.atualizaCondicoesPasciente();
    }

    public void setIdadeMinimaCondicao(int idadeMinima) {
        this.condicoesPrimeiraDose.setIdadeMinima(idadeMinima);
        this.atualizaCondicoesPasciente();
    }

    public void addProfissaoCondicao(String profissao){
        this.condicoesPrimeiraDose.addProfissao(profissao);
        this.atualizaCondicoesPasciente();
    }

    private void atualizaCondicoesPasciente(){
        this.pacienteController.atualizaCondicoesPrimeiraDose(this.condicoesPrimeiraDose);
    }


}
