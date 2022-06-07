/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba_parameta.controller;

import com.prueba.prueba_parameta.services.EmpleadoService;
import com.prueba.prueba_parameta.entity.Empleado;

import java.time.Period;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author COMPUMAX
 */
@RequiredArgsConstructor
@RestController()
@RequestMapping("/api")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @PostMapping("/save")
    public JSONObject save(@Valid @RequestBody Empleado empleado) {
        JSONObject json_edad =  new JSONObject();
        JSONObject json_vinculo =  new JSONObject();
        JSONObject resultado =  new JSONObject();

        Period edad = empleadoService.calcular_fechas(empleado.getFechaNacimiento());
        Period vinculo = empleadoService.calcular_fechas(empleado.getFechaVinculacion());
            if (edad.getYears() > 18) {
                json_edad.put("year", edad.getYears());
                json_edad.put("month", edad.getMonths());
                json_edad.put("day", edad.getDays()-1);
                
                json_vinculo.put("year", vinculo.getYears());
                json_vinculo.put("month", vinculo.getMonths());
                empleado.setTiempoVinculacion(json_vinculo.toJSONString());
                empleado.setEdad(json_edad.toJSONString());
                Empleado empleadoSave = empleadoService.save(empleado);
                resultado.put("empleado",empleadoSave);
                resultado.put("vinculoLaboral",json_vinculo);
                resultado.put("edad",json_edad);
                return resultado;
            }else{
                resultado.put("empleado","usuario es menor de edad");
            }

        return resultado;

    }

}
