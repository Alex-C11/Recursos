/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife.servicio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Redes
 */
public class ServicioImpl implements ServicioA {

    public ServicioImpl() {
    }

    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    @Override
    public boolean validarClave(String clave) {

        if (clave.length() < 8) {
            return false;
        }

        // Verificar presencia de mayúsculas, minúsculas, números y caracteres especiales
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*()-_+=])(?=\\S+$).{8,}");
        Matcher matcher = pattern.matcher(clave);

        return matcher.matches();

    }

}
