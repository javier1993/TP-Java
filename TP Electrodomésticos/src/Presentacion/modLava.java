package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import Entidades.Lavarropa;
import Negocio.CatalogoLavarropas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class modLava extends JFrame {

	private JPanel contentPane;
	private JTextField tPrecio;
	private JTextField tPeso;
	private JTextField tCarga;

	public modLava(final CatalogoLavarropas cat, final Lavarropa l) {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLavarropa = new JLabel("Lavarropa");
		lblLavarropa.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setFont(new Font("Tahoma", Font.ITALIC, 14));
	
		tPrecio = new JTextField(""+l.getPrecio());
		tPrecio.setColumns(10);
		
		tPeso = new JTextField(""+l.getPeso());
		tPeso.setColumns(10);
		
		tCarga = new JTextField(""+l.getCarga());
		tCarga.setColumns(10);
		
		this.setVisible(true);
		
		String[] colores = { "Blanco", "Negro", "Rojo", "Azul", "Gris" };
		final JComboBox cColores = new JComboBox(colores);
		cColores.setSelectedItem(l.getColor());
		
		String[] consumos = { "A", "B", "C", "D", "E", "F" };
		final JComboBox cConsumos = new JComboBox(consumos);
		cConsumos.setSelectedItem(l.getConsumo());
		
		JButton bModificar = new JButton("Modificar");
		
		bModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				boolean estado = false;
				estado = ( tPrecio.getText().matches("[0.0-9.9]*") & tPeso.getText().matches("[0-9]*") & tCarga.getText().matches("[0-9]*") );
				
						if (estado){
							
							String pre=tPrecio.getText(),pes=tPeso.getText(),col=(String) cColores.getSelectedItem(),con=(String) cConsumos.getSelectedItem(),car=tCarga.getText();
							Lavarropa la = new Lavarropa(Float.parseFloat(pre),Integer.parseInt(pes),col,con,Integer.parseInt(car));
							la.setId(l.getId());
							col=la.comprobarColor(col);
							la.precioFinal();
							float precio = la.getPrecio();
							int i=JOptionPane.showConfirmDialog(null, "Estos datos reemplazaran los anteriores:\nPrecio: "+precio+"\nPeso: "+pes+"\nColor: "+col+"\nConsumo: "+con+ "\nCarga: "+car, "Confirmación ", JOptionPane.YES_NO_OPTION);
						
								if (i==0) {

									cat.modLava(la);
									dispose();
								}
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Verificar Datos", "Error", JOptionPane.ERROR_MESSAGE);
						}
				
			}
	
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(lblLavarropa))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrecioBase, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPeso, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
								.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCarga, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(bModificar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLavarropa)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioBase)
						.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeso)
						.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsumo)
						.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCarga)
						.addComponent(tCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bModificar, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
