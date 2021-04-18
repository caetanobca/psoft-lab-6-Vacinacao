package Paciente;

import com.sun.jdi.request.StepRequest;
import condicoes.CondicoesPrimeiraDose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    private Paciente pacienteTest;

    @BeforeEach
    void setUp() {
        HashSet<String> comorbidadesPaciente = new HashSet<>();
        comorbidadesPaciente.add("hipertensão");

        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("diabetes");
        comorbidades.add("imunossuprimidos");

        HashSet<String> profissoes = new HashSet<>();
        profissoes.add("medicos");
        profissoes.add("enfermeiros");

        CondicoesPrimeiraDose condicoesPrimeiraDose = new CondicoesPrimeiraDose(60, comorbidades, profissoes);

        this.pacienteTest = new Paciente("Caetano Albuquerque", "12345678900", "Rua da minha casa",
                "123456789123456", "caetano.albuquerque@email.com", "(83)912345678", "estudante",
                comorbidadesPaciente, 22, condicoesPrimeiraDose);
    }

    @Test
    void atualizaEstadoVacinacaoParaHabilitadoPrimeiraDose() {
        assertEquals("Paciente não habilitado para vacinação", this.pacienteTest.getSituacaoVacinacao());
        this.pacienteTest.addComorbidades("diabetes");
        assertEquals("Paciente habilitado para primeira dose", this.pacienteTest.getSituacaoVacinacao());
    }

    @Test
    void atualizaEstadoVacinacaoParaTomouPrimeira() {
        this.pacienteTest.addComorbidades("diabetes");

        this.pacienteTest.atualizaEstadoVacinacao();
        assertEquals("Paciente tomou primeira dose", this.pacienteTest.getSituacaoVacinacao());
    }

    @Test
    void atualizaEstadoVacinacaoParaHabilitadoSegundaDose() {
        this.pacienteTest.addComorbidades("diabetes");
        this.pacienteTest.atualizaEstadoVacinacao();

        this.pacienteTest.setPrimeiraDose(19);
        this.pacienteTest.atualizaEstadoVacinacao();
        assertNotEquals("Paciente habilitado para segunda dose", this.pacienteTest.getSituacaoVacinacao());

        this.pacienteTest.setPrimeiraDose(20);
        assertEquals("Paciente habilitado para segunda dose", this.pacienteTest.getSituacaoVacinacao());
    }

    @Test
    void atualizaEstadoVacinacaoParaFinalizada() {
        this.pacienteTest.addComorbidades("diabetes");
        this.pacienteTest.atualizaEstadoVacinacao();
        this.pacienteTest.setPrimeiraDose(20);
        this.pacienteTest.atualizaEstadoVacinacao();

        this.pacienteTest.atualizaEstadoVacinacao();
        assertEquals("Paciente com vacinação finalizada", this.pacienteTest.getSituacaoVacinacao());
    }

    @Test
    void tentarAtualizaEstadoVacinacaoQuandoFinalizada() {
        this.pacienteTest.addComorbidades("diabetes");
        this.pacienteTest.atualizaEstadoVacinacao();
        this.pacienteTest.setPrimeiraDose(20);
        this.pacienteTest.atualizaEstadoVacinacao();
        this.pacienteTest.atualizaEstadoVacinacao();

        this.pacienteTest.atualizaEstadoVacinacao();
        assertEquals("Paciente com vacinação finalizada", this.pacienteTest.getSituacaoVacinacao());
    }

    @Test
    void getSituacaoVacinacaoNaoHabilitado(){
        assertEquals("Paciente não habilitado para vacinação", this.pacienteTest.getSituacaoVacinacao());
    }
}