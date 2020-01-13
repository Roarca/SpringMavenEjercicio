/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class validarMotor implements Validator{
    
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Motor.class.isAssignableFrom(type);
       // return TuClase.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Motor mot=(Motor)o;
        
        //Valido cada campo requerido , en el caso del modelo , aunque pide que sea igual a 5 , por comodidad 
        //a la hora de realizar pruebas es >=5 (y porque en la BBDD es un VARCHAR(50) y no se corresponderia con el).
        if (mot.getModelo_pk().length()<=5)
        {
            errors.rejectValue("modelo_pk", "verificaModelo","Tiene que ser mayor de 5 caracteres.");
        }
        
        if(mot.getPeso()<0)
        {
	    errors.rejectValue("peso", "verificaPeso","El peso debe de ser mayor a 0.");
	}
        
        if(mot.getPotencia()<0)
        {
	    errors.rejectValue("potencia", "verificaPotencia","El peso debe de ser mayor a 0.");
	}
        
        if(mot.getCantidad()<=0)
        {
	    errors.rejectValue("cantidad", "verificaCantidad","No se permiten valores negativos.");
	}
    }
}
