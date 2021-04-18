package situacao;

import Paciente.Paciente;
import condicoes.CondicoesPrimeiraDose;

public class NaoHabilitado extends SituacaoVacinacao {

    public NaoHabilitado(CondicoesPrimeiraDose condicoesPrimeiraDose) {
        super(condicoesPrimeiraDose);
    }

    @Override
    public void atualizaEstadoVacinacao(Paciente paciente){
        if (super.condicoesPrimeiraDose.liberaVacina(paciente.getIdade(), paciente.getProfissao(), paciente.getComorbidades())){
            paciente.setSituacaoVacinacao(new HabilitadoPrimeiraDose());
        }
    }

    @Override
    public String toString() {
        return "Paciente não habilitado para vacinação";
    }
}