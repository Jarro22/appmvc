import controlador.UsuarioControlador;
import database.ConexionDB;
import modelo.UsuarioDAO;
import vista.UsuarioVista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            try {

                Connection conexion = ConexionDB.getConnection();

                UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
                UsuarioVista usuarioVista = new UsuarioVista();
                UsuarioControlador usuarioControlador = new
                        UsuarioControlador(usuarioDAO, usuarioVista);

                Scanner scanner = new Scanner(System.in);
                int opcion;
                do {
                    System.out.println("\n=== Menú de Gestión de Usuarios ===");
                    System.out.println("1. Mostrar usuarios");
                    System.out.println("2. Agregar usuario");
                    System.out.println("0. Salir");
                    System.out.print("Selecciona una opción: ");
                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            usuarioControlador.listarUsuarios(); // Mostrar usuarios
                            break;
                        case 2:
                            usuarioControlador.agregarUsuario(); // Agregar usuario
                            break;
                        case 0:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                } while (opcion !=0);

                ConexionDB.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
