package com.codoaocodo.javacrud_final.Modelo;

import com.codoaocodo.javacrud_final.Conexion.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OradorDAO {
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE id_orador = ?";
    
    public Orador obtenerPorId(int id){
        String query = "SELECT * FROM oradores WHERE id_orador="+id;
        
        Connection conn = AdministradorDeConexiones.getConnection();
        Orador oradorDB = null;
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                int idDB = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                LocalDateTime fecha = rs.getTimestamp(6).toLocalDateTime();
                
                oradorDB = new Orador(idDB, nombre, apellido, tema, mail, fecha);
            }
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        return oradorDB;
    }
    
    public List<Orador> listarOradores(){
        String query = "SELECT * FROM oradores ";
        
        Connection conn = AdministradorDeConexiones.getConnection();
        
        List<Orador> oradores = new ArrayList<>();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int idDB = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                LocalDateTime fecha = rs.getTimestamp(6).toLocalDateTime();
                
                Orador oradorDB =  new Orador(idDB, nombre, apellido, tema, mail, fecha);
                
                oradores.add(oradorDB);                
            }
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        return oradores;
    }
    
    public boolean crearOrador(String nom, String ape, String tema, String mail){
        Connection conn = AdministradorDeConexiones.getConnection();
        if(conn != null){            
            try{
                PreparedStatement ps = conn.prepareStatement("INSERT INTO oradores (nombre, apellido, mail, tema, fecha_alta) VALUES (?,?,?,?,?)");
                ps.setString(1, nom);
                ps.setString(2, ape);
                ps.setString(3, mail);
                ps.setString(4, tema);
                ps.setDate(5, Date.valueOf(LocalDate.now()));
                ps.execute();
                conn.close();
                return true;
            }
            catch(Exception e){
                e.printStackTrace(System.out);
                return false;
            }
        }
        return false;
    }
    
    public boolean actualizarOrador(int id, String nom, String ape, String tema, String mail){
        Connection conn = AdministradorDeConexiones.getConnection();
        if(conn != null){
            String query = "UPDATE oradores "
                    + "set nombre='"+nom+"',"
                    + "apellido ='"+ape+"',"
                    + "mail ='"+mail+"',"
                    + "tema ='"+tema+"'"
                    + "WHERE id_orador ='"+id+"'";
            try{
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                conn.close();
                return true;
            }
            catch(Exception e){
                e.printStackTrace(System.out);
            }
        }
        return false;
    }
    
    public List<Orador> buscarPorNombre(String nombreBuscado){
        List<Orador> oradores =  new ArrayList();
        
        Connection conn = AdministradorDeConexiones.getConnection();

        String query = "SELECT * FROM oradores WHERE nombre LIKE '%"+nombreBuscado+"%' ";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                int idDB = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                LocalDateTime fecha = rs.getTimestamp(6).toLocalDateTime();
                
                Orador oradorDB =  new Orador(idDB, nombre, apellido, tema, mail, fecha);
                
                oradores.add(oradorDB); 
            }
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        
        return oradores;
    }
    
    public boolean eliminarOrador(int id){
        int registros = 0;
        try{
            Connection conn = AdministradorDeConexiones.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace(System.out);
        }
        return registros > 0;
    }
}

