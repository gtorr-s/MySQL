package com.mycompany.sistemaacademico;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConexaoDB {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "facu";
    private static String usuario = "root";
    private static String senha = "ehsegredo";
    
    public static Connection obtemConexao (){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC", usuario,senha);
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}


