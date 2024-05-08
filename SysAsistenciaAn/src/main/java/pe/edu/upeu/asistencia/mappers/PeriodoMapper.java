/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.asistencia.dtos.PeriodoDto;
import pe.edu.upeu.asistencia.models.Periodo;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
@Mapper(componentModel = "spring")
public interface PeriodoMapper {
    PeriodoDto toPeriodoDto(Periodo periodo);

    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "actividads", ignore = true)
    Periodo periodoCrearDtoToPeriodo(PeriodoDto.PeriodoCrearDto periodoCrearDto);

    List<PeriodoDto> periodoListDtoToPeriodoList(List<Periodo> periodo);
    
}
