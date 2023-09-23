//Universidad del Valle de Guatemala	                                                                                            
//Adriana Palacios 
//CC2008 - Introducción a la Programación Orientada a Objetos 
//carné 23044
//Semestre II, 2023


import java.util.Scanner;

/**
 * Esta clase representa el punto de entrada principal de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AsignadorSalones asignadorSalones = new AsignadorSalones();

        int opcion;
        do {
            System.out.println("=== Menú ===");
            System.out.println("1. Cargar archivo de salones");
            System.out.println("2. Cargar archivo de cursos");
            System.out.println("3. Consultar salón");
            System.out.println("4. Mostrar detalles de curso");
            System.out.println("5. Asignar salones");
            System.out.println("6. Ver informe");
            System.out.println("7. Exportar resultado");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del archivo de salones: ");
                    String archivoSalones = scanner.nextLine();
                    asignadorSalones.cargarArchivoSalones(archivoSalones);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del archivo de cursos: ");
                    String archivoCursos = scanner.nextLine();
                    asignadorSalones.cargarArchivoCursos(archivoCursos);
                    break;
                case 3:
                    System.out.println("Ingrese los datos del salón a consultar:");
                    System.out.print("ID de la sede: ");
                    int idSede = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID del salón: ");
                    int idSalon = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Edificio: ");
                    char edificio = scanner.next().charAt(0);
                    System.out.print("Nivel: ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine();
                    asignadorSalones.consultarSalon(idSede, idSalon, edificio, nivel);
                    break;
                
                case 4:
                    System.out.print("Ingrese el ID del curso a consultar: ");
                    int idCursoConsulta = scanner.nextInt();
                    asignadorSalones.mostrarDetallesCurso(idCursoConsulta);
                    break;
                
                case 5:
                    asignadorSalones.asignarSalones();
                    break;
                case 6:
                    asignadorSalones.generarInforme();
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del archivo de exportación: ");
                    String archivoExportacion = scanner.nextLine();
                    asignadorSalones.exportarResultado(archivoExportacion);
                    break;
                
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        } while (opcion != 8);

        scanner.close(); 
    }
}
