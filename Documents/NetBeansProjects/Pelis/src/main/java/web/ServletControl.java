package web;

import data.PelisDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.*;



@WebServlet("/servletControl")
public class ServletControl extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    eliminarPeli(req, res);
                    break;
                case "editar":
                    editarPeli(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }else{
            accionDefault(req, res);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if(queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarPeli(req,res);
                    break;
                case "modificar":
                    modificarPeli(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
                }    
            }
        }
    
    private void accionDefault(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{    
        List <Stock> pelis = new PelisDAO().findAll();
        pelis.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("pelis", pelis);
        sesion.setAttribute("cantidadVisitas",calcularVisitas(pelis));
        sesion.setAttribute("costoTotal", calcularCosto(pelis));
        res.sendRedirect("pelis.jsp");
    }
    
    private void insertarPeli(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String director = req.getParameter("director");
        int duracion = Integer.parseInt(req.getParameter("duracion"));
        double costo = Double.parseDouble(req.getParameter("costo"));
        int visitas = Integer.parseInt(req.getParameter("visitas"));
        
        Stock peli = new Stock(nombre, director, duracion, costo, visitas);
        int registrosMod = new PelisDAO().insert(peli);
        System.out.println("insertadas = " + registrosMod);
        accionDefault(req, res);
    }
    
    private void eliminarPeli(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idpeli = Integer.parseInt(req.getParameter("idpeli"));
        int regMod = new PelisDAO().deletePeli(idpeli);
        System.out.println("SE ELIMINARON: "+ regMod +" REGISTROS");
        accionDefault(req, res);
    }
    
    private void editarPeli(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idpeli = Integer.parseInt(req.getParameter("idpeli"));
        Stock peli = new PelisDAO().findById(idpeli);
        req.setAttribute("peli", peli);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
    private void modificarPeli(HttpServletRequest req , HttpServletResponse res)  throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String director = req.getParameter("director");
        int duracion = Integer.parseInt(req.getParameter("duracion"));
        double costo = Double.parseDouble(req.getParameter("costo"));
        int visitas = Integer.parseInt(req.getParameter("visitas"));
        int idpeli = Integer.parseInt(req.getParameter("idpeli"));
        Stock pel = new Stock(idpeli,nombre,director,duracion,costo,visitas);
        int regMod = new PelisDAO().update(pel);
        System.out.println("SE ACTUALIZARON: "+ regMod +" REGISTROS");
        accionDefault(req,res);
    }
    
    private int calcularVisitas(List<Stock> pel){
        int cant=0;
        for (int i = 0; i < pel.size(); i++) {
            cant += pel.get(i).getVisitas();
        }
        
        return cant;
    }
    
    private double calcularCosto(List<Stock> pel){
        double costo= 0;
        for (int i = 0; i < pel.size(); i++) {
            costo +=  pel.get(i).getCosto(); //* pel.get(i).getVisitas();
        }
        return costo;
    }
}