package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

public abstract class SituacaoVacinacao {
    protected CondicoesPrimeiraDose condicoesPrimeiraDose;

    public SituacaoVacinacao(){}

    public SituacaoVacinacao(CondicoesPrimeiraDose condicoesPrimeiraDose) {
        this.condicoesPrimeiraDose = condicoesPrimeiraDose;
    }

    public void atualizaEstadoVacinacao(Paciente paciente){}

    public void setCondicoesPrimeiraDose(CondicoesPrimeiraDose condicoesPrimeiraDose) {
        this.condicoesPrimeiraDose = condicoesPrimeiraDose;
    }
}
