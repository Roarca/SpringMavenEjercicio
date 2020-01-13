
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
    private JdbcTemplate jdbcTemplate;
    
    public listadoController() {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("listadoMotores.htm")
    public ModelAndView home(HttpServletRequest request)
    {
        ModelAndView mav=new ModelAndView();
        String sql="select * from motores";
        List motores =this.jdbcTemplate.queryForList(sql);

        mav.addObject("motores",motores);
        mav.setViewName("listadoMotores");
        return mav;
    }
}