package Negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Datos.DataConnectionManager;
import Entidades.Lavarropa;
import Entidades.Television;

public class CatalogoTelevisiones {

	//=============================================================================================================
	
	public void addTele(Entidades.Television nuevoTele){
		
		String sql="insert into television(descripcion,precio,peso,color,consumo,pulgadas,sintonizador) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia=null;
		Connection conn=DataConnectionManager.getInstancia().getConn();
		
		
		try {
				sentencia=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setString(1, nuevoTele.getDescripcion());
				sentencia.setFloat(2, nuevoTele.getPrecio());
				sentencia.setInt(3, nuevoTele.getPeso());
				sentencia.setString(4, nuevoTele.getColor());
				sentencia.setString(5, nuevoTele.getConsumo());
				sentencia.setInt(6, nuevoTele.getPulgadas());
				sentencia.setBoolean(7, nuevoTele.isSintonizador());
				
				int filasAfectadas=sentencia.executeUpdate();
				ResultSet cps= sentencia.getGeneratedKeys();
				if(cps.next()){
						int locId=cps.getInt(1);
						nuevoTele.setId(locId);
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
	
	public ArrayList<Entidades.Television> getTelevisores(){
		ArrayList<Entidades.Television> locs= new ArrayList<Entidades.Television>();

		String sql="select id, descripcion, precio, peso, color, consumo, pulgadas, sintonizador from television";
		Statement sentencia=null;
		ResultSet rs=null;

		
		try {	
				sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
				rs= sentencia.executeQuery(sql);

				while(rs.next()){
					Entidades.Television t= new Entidades.Television();
					t.setId(rs.getInt("id"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setPrecio(rs.getFloat("precio"));
					t.setPeso(rs.getInt("peso"));
					t.setColor(rs.getString("color"));
					t.setConsumo(rs.getString("consumo"));
					t.setPulgadas(rs.getInt("pulgadas"));
					t.setSintonizador(rs.getBoolean("sintonizador"));
					locs.add(t);
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
	
	public void removeTele(int idTelevision){
		
		String sql="delete from television where id = "+idTelevision;
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
	
		public void modTele(Entidades.Television tel){
			
			int id=tel.getId();
			String sql="update television set precio = "+tel.getPrecio()+", peso = "+tel.getPeso()+", color = '"+tel.getColor()+"', consumo = '"+tel.getConsumo()+"', pulgadas = "+tel.getPulgadas()+", sintonizador = "+tel.isSintonizador()+" where id = "+id;
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
		
	public ArrayList<Entidades.Television> getTelevisionesByImporte(float imp1, float imp2){
			ArrayList<Entidades.Television> locs= new ArrayList<Entidades.Television>();

			String sql="select id, descripcion, precio, peso, color, consumo, pulgadas, sintonizador from television where precio between "+imp1+" and "+imp2;
			Statement sentencia=null;
			ResultSet rs=null;

			
			try {	
					sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
					rs= sentencia.executeQuery(sql);

					while(rs.next()){
						Entidades.Television t= new Entidades.Television();
						t.setId(rs.getInt("id"));
						t.setDescripcion(rs.getString("descripcion"));
						t.setPrecio(rs.getFloat("precio"));
						t.setPeso(rs.getInt("peso"));
						t.setColor(rs.getString("color"));
						t.setConsumo(rs.getString("consumo"));
						t.setPulgadas(rs.getInt("pulgadas"));
						t.setSintonizador(rs.getBoolean("sintonizador"));
						locs.add(t);
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
	
	public ArrayList<Entidades.Television> getTelevisionesByConsumo(String a, String b){
		ArrayList<Entidades.Television> locs= new ArrayList<Entidades.Television>();

		String sql="select id, descripcion, precio, peso, color, consumo, pulgadas, sintonizador from television where consumo between '"+a+"' and '"+b+"'";
		Statement sentencia=null;
		ResultSet rs=null;

		
		try {	
				sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
				rs= sentencia.executeQuery(sql);

				while(rs.next()){
					Entidades.Television t= new Entidades.Television();
					t.setId(rs.getInt("id"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setPrecio(rs.getFloat("precio"));
					t.setPeso(rs.getInt("peso"));
					t.setColor(rs.getString("color"));
					t.setConsumo(rs.getString("consumo"));
					t.setPulgadas(rs.getInt("pulgadas"));
					t.setSintonizador(rs.getBoolean("sintonizador"));
					locs.add(t);
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
	
	public ArrayList<Entidades.Television> getTelevisionesByImpyCon(float imp1, float imp2, String a, String b){
		ArrayList<Entidades.Television> locs= new ArrayList<Entidades.Television>();

		String sql="select id, descripcion, precio, peso, color, consumo, pulgadas, sintonizador from television where precio between "+imp1+" and "+imp2+" and consumo between '"+a+"' and '"+b+"'";
		Statement sentencia=null;
		ResultSet rs=null;

		
		try {	
				sentencia= DataConnectionManager.getInstancia().getConn().createStatement();
				rs= sentencia.executeQuery(sql);

				while(rs.next()){
					Entidades.Television t= new Entidades.Television();
					t.setId(rs.getInt("id"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setPrecio(rs.getFloat("precio"));
					t.setPeso(rs.getInt("peso"));
					t.setColor(rs.getString("color"));
					t.setConsumo(rs.getString("consumo"));
					t.setPulgadas(rs.getInt("pulgadas"));
					t.setSintonizador(rs.getBoolean("sintonizador"));
					locs.add(t);
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
	
	ArrayList<Television> televisiones;
	
	public CatalogoTelevisiones(){
		televisiones = new ArrayList<Television>();
	}
	
	/*public void addTelevision(Television tev){
		televisiones.add(tev);
	}*/
	
	public ArrayList<Television> getArray(){
		return televisiones;
	}

	public void modificarTelevision(Television tev,int posi){
		televisiones.set(posi, tev);
	}

	public void eliminarTelevision(int posi){
		televisiones.remove(posi);
	}

	public void mostrarTelevision(int posi){
		televisiones.get(posi);
	}

}
