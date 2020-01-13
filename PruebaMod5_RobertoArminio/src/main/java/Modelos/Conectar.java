
package Modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
 
    public DriverManagerDataSource conectar()
    {
        //Creo la conexion a la BBDD en una clase aparte, para poder ser usada en toda la applicacion
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/motorland");
        //En una app real , seria importante cambiar el usuario y la contraseña para garantizar la seguridad
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
}
