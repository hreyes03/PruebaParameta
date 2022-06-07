/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba.prueba_parameta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.prueba_parameta.entity.Empleado;
/**
 *
 * @author COMPUMAX
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
