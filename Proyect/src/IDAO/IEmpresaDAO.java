/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Persona;
import javafx.collections.ObservableList;

/**
 *
 * @author erick
 */
public interface IEmpresaDAO {
    
    public void registrarEmp(String txt_EntrepriceName, String txt_Acronym, String txt_Phone);
//     public ObservableList<Persona> Personas();
}