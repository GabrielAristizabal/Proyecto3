package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Cama;
import model.CaracteristicasAdicionales;
import model.Habitacion;

public class InfoHabitacion extends JFrame{
	private Color bBColor=new Color(Integer.parseInt("2C7873",16));
    private Color BColor=new Color(0x763626);
    private Color Ctexto = new Color(0xFFF9F3);
    private Color BRColor = new Color(0x021C1E);
    private Font garamond = new Font("Garamond", Font.PLAIN, 16);
    private Font Title=new Font("Garamond", Font.BOLD, 27);
    
    public InfoHabitacion(Habitacion habitacion){
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize( new Dimension( 550, 680 ) );
		setTitle("Consultar Habitaciones");
        getContentPane().setBackground(bBColor);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        JLabel titulo = new JLabel("Consultar Habitacion");
        titulo.setFont(Title);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Ctexto); 
        titulo.setBackground(bBColor);
        titulo.setBounds(10, 10, 510, 30); 

        JLabel ID = new JLabel("ID:");
        ID.setFont(garamond);
        ID.setHorizontalAlignment(SwingConstants.RIGHT);
        ID.setForeground(Ctexto); 
        ID.setBackground(bBColor);
        ID.setBounds(30, 50, 115, 30);
        JTextField IDParametro = new  JTextField(habitacion.getIdHabitación());
        IDParametro.setBounds(155, 60, 95, 20);
        IDParametro.setForeground(Ctexto); 
        IDParametro.setBackground(bBColor);
        IDParametro.setEditable(false);
        
        JLabel Tipo= new JLabel("Tamaño:");
        Tipo.setFont(garamond);
        Tipo.setHorizontalAlignment(SwingConstants.RIGHT);
        Tipo.setForeground(Ctexto); 
        Tipo.setBackground(bBColor);
        Tipo.setBounds(30, 80, 115, 30);
        System.out.printf(Integer.toString(habitacion.getTamaño()));
        JTextField TipoParametro= new  JTextField(Integer.toString(habitacion.getTamaño()));
        TipoParametro.setBounds(155, 90, 95, 20);
        TipoParametro.setForeground(Ctexto); 
        TipoParametro.setBackground(bBColor);
        TipoParametro.setEditable(false);
    
        JLabel Ubicacion= new JLabel("Ubicacion:");
        Ubicacion.setFont(garamond);
        Ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
        Ubicacion.setForeground(Ctexto); 
        Ubicacion.setBackground(bBColor);
        Ubicacion.setBounds(30, 110, 115, 30);
        JTextField UbicacionParametro = new  JTextField(habitacion.getUbicacion());
        UbicacionParametro.setBounds(155, 120, 95, 20);
        UbicacionParametro.setForeground(Ctexto); 
        UbicacionParametro.setBackground(bBColor);
        UbicacionParametro.setEditable(false);
        JLabel Capacidad= new JLabel("Capacidad:");
        Capacidad.setFont(garamond);
        Capacidad.setHorizontalAlignment(SwingConstants.RIGHT);
        Capacidad.setForeground(Ctexto); 
        Capacidad.setBackground(bBColor);
        Capacidad.setBounds(30, 140, 115, 30);
        JTextField CapacidadParametro = new  JTextField(Integer.toString(habitacion.getCapacidad()));
        CapacidadParametro.setBounds(155, 150, 95, 20);
        CapacidadParametro.setForeground(Ctexto); 
        CapacidadParametro.setBackground(bBColor);
        CapacidadParametro.setEditable(false);
        
        JLabel Caracteristicas= new JLabel("Caracteristicas");
        Caracteristicas.setFont(garamond);
        Caracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
        Caracteristicas.setForeground(Ctexto); 
        Caracteristicas.setBackground(bBColor);
        Caracteristicas.setBounds(290, 50, 230, 30);
        ArrayList<JCheckBox> caracteristicasInfo = new ArrayList<>();
        JCheckBox Balcon = new JCheckBox("Balcon");
        Balcon.setFont(garamond);
        Balcon.setForeground(Ctexto); 
        Balcon.setBackground(BRColor);
        Balcon.setBounds(290, 80, 200, 25);
        Balcon.setEnabled(false);
        JCheckBox Vista = new JCheckBox("Vista");
        Vista.setFont(garamond);
        Vista.setForeground(Ctexto); 
        Vista.setBackground(BRColor);
        Vista.setBounds(290, 105, 200, 25);
        Vista.setEnabled(false);
        JCheckBox Cocina = new JCheckBox("Cocina");
        Cocina.setFont(garamond);
        Cocina.setForeground(Ctexto); 
        Cocina.setBackground(BRColor);
        Cocina.setBounds(290, 130, 200, 25);
        Cocina.setEnabled(false);
        
        ArrayList<CaracteristicasAdicionales> caracteristicas = habitacion.getCaracteristicas();
        int desplazamiento = 130;
        for(int i = 0; i<11; i++) {
        	desplazamiento += 25;
        	CaracteristicasAdicionales caracteristica = caracteristicas.get(i);
        	JCheckBox caracteristicaInfo = new JCheckBox(caracteristica.getCaracteristica());
        	caracteristicaInfo.setFont(garamond);
        	caracteristicaInfo.setForeground(Ctexto); 
        	caracteristicaInfo.setBackground(BRColor);
        	caracteristicaInfo.setBounds(290, desplazamiento, 200, 25);
        	caracteristicaInfo.setEnabled(false);
        	caracteristicaInfo.setSelected(caracteristica.isDisponibilidad());
        	add(caracteristicaInfo);
        }
        
        Balcon.setSelected(habitacion.isBalcon());
        Vista.setSelected(habitacion.isVista());
        Cocina.setSelected(habitacion.isCocina()); 
        
        JLabel titleCamas = new JLabel("Camas de la Habitación");
        titleCamas.setFont(garamond);
        titleCamas.setHorizontalAlignment(SwingConstants.CENTER);
        titleCamas.setForeground(Ctexto); 
        titleCamas.setBackground(bBColor);
        titleCamas.setBounds(50, 200, 200, 25);
        
        JLabel nCamas = new JLabel("No. Camas: " + habitacion.getCantidadCamas());
        nCamas.setFont(garamond);
        nCamas.setHorizontalAlignment(SwingConstants.CENTER);
        nCamas.setForeground(Ctexto); 
        nCamas.setBackground(bBColor);
        nCamas.setBounds(50, 226, 200, 25);
        
        ArrayList<String> camasInfo = new ArrayList<>();
        ArrayList<Cama> camas = habitacion.getCamas();
        for (Cama cama : camas) {
            camasInfo.add(cama.toString());
        }
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String camaInfo : camasInfo) {
            model.addElement(camaInfo);
        }
        JList<String> listaCamas = new JList<>(model);
        listaCamas.setPreferredSize(new Dimension(300, 500));
        listaCamas.setBounds(50, 250, 200, 300);
        
        add(titulo);
        add(ID);
        add(IDParametro);
        add(Tipo);
        add(TipoParametro);
        add(Ubicacion);
        add(UbicacionParametro);
        add(Capacidad);
        add(CapacidadParametro);
        add(Caracteristicas);
        add(Balcon);
        add(Vista);
        add(Cocina);
        add(titleCamas);
        add(listaCamas);
        add(nCamas);
    }
}
