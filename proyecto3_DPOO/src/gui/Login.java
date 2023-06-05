package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.PropertyManagementSystem;
import model.Usuario;


public class Login extends JFrame implements ActionListener{
	private PropertyManagementSystem PMS;
	
	private JLabel titulo;
	
	private JLabel lbUsuario;
	private JLabel lbPswrd;
	private JLabel lbIncorrecto;
	
	private JTextField txtUsuario;
	private JTextField txtPswrd;
	
	private JButton btnCambiar;
	
	private Color rojo;
	private Color azul;
	private Color verde;
	
	public Login() {
		PMS = new PropertyManagementSystem();
		
		getContentPane().setBackground(new Color(44, 120, 115));
		setLayout(new GridBagLayout());
				
		titulo = new JLabel("Iniciar Sesión");
		Font fuente = titulo.getFont();
		fuente = fuente.deriveFont(25f);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(fuente);
		
		
		//login = new JButton("Entrar");
		//login.setActionCommand("ENTRAR");
		//login.addActionListener(this);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		add(titulo, c);
		
		c.gridx = 0;
		c.gridy = 1;
		
		rojo = new Color(118, 54, 38);
		verde = new Color(44, 120, 115);
		azul = new Color(2, 28, 30);
		
		setPreferredSize(new Dimension(400, 500));
		getContentPane().setBackground(verde);
		setLayout(new GridBagLayout());
		setResizable(false);
		
		lbUsuario = new JLabel("Usuario");
		lbPswrd = new JLabel("Contraseña");
		lbIncorrecto = new JLabel();
		
		txtUsuario = new JTextField();
		txtUsuario.setPreferredSize(new Dimension(200, 35));
		txtPswrd = new JTextField();
		txtPswrd.setPreferredSize(new Dimension(200, 35));
		
		btnCambiar = new JButton("Entrar");
		btnCambiar.setBackground(rojo);
		btnCambiar.setActionCommand("ENTRAR");
		btnCambiar.addActionListener(this);
		
		c.insets = new Insets(5, 5, 20, 5);
		c.gridx = 0;
		c.gridy = 0;
		
		fuente = fuente.deriveFont(15f);
		lbUsuario.setFont(fuente);
		lbUsuario.setForeground(Color.WHITE);
		lbPswrd.setFont(fuente);
		lbPswrd.setForeground(Color.WHITE);
		btnCambiar.setFont(fuente);
		btnCambiar.setForeground(Color.WHITE);
		lbIncorrecto.setFont(fuente);
		lbIncorrecto.setForeground(Color.WHITE);
		
		c.insets = new Insets(5, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 1;
		add(lbUsuario, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(txtUsuario, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(lbPswrd, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(txtPswrd, c);
		
		c.insets = new Insets(32, 5, 0, 5);
		c.gridx = 0;
		c.gridy = 5;
		add(btnCambiar, c);
		
	
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(5, 5, 0, 5);
		add(lbIncorrecto, c);

		pack();
		setVisible(true);
		
		
		setSize(new Dimension(400, 500));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		
		if (cmd.equals("ENTRAR")) {
			lbIncorrecto.setText("");
			String usuarioLogIn = txtUsuario.getText();
			String password = txtPswrd.getText();
			if(existeUsuario(usuarioLogIn)) {
				if(PMS.getCredenciales().get(usuarioLogIn).getContrasenia().equals(password)) {
					Usuario user = PMS.getCredenciales().get(usuarioLogIn);
					PMS.setUsuarioActivo(user);
					if(user.getRol().equals("Administrador")) {
						OpcionesAdministrador AdminInterfaz = new OpcionesAdministrador(PMS);
					}else if(user.getRol().equals("Empleado")) {
						RegistrarConsumo accionEmpleado = new RegistrarConsumo();
					}else if(user.getRol().equals("Recepcionista")) {
						OpcionesRecepcionista recepcionistaInterfaz = new OpcionesRecepcionista(PMS);
					}
					dispose();
				}else {
					lbIncorrecto.setText("Contraseña Incorrecta");
				}
			
			}else {
				lbIncorrecto.setText("Usuario Incorrecto");
			}
			
		}
	}
	
	private boolean existeUsuario(String usuarioLogIn) {
		return PMS.getCredenciales().keySet().contains(usuarioLogIn);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Login vt = new Login();
	}
}

