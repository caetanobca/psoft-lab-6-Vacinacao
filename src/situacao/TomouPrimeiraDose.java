package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

public class TomouPrimeiraDose extends SituacaoVacinacao {
    public TomouPrimeiraDose( ) {
        super();
    }

    @Override
    public void atualizaEstadoVacinacao(Paciente paciente) {
        if (paciente.getPrimeiraDose() >= 20){
            paciente.setSituacaoVacinacao(new HabilitadoSegundaDose());
        }
    }

    @Override
    public String toString() {
        return "Paciente tomou primeira dose";
    }
}
