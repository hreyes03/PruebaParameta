/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba_parameta.services.impl;

import com.prueba.prueba_parameta.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.prueba.prueba_parameta.entity.Empleado;
import com.prueba.prueba_parameta.services.EmpleadoService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author COMPUMAX
 */
@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }


    @Override
    public Period calcular_fechas(Date fechaInicio) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha_actual = LocalDate.now();
        String fecha = dateToString(fechaInicio);
        LocalDate fecha_nacimiento = LocalDate.parse(fecha, formato);
        Period periodo = Period.between(fecha_nacimiento, fecha_actual);
        return periodo;
    }

    public String dateToString(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }
}
