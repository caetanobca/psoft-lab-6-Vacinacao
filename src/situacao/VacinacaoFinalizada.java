package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

public class VacinacaoFinalizada extends SituacaoVacinacao {
    public VacinacaoFinalizada( ) {
        super();
    }

    @Override
    public String toString() {
        return "Paciente com vacinação finalizada";
    }
}
