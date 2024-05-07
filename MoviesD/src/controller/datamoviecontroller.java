/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdatamovie.datamovieDAO;
import DAOImplements.datamoviesDimplement;
import model.*;
import view.MainView1;
/**
 *
 * @author Surya Aji
 */

public class datamoviecontroller {
    MainView1 frame;
    datamoviesDimplement impldatamovie;
    List<datamovie> dp;
    
    public datamoviecontroller(MainView1 frame){
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        dp = impldatamovie.getAll();
    }
    public void isitabel(){
        dp = impldatamovie.getAll();
        modeltabeldatamovie mp = new modeltabeldatamovie(dp);
        frame.getTableData().setModel(mp);
    }
    
    public void insert(){
        datamovie dp = new datamovie();
        dp.setJudul(frame.getJTJudul().getText());
        dp.setAlur(Double.parseDouble(frame.getJTAlur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getJTPenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getJTAkting().getText()));
        impldatamovie.insert(dp);
    }
     public void update(){
        datamovie dp = new datamovie();
        dp.setAlur(Double.parseDouble(frame.getJTAlur().getText()));
        dp.setPenokohan(Double.parseDouble(frame.getJTPenokohan().getText()));
        dp.setAkting(Double.parseDouble(frame.getJTAkting().getText()));
        dp.setJudul(frame.getJTJudul().getText());
        impldatamovie.update(dp);
    }
     public void delete(){
        String judul = (frame.getJTJudul().getText());
        impldatamovie.delete(judul);
    }
    
}
    
    
