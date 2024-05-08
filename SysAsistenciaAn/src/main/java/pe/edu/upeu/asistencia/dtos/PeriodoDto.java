/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.dtos;

//import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.asistencia.models.Evento;
import pe.edu.upeu.asistencia.models.Matricula;


/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeriodoDto {

     Long id;
     String nombre;
     String estado;
    // List<Matricula> matriculas;
    // List<Evento> eventos
    @JsonIgnoreProperties({"periodoId"})
    List<Matricula> matriculas;     
    @JsonIgnoreProperties({"periodoId"})
    List<Evento> eventos;

    public record PeriodoCrearDto(Long id, String nombre, String estado) {}
}
