/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba_parameta.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

/**
 *
 * @author COMPUMAX
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El campo Nombre es obligatorio")
    private String nombres;
    @NotBlank(message = "El campo Apellido es obligatorio")
    private String apellidos;
    @NotBlank(message = "El campo Tipo de documento es obligatorio")
    private String tipoDocumeno;
    @NotBlank(message = "El campo Numero de documento es obligatorio")
    private String numeroDocumento;
    @NotNull(message = "El campo Fecha de nacimiento es obligatorio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @NotNull(message = "El campo Fecha de vinculacion es obligatorio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaVinculacion;
    @NotBlank(message = "El campo Cargo es obligatorio")
    private String cargo;
    @NotNull(message = "El campo Salario es obligatorio")
    private double salario;
    
    private String tiempoVinculacion;
    private String edad;
/*
    @PostPersist
    public JSONObject calcularFechas() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate fecha_actual = LocalDate.now();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        JSONObject resultado = new JSONObject();
        JSONObject formatoEdad = new JSONObject();
        JSONObject formatoVinculo = new JSONObject();


        LocalDate fecha_nacimiento = LocalDate.parse(dateFormat.format(fechaNacimiento), formato);
        LocalDate fecha_vinculo = LocalDate.parse(dateFormat.format(fechaVinculacion), formato);
        Period periodoNacimiento = Period.between(fecha_nacimiento, fecha_actual);
        Period periodoVinculo = Period.between(fecha_vinculo, fecha_actual);

        resultado.put("nombres",nombres);
        resultado.put("apellidos",apellidos);
        resultado.put("tipoDocumento",tipoDocumeno);
        resultado.put("numeroDocumento",numeroDocumento);
        resultado.put("fechaNacimiento",fechaNacimiento);
        resultado.put("fechaVinculacion",fechaVinculacion);
        resultado.put("cargo",cargo);
        resultado.put("salario",salario);

        formatoEdad.put("year",periodoNacimiento.getYears());
        formatoEdad.put("month",periodoNacimiento.getMonths());
        formatoEdad.put("day",periodoNacimiento.getDays());

        formatoVinculo.put("year",periodoVinculo.getYears());
        formatoVinculo.put("month",periodoVinculo.getMonths());

        resultado.put("edad",formatoEdad);
        resultado.put("tiempoVinculacion",formatoVinculo);
        return resultado;
    }
*/
}
