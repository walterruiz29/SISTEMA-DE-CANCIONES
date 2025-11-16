

package com.mycompany.gestor.canciones;
import modelo.*;
import gestor.*;
import java.util.*;
import modelo.*;
import gestor.*;
public class GestorCanciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioActual = null;

        System.out.println("🎶 Bienvenido al Sistema de Canciones 🎶");
        System.out.println("1. Login");
        System.out.println("2. Registrar");
        System.out.print("Seleccione opción: ");
        int opcion = sc.nextInt(); sc.nextLine();

        if (opcion == 1) {
            System.out.print("Usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();
            usuarioActual = GestorUsuarios.login(nombre, pass);
            if (usuarioActual == null) {
                System.out.println("❌ Usuario o contraseña incorrectos.");
                return;
            }
        } else if (opcion == 2) {
            System.out.print("Nuevo usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();
            usuarioActual = GestorUsuarios.registrar(nombre, pass);
            System.out.println("✅ Usuario registrado con éxito.");
        }
        
        

    public static List<Cancion> obtenerCancionesUsuario(int userId) {
        List<Cancion> todas = cargarCanciones();
        List<Cancion> propias = new ArrayList<>();
        for (Cancion c : todas) {
            if (c.getUserId() == userId) {
                propias.add(c);
            }
        }
        return propias;
    }

    public static void agregarCancion(int userId, String titulo, String artista) {
        List<Cancion> canciones = cargarCanciones();
        int nuevoId = canciones.size() + 1;
        Cancion nueva = new Cancion(nuevoId, userId, titulo, artista);
        canciones.add(nueva);
        guardarCanciones(canciones);
    }

    public static boolean eliminarCancion(int userId, int cancionId) {
        List<Cancion> canciones = cargarCanciones();
        boolean eliminada = canciones.removeIf(c -> c.getId() == cancionId && c.getUserId() == userId);
        if (eliminada) guardarCanciones(canciones);
        return eliminada;
    }

    public static boolean editarCancion(int userId, int cancionId, String nuevoTitulo, String nuevoArtista) {
        List<Cancion> canciones = cargarCanciones();
        for (Cancion c : canciones) {
            if (c.getId() == cancionId && c.getUserId() == userId) {
                c.setTitulo(nuevoTitulo);
                c.setArtista(nuevoArtista);
                guardarCanciones(canciones);
                return true;
            }
        }
        return false;
    }
    
    
    
    if (usuarioActual != null) {
            System.out.println("\n👋 Bienvenido, " + usuarioActual.getNombre());
            while (true) {
                System.out.println("\nMenú Principal:");
                System.out.println("1. Ver mis canciones");
                System.out.println("2. Agregar canción");
                System.out.println("3. Editar canción");
                System.out.println("4. Eliminar canción");
                System.out.println("5. Salir");
                System.out.print("Seleccione opción: ");
                int op = sc.nextInt(); sc.nextLine();

            }
        }
    if (op == 1) {
                    List<Cancion> canciones = GestorCanciones.obtenerCancionesUsuario(usuarioActual.getId());
                    if (canciones.isEmpty()) {
                        System.out.println("🎵 No tienes canciones registradas.");
                    } else {
                        canciones.forEach(System.out::println);
                    }
                }
    
    else if (op == 2) {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    GestorCanciones.agregarCancion(usuarioActual.getId(), titulo, artista);
                    System.out.println("✅ Canción agregada.");
                } 
                else if (op == 3) {
                    System.out.print("ID de la canción a editar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Nuevo artista: ");
                    String artista = sc.nextLine();
                    boolean ok = GestorCanciones.editarCancion(usuarioActual.getId(), id, titulo, artista);
                    System.out.println(ok ? "✅ Canción actualizada." : "❌ No se encontró la canción.");
                } 
                else if (op == 4) {
                    System.out.print("ID de la canción a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    boolean ok = GestorCanciones.eliminarCancion(usuarioActual.getId(), id);
                    System.out.println(ok ? "🗑️ Canción eliminada." : "❌ No se encontró la canción.");
                } 
                else if (op == 5) {
                    System.out.println("👋 Hasta luego, " + usuarioActual.getNombre() + "!");
                    break;
                }

 }

