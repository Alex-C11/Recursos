/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.asistencia.models.Persona;
import pe.edu.upeu.asistencia.services.PersonaService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/asis/persona")
public class PersonaController {
    @Autowired
    private PersonaService entidadService;    
    

    @GetMapping(value = "/list")
    public ResponseEntity<List<Persona>> listEntidad() {

        return ResponseEntity.ok().body(entidadService.findAll());

    }     
}
