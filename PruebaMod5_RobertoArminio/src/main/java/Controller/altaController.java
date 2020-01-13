
package Controller;
import Modelos.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

//TAGS necesarios para el controlador
@Controller
@RequestMapping("altaMotor.htm")
public class altaController {
    
    //Creamos un atributo de JDBCTemplate , para poder abrir la conexin , generar consultas ... mas tarde
    // y lo acompañamos de un objeto de la clase validar , para validar la entrada de datos.
    private JdbcTemplate jdbcTemplate;
    private validarMotor validar;
    

    public altaController() 
    {
        //Inicializamos en el constructor nuestro atributo JDBController asignadoselo a nuestra clase conexion 
        //previamente creada
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
        this.validar = new validarMotor();
    }
    //Mapping del metodo get de la app , no es necesario la URL ya que se la he puesto a la clase entera
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView alta()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("altaMotor");
        mav.addObject("motor",new Motor());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView alta
        (
                @ModelAttribute("motor") Motor m,
                BindingResult result
        )
    {
         this.validar.validate(m, result);
        if (result.hasErrors()) {
             ModelAndView mav=new ModelAndView();
            mav.setViewName("altaMotor");
            mav.addObject("motor",new Motor());
            return mav;
        }else{
            this.jdbcTemplate.update(
            "insert into motores (modelo_pk,fabricante,potencia,peso,cantidad ) values (?,?,?,?,?)",
             m.getModelo_pk(),m.getFabricante(),m.getPotencia(),m.getPeso(),m.getCantidad());
             return new ModelAndView("redirect:/listadoMotores.htm");
        }
    }
       
    }
