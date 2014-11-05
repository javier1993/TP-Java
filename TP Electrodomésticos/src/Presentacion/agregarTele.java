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

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import Entidades.Television;
import Negocio.CatalogoTelevisiones;

import javax.swing.JComboBox;

public class agregarTele extends JFrame {

	private JPanel contentPane;
	private JTextField tPrecio;
	private JTextField tPeso;
	private JTextField tPulgadas;
	
	public agregarTele(final CatalogoTelevisiones tel)  {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblNewLabel = new JLabel("Pulgadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblSintonizador = new JLabel("Sintonizador");
		lblSintonizador.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblTelevision = new JLabel("Television");
		lblTelevision.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		tPrecio = new JTextField();
		tPrecio.setColumns(10);
		
		tPeso = new JTextField();
		tPeso.setColumns(10);
		
		tPulgadas = new JTextField();
		tPulgadas.setColumns(10);
		
		final JCheckBox cSint = new JCheckBox("Si/No",false);
		
		String[] colores = { "Blanco", "Negro", "Rojo", "Azul", "Gris" };
		final JComboBox cColores = new JComboBox(colores);
		
		String[] consumos = { "A", "B", "C", "D", "E", "F" };
		final JComboBox cConsumos = new JComboBox(consumos);
		
		JButton bAgregar = new JButton("Agregar");
		
		bAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
                
				boolean estado = false; String estadoSint;
				estado = ( tPrecio.getText().matches("[0-9]*") & tPeso.getText().matches("[0-9]*") & tPulgadas.getText().matches("[0-9]*") );
				
						if (estado){

							if (cSint.isSelected()) { estadoSint="Si";
							} else {estadoSint="No";}
							
							String pre=tPrecio.getText(),pes=tPeso.getText(),col=(String) cColores.getSelectedItem(),con=(String) cConsumos.getSelectedItem(),pul=tPulgadas.getText();
							float precio=Float.parseFloat(pre);

							Television tv = new Television(precio,Integer.parseInt(pes),col,con,Integer.parseInt(pul),cSint.isSelected());
							col=tv.comprobarColor(col);
							tv.precioFinal();
							precio=tv.getPrecio();
							
							int i=JOptionPane.showConfirmDialog(null, "Se cargarán los siguientes datos:\nPrecio: "+precio+"\nPeso: "+pes+"\nColor: "+col+"\nConsumo: "+con+ "\nPulgadas: "+pul+"\nSintonizador?: "+estadoSint, "Confirmación ", JOptionPane.YES_NO_OPTION);
						
							if (i==0) {
								tel.addTele(tv);
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
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecioBase, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSintonizador, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cSint)
								.addComponent(tPulgadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(lblTelevision))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(bAgregar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTelevision)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioBase))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblColor)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPeso)
							.addGap(35)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConsumo))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tPulgadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSintonizador)
						.addComponent(cSint))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bAgregar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
