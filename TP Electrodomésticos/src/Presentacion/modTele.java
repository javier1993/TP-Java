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
import javax.swing.JCheckBox;
import javax.swing.JButton;

import Entidades.Television;
import Negocio.CatalogoTelevisiones;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class modTele extends JFrame {

	private JPanel contentPane;
	private JTextField tPrecio;
	private JTextField tPeso;
	private JTextField tPulgadas;

	public modTele(final CatalogoTelevisiones tel, final Television t) {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 352);
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
		
		JLabel lblPulgadas = new JLabel("Pulgadas");
		lblPulgadas.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblSintonizador = new JLabel("Sintonizador");
		lblSintonizador.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		tPrecio = new JTextField(""+t.getPrecio());
		tPrecio.setColumns(10);
		
		tPeso = new JTextField(""+t.getPeso());
		tPeso.setColumns(10);
		
		tPulgadas = new JTextField(""+t.getPulgadas());
		tPulgadas.setColumns(10);
		
		this.setVisible(true);
		final JCheckBox cSint = new JCheckBox("Si/No",t.isSintonizador());
		
		String[] colores = { "Blanco", "Negro", "Rojo", "Azul", "Gris" };
		final JComboBox cColores = new JComboBox(colores);
		cColores.setSelectedItem(t.getColor());
		
		String[] consumos = { "A", "B", "C", "D", "E", "F" };
		final JComboBox cConsumos = new JComboBox(consumos);
		cConsumos.setSelectedItem(t.getConsumo());
		
		JButton bModificar = new JButton("Modificar");
		
		bModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				boolean estado = false; String estadoSint;
				estado = ( tPrecio.getText().matches("[0.0-9.9]*") & tPeso.getText().matches("[0-9]*") & tPulgadas.getText().matches("[0-9]*") );
				
						if (estado){
							
							if (cSint.isSelected()) { estadoSint="Si";
							} else {estadoSint="No";}
							
							String pre=tPrecio.getText(),pes=tPeso.getText(),col=(String) cColores.getSelectedItem(),con=(String) cConsumos.getSelectedItem(),pul=tPulgadas.getText();
							Television tv = new Television(Float.parseFloat(pre),Integer.parseInt(pes),col,con,Integer.parseInt(pul),cSint.isSelected());
							tv.setId(t.getId());
							col=tv.comprobarColor(col);
							tv.precioFinal();
							float precio=tv.getPrecio();
							int i=JOptionPane.showConfirmDialog(null, "Estos datos reemplazaran los anteriores:\nPrecio: "+precio+"\nPeso: "+pes+"\nColor: "+col+"\nConsumo: "+con+ "\nPulgadas: "+pul+"\nSintonizador: "+estadoSint, "Confirmación ", JOptionPane.YES_NO_OPTION);
						
								if (i==0) {

									tel.modTele(tv);
									dispose();
								}
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Verificar Datos", "Error", JOptionPane.ERROR_MESSAGE);
						}
				
			}
	
		});
		
		JLabel lblTelevision = new JLabel("Television");
		lblTelevision.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblTelevision))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblConsumo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPulgadas, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPrecioBase, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
												.addGap(18))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblColor, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(tPulgadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cSint, Alignment.LEADING)))
										.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(13)
									.addComponent(lblSintonizador, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
					.addGap(76))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(bModificar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTelevision)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(tPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrecioBase)
							.addGap(14)
							.addComponent(lblPeso)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColor)
						.addComponent(cColores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cConsumos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConsumo))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tPulgadas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPulgadas))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSintonizador)
						.addComponent(cSint))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bModificar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
