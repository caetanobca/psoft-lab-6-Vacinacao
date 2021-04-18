package Paciente;

import condicoes.CondicoesPrimeiraDose;
import situacao.NaoHabilitado;
import situacao.SituacaoVacinacao;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Paciente {

    /**
     * Nome completo do pasciente
     */
    private String nome;

    /**
     * CPF do paciente (11 digitos)
     */
    private String cpf;

    /**
     * Endereço do pasciente
     */
    private String endereco;

    /**
     * Numero da carteirinha do SUS (Viva o SUS!!! <3)
     */
    private String sus;

    /**
     * endereço de e-mail do pasciente
     */
    private String email;

    /**
     * telefone do pasciente
     */
    private String telefone;

    /**
     * Profissão do pasciente, para caso isso o dê preferencia
     */
    private String profissao;

    /**
     * Comorbidades que o pasciente apresente
     */
    private Set<String> comorbidades;

    /**
     * Estado do pasciente em relação a vacinação
     * Podendo Ser:
     * 1. Não habilitada para a vacina;
     * 2. Habilitada para tomar a 1° dose;
     * 3. Tomou a 1° dose;
     * 4. Habilitada para tomar a 2° dose;
     * 5. Vacinação finalizada.
     */
    private SituacaoVacinacao situacaoVacinacao;

    /**
     * Idade do pasciente para saber quando ele vai ser liberado para a primeira dose.
     */
    private int idade;

    /**
     * Quantidades de dias desde de que o paciente tomou a primeira dose
     */
    private int diasDesdePrimeiraDose;



    /**
     * Constutor que inicializa os atributos de cadastro do pasciente.
     * @param nome
     * @param cpf
     * @param endereco
     * @param sus
     * @param email
     * @param telefone
     * @param profissao
     * @param comorbidades
     */
    public Paciente(String nome, String cpf, String endereco, String sus, String email, String telefone,
                    String profissao, HashSet<String> comorbidades, int idade, CondicoesPrimeiraDose condicoesPrimeiraDose) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sus = sus;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = comorbidades;
        this.idade = idade;
        this.situacaoVacinacao = new NaoHabilitado(condicoesPrimeiraDose);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSituacaoVacinacao(SituacaoVacinacao situacaoVacinacao) {
        this.situacaoVacinacao = situacaoVacinacao;
    }

    /**
     * Adiciona uma comorbidade ao paciente e verifica se isso o torna apto a receber a primeira dose
     * @param comorbidade
     */
    public void addComorbidades(String comorbidade) {
        this.comorbidades.add(comorbidade);
        this.atualizaEstadoVacinacao();
    }

    public void setPrimeiraDose(int primeiraDose) {
        this.diasDesdePrimeiraDose = primeiraDose;
        this.atualizaEstadoVacinacao();
    }

    public String getProfissao() {
        return profissao;
    }

    public Set<String> getComorbidades() {
        return comorbidades;
    }

    public int getIdade() {
        return idade;
    }

    public int getPrimeiraDose() {
        return this.diasDesdePrimeiraDose;
    }

    public void atualizaEstadoVacinacao(){
        this.situacaoVacinacao.atualizaEstadoVacinacao(this);
    }

    public String getSituacaoVacinacao(){
        return this.situacaoVacinacao.toString();
    }

    /**
     * Indentificador unico do paciente é o cpf
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return cpf.equals(paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public void atualizaCondicoesPrimeiraDose(CondicoesPrimeiraDose condicoesPrimeiraDose) {
        this.situacaoVacinacao.setCondicoesPrimeiraDose(condicoesPrimeiraDose);
    }
}
