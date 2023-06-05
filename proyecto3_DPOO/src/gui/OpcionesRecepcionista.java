package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.PropertyManagementSystem;

public class OpcionesRecepcionista extends JFrame implements ActionListener{
	private PropertyManagementSystem PMS;
	public OpcionesRecepcionista(PropertyManagementSystem PMS) {
		this.PMS = PMS;
        setTitle("Opciones Recepcionista");
        setPreferredSize(new Dimension(400, 600));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Title Label
        JLabel lbTitulo = new JLabel("Bienvenido \nRecepcionista");
        Font fuente = lbTitulo.getFont();
        fuente = fuente.deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 30, 10);
        add(lbTitulo, gbc);
        
        fuente = fuente.deriveFont(15f);
        // Consultar Habitación Button
        JButton btnConsultarHabitacion = new JButton("Consultar Habitación");
        btnConsultarHabitacion.setFont(fuente);
        btnConsultarHabitacion.setBackground(new Color(118, 54, 38));
        btnConsultarHabitacion.setForeground(Color.WHITE);
        btnConsultarHabitacion.setActionCommand("CONSULTAR_HABITACION");
        btnConsultarHabitacion.addActionListener(this);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 15, 5, 15);
        add(btnConsultarHabitacion, gbc);

        // Realizar Reserva Button
        JButton btnRealizarReserva = new JButton("Realizar Reserva");
        btnRealizarReserva.setFont(fuente);
        btnRealizarReserva.setBackground(new Color(118, 54, 38));
        btnRealizarReserva.setForeground(Color.WHITE);
        btnRealizarReserva.setActionCommand("REALIZAR_RESERVA");
        btnRealizarReserva.addActionListener(this);
        gbc.gridy = 2;
        add(btnRealizarReserva, gbc);

        // Consultar Reserva Button
        JButton btnConsultarReserva = new JButton("Consultar Reserva");
        btnConsultarReserva.setFont(fuente);
        btnConsultarReserva.setBackground(new Color(118, 54, 38));
        btnConsultarReserva.setForeground(Color.WHITE);
        btnConsultarReserva.setActionCommand("CONSULTAR_RESERVA");
        btnConsultarReserva.addActionListener(this);
        gbc.gridy = 3;
        add(btnConsultarReserva, gbc);

        // Registrar Huésped Button
        JButton btnRegistrarHuesped = new JButton("Registrar Huésped");
        btnRegistrarHuesped.setFont(fuente);
        btnRegistrarHuesped.setBackground(new Color(118, 54, 38));
        btnRegistrarHuesped.setForeground(Color.WHITE);
        btnRegistrarHuesped.setActionCommand("REGISTRAR_HUESPED");
        btnRegistrarHuesped.addActionListener(this);
        gbc.gridy = 4;
        add(btnRegistrarHuesped, gbc);

        // Registrar Consumo Button
        JButton btnRegistrarConsumo = new JButton("Registrar Consumo");
        btnRegistrarConsumo.setFont(fuente);
        btnRegistrarConsumo.setBackground(new Color(118, 54, 38));
        btnRegistrarConsumo.setForeground(Color.WHITE);
        btnRegistrarConsumo.setActionCommand("REGISTRAR_CONSUMO");
        btnRegistrarConsumo.addActionListener(this);
        gbc.gridy = 5;
        add(btnRegistrarConsumo, gbc);
        
     // Registrar Consumo Button
        JButton btnCheckOut = new JButton("CheckOut");
        btnRegistrarConsumo.setFont(fuente);
        btnRegistrarConsumo.setBackground(new Color(118, 54, 38));
        btnRegistrarConsumo.setForeground(Color.WHITE);
        btnRegistrarConsumo.setActionCommand("CHECKOUT");
        btnRegistrarConsumo.addActionListener(this);
        gbc.gridy = 6;
        add(btnRegistrarConsumo, gbc);
        
        JButton btnCambiarPswrd = new JButton("Cambiar Contraseña");
        btnCambiarPswrd.setFont(fuente);
        btnCambiarPswrd.setBackground(new Color(118, 54, 38));
        btnCambiarPswrd.setForeground(Color.WHITE);
        btnCambiarPswrd.setActionCommand("CAMBIAR_CONTRASENA");
        btnCambiarPswrd.addActionListener(this);
        gbc.insets = new Insets(25, 15, 5, 15);
        gbc.gridy = 7;
        add(btnCambiarPswrd, gbc);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(fuente);
        btnSalir.setBackground(new Color(118, 54, 38));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setActionCommand("SALIR");
        btnSalir.addActionListener(this);
        gbc.insets = new Insets(5, 15, 5, 15);
        gbc.gridy = 8;
        add(btnSalir, gbc);
        
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

	    switch (comando) {
	        case "CONSULTAR_HABITACION":
	            ConsultarHabitacion consultarHabi = new ConsultarHabitacion(PMS);
	            break;
	        case "REALIZAR_RESERVA":
	            // Acciones a realizar cuando se presione el botón "Realizar Reserva"
	            break;
	        case "CONSULTAR_RESERVA":
	            // Acciones a realizar cuando se presione el botón "Consultar Reserva"
	            break;
	        case "REGISTRAR_HUESPED":
	            // Acciones a realizar cuando se presione el botón "Registrar Huésped"
	            break;
	        case "REGISTRAR_CONSUMO":
	        	
	        	break;
	        case "CAMBIAR_CONTRASENA":
	        	CambiarPassword newPassword = new CambiarPassword(PMS);
	            break;
	        case "CHECKOUT":
	        	PagarHabitacion checkout = new PagarHabitacion(PMS);
	            break;
	        case "SALIR":
	            // Acciones a realizar cuando se presione el botón "Salir"
	            dispose(); // Cierra el diálogo
	            break;
	        default:
	            break;
	    }
	}

}
