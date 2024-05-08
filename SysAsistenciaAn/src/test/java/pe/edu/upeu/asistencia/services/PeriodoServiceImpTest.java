/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upeu.asistencia.models.Periodo;
import pe.edu.upeu.asistencia.repositories.PeriodoRepository;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Order;


/**
 *
 * @author DELL
 */
@ExtendWith(MockitoExtension.class)
public class PeriodoServiceImpTest {

    @Mock
    private PeriodoRepository periodoRepository;

    @InjectMocks
    private PeriodoServiceImp periodoService;

    Periodo periodo;

    @BeforeEach
    public void setUp() {
        periodo = Periodo.builder()
                .id(1L)
                .nombre("2024-1")
                .estado("Activo")
                .build();
    }

    @AfterEach
    public void tearDown() {
    }

    @Order(1)
    @DisplayName("Test para guardar un periodo")
    @Test
    public void testSave() {
        System.out.println("save");
        //given       
        given(periodoRepository.save(periodo)).willReturn(periodo);
        //when
        Periodo periodox = periodoService.save(periodo);
        System.out.println(periodox.getNombre()+"\t"+periodox.getEstado());
        //then
        assertThat(periodox.getNombre()).isNotNull();
        assertThat(periodox.getNombre()).isEqualTo(periodo.getNombre());
    }

    @Test
    public void testFindAll() {
        //given
        Periodo empleado1 = Periodo.builder()
                .id(2L)
                .nombre("2024-2")
                .estado("Activo")
                .build();
        given(periodoRepository.findAll()).willReturn(List.of(periodo, empleado1));
        //when
        List<Periodo> empleados = periodoService.findAll();
        for (Periodo empleado : empleados) {
            System.out.println(empleado.getId()+"\t"+empleado.getNombre()+"\t"+empleado.getEstado());
        }
        //then
        assertThat(empleados).isNotNull();
        assertThat(empleados.size()).isEqualTo(2);
    }

    @Order(2)
    @Test
    public void testGetPeriodoById() {
        System.out.println("getPeriodoById");
        //given        
        given(periodoRepository.findById(1L)).willReturn(Optional.of(periodo));
        //when
        Periodo periodox = periodoService.getPeriodoById(periodo.getId());
        //then
        System.out.println(periodox.getId()+"\t"+periodox.getNombre()+"\t"+periodox.getEstado());
        assertThat(periodox).isNotNull();
    }

    @Order(3)
    @Test
    public void testDelete() {
        System.out.println("delete");
        // Mock           
        given(periodoRepository.findById(1L)).willReturn(Optional.of(periodo));
        // Llamada a método a testear
        Map<String, Boolean> response = periodoService.delete(1L);
        // Asserts
        assertThat(response.get("deleted")).isEqualTo(true);
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        //given
        given(periodoRepository.save(periodo)).willReturn(periodo);
        given(periodoRepository.findById(1L)).willReturn(Optional.of(periodo));

        periodo.setEstado("Inactivo");
        periodo.setNombre("2025-1");
        //when
        Periodo periodoActualizado = periodoService.update(periodo, 1L);
         System.out.println(periodoActualizado.getId()+"\t"+periodoActualizado.getNombre()
                 +"\t"+periodoActualizado.getEstado());
        //then
        assertThat(periodoActualizado.getNombre()).isEqualTo("2025-1");
        assertThat(periodoActualizado.getEstado()).isEqualTo("Inactivo");

    }

}
