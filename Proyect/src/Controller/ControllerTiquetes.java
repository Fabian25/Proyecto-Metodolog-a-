/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewTiquetes;
import Model.Tiquetes;
import java.util.ArrayList;
import java.util.List;
import DAO.*;
import IDAO.*;

/**
 *
 * @author jose
 */
public class ControllerTiquetes {

    private ViewTiquetes vista = new ViewTiquetes();

    public ControllerTiquetes() {
    }

    //llama al DAO para guardar un tiquete
    public void registrar(Tiquetes tiquete) {
        ITiqueteDAO dao = new TiquetesDAOImplements();
        dao.registrar(tiquete);
    }

    //llama al DAO para actualizar un tiquete
    public void actualizar(Tiquetes tiquete) {
        ITiqueteDAO dao = new TiquetesDAOImplements();
        dao.actualizar(tiquete);
    }

    //llama al DAO para eliminar un tiquete
    public void eliminar(Tiquetes tiquete) {
        ITiqueteDAO dao = new TiquetesDAOImplements();
        dao.eliminar(tiquete);
    }

    //llama al DAO para obtener todos los tiquete y luego los muestra en la vista
    public void verTiquetes() {
        List<Tiquetes> tiquetes = new ArrayList<Tiquetes>();
        ITiqueteDAO dao = new TiquetesDAOImplements();
        tiquetes = dao.obtener();
        vista.verClientes(tiquetes);
    }
}
