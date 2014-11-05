package Presentacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

import java.awt.Font;

import javax.swing.JButton;

import Entidades.Lavarropa;
import Negocio.CatalogoLavarropas;
import javax.swing.JComboBox;

public class agregarLava extends JFrame {

	private JPanel contentPane;
	private JTextField tPrecio;
	private JTextField tPeso;
	private JTextField tCarga;

	public agregarLava(final CatalogoLavarropas lav) {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 315);
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
		
		tPrecio = new JTextField();
		tPrecio.setColumns(10);
		
		tPeso = new JTextField();
		tPeso.setColumns(10);
		
		tCarga = new JTextField();
		tCarga.setColumns(10);
		
		String[] colores = { "Blanco", "Negro", "Rojo", "Azul", "Gris" };
		final JComboBox cColores = new JComboBox(colores);
		
		String[] consumos = { "A", "B", "C", "D", "E", "F" };
		final JComboBox cConsumos = new JComboBox(consumos);
		
		JButton bAgregar = new JButton("Agregar");
		
		bAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				boolean estado = false;
				estado = ( tPrecio.getText().matches("[0-9]*") & tPeso.getText().matches("[0-9]*") & tCarga.getText().matches("[0-9]*") );
	
						if (estado) {
							String pre=tPrecio.getText(),pes=tPeso.getText(),col=(String) cColores.getSelectedItem(),con=(String) cConsumos.getSelectedItem(),car=tCarga.getText();
							
							float precio=Float.parseFloat(pre);
							
							Lavarropa lr = new Lavarropa(Integer.parseInt(pre),Integer.parseInt(pes),col,con,Integer.parseInt(car));
							col=lr.comprobarColor(col);
							lr.precioFinal();
							precio=lr.getPrecio();
							//System.out.println("Precio "+precio);
							int i=JOptionPane.showConfirmDialog(null, "Se cargarán los siguientes datos:\nPrecio: "+precio+"\nPeso: "+pes+"\nColor: "+col+"\nConsumo: "+con+ "\nCarga: "+car, "Confirmación ", JOptionPane.YES_NO_OPTION);
							
							if (i==0) {
								lav.addLava(lr);
								dispose();
							}
					
						}
						else {
							JOptionPane.showMessageDialog(null, "Verificar Datos", "Verifica tus Datos", JOptionPane.ERROR_MESSAGE);
						}
					
			}
			
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrecioBase, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPeso, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
								.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCarga, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(bAgregar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblLavarropa)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLavarropa)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioBase))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeso)
						.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsumo)
						.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tCarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCarga))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bAgregar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
