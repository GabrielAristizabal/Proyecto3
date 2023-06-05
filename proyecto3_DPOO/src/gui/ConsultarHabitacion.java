package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Habitacion;
import model.PropertyManagementSystem;

public class ConsultarHabitacion extends JDialog implements ActionListener {
	private PropertyManagementSystem PMS;
	
	private JLabel lbTitulo;
    private JLabel lbIDHabitacion;
    private JLabel lbFecha;
    private JTextField txtIDHabitacion;
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAnio;
    private JButton btnConsultar;

    public ConsultarHabitacion(PropertyManagementSystem PMS) {
        this.PMS = PMS;
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(false);
        getContentPane().setBackground(new Color(44, 120, 115));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title Label
        lbTitulo = new JLabel("Consultar Habitación");
        Font fuente = lbTitulo.getFont().deriveFont(25f);
        lbTitulo.setFont(fuente);
        lbTitulo.setForeground(Color.WHITE);
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lbTitulo, gbc);

        Font labelFont = lbTitulo.getFont().deriveFont(15f);

        // ID de la Habitación Field
        lbIDHabitacion = new JLabel("ID Habitación:");
        lbIDHabitacion.setForeground(Color.WHITE);
        lbIDHabitacion.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lbIDHabitacion, gbc);

        txtIDHabitacion = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtIDHabitacion, gbc);

        // Consultar Button
        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(labelFont);
        btnConsultar.setBackground(new Color(118, 54, 38));
        btnConsultar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnConsultar, gbc);
        
        btnConsultar.setActionCommand("CONSULTAR");
        btnConsultar.addActionListener(this);
        
        pack();
        setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("CONSULTAR")){			
			String IDHabitacion = txtIDHabitacion.getText();
			Habitacion habitacion = PMS.getHabitaciones().get(IDHabitacion);
			
			if(habitacion != null) {
				InfoHabitacion infoHabitacion = new InfoHabitacion(habitacion);
			}
		}
		
		
	}

}
