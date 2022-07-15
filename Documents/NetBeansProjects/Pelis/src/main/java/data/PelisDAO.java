package data;

import static data.ConecDB.*;
import java.sql.*;
import java.util.*;
import modelo.Stock;

public class PelisDAO {
    private static final String SQL_CREATE="INSERT INTO peli(nombre, director, duracion, costo, visitas) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM  peli";
    private static final String SQL_READ_BY_ID="SELECT * FROM peli WHERE idpeli= ?";
    private static final String SQL_UPDATE_COSTO="UPDATE peli SET costo = ? WHERE idpeli = ?";
    private static final String SQL_UPDATE_VISITAS="UPDATE peli SET visitas = ? WHERE idpeli = ?";
    private static final String SQL_UPDATE="UPDATE peli SET nombre = ?, director = ?, duracion = ?, costo = ?, visitas = ? WHERE idpeli = ?";
    private static final String SQL_DELETE="DELETE FROM peli WHERE idpeli = ?";
    
    
     public List<Stock> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Stock peli;
        List<Stock> peliA = new ArrayList();

        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idpeli = rs.getInt(1);
                String nombre = rs.getString(2);
                String director = rs.getString(3);
                int duracion = rs.getInt(4);
                double costo = rs.getDouble(5);
                int visitas = rs.getInt(6);

                peli = new Stock(idpeli, nombre, director, duracion, costo, visitas);

                peliA.add(peli);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return peliA;
    }
     
     public Stock findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Stock peli = null;
        
        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                
                int idPeli = rs.getInt(1);
                String nombre = rs.getString(2);
                String director = rs.getString(3);
                int duracion = rs.getInt(4);
                double costo = rs.getDouble(5);
                int visitas = rs.getInt(6);

                peli = new Stock(idPeli, nombre, director, duracion, costo, visitas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return peli;
    }
     public int insert(Stock peli){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, peli.getNombre());
            stmt.setString(2, peli.getDirector());
            stmt.setInt(3, peli.getDuracion());
            stmt.setDouble(4, peli.getCosto());
            stmt.setInt(5, peli.getVisitas());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int updateCosto(Stock peli){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_UPDATE_COSTO);
            stmt.setDouble(1, peli.getCosto());
            stmt.setInt(2, peli.getIdpeli());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
      public int updateCopias(Stock peli){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_UPDATE_VISITAS);
            stmt.setInt(1, peli.getVisitas());
            stmt.setInt(2, peli.getIdpeli());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
        public int update(Stock peli){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            try{
                conn = getConecDB();
                stmt = conn.prepareStatement(SQL_UPDATE);
                stmt.setString(1, peli.getNombre());
                stmt.setString(2, peli.getDirector());
                stmt.setInt(3, peli.getDuracion());
                stmt.setDouble(4, peli.getCosto());
                stmt.setInt(5, peli.getVisitas());
                stmt.setInt(6, peli.getIdpeli());
                registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
}
      
      
       public int deletePeli(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConecDB();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
