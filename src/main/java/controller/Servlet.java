package controller;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ReceitaService;
import model.Receita;
import model.IngredService;
import model.Ingrediente;
import model.ReceitaIngredienteService;
import model.ReceitaIngrediente;
import java.util.List;

@WebServlet({"*.action","/"})
public class Servlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req,
                       HttpServletResponse res){
        
        String path = req.getServletPath();
        ServletContext sc = req.getServletContext();
        ReceitaService us = new ReceitaService();   
        IngredService is = new IngredService();
        ReceitaIngredienteService ris = new ReceitaIngredienteService();
        List<Receita> receita = us.list();
        List<String> receitaIngrediente = new ArrayList<String>();
        for (Receita r : receita) {
            long r_id = r.getId();
            List<ReceitaIngrediente> recIng = ris.listfromreceita(r_id);
            String ings = "";
            for (ReceitaIngrediente ri : recIng) {
                long id_ingrediente = ri.getIdIngrediente();
                Ingrediente ing = is.getbyid(id_ingrediente);
                if (ings.trim().equals("") == false) ings = ings + ", ";
                ings = ings + ri.getMedida() + " " + ing.getNome();
            }
             receitaIngrediente.add(ings);
        }
        List<Ingrediente> ingrediente = is.list();		
		req.setAttribute("receitas", receita);		
		req.setAttribute("ingredientes", ingrediente);
                req.setAttribute("receita_ingredientes", receitaIngrediente);
        switch (path){
            case "/":
               try{
                    sc.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
                } catch (Exception e){}
               break;
            case "/ingrediente":
                try{
                    sc.getRequestDispatcher("/jsp/ingrediente.jsp").forward(req, res);
                } catch (Exception e){}
                break;
            case "/listaIngrediente":
                try{
                    sc.getRequestDispatcher("/jsp/ingredList.jsp").forward(req, res);
                } catch (Exception e){}
                break;
                case "/receita":
                try{
                    sc.getRequestDispatcher("/jsp/receita.jsp").forward(req, res);
                } catch (Exception e){}
                break;
                case "/listaReceita":
                try{
                    sc.getRequestDispatcher("/jsp/receList.jsp").forward(req, res);
                } catch (Exception e){}
                break;
            default:
                try{
                   sc.getRequestDispatcher("/jsp/notfound.jsp").forward(req, res);
                }catch (Exception e){}               
        }
        
    }  

    @Override
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res) {
        String path = req.getServletPath();
        ServletContext sc = req.getServletContext();
        switch (path) {
            case "/ingrediente":
                try {
                    IngredService ing = new IngredService(); 

                    String nome = req.getParameter("nome");
                    ing.create(nome);
                    
                    res.sendRedirect("/Home/listaIngrediente");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "/listaIngrediente":
                try {
                    IngredService ing = new IngredService(); 
                    ReceitaIngredienteService ris = new ReceitaIngredienteService();
                    long id_ingrediente = Integer.parseInt(req.getParameter("hidBt"));

                    List<ReceitaIngrediente> recIng =  ris.listfromingrediente(id_ingrediente);
                    for (ReceitaIngrediente ri : recIng) {
                        ris.delete(ri.getId());
                    }
                    ing.delete(id_ingrediente);
                    

                    res.sendRedirect("/Home/listaIngrediente");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "/receita":
                try {
                    ReceitaService ds = new ReceitaService();
                    ReceitaIngredienteService ris = new ReceitaIngredienteService(); 
                    String nome = req.getParameter("nome");
                    String passo = req.getParameter("passo");
                    Receita r = ds.create(nome, passo);
                    long id_receita = r.getId();
                    String countItem = req.getParameter("countItem");
                    int count = Integer.parseInt(countItem);
                    for (int i = 0; i < count; i++) {
                        int id_ingrediente = Integer.parseInt(req.getParameter("ingrediente" + i));
                        String medida = req.getParameter("medida" + i);
                        ris.create(medida, id_receita, id_ingrediente);
                    }
                    res.sendRedirect("/Home/listaReceita");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "/listaReceita":
                try {
                    ReceitaService r = new ReceitaService(); 
                    ReceitaIngredienteService ris = new ReceitaIngredienteService();
                    long id_receita = Integer.parseInt(req.getParameter("hidBt"));

                    List<ReceitaIngrediente> recIng =  ris.listfromreceita(id_receita);
                    for (ReceitaIngrediente ri : recIng) {
                        ris.delete(ri.getId());
                    }
                    r.delete(id_receita);
                    res.sendRedirect("/Home/listaReceita");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "/voltar":
                try {
                    
                    res.sendRedirect("/Home/");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                try {
                    sc.getRequestDispatcher("/jsp/notfound.jsp").forward(req, res);
                } catch (Exception e) {
                }
        }
    }
}