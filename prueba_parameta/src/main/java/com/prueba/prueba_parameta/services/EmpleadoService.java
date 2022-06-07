/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba.prueba_parameta.services;
import com.prueba.prueba_parameta.entity.Empleado;

import java.time.Period;
import java.util.Date;
/**
 *
 * @author COMPUMAX
 */
public interface EmpleadoService {
    public Empleado save(Empleado empleado);
    public Period calcular_fechas(Date fecha);
}
