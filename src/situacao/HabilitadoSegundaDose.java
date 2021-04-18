package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

public class HabilitadoSegundaDose extends SituacaoVacinacao {
    public HabilitadoSegundaDose( ) {
        super();
    }

    @Override
    public void atualizaEstadoVacinacao(Paciente paciente) {
       paciente.setSituacaoVacinacao(new VacinacaoFinalizada());
    }

    @Override
    public String toString() {
        return "Paciente habilitado para segunda dose";
    }
}
