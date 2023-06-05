package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
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
import modelo.PropertyManagementSystem;
import modelo.Usuario;

public class testCarga {

	private LectorEscritorArchivos lector;
	private Habitacion habitacion;
	
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
	}
	
	@Test
	@Order(1)
	@DisplayName("cargarServicios()")
	public void  testCargarServicios() {
		try {
			lector.cargarServicios();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Comsumible> prueba = lector.getServicios();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(2)
	@DisplayName("cargarCredenciales()")
	public void  testCargarCredenciales() {
		try {
			lector.cargarCredenciales();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Usuario> prueba = lector.getCredenciales();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(3)
	@DisplayName("cargarMenu()")
	public void  testCargarMenu() {
		try {
			lector.cargarMenu();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Producto> prueba = lector.getMenu();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(4)
	@DisplayName("cargarMenu()")
	public void  testCargarClientes() {
		try {
			lector.cargarClientes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Huesped> prueba = lector.getClientes();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(5)
	@DisplayName("cargarRegistroConsumos()")
	public void  testCargarRegistroConsumos() {
		try {
			lector.cargarClientes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, String> prueba = lector.getRegistroConsumos();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(6)
	@DisplayName("cargarCuentas()")
	public void  testCargarCuentas() {
		try {
			lector.cargarClientes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Cuenta> prueba = lector.getCuentas();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(7)
	@DisplayName("argarHabitaciones()")
	public void  testCargarHabitaciones() {
		try {
			lector.cargarHabitaciones();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, Habitacion> prueba = lector.getHabitaciones();
		assertTrue(0 < prueba.size(), () -> "Se carga los datos");
	}
	
	@Test
	@Order(8)
	@DisplayName("cargarDatos()")
	public void testCargarDatos() {
		lector.cargarDatos();
		ArrayList<Comsumible> servicios = lector.getServicios();
		ArrayList<Producto> menu = lector.getMenu();
		HashMap<String, Usuario> credenciales = lector.getCredenciales();
		HashMap<String, Huesped> clientes = lector.getClientes();
		HashMap<String, Habitacion> habitaciones = lector.getHabitaciones();
		HashMap<String, Cuenta> cuentas = lector.getCuentas();
		HashMap<String, String> registroConsumos = lector.getRegistroConsumos();
		assertAll("Comparar datos",
				() -> assertTrue(0 < servicios.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < menu.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < credenciales.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < clientes.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < habitaciones.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < cuentas.size(), () -> "Se carga los datos"),
				() -> assertTrue(0 < registroConsumos.size(), () -> "Se carga los datos"));
	}
	
	@Test
	@Order(9)
	@DisplayName("actualizarInformacion()")
	public void testActualizarInformacion() {
		File archivo = new File("data/archivoHabitaciones.txt");
		habitacion = new Habitacion("902", "Noveno Piso", "Individual", true, true, false);
		lector.cargarDatos();
		HashMap<String, Habitacion> habitaciones = lector.getHabitaciones();
		habitaciones.put("902", habitacion);
		lector.actualizarInformacion();
		File prueba = new File("data/archivoHabitaciones.txt");
		assertTrue(archivo != prueba, () -> "Se actualiza el archivo");
	}
	
}
