package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import modelo.Comsumible;
import modelo.Cuenta;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.LectorEscritorArchivos;
import modelo.Producto;
import modelo.Recepcionista;
import modelo.ServicioAlojamiento;
import modelo.Usuario;

public class testRecepcionista {
	
	private Recepcionista recepcionista;
	private Comsumible consumible;
	private LectorEscritorArchivos lector;
		
	@BeforeEach
	public void setUp() {
		ArrayList<Comsumible> servicios = new ArrayList<Comsumible>();
		ArrayList<Producto> menu = new ArrayList<Producto>();
		HashMap<String, Usuario> credenciales = new HashMap<String, Usuario>();
		HashMap<String, Huesped> clientes = new HashMap<String, Huesped>();
		HashMap<String, Habitacion> habitaciones = new HashMap<String, Habitacion>();
		HashMap<String, Cuenta> cuentas = new HashMap<String, Cuenta>();
		HashMap<String, String> registroConsumos = new HashMap<String, String>();
			
		lector = new LectorEscritorArchivos(servicios, menu, credenciales, clientes, habitaciones,
				cuentas, registroConsumos);
		recepcionista = new Recepcionista("Andrea Parra Mejia", "1391620479", "2170",
				"aparram@hotel.com", "Recepcionista", "Andrea","1234", habitaciones, cuentas, clientes);
	}
	
	@Test
	@Order(1)
	@DisplayName("crearHuesped()")
	public void  testCrearHuesped() {
		lector.cargarDatos();
		HashMap<String, Habitacion> hatabiciones = lector.getHabitaciones();
		HashMap<String, Huesped> numero = recepcionista.getClientes();
		recepcionista.crearHuesped("Gabriel Aristizabal", "1001297408", "3208138796", "g.aristizabal@uniandes.edu.co",
				null, "1234", hatabiciones, "Huesped");
		HashMap<String, Huesped> prueba = recepcionista.getClientes();
		assertTrue(numero.size() < prueba.size(), () -> "Se crea el huesped");
	}
	
	@Test
	@Order(2)
	@DisplayName("nuevaReserva()")
	public void  testNuevaReserva() {
		lector.cargarDatos();
		Habitacion habitacion = new Habitacion("902", "Noveno Piso", "Individual", true, true, false);
		lector.cargarDatos();
		HashMap<String, Habitacion> hatabiciones = lector.getHabitaciones();
		recepcionista.crearHuesped("Gabriel Aristizabal", "1001297408", "3208138796", "g.aristizabal@uniandes.edu.co",
				null, "1234", hatabiciones, "Huesped");
		HashMap<String, Huesped> lista = recepcionista.getClientes();
		Huesped huesped = lista.get("1001297408");
		String cuenta = huesped.getCuentaActual();
		Comsumible consumible = new ServicioAlojamiento(habitacion, "7/4/2023");
		recepcionista.nuevaReserva(huesped, consumible, false, "7/4/2023", "777");
		String prueba = huesped.getCuentaActual();
		HashMap<String, Cuenta> cuentas = huesped.getCuentas();
		assertAll("Comparar datos",
				() -> assertTrue(cuenta != prueba, () -> "Se cambia la cuenta actual"),
				() -> assertTrue(0 < cuentas.size(), () -> "Se la cuenta"));
	}
	
}
