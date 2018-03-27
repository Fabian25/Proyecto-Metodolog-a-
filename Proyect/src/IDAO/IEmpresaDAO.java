/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Empresa;
import Model.Persona;
import javafx.collections.ObservableList;

/**
 *
 * @author erick
 */
public interface IEmpresaDAO {

    public void registrarEmp(String txt_EntrepriceName, String txt_Acronym, String txt_Phone);

    public void registrarStorage(String txt_EntrepriceName, String txt_Acronym, String txt_Phone);
    
    public void Modificar(String txt_EntrepriceName, String txt_Acronym, String txt_Phone, String idEmpresa);

    public ObservableList<Empresa> Empresa(String busqueda);
    
     public void eliminar(String id);
}
