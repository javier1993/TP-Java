package Negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Datos.DataConnectionManager;
import Entidades.Lavarropa;

public class CatalogoLavarropas {

	//=============================================================================================================
	
	public void addLava(Entidades.Lavarropa nuevoLav){
		
		String sql="insert into lavarropa(descripcion,precio,peso,color,consumo,carga) values (?,?,?,?,?,?)";
		PreparedStatement sentencia=null;
		Connection conn=DataConnectionManager.getInstancia().getConn();
		
		
		try {
				sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setString(1, nuevoLav.getDescripcion());
				sentencia.setFloat(2, nuevoLav.getPrecio());
				sentencia.setInt(3, nuevoLav.getPeso());
				sentencia.setString(4, nuevoLav.getColor());
				//sentencia.setFloat(5, nuevoLav.getConsumo());
				sentencia.setString(5, nuevoLav.getConsumo());
				//sentencia.setNCharacterStream(5, nuevoLav.getConsumo());
				sentencia.setInt(6, nuevoLav.getCarga());
				
				int filasAfectadas=sentencia.executeUpdate();
				ResultSet cps= sentencia.getGeneratedKeys();
				if(cps.next()){
						int locId=cps.getInt(1);
						nuevoLav.setId(locId);
				}

		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
				try{
						if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
						DataConnectionManager.getInstancia().CloseConn();
				}
				catch (SQLException sqle){
						sqle.printStackTrace();
				}
		}
	}
	
	//=============================================================================================================
	
	public ArrayList<Entidades.Lavarropa> getLavarropas(){
	ArrayList<Entidades.Lavarropa> locs= new ArrayList<Entidades.Lavarropa>();

	String sql="select id, descripcion, precio, peso, color, consumo, carga from lavarropa";
	Statement sentencia=null;
	ResultSet rs=null;

	
	try {	
			sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
			rs= sentencia.executeQuery(sql);

			while(rs.next()){
				Entidades.Lavarropa l= new Entidades.Lavarropa();
				l.setId(rs.getInt("id"));
				l.setDescripcion(rs.getString("descripcion"));
				l.setPrecio(rs.getFloat("precio"));
				l.setPeso(rs.getInt("peso"));
				l.setColor(rs.getString("color"));
				l.setConsumo(rs.getString("consumo"));
				Lavarropa.setCarga(rs.getInt("carga"));
				locs.add(l);
			}	
	} catch (SQLException e) {
			e.printStackTrace();
	}
	finally{
			try{
					if(rs!=null){rs.close();}
					if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
					DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle){
					sqle.printStackTrace();
			}
	}


	return locs;
	
	}
	
	//=============================================================================================================
	
	public void removeLava(int idLavarropa){
		
		String sql="delete from lavarropa where id = "+idLavarropa;
		PreparedStatement sentencia=null;
		Connection conn=DataConnectionManager.getInstancia().getConn();
		
		
		try {
				sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				
				int filasAfectadas=sentencia.executeUpdate();
				

		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
				try{
						if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
						DataConnectionManager.getInstancia().CloseConn();
				}
				catch (SQLException sqle){
						sqle.printStackTrace();
				}
		}
	}
	
	
	//=============================================================================================================
	
	public void modLava(Entidades.Lavarropa lav){
		
		int id=lav.getId();
		System.out.println("Id del electrodomestico "+id);
		String sql="update lavarropa set precio = "+lav.getPrecio()+", peso = "+lav.getPeso()+", color = '"+lav.getColor()+"', consumo = '"+lav.getConsumo()+"', carga = "+lav.getCarga()+" where id = "+id;
		PreparedStatement sentencia=null;
		Connection conn=DataConnectionManager.getInstancia().getConn();
		
		
		try {
				sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				
				int filasAfectadas=sentencia.executeUpdate();
				
				
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
				try{
						if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
						DataConnectionManager.getInstancia().CloseConn();
				}
				catch (SQLException sqle){
						sqle.printStackTrace();
				}
		}
	}

	//=============================================================================================================
	
	public ArrayList<Entidades.Lavarropa> getLavarropasByImporte(float imp1, float imp2){
		ArrayList<Entidades.Lavarropa> locs= new ArrayList<Entidades.Lavarropa>();

		String sql="select id, descripcion, precio, peso, color, consumo, carga from lavarropa where precio between "+imp1+" and "+imp2;
		Statement sentencia=null;
		ResultSet rs=null;

		
		try {	
				sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
				rs= sentencia.executeQuery(sql);

				while(rs.next()){
					Entidades.Lavarropa l= new Entidades.Lavarropa();
					l.setId(rs.getInt("id"));
					l.setDescripcion(rs.getString("descripcion"));
					l.setPrecio(rs.getFloat("precio"));
					l.setPeso(rs.getInt("peso"));
					l.setColor(rs.getString("color"));
					l.setConsumo(rs.getString("consumo"));
					Lavarropa.setCarga(rs.getInt("carga"));
					locs.add(l);
				}	
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
				try{
						if(rs!=null){rs.close();}
						if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
						DataConnectionManager.getInstancia().CloseConn();
				}
				catch (SQLException sqle){
						sqle.printStackTrace();
				}
				}


		return locs;
		
	}
	
	//=============================================================================================================
	
	
	public ArrayList<Entidades.Lavarropa> getLavarropasByConsumo(String a, String b){
			ArrayList<Entidades.Lavarropa> locs= new ArrayList<Entidades.Lavarropa>();

			String sql="select id, descripcion, precio, peso, color, consumo, carga from lavarropa where consumo between '"+a+"' and '"+b+"'";
			Statement sentencia=null;
			ResultSet rs=null;

			
			try {	
					sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
					rs= sentencia.executeQuery(sql);

					while(rs.next()){
						Entidades.Lavarropa l= new Entidades.Lavarropa();
						l.setId(rs.getInt("id"));
						l.setDescripcion(rs.getString("descripcion"));
						l.setPrecio(rs.getFloat("precio"));
						l.setPeso(rs.getInt("peso"));
						l.setColor(rs.getString("color"));
						l.setConsumo(rs.getString("consumo"));
						Lavarropa.setCarga(rs.getInt("carga"));
						locs.add(l);
					}	
			} catch (SQLException e) {
					e.printStackTrace();
			}
			finally{
					try{
							if(rs!=null){rs.close(); }
							if(sentencia!=null && !sentencia.isClosed()){sentencia.close(); }
							DataConnectionManager.getInstancia().CloseConn();
					}
					catch (SQLException sqle){
							sqle.printStackTrace();
					}
			}


			return locs;
			
	}
		
	//=============================================================================================================
	
		
	public ArrayList<Entidades.Lavarropa> getLavarropasByImpyCon(float imp1, float imp2, String a, String b){
				ArrayList<Entidades.Lavarropa> locs= new ArrayList<Entidades.Lavarropa>();

				String sql="select id, descripcion, precio, peso, color, consumo, carga from lavarropa where precio between "+imp1+" and "+imp2+" and consumo between '"+a+"' and '"+b+"'";
				Statement sentencia=null;
				ResultSet rs=null;

				
				try {	
						sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
						rs= sentencia.executeQuery(sql);

						while(rs.next()){
							Entidades.Lavarropa l= new Entidades.Lavarropa();
							l.setId(rs.getInt("id"));
							l.setDescripcion(rs.getString("descripcion"));
							l.setPrecio(rs.getFloat("precio"));
							l.setPeso(rs.getInt("peso"));
							l.setColor(rs.getString("color"));
							l.setConsumo(rs.getString("consumo"));
							Lavarropa.setCarga(rs.getInt("carga"));
							locs.add(l);
						}	
				} catch (SQLException e) {
						e.printStackTrace();
				}
				finally{
						try{
								if(rs!=null){rs.close();}
								if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
								DataConnectionManager.getInstancia().CloseConn();
						}
						catch (SQLException sqle){
								sqle.printStackTrace();
						}
				}


				return locs;
				
	}
			
	//=============================================================================================================
		
	ArrayList<Lavarropa> lavarropas;
	
	public CatalogoLavarropas(){
		lavarropas = new ArrayList<Lavarropa>();
	}
	/*public void addLavarropa(Lavarropa lav){
		lavarropas.add(lav);
	}*/
	public ArrayList<Lavarropa> getArray(){
		return lavarropas;
	}
	
	public void modificarLavarropa(Lavarropa lav,int posi){
		lavarropas.set(posi, lav);
	}

	public void eliminarLavarropa(int posi){
		lavarropas.remove(posi);
	}

	public void mostrarLavarropa(int posi){
		lavarropas.get(posi);
	}
}
