package Paciente;

import condicoes.CondicoesPrimeiraDose;

import java.util.*;

public class PacienteController {

    /**
     * Mapa que guarda todos os pacientes cadastrados, usando como chave o seu cpf
     */
    private Map<String, Paciente> pacientes;

    public PacienteController(){
        this.pacientes = new HashMap<String, Paciente>();
    }

    public void cadastrarPaciente(String nome, String cpf, String endereco, String sus, String email,
                                  String telefone, String profissao, HashSet<String> comorbidades,
                                  int idade, CondicoesPrimeiraDose condicoesPrimeiraDose){

        if (!this.pacientes.containsKey(cpf)) {
            this.pacientes.put(cpf, new Paciente(nome, cpf, endereco, sus, email, telefone, profissao, comorbidades, idade,
                    condicoesPrimeiraDose));
        }
    }

    public void setNome(String cpf, String nome) {
        this.pacientes.get(cpf).setNome(nome);
    }

    public void setEndereco(String cpf, String endereco) {
        this.pacientes.get(cpf).setEndereco(endereco);
    }

    public void setSus(String cpf, String sus) {
        this.pacientes.get(cpf).setSus(sus);
    }

    public void setEmail(String cpf, String email) {
        this.pacientes.get(cpf).setEmail(email);
    }

    public void setTelefone(String cpf, String telefone) {
        this.pacientes.get(cpf).setTelefone(telefone);
    }

    public void setProfissao(String cpf, String profissao) {
        this.pacientes.get(cpf).setProfissao(profissao);
    }

    public void setIdade(String cpf, int idade) {
        this.pacientes.get(cpf).setIdade(idade);
    }

    public void setDiasDesdePrimeiraDose(String cpf, int diasDesdePrimeira) {
        this.pacientes.get(cpf).setPrimeiraDose(diasDesdePrimeira);
    }

    public void addComorbidades(String cpf, String comorbidade) {
        this.pacientes.get(cpf).addComorbidades(comorbidade);
    }

    public void atualizaEstadoVacinacao(String cpf){
        this.pacientes.get(cpf).atualizaEstadoVacinacao();
    }

    public String getSituacaoVacinacao(String cpf){
        return this.pacientes.get(cpf).getSituacaoVacinacao();
    }

    public void atualizaCondicoesPrimeiraDose(CondicoesPrimeiraDose condicoesPrimeiraDose) {
        for (Paciente p : this.pacientes.values()){
            p.atualizaCondicoesPrimeiraDose(condicoesPrimeiraDose);
        }
    }


}
