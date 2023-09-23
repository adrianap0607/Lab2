//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


/**
 * Esta clase representa una sede en una institución educativa.
 */
public class Sede {
    private int idSede;
    private char edificio;
    private int nivel;

    /**
     * Constructor de la clase Sede.
     *
     * @param idSede   El ID de la sede.
     * @param edificio El edificio de la sede.
     * @param nivel    El nivel o piso de la sede.
     */
    public Sede(int idSede, char edificio, int nivel) {
        this.idSede = idSede;
        this.edificio = edificio;
        this.nivel = nivel;
    }

    /**
     * Obtiene el ID de la sede.
     *
     * @return El ID de la sede.
     */
    public int getIdSede() {
        return idSede;
    }

    /**
     * Obtiene el edificio de la sede.
     *
     * @return El edificio de la sede.
     */
    public char getEdificio() {
        return edificio;
    }

    /**
     * Obtiene el nivel o piso de la sede.
     *
     * @return El nivel o piso de la sede.
     */
    public int getNivel() {
        return nivel;
    }
}
