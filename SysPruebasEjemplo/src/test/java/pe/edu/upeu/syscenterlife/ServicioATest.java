/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import pe.edu.upeu.syscenterlife.servicio.ServicioImpl;

import org.junit.jupiter.api.Test;
import pe.edu.upeu.syscenterlife.servicio.ServicioA;

/**
 *
 * @author Redes
 */
public class ServicioATest {

    @Test
    public void testSuma() {
        int a = 2;
        int b = 3;
        ServicioA servicioA = new ServicioImpl();
        Assertions.assertEquals(servicioA.suma(a, b), 5);
    }

    @Test
    public void testSumaValoresInc() {
        int a = -6;
        int b = 3;
        ServicioA servicioA = new ServicioImpl();
        Assertions.assertEquals(servicioA.suma(a, b), -3);
    }

    @Test
    public void testValidarClaves() {
        String clave = "Da123456@";
        ServicioA servicioA = new ServicioImpl();
        Assertions.assertEquals(servicioA.validarClave(clave), true);
    }
    
    @Test
    public void testValidarClavesSinNum() {
        String clave = "sdsdsds";
        ServicioA servicioA = new ServicioImpl();
        Assertions.assertEquals(servicioA.validarClave(clave), false);
    }

}
