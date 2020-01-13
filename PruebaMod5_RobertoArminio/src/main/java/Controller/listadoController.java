
package Controller;
import Modelos.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class listadoController {
    //Creamos un atributo de JDBCTemplate , para poder abrir la conexin , generar consultas ... mas tarde
    private JdbcTemplate jdbcTemplate;
    
    public listadoController() {
        //Inicializamos en el constructor nuestro atributo JDBController asignadoselo a nuestra clase conexion 
        //previamente creada
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    //Mapeo del archivo JSP listadoMotores
    @RequestMapping("listadoMotores.htm")
    public ModelAndView home(HttpServletRequest request)
    {
        //Generamos una nueva vista
        ModelAndView mav=new ModelAndView();
        String sql="select * from motores";
        //A traves de JDBC ejecutamos una consulta y la guardamos en una lista de motor(es)
        List motores =this.jdbcTemplate.queryForList(sql);

        //Añado la lista a la vista
        mav.addObject("motores",motores);
        //Le asigno el nombre JSP a la vista
        mav.setViewName("listadoMotores");
        return mav;
    }
}