package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.bl.entities.Reserva;
import cr.ac.ucenfotec.tl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {

    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void menuPrincipal() {
        byte opcion = -1;

        do {
            try {
                System.out.println("\n-------------------------------------");
                System.out.println("      SISTEMA DE RESERVAS HOTELERAS   ");
                System.out.println("-------------------------------------");
                System.out.println("1) Registrar cliente");
                System.out.println("2) Registrar habitación");
                System.out.println("3) Registrar reserva");
                System.out.println("4) Ver clientes");
                System.out.println("5) Ver habitaciones");
                System.out.println("6) Ver reservas");
                System.out.println("7) Cancelar reserva");
                System.out.println("0) Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Byte.parseByte(entrada.readLine());

                switch (opcion) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2:
                        registrarHabitacion();
                        break;
                    case 3:
                        registrarReserva();
                        break;
                    case 4:
                        verClientes();
                        break;
                    case 5:
                        verHabitaciones();
                        break;
                    case 6:
                        verReservas();
                        break;
                    case 7:
                        cancelarReserva();
                        break;
                    case 0:
                        System.out.println("Gracias por utilizar el sistema.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } catch (SQLException e) {
                System.out.println("Error de base de datos: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("No se encontró el driver de MySQL.");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }

    private static void registrarCliente() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Registro de cliente ---");

        System.out.print("Nombre completo: ");
        String nombreCompleto = entrada.readLine();

        System.out.print("Identificación: ");
        String identificacion = entrada.readLine();

        System.out.print("Teléfono: ");
        String telefono = entrada.readLine();

        System.out.print("Correo: ");
        String correo = entrada.readLine();

        String mensaje = Controlador.registrarCliente(nombreCompleto, identificacion, telefono, correo);
        System.out.println(mensaje);
    }

    private static void registrarHabitacion() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Registro de habitación ---");

        System.out.print("Número de habitación: ");
        int numero = Integer.parseInt(entrada.readLine());

        System.out.print("Tipo de habitación: ");
        String tipo = entrada.readLine();

        System.out.print("Precio por noche: ");
        double precioPorNoche = Double.parseDouble(entrada.readLine());

        String mensaje = Controlador.registrarHabitacion(numero, tipo, precioPorNoche);
        System.out.println(mensaje);
    }

    private static void registrarReserva() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Registro de reserva ---");

        System.out.print("Código de reserva: ");
        String codigoReserva = entrada.readLine();

        System.out.print("Fecha de entrada: ");
        String fechaEntrada = entrada.readLine();

        System.out.print("Fecha de salida: ");
        String fechaSalida = entrada.readLine();

        System.out.print("Identificación del cliente: ");
        String identificacionCliente = entrada.readLine();

        System.out.print("Número de habitación: ");
        int numeroHabitacion = Integer.parseInt(entrada.readLine());

        String mensaje = Controlador.registrarReserva(
                codigoReserva,
                fechaEntrada,
                fechaSalida,
                identificacionCliente,
                numeroHabitacion
        );

        System.out.println(mensaje);
    }

    private static void verClientes() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Lista de clientes ---");

        ArrayList<Cliente> clientes = Controlador.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i).mostrarInformacion());
        }
    }

    private static void verHabitaciones() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Lista de habitaciones ---");

        ArrayList<Habitacion> habitaciones = Controlador.listarHabitaciones();

        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }

        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println(habitaciones.get(i).generarResumen());
        }
    }

    private static void verReservas() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Lista de reservas ---");

        ArrayList<Reserva> reservas = Controlador.listarReservas();

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (int i = 0; i < reservas.size(); i++) {
            System.out.println(reservas.get(i).generarResumen());
        }
    }

    private static void cancelarReserva() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n--- Cancelación de reserva ---");

        System.out.print("Código de la reserva a cancelar: ");
        String codigoReserva = entrada.readLine();

        String mensaje = Controlador.cancelarReserva(codigoReserva);
        System.out.println(mensaje);
    }
}