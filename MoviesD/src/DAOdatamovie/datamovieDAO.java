package DAOdatamovie;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplements.datamoviesDimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class datamovieDAO implements datamoviesDimplement {
    Connection connection;
    
    final String select = "select * from movie;";
    final String insert = "INSERT INTO movie (judul,alur,penokohan,akting,nilai) VALUES (?,?,?,?,?);";
    final String update = "update movie set alur=?, penokohan=?, akting=? where judul=?;";
    final String delete = "delete from movie where judul=?;";
    
    public datamovieDAO() {
        connection = connector.connection();
    }
    
    @Override
    public void insert(datamovie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getRating());
            statement.executeUpdate();
        } catch ( SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex ) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(datamovie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            statement.setString(4, m.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex ) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<datamovie> getAll() {
        List<datamovie> dm = null;
        try {
            dm = new ArrayList<datamovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()) {
                datamovie md = new datamovie();
                md.setJudul(rs.getString("judul"));
                md.setAlur(rs.getDouble("alur"));
                md.setPenokohan(rs.getDouble("penokohan"));
                md.setAkting(rs.getDouble("akting"));
                dm.add(md);
            }
        } catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dm;
    }
}
