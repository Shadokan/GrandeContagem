package com.grandemc.entity;

import com.grandemc.GrandeContagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.grandemc.GrandeContagem.*;

public class PlayerManager {

    private ArrayList<PlayerObjeto> lista;


    public PlayerManager() {
        lista = new ArrayList<>();
    }

    private void createPlayer(PlayerObjeto pb){
        lista.add(pb);
    }

    public PlayerObjeto getPlayer(String nome){
        for (PlayerObjeto user : lista){
            if (user.getNome().equalsIgnoreCase(nome)) return user;
        }
        return null;
    }

    public void salvarPlayer(PlayerObjeto p){

        try {

            getMYSQL().openConnection();
            Connection connection = getMYSQL().getConnection();

            PreparedStatement ps = connection.prepareStatement("UPDATE informacoes SET blocos = '"+ p.getQuantidade() +"' WHERE nome = '"+ p.getNome() + "'");
            ps.execute();
            ps.close();

            getMYSQL().closeConnection();

        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void loadPlayer(String nome){

        try{

            getMYSQL().openConnection();
            Connection c = getMYSQL().getConnection();

            PreparedStatement ps = c.prepareStatement("SELECT * FROM informacoes WHERE nome = '" + nome + "'");
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                createPlayer(new PlayerObjeto(rs.getString("nome"), rs.getInt("blocos")));
            } else{
                ps = c.prepareStatement("INSERT INTO informacoes VALUES ('" + nome + "', '" + 0 +"')");
                ps.execute();
                ps.close();
                createPlayer(new PlayerObjeto(nome, 0));
            }


            getMYSQL().closeConnection();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

}
