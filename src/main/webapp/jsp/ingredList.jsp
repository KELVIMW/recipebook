<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Ingrediente" %>
<!doctype html>
<html lang="pt-br">
  <head>
    
    <title>lista de ingredientes</title>
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
      <caption><h1 id="a" >Lista de Ingredientes </h1></caption>
      <tr>
          <th id="">Nome</th>
          <th id="">Opções</th>
      </tr>
      
          <tr>
            
            <%
     
     
      List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
        for (int i=0;i < ingredientes.size();i++)
        {
          long idk = ingredientes.get(i).getId();
          out.print("<td >"+ingredientes.get(i).getNome()+"</td>" );
            %>
            <td>
            <form method="post">
              <input type="hidden" name="hidBt" />
              <label>
                  <%-- <input type="submit" name="<%=i %>" value="edit" onclick="this.form.hidBt.value=this.value;this.form.action='listaReceita?flag=1&act=1';this.form.submit();" /> --%>
                  <input type="submit" name="delete_<%=i %>" value="delete" onclick="this.form.hidBt.value='<%=idk %>';this.form.action='listaIngrediente';this.form.submit();" />
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
