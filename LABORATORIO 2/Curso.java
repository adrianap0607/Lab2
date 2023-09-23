//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


/**
 * Esta clase representa un curso en una institución educativa.
 */
public class Curso {
    private int idCurso;
    private int idSede;
    private String nombreCurso;
    private int horario;
    private int duracion;
    private String dias;
    private int cantidadEstudiantes;
    private Salon salonAsignado; // Añadimos un atributo para el salón asignado

    /**
     * Constructor de la clase Curso.
     *
     * @param idCurso            El ID del curso.
     * @param idSede             El ID de la sede donde se imparte el curso.
     * @param nombreCurso        El nombre del curso.
     * @param horario            El horario del curso.
     * @param duracion           La duración del curso.
     * @param dias               Los días en que se imparte el curso.
     * @param cantidadEstudiantes La cantidad de estudiantes inscritos en el curso.
     */
    public Curso(int idCurso, int idSede, String nombreCurso, int horario, int duracion, String dias, int cantidadEstudiantes) {
        this.idCurso = idCurso;
        this.idSede = idSede;
        this.nombreCurso = nombreCurso;
        this.horario = horario;
        this.duracion = duracion;
        this.dias = dias;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    /**
     * Obtiene el ID del curso.
     *
     * @return El ID del curso.
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * Obtiene el ID de la sede donde se imparte el curso.
     *
     * @return El ID de la sede.
     */
    public int getIdSede() {
        return idSede;
    }

    /**
     * Obtiene el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * Obtiene el horario del curso.
     *
     * @return El horario del curso.
     */
    public int getHorario() {
        return horario;
    }

    /**
     * Obtiene la duración del curso.
     *
     * @return La duración del curso.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene los días en que se imparte el curso.
     *
     * @return Los días del curso.
     */
    public String getDias() {
        return dias;
    }

    /**
     * Obtiene la cantidad de estudiantes inscritos en el curso.
     *
     * @return La cantidad de estudiantes.
     */
    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    /**
     * Obtiene el salón asignado para el curso.
     *
     * @return El salón asignado o null si no se ha asignado un salón.
     */
    public Salon getSalonAsignado() {
        return salonAsignado;
    }

    /**
     * Establece el salón asignado para el curso.
     *
     * @param salonAsignado El salón asignado.
     */
    public void setSalonAsignado(Salon salonAsignado) {
        this.salonAsignado = salonAsignado;
    }
}
