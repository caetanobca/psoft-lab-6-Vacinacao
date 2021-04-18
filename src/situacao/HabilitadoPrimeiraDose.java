package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

import java.util.Calendar;

public class HabilitadoPrimeiraDose extends SituacaoVacinacao {

    public HabilitadoPrimeiraDose() {
        super();
    }

    @Override
    public void atualizaEstadoVacinacao(Paciente paciente) {
        paciente.setSituacaoVacinacao(new TomouPrimeiraDose());
        paciente.setPrimeiraDose(0);
    }

    @Override
    public String toString() {
        return "Paciente habilitado para primeira dose";
    }
}
