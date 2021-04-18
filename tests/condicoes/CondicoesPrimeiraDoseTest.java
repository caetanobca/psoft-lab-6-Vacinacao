package condicoes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CondicoesPrimeiraDoseTest {

    private CondicoesPrimeiraDose condicoesPrimeiraDoseTest;

    @BeforeEach
    void setUp() {
        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("hipertenssão");

        HashSet<String> profissoes = new HashSet<>();
        profissoes.add("medico");
        profissoes.add("enfermeiro");

        this.condicoesPrimeiraDoseTest = new CondicoesPrimeiraDose(60, comorbidades, profissoes);
    }

    @Test
    void naoLiberaVacina() {
        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("diabetes");

        assertFalse(this.condicoesPrimeiraDoseTest.liberaVacina(59, "escritor", comorbidades));
    }

    @Test
    void LiberaVacinaIdadeLimite() {
        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("diabetes");

        assertTrue(this.condicoesPrimeiraDoseTest.liberaVacina(60, "escritor", comorbidades));
    }

    @Test
    void LiberaVacinaComorbidade() {
        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("diabetes");
        comorbidades.add("hipertenssão");

        assertTrue(this.condicoesPrimeiraDoseTest.liberaVacina(30, "escritor", comorbidades));
    }

    @Test
    void LiberaVacinaProfissao() {
        HashSet<String> comorbidades = new HashSet<>();
        comorbidades.add("diabetes");

        assertTrue(this.condicoesPrimeiraDoseTest.liberaVacina(30, "enfermeiro", comorbidades));
    }
}