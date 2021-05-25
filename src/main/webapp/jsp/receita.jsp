<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Ingrediente" %>
<!doctype html>
<html lang="pt-br">
  <head>
    <title>Criar receita</title>

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
      font-size: 20px;
      text-align: center;
     
    }
    #c{
      font-size: 20px;
      text-align: center;
      border: solid;
      background-color:rgb(0,255,255);
    }
    #d{
      font-size: 16px;
      color: rgba(4, 82, 11, 0.993);
      text-align: left;
      border: solid;
    }
    #e{
      border: solid;
      text-align: justify;
    }
    </style>
  </head>
  <body >
    <div >
  

  <main id= "e">
    <nav id ="a">
    <h3 >Cadastrar Receita</h3></nav>
    
    <form method="post">
      <label for="nomeReceita">Nome da Receita:</label>
      <input type="text" id="nomeReceita" name="nome"><br><br>
      <label for="medida">Medida do ingrediente |</label>
      <label for="medida">Ingrediente     |</label>
      <a href="#" id="filldetails" onclick="javascript:addIngrediente()">Adicionar ingrediente</a>
      <div id="container"/></div>
      <label for="passoRceita">Passos da Receita:</label>
      <input type="text" id="passoRceita" name="passo" style="width:500px" ><br><br>
      <button type="submit" value="Submit">Cadastrar</button>
      <input type="hidden" id="countItem" name="countItem"/>
      <script type="text/javascript">
        var countItem = 0
        addIngrediente = function(){
          var container = document.getElementById("container");
          var input = document.createElement("input");
          input.type = "text";
          input.id="medida"+ countItem;
          input.name = "medida"+ countItem;
          container.appendChild(input);
          var selectList = document.createElement("select");
          selectList.id = "ingrediente"+ countItem;
          selectList.name = "ingrediente"+ countItem;
          container.appendChild(selectList);
          var arrayOb = new Array();
          <%
              List<Ingrediente> ingredientes = (List<Ingrediente>) request.getAttribute("ingredientes");
              for (int i=0;i < ingredientes.size();i++) {
          %>
                arrayOb[<%= i %>]={id:<%= ingredientes.get(i).getId() %>, nome: '<%= ingredientes.get(i).getNome() %>'};
          <% } %>
            console.log(arrayOb);
            for (var i = 0; i < arrayOb.length; i++) {
              var option = document.createElement("option");
              option.value = arrayOb[i].id;
              option.text = arrayOb[i].nome;
              selectList.appendChild(option);
          }
          container.appendChild(document.createElement("br"));
          countItem += 1
          document.getElementById('countItem').value = countItem;
          console.log(countItem);
        }
    </script>
    </form>
    <a href="/Home/"><button >Voltar</button></a>
     </main>
</div>
</body>
</html>
