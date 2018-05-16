<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="assets/font.css" type="text/css">
  <link rel="stylesheet" href="assets/fontawesome/css/fontawesome-all.css">
  <link rel="stylesheet" href="assets/theme.css">
  <title>SoftSale - Cadastrar Funcionário</title>
</head>

<body>
  <nav class="navbar navbar-expand-md bg-secondary navbar-dark">
    <div class="container">
      <a class="navbar-brand" href="#">SoftSale</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="btn-group px-1">
          <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Cadastros</button>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="/SoftSale/clientes-list">Clientes</a>
            <a class="dropdown-item" href="/SoftSale/funcionarios-list">Funcionários</a>
          </div>
        </div>
        <ul class="navbar-nav mr-auto"></ul>
        <form class="form-inline m-0">
          <a class="btn btn-primary" href="/SoftSale/login.jsp">Sair</a>
        </form>
      </div>
    </div>
  </nav>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <form action="/SoftSale/funcionarios-add" method="post">
              <div class="card-header">
                <div class="row col-md-12 m-0 p-0">
                  <h2 class="m-0 mr-auto">Cadastro funcionário</h2>
                  <a href="/SoftSale/funcionarios-list" class="btn btn-outline-primary mx-1">Cancelar</a>
                  <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="col-md-12">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label>Nome</label>
                          <input type="text" required class="form-control" placeholder="Insira o nome" name="nome"> </div>
                      </div>
                      <div class="col-md-3">
                        <div class="form-group">
                          <label for="exampleInputEmail1">CPF</label>
                          <input type="text" required class="form-control" placeholder="Insira o CPF" name="cpf"> </div>
                      </div>
                      <div class="col-md-3">
                          <div class="form-group">
                            <label for="exampleInputEmail1">Senha</label>
                            <input type="password" required class="form-control" placeholder="Insira a senha" name="senha"> </div>
                        </div>
                    </div>
                    <h5> Contato </h5>
                    <div class="dropdown-divider"> </div>
                    <div class="row">
                      <div class="col-md-8">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Email</label>
                          <input type="email" class="form-control" placeholder="Insira o email" name="email"> </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Telefone</label>
                          <input type="text" class="form-control" placeholder="Insira o telefone" name="telefone"> </div>
                      </div>
                    </div>
                    <h5> Endereço </h5>
                    <div class="dropdown-divider"> </div>
                    <div class="row">
                      <div class="col-md-10">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Logradouro</label>
                          <input type="text" required class="form-control" placeholder="Insira o logradouro" name="logradouro"> </div>
                      </div>
                      <div class="col-md-2">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Numero</label>
                          <input type="text" class="form-control" placeholder="Insira o número" name="numero"> </div>
                      </div>
                      <div class="col-md-5">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Bairro</label>
                          <input type="text" required class="form-control" placeholder="Insira o bairro" name="bairro"> </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Cidade</label>
                          <input type="text" required class="form-control" placeholder="Insira o cidade" name="cidade"> </div>
                      </div>
                      <div class="col-md-3">
                        <div class="form-group">
                          <label for="exampleInputEmail1">Estado</label>
                          <input type="text" required class="form-control" placeholder="Insira o estado" name="estado"> </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="assets/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="assets/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</body>

</html>