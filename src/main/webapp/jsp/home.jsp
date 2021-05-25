<!doctype html>
<html lang>
  <head>
    <meta charset = "UTF-8">
    <title>Pagina Inicial</title>

    <style type="text/css">
      #a {
      
      font-size: 25px;
      color: rgb(0, 0, 0);
      border: solid;
      background-color:rgb(255, 51, 0);
      padding: 1px;
      margin: 1px;
      text-align: center;
    }
    #c{
      font-size: 20px;
      text-align: center;
     
    }
    #b {
      background-color: #4CAF50; /* Green */
      border: none;
      color: white;
      padding: 15px 32px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
    }
    </style>
      
  </head>
  
  <body >
    <div >
  <header >
    <div >
      <nav id="a">
        
        <h3>Sistema Web - Livro de Receitas</h3>
      </nav>
    </div>
  </header>
  <div id="c">
    <p ><a href="/Home/ingrediente"><button id="b">Cadastrar Ingrediente</button></a><br><br>
      <a href="/Home/listaIngrediente"><button id="b">Visualizar Ingrediente</button></a></p>  
    <p ><a href="/Home/receita"><button id="b">Cadastrar Receita</button></a><br><br>
    <a href="/Home/listaReceita"><button id="b">Visualizar Receita</button></a></p>
    </div>
  
  </div>
  </body>
</html>
