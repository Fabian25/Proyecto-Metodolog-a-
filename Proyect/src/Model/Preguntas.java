/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jose
 */
public class Preguntas {

    public Preguntas(int IdPregunta, String Pregunta) {
        this.IdPregunta = IdPregunta;
        this.Pregunta = Pregunta;
    }

    public Preguntas() {
    }

    public int getIdPregunta() {
        return IdPregunta;
    }

    public void setIdPregunta(int IdPregunta) {
        this.IdPregunta = IdPregunta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }
    private int IdPregunta;
    private String Pregunta;
}
