/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Tiquetes;
import java.util.List;

/**
 *
 * @author jose
 */
public interface ITiqueteDAO {
    	public boolean registrar(Tiquetes tiquete);
	public List<Tiquetes> obtener();
	public boolean actualizar(Tiquetes  tiquete);
	public boolean eliminar(Tiquetes tiquete); 
}
