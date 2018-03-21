/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import Model.Persona;
import Controller.*;
import Model.PersonaPrototype;
 


public class Proyect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
                           PersonaPrototype a = new PersonaPrototype();
        Persona x = (Persona) a.prototipo("Client");
        System.out.println(x.getNombre());                                                                   
    }
    
}
