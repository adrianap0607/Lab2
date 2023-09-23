//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase representa un salón en una institución educativa.
 */
public class Salon {
    private int idSede;
    private char edificio;
    private int nivel;
    private int idSalon;
    private int capacidad;
    private Map<String, String[]> horarios;

    /**
     * Constructor de la clase Salon.
     *
     * @param idSede     El ID de la sede a la que pertenece el salón.
     * @param edificio   El edificio en el que se encuentra el salón.
     * @param nivel      El nivel o piso en el que se encuentra el salón.
     * @param idSalon    El ID del salón.
     * @param capacidad  La capacidad máxima de estudiantes que puede albergar el salón.
     */
    public Salon(int idSede, char edificio, int nivel, int idSalon, int capacidad) {
        this.idSede = idSede;
        this.edificio = edificio;
        this.nivel = nivel;
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.horarios = new HashMap<>();
    }

    /**
     * Obtiene el ID de la sede a la que pertenece el salón.
     *
     * @return El ID de la sede.
     */
    public int getIdSede() {
        return idSede;
    }

    /**
     * Establece el ID de la sede a la que pertenece el salón.
     *
     * @param idSede El ID de la sede.
     */
    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    /**
     * Obtiene el edificio en el que se encuentra el salón.
     *
     * @return El edificio del salón.
     */
    public char getEdificio() {
        return edificio;
    }

    /**
     * Establece el edificio en el que se encuentra el salón.
     *
     * @param edificio El edificio del salón.
     */
    public void setEdificio(char edificio) {
        this.edificio = edificio;
    }

    /**
     * Obtiene el nivel o piso en el que se encuentra el salón.
     *
     * @return El nivel o piso del salón.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel o piso en el que se encuentra el salón.
     *
     * @param nivel El nivel o piso del salón.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene el ID del salón.
     *
     * @return El ID del salón.
     */
    public int getIdSalon() {
        return idSalon;
    }

    /**
     * Establece el ID del salón.
     *
     * @param idSalon El ID del salón.
     */
    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    /**
     * Obtiene la capacidad máxima de estudiantes que puede albergar el salón.
     *
     * @return La capacidad del salón.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de estudiantes que puede albergar el salón.
     *
     * @param capacidad La capacidad del salón.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene los horarios asignados al salón.
     *
     * @return Un mapa de horarios donde la clave es el día de la semana y el valor es un arreglo de horario.
     */
    public Map<String, String[]> getHorarios() {
        return horarios;
    }

    /**
     * Establece los horarios asignados al salón.
     *
     * @param horarios Un mapa de horarios donde la clave es el día de la semana y el valor es un arreglo de horario.
     */
    public void setHorarios(Map<String, String[]> horarios) {
        this.horarios = horarios;
    }

    /**
     * Agrega un horario al salón para un día específico.
     *
     * @param dia     El día de la semana.
     * @param horario Un arreglo de horario en el formato [hora de inicio, hora de fin].
     */
    public void agregarHorario(String dia, String[] horario) {
        horarios.put(dia, horario);
    }

    /**
     * Obtiene los horarios asignados al salón para un día específico.
     *
     * @param dia El día de la semana.
     * @return Un arreglo de horario en el formato [hora de inicio, hora de fin].
     */
    public String[] obtenerHorarios(String dia) {
        return horarios.get(dia);
    }
}
