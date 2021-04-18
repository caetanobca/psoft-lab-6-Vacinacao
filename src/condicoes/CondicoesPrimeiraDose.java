package condicoes;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CondicoesPrimeiraDose {
    private int idadeMinima;
    private Set<String> comorbidades;
    private Set<String> profissoes;

    public CondicoesPrimeiraDose(){
        this.idadeMinima = 70;
        this.comorbidades = new HashSet<>();
        this.profissoes = new HashSet<>();
    }

    public CondicoesPrimeiraDose(int idadeMinima, HashSet<String> comorbidades, HashSet<String> profissoes) {
        this.comorbidades = comorbidades;
        this.idadeMinima = idadeMinima;
        this.profissoes = profissoes;
    }

    public void addComorbidades(String comorbidade){
        this.comorbidades.add(comorbidade);
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public void addProfissao(String profissao){
        this.profissoes.add(profissao);
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public boolean exisisteComorbidade(String comorbidade){
        return this.comorbidades.contains(comorbidade);
    }

    public boolean existeProfissao(String profissao){
        return this.profissoes.contains(profissao);
    }

    public boolean liberaVacina (int idade, String profissao, Set<String> comorbidades){
        return this.verificaIdade(idade) || this.verificaProfissao(profissao) || this.verificaComorbidades(comorbidades);
    }

    private boolean verificaIdade(int idade){
        return idade >= this.idadeMinima;
    }

    private boolean verificaProfissao(String profissao){
        return this.profissoes.contains(profissao);
    }

    private boolean verificaComorbidades(Set<String> comorbidades){
        return !Collections.disjoint(this.comorbidades, comorbidades);
    }
}
