<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Receita" %>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>lista de receita</title>
    <style type="text/css">
      #a {
      
      font-size: 25px;
      color: rgb(255,0,0);
      border: solid;
      background-color:rgb(0,255,255);
      padding: 1px;
      margin: 1px;
      text-align: center;
    }
    #b{
      font-size: 18px;
      text-align: center;
      border: solid;
    }
    #c{
      font-size: 25px;
      text-align: center;
      border: solid;
    }
    </style>
  </head>
  <body >
    <div >
  

  <main >
    <table border ="1">
      <caption><h1 id="a" >Lista de Receitas </h1></caption>
      <tr>
          
          <th id="">Nome</th>
          <th id="">Ingredientes</th>
          <th id="">Passos</th>
          <th id="">Opções</th>
      </tr>
      
          <tr> 
            
            <%
            List<Receita> receitas = (List<Receita>) request.getAttribute("receitas");
            List<String> ingredientes = (List<String>) request.getAttribute("receita_ingredientes");
                  for (int i=0;i < receitas.size();i++)
                  {
                    long idk = receitas.get(i).getId();
                    out.print("<td >"+receitas.get(i).getNome()+"</td>" );
                    out.print("<td >"+ingredientes.get(i)+"</td>" );
                    out.print("<td>"+receitas.get(i).getPasso()+"</td>");
                     %>
                     <td>
                      <form method="post">
                        <input type="hidden" name="hidBt" />
                        <label>
                            <%-- <input type="submit" name="<%=i %>" value="edit" onclick="this.form.hidBt.value=this.value;this.form.action='listaReceita?flag=1&act=1';this.form.submit();" /> --%>
                            <input type="submit" name="delete_<%=i %>" value="delete" onclick="this.form.hidBt.value='<%=idk %>';this.form.action='listaReceita';this.form.submit();" />
                        </label> 
                      </form>
                    </td><tr>
                    <%
                  }		
              %>
          
          </tr>
      
  </table>
   
   
    <a href="/Home/"><button >Voltar</button></a>
    </main>
  </div>
  </body>
</html>
