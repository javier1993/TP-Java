package Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;

import Entidades.Lavarropa;
import Entidades.Television;
import Negocio.CatalogoLavarropas;
import Negocio.CatalogoTelevisiones;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.util.Collections;

import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField aImporte;
	private JTextField bImporte;
	private JTable table;

	CatalogoLavarropas lav = new CatalogoLavarropas();
	CatalogoTelevisiones tev = new CatalogoTelevisiones();
	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListadoTelevisiones = new JLabel("Gesti\u00F3n de Electrodom\u00E9sticos");
		lblListadoTelevisiones.setFont(new Font("Trajan Pro", Font.BOLD, 16));
		
		table = new JTable();
		
		String[] columnas = {"Id","Descripcion", "Precio", "Peso", "Color", "Consumo", "Carga", "Pulgadas", "Sintonizador"};
		
		final DefaultTableModel tabla = new DefaultTableModel(null,columnas);
		
		JScrollPane scrollPane = new JScrollPane();
		final JTable table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(tabla);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumn col0 = table_1.getColumnModel().getColumn(0);
		TableColumn col1 = table_1.getColumnModel().getColumn(1);
		TableColumn col2 = table_1.getColumnModel().getColumn(2);
		TableColumn col4 = table_1.getColumnModel().getColumn(4);
		TableColumn col5 = table_1.getColumnModel().getColumn(5);
		TableColumn col6 = table_1.getColumnModel().getColumn(6);
		TableColumn col7 = table_1.getColumnModel().getColumn(7);
		final DefaultListModel modelo = new DefaultListModel();
		
		
		
	//===============================================================================================
		
		JButton bModificar = new JButton("Modificar ");
				
		        bModificar.addActionListener(new ActionListener() { 
					
					public void actionPerformed(ActionEvent arg0) {
						
						int pos = -1;
							
						pos = table_1.getSelectedRow();
						
							
							if (pos == -1) {
							JOptionPane.showMessageDialog(null, "No hay nada seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
							}else {
								
								if (tabla.getValueAt(pos, 1)=="Television") {
									
									Television tele = new Television ((Float)tabla.getValueAt(pos, 2),(Integer)tabla.getValueAt(pos, 3),(String)tabla.getValueAt(pos, 4),(String)tabla.getValueAt(pos, 5),(Integer)tabla.getValueAt(pos, 7),(Boolean)tabla.getValueAt(pos, 8));
									tele.setId((Integer)tabla.getValueAt(pos, 0));		
									System.out.println("Id televisor "+tele.getId());
									modTele tv = new modTele(tev,tele);
													
											
								} else {
									
									Lavarropa lava = new Lavarropa ((Float)tabla.getValueAt(pos, 2),(Integer)tabla.getValueAt(pos, 3),(String)tabla.getValueAt(pos, 4),(String)tabla.getValueAt(pos, 5),(Integer)tabla.getValueAt(pos, 6));
									lava.setId((Integer)tabla.getValueAt(pos, 0));		
									System.out.println("Id lavarropa "+lava.getId());
									modLava la = new modLava(lav,lava);
														
								}
						
							
							}
					
					}
				
				});
		
		
	//===============================================================================================
		
		JButton bEliminar = new JButton("Eliminar");
				
			bEliminar.addActionListener(new ActionListener() { 
			
				public void actionPerformed(ActionEvent arg0) {
					String estadoSint; int pos = -1;

					pos = table_1.getSelectedRow();
							
							System.out.println(pos);
							
							if (pos == -1) {
								JOptionPane.showMessageDialog(null, "No hay nada seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
							}else {
						
									if (tabla.getValueAt(pos, 1)=="Television") {
										
										int idTele = (int) tabla.getValueAt(pos, 0);
										System.out.println("Id de lavarropa: "+idTele);
										
										
											int c=JOptionPane.showConfirmDialog(null, "Se eliminaran los siguientes datos:\nPrecio: "+tabla.getValueAt(pos, 2)+"\nPeso: "+tabla.getValueAt(pos, 3)+"\nColor: "+tabla.getValueAt(pos, 4)+"\nConsumo: "+tabla.getValueAt(pos, 5)+ "\nPulgadas: "+tabla.getValueAt(pos, 7)+"\n"+tabla.getValueAt(pos, 8), "Confirmación ", JOptionPane.YES_NO_OPTION);
																if (c==0) {
																	tabla.removeRow(pos);
																	tev.removeTele(idTele);
																}
									
									} else {
										
										int idLava = (int) tabla.getValueAt(pos, 0);
										System.out.println("Id de lavarropa: "+idLava);
										
										
										int c=JOptionPane.showConfirmDialog(null, "Se eliminaran los siguientes datos:\nPrecio: "+tabla.getValueAt(pos, 2)+"\nPeso: "+tabla.getValueAt(pos, 3)+"\nColor: "+tabla.getValueAt(pos, 4)+"\nConsumo: "+tabla.getValueAt(pos, 5)+ "\nCarga: "+tabla.getValueAt(pos, 6)+"\n", "Confirmación ", JOptionPane.YES_NO_OPTION);
														if (c==0){
															tabla.removeRow(pos);
															lav.removeLava(idLava);
															
														}
													
											
									}
						}
				}
		
			});
		
	//===============================================================================================
			
		final JCheckBox cTele = new JCheckBox("Television");
		
		final JCheckBox cLava = new JCheckBox("Lavarropa");
		
		JButton bAgregar = new JButton("Agregar");
		
		bAgregar.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent arg0) {
	
				if (cTele.isSelected()!=cLava.isSelected()){
					
					if (cTele.isSelected()==true) { 
						agregarTele television = new agregarTele(tev);
						television.setVisible(true);
					} else {
						agregarLava lavarropa = new agregarLava(lav);
						lavarropa.setVisible(true);
					}
					
				} else {JOptionPane.showMessageDialog(null, "Seleccionar uno de los electrodomesticos", "Error", JOptionPane.ERROR_MESSAGE); }
				
			}	
		
		});
		
		final JCheckBox cConsumo = new JCheckBox("Listado por Consumo");
		cConsumo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		bImporte = new JTextField();
		bImporte.setColumns(10);
		
		aImporte = new JTextField();
		aImporte.setColumns(10);
		
		final JCheckBox cImporte = new JCheckBox("Listado por Importe",false);
		cImporte.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		String[] consumos = { "A", "B", "C", "D", "E", "F" };
		final JComboBox aConsumo = new JComboBox(consumos);
		final JComboBox bConsumo = new JComboBox(consumos);
		bConsumo.setSelectedItem("F");
		
	//===============================================================================================
		
		JButton bListado = new JButton("Listado");
				
			bListado.addActionListener(new ActionListener() { 
						
						public void actionPerformed(ActionEvent arg0) {
							
							String estadoSint;int num = tabla.getRowCount();
							
							String aCon=(String) aConsumo.getSelectedItem();
							String bCon=(String) bConsumo.getSelectedItem();
							
								if ( cImporte.isSelected()==true & cConsumo.isSelected()==true ) {
									
									if ( aImporte.getText().isEmpty() | bImporte.getText().isEmpty() ) {
										JOptionPane.showMessageDialog(null, "Completar el rango de importes", "Error", JOptionPane.ERROR_MESSAGE);
									} else if ( !(aImporte.getText().matches("[0-9]*")) | !(bImporte.getText().matches("[0-9]*")) ) {
										JOptionPane.showMessageDialog(null, "Corregir el rango de importes", "Error", JOptionPane.ERROR_MESSAGE);
									} else {
											
											float aImp=Float.parseFloat(aImporte.getText());
											float bImp=Float.parseFloat(bImporte.getText());
											
											for (int i=0 ; i<num ; i++) { tabla.removeRow(0);}
									
												for (Entidades.Lavarropa l : (lav.getLavarropasByImpyCon(aImp,bImp,aCon,bCon))) {
													if(l!=null){
														String la="";
														la+=Integer.toString(l.getId())+"\t";
														la+=l.getDescripcion()+"\t";
														la+=Float.toString(l.getPrecio())+"\t";
														la+=Integer.toString(l.getPeso())+"\t";
														la+=l.getColor()+"\t";
														la+=l.getConsumo()+"\t";
														la+=Integer.toString(l.getCarga());
						
														//System.out.println(la);
													}else{
														System.out.println("Lavarropa Inexistente");
														}
				
													Object[] newRow = {l.getId(),l.getDescripcion(),l.getPrecio(),l.getPeso(),l.getColor(),l.getConsumo(),l.getCarga(),"---","---"};
													tabla.addRow(newRow);
				
												}
				
												for (Entidades.Television t : (tev.getTelevisionesByImpyCon(aImp,bImp,aCon,bCon))) {
													if(t!=null){
														String te="";
														te+=Integer.toString(t.getId())+"\t";
														te+=t.getDescripcion()+"\t";
														te+=Float.toString(t.getPrecio())+"\t";
														te+=Integer.toString(t.getPeso())+"\t";
														te+=t.getColor()+"\t";
														te+=t.getConsumo()+"\t";
														te+=Integer.toString(t.getPulgadas())+"\t";
														te+=Boolean.toString(t.isSintonizador())+"\t";
						
														//System.out.println(te);
													}else{
														System.out.println("Television Inexistente");
														}
				
													/*String estadoSint;
													
													if (t.isSintonizador()) { estadoSint = "Si";
													} else {estadoSint = "No";}*/
					
													Object[] newRow = {t.getId(),t.getDescripcion(),t.getPrecio(),t.getPeso(),t.getColor(),t.getConsumo(),"---",t.getPulgadas(),t.isSintonizador()};
													tabla.addRow(newRow);
				
												}
				
				
											}
								} else {
									
									if ( cImporte.isSelected()==true & cConsumo.isSelected()==false ){
										
										if ( aImporte.getText().isEmpty() | bImporte.getText().isEmpty() ) {
											JOptionPane.showMessageDialog(null, "Completar el rango de importes", "Error", JOptionPane.ERROR_MESSAGE);
										} else if ( !(aImporte.getText().matches("[0-9]*")) | !(bImporte.getText().matches("[0-9]*")) ) {
											JOptionPane.showMessageDialog(null, "Corregir el rango de importes", "Error", JOptionPane.ERROR_MESSAGE);
										} else {
												
												float aImp=Float.parseFloat(aImporte.getText()); 
												float bImp=Float.parseFloat(bImporte.getText());
										
												for (int i=0 ; i<num ; i++) { tabla.removeRow(0);}
										
												for (Entidades.Lavarropa l : (lav.getLavarropasByImporte(aImp,bImp))) {
													if(l!=null){
														String la="";
														la+=Integer.toString(l.getId())+"\t";
														la+=l.getDescripcion()+"\t";
														la+=Float.toString(l.getPrecio())+"\t";
														la+=Integer.toString(l.getPeso())+"\t";
														la+=l.getColor()+"\t";
														la+=l.getConsumo()+"\t";
														la+=Integer.toString(l.getCarga());
														
														//System.out.println(la);
													}else{
														System.out.println("Lavarropa Inexistente");
													}
												
													Object[] newRow = {l.getId(),l.getDescripcion(),l.getPrecio(),l.getPeso(),l.getColor(),l.getConsumo(),l.getCarga(),"---","---"};
													tabla.addRow(newRow);
												
												}
												
												for (Entidades.Television t : (tev.getTelevisionesByImporte(aImp,bImp))) {
													if(t!=null){
														String te="";
														te+=Integer.toString(t.getId())+"\t";
														te+=t.getDescripcion()+"\t";
														te+=Float.toString(t.getPrecio())+"\t";
														te+=Integer.toString(t.getPeso())+"\t";
														te+=t.getColor()+"\t";
														te+=t.getConsumo()+"\t";
														te+=Integer.toString(t.getPulgadas())+"\t";
														te+=Boolean.toString(t.isSintonizador())+"\t";
														
														//System.out.println(te);
													}else{
														System.out.println("Television Inexistente");
													}
												
													/*String estadoSint;
													
													if (t.isSintonizador()) { estadoSint = "Si";
													} else {estadoSint = "No";}*/
													
													Object[] newRow = {t.getId(),t.getDescripcion(),t.getPrecio(),t.getPeso(),t.getColor(),t.getConsumo(),"---",t.getPulgadas(),t.isSintonizador()};
													tabla.addRow(newRow);
												
												}
				
				
												
											}
									
									} else {
										
										if ( cImporte.isSelected()==false & cConsumo.isSelected()==true ){
											
											for (int i=0 ; i<num ; i++) { tabla.removeRow(0);}
											
											for (Entidades.Lavarropa l : (lav.getLavarropasByConsumo(aCon,bCon))) {
												if(l!=null){
													String la="";
													la+=Integer.toString(l.getId())+"\t";
													la+=l.getDescripcion()+"\t";
													la+=Float.toString(l.getPrecio())+"\t";
													la+=Integer.toString(l.getPeso())+"\t";
													la+=l.getColor()+"\t";
													la+=l.getConsumo()+"\t";
													la+=Integer.toString(l.getCarga());
													
													//System.out.println(la);
												}else{
													System.out.println("Lavarropa Inexistente");
												}
											
												Object[] newRow = {l.getId(),l.getDescripcion(),l.getPrecio(),l.getPeso(),l.getColor(),l.getConsumo(),l.getCarga(),"---","---"};
												tabla.addRow(newRow);
											
											}
											
											for (Entidades.Television t : (tev.getTelevisionesByConsumo(aCon,bCon))) {
												if(t!=null){
													String te="";
													te+=Integer.toString(t.getId())+"\t";
													te+=t.getDescripcion()+"\t";
													te+=Float.toString(t.getPrecio())+"\t";
													te+=Integer.toString(t.getPeso())+"\t";
													te+=t.getColor()+"\t";
													te+=t.getConsumo()+"\t";
													te+=Integer.toString(t.getPulgadas())+"\t";
													te+=Boolean.toString(t.isSintonizador())+"\t";
													
													//System.out.println(te);
												}else{
													System.out.println("Television Inexistente");
												}
											
												/*String estadoSint;
												
												if (t.isSintonizador()) { estadoSint = "Si";
												} else {estadoSint = "No";}*/
												
												Object[] newRow = {t.getId(),t.getDescripcion(),t.getPrecio(),t.getPeso(),t.getColor(),t.getConsumo(),"---",t.getPulgadas(),t.isSintonizador()};
												tabla.addRow(newRow);
											
											}
				
				
										
										} else {
											
											if ( cImporte.isSelected()==false & cConsumo.isSelected()==false ) {
											//JOptionPane.showMessageDialog(null, "Seleccionar opciones de listado", "Error", JOptionPane.ERROR_MESSAGE);
												
												for (int i=0 ; i<num ; i++) { tabla.removeRow(0);}
												
												for (Entidades.Lavarropa l : (lav.getLavarropas())) {
													if(l!=null){
														String la="";
														la+=Integer.toString(l.getId())+"\t";
														la+=l.getDescripcion()+"\t";
														la+=Float.toString(l.getPrecio())+"\t";
														la+=Integer.toString(l.getPeso())+"\t";
														la+=l.getColor()+"\t";
														la+=l.getConsumo()+"\t";
														la+=Integer.toString(l.getCarga());
														
														//System.out.println(la);
													}else{
														System.out.println("Lavarropa Inexistente");
													}
												
													Object[] newRow = {l.getId(),l.getDescripcion(),l.getPrecio(),l.getPeso(),l.getColor(),l.getConsumo(),l.getCarga(),"---","---"};
													tabla.addRow(newRow);
												
												}
												
												for (Entidades.Television t : (tev.getTelevisores())) {
													if(t!=null){
														String te="";
														te+=Integer.toString(t.getId())+"\t";
														te+=t.getDescripcion()+"\t";
														te+=Float.toString(t.getPrecio())+"\t";
														te+=Integer.toString(t.getPeso())+"\t";
														te+=t.getColor()+"\t";
														te+=t.getConsumo()+"\t";
														te+=Integer.toString(t.getPulgadas())+"\t";
														te+=Boolean.toString(t.isSintonizador())+"\t";
														
														//System.out.println(te);
													}else{
														System.out.println("Television Inexistente");
													}
												
													/*String estadoSint;
													
													if (t.isSintonizador()) { estadoSint = "Si";
													} else {estadoSint = "No";}*/
													
													Object[] newRow = {t.getId(),t.getDescripcion(),t.getPrecio(),t.getPeso(),t.getColor(),t.getConsumo(),"---",t.getPulgadas(),t.isSintonizador()};
													tabla.addRow(newRow);
				
												}
				
				
				
											
											}
										}
									}
									
									
								}
						
						
						}
						
					});
				
		this.setVisible(true);
		
	//===============================================================================================
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bAgregar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(28)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(cTele)
												.addComponent(cLava))))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(13)
											.addComponent(bModificar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bEliminar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bListado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(cImporte)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(aImporte, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(bImporte, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(cConsumo)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(aConsumo, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(bConsumo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(lblListadoTelevisiones)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblListadoTelevisiones)
					.addGap(7)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bAgregar, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(bModificar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(bEliminar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(bListado, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cTele)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cLava))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cImporte)
								.addComponent(aImporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bImporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cConsumo)
								.addComponent(aConsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bConsumo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(25))
		);
		
		contentPane.setLayout(gl_contentPane);
	
	}
}
