package by.bsuir.bocharenko.rms.webappcommand.material;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.MaterialJpaController;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class CreateMaterialCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String t = request.getParameter("title");
        String w = request.getParameter("weight");
        String v = request.getParameter("volume");
        String u = request.getParameter("unitStorageCost");
        if(w.equals("") ||  v.equals("") || u.equals("") || t.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод формы");
            return "/jsp/error.jsp";
        }
        Integer unitStorageCost = new Integer(u);
        Float weight = new Float(w);
        Float volume = new Float(v);
        Material material = new Material();
        material.setTitle(request.getParameter("title"));
        material.setSpecification(request.getParameter("specification"));
        material.setMeasure(request.getParameter("measure"));
        material.setWeight(weight);
        material.setVolume(volume);
        material.setUnitStorageCost(unitStorageCost);
        MaterialJpaController dbconn = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        dbconn.create(material);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        return "/jsp/main.jsp";
    }
}
