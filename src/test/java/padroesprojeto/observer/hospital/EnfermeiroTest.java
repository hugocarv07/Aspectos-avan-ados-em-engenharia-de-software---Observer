package padroesprojeto.observer.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnfermeiroTest {

    @Test
    void deveNotificarUmEnfermeiro() {
        Plantao plantao = new Plantao(2024, "Noite", "UTI", "Equipe A");
        Enfermeiro enfermeiro = new Enfermeiro("Enfermeiro 1");
        enfermeiro.escalarNoPlantao(plantao);
        plantao.registrarOcorrencia();
        assertEquals("Enfermeiro 1, ocorrência registrada no Plantao{ano=2024, turno='Noite', setor='UTI', equipe='Equipe A'}",
                enfermeiro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarEnfermeiros() {
        Plantao plantao = new Plantao(2024, "Noite", "UTI", "Equipe A");
        Enfermeiro enfermeiro1 = new Enfermeiro("Enfermeiro 1");
        Enfermeiro enfermeiro2 = new Enfermeiro("Enfermeiro 2");
        enfermeiro1.escalarNoPlantao(plantao);
        enfermeiro2.escalarNoPlantao(plantao);
        plantao.registrarOcorrencia();
        assertEquals("Enfermeiro 1, ocorrência registrada no Plantao{ano=2024, turno='Noite', setor='UTI', equipe='Equipe A'}",
                enfermeiro1.getUltimaNotificacao());
        assertEquals("Enfermeiro 2, ocorrência registrada no Plantao{ano=2024, turno='Noite', setor='UTI', equipe='Equipe A'}",
                enfermeiro2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarEnfermeiro() {
        Plantao plantao = new Plantao(2024, "Noite", "UTI", "Equipe A");
        Enfermeiro enfermeiro = new Enfermeiro("Enfermeiro 1");
        plantao.registrarOcorrencia();
        assertEquals(null, enfermeiro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarEnfermeiroDaEquipeA() {
        Plantao plantaoA = new Plantao(2024, "Noite", "UTI", "Equipe A");
        Plantao plantaoB = new Plantao(2024, "Noite", "UTI", "Equipe B");
        Enfermeiro enfermeiro1 = new Enfermeiro("Enfermeiro 1");
        Enfermeiro enfermeiro2 = new Enfermeiro("Enfermeiro 2");
        enfermeiro1.escalarNoPlantao(plantaoA);
        enfermeiro2.escalarNoPlantao(plantaoB);
        plantaoA.registrarOcorrencia();
        assertEquals("Enfermeiro 1, ocorrência registrada no Plantao{ano=2024, turno='Noite', setor='UTI', equipe='Equipe A'}",
                enfermeiro1.getUltimaNotificacao());
        assertEquals(null, enfermeiro2.getUltimaNotificacao());
    }
}
