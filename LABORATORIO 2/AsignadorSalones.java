//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.io.BufferedReader;
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa un Asignador de Salones que se encarga de asignar salones
 * a cursos en una institución educativa.
 */
public class AsignadorSalones {

    private List<Salon> salones;
    private List<Curso> cursos;
    private List<Curso> cursosAsignados;
    private List<Curso> cursosNoAsignados;

    /**
     * Constructor de la clase AsignadorSalones. Inicializa las listas de salones,
     * cursos asignados y cursos no asignados.
     */
    public AsignadorSalones() {
        salones = new ArrayList<>();
        cursos = new ArrayList<>();
        cursosAsignados = new ArrayList<>();
        cursosNoAsignados = new ArrayList<>();
    }

    /**
     * Carga los datos de salones desde un archivo CSV.
     *
     * @param nombreArchivo El nombre del archivo CSV que contiene los datos de salones.
     */
    public void cargarArchivoSalones(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            br.readLine(); // Omitir la primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                // Procesar cada línea del archivo CSV de salones
                String[] datos = line.split(",");
                if (datos.length == 5) {
                    int idSede = Integer.parseInt(datos[0].trim());
                    char edificio = datos[1].trim().charAt(0);
                    int nivel = Integer.parseInt(datos[2].trim());
                    int idSalon = Integer.parseInt(datos[3].trim());
                    int capacidad = Integer.parseInt(datos[4].trim());

                    // Crea y agrega un nuevo salón a la lista de salones
                    Salon salon = new Salon(idSede, edificio, nivel, idSalon, capacidad);
                    salones.add(salon);
                } else {
                    System.out.println("Línea incorrecta en el archivo de salones: " + line);
                }
            }
            System.out.println("Archivo de salones cargado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de salones: " + e.getMessage());
        }
    }
    
    /**
     * Carga los datos de cursos desde un archivo CSV.
     *
     * @param nombreArchivo El nombre del archivo CSV que contiene los datos de cursos.
     */
    public void cargarArchivoCursos(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            br.readLine(); // Omitir la primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                // Procesar cada línea del archivo CSV de cursos
                String[] datos = line.split(",");
                if (datos.length == 7) {
                    int idCurso = Integer.parseInt(datos[0]);
                    int idSede = Integer.parseInt(datos[1]);
                    String nombreCurso = datos[2];
                    int horario = Integer.parseInt(datos[3]);
                    int duracion = Integer.parseInt(datos[4]);
                    String dias = datos[5];
                    int cantidadEstudiantes = Integer.parseInt(datos[6]);

                    // Crea y agrega un nuevo curso a la lista de cursos
                    Curso curso = new Curso(idCurso, idSede, nombreCurso, horario, duracion, dias, cantidadEstudiantes);
                    cursos.add(curso);
                } else {
                    System.out.println("Línea incorrecta en el archivo de cursos: " + line);
                }
            }
            System.out.println("Archivo de cursos cargado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de cursos: " + e.getMessage());
        }
    }

    /**
     * Consulta y muestra detalles de un salón específico.
     *
     * @param idSede    El ID de la sede del salón.
     * @param idSalon   El ID del salón.
     * @param edificio  El edificio en el que se encuentra el salón.
     * @param nivel     El nivel en el que se encuentra el salón.
     */
    public void consultarSalon(int idSede, int idSalon, char edificio, int nivel) {
        for (Salon salon : salones) {
            if (salon.getIdSede() == idSede &&
                salon.getIdSalon() == idSalon &&
                salon.getEdificio() == edificio &&
                salon.getNivel() == nivel) {
                System.out.println("Sede: " + salon.getIdSede());
                System.out.println("Edificio: " + salon.getEdificio());
                System.out.println("Nivel: " + salon.getNivel());
                System.out.println("ID del salón: " + salon.getIdSalon());

                // Obtén los horarios del salón
                Map<String, String[]> horarios = salon.getHorarios();

                // Muestra los horarios si están disponibles
                if (!horarios.isEmpty()) {
                    System.out.println("Horarios del salón:");
                    for (Map.Entry<String, String[]> entry : horarios.entrySet()) {
                        String dia = entry.getKey();
                        String[] horario = entry.getValue();
                        System.out.println(dia + ": " + horario[0] + " a " + horario[1]);
                    }
                } else {
                    System.out.println("El salón no tiene horarios asignados.");
                }
                return;
            }
        }
        System.out.println("Salón no encontrado.");
    }

    /**
     * Consulta y muestra detalles de un curso específico.
     *
     * @param idCurso El ID del curso.
     */
    public void mostrarDetallesCurso(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getIdCurso() == idCurso) {
                System.out.println("ID: " + curso.getIdCurso());
                System.out.println("Sede: " + curso.getIdSede());
                System.out.println("Nombre del curso: " + curso.getNombreCurso());
                System.out.println("Horario: " + curso.getHorario());
                System.out.println("Duración: " + curso.getDuracion());
                System.out.println("Días: " + curso.getDias());
                System.out.println("Cantidad de estudiantes: " + curso.getCantidadEstudiantes());

                Salon salonAsignado = curso.getSalonAsignado();
                if (salonAsignado != null) {
                    System.out.println("Salón asignado: Sede " + salonAsignado.getIdSede() +
                                       ", Edificio " + salonAsignado.getEdificio() +
                                       ", Nivel " + salonAsignado.getNivel() +
                                       ", ID del salón " + salonAsignado.getIdSalon());
                } else {
                    System.out.println("Este curso aún no tiene un salón asignado.");
                }
                return;
            }
        }
        System.out.println("Curso no encontrado.");
    }

    /**
     * Asigna salones a cursos según ciertas condiciones.
     */
    public void asignarSalones() {
        for (Curso curso : cursos) {
            if (curso.getSalonAsignado() == null) {
                for (Salon salon : salones) {
                    // Verifica las condiciones para la asignación de salón (según tus reglas)
                    if (salon.getIdSede() == curso.getIdSede() &&
                        salon.getCapacidad() >= curso.getCantidadEstudiantes()) {
                        // Asigna el salón al curso
                        curso.setSalonAsignado(salon);
                        cursosAsignados.add(curso);
                        break; // Sale del bucle interno una vez asignado un salón
                    }
                }
                // Si no se pudo asignar un salón, agrega el curso a la lista de no asignados
                if (curso.getSalonAsignado() == null) {
                    cursosNoAsignados.add(curso);
                }
            }
        }
        System.out.println("Asignación de salones completada.");
    }

    /**
     * Genera un informe que muestra los cursos asignados y no asignados.
     */
    public void generarInforme() {
        System.out.println("=== Informe ===");
        System.out.println("Cursos asignados:");
        for (Curso curso : cursosAsignados) {
            System.out.println("ID del curso: " + curso.getIdCurso());
            System.out.println("Sede: " + curso.getIdSede());
            System.out.println("Nombre del curso: " + curso.getNombreCurso());
            System.out.println("Salón asignado: " + curso.getSalonAsignado().getIdSalon());
        }

        System.out.println("\nCursos no asignados:");
        for (Curso curso : cursosNoAsignados) {
            System.out.println("ID del curso: " + curso.getIdCurso());
            System.out.println("Sede: " + curso.getIdSede());
            System.out.println("Nombre del curso: " + curso.getNombreCurso());
        }
    }

    /**
     * Exporta los resultados a un archivo de texto.
     *
     * @param nombreArchivo El nombre del archivo de texto donde se exportarán los resultados.
     */
    public void exportarResultado(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribe los resultados en el archivo en el formato deseado
            for (Curso curso : cursosAsignados) {
                writer.write("ID del curso: " + curso.getIdCurso() + "\n");
                writer.write("Sede: " + curso.getIdSede() + "\n");
                writer.write("Nombre del curso: " + curso.getNombreCurso() + "\n");
                writer.write("Salón asignado: " + curso.getSalonAsignado().getIdSalon() + "\n");
                // Escribe más detalles según tus necesidades
                writer.write("\n");
            }

            writer.write("\nCursos no asignados:\n");
            for (Curso curso : cursosNoAsignados) {
                writer.write("ID del curso: " + curso.getIdCurso() + "\n");
                writer.write("Sede: " + curso.getIdSede() + "\n");
                writer.write("Nombre del curso: " + curso.getNombreCurso() + "\n");
                // Escribe más detalles según tus necesidades
                writer.write("\n");
            }

            System.out.println("Resultados exportados a " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar el resultado: " + e.getMessage());
        }
    }
}
