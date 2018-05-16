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
  <title>SoftSale - Funcionários</title>
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
          <button class="btn btn-primary" type="submit">Sair</button>
        </form>
      </div>
    </div>
  </nav>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-header">
              <div class="row col-md-12 m-0 p-0">
                <h2 class="m-0 mr-auto">Funcionários</h2>
                <a class="btn btn-primary" href="/SoftSale/funcionarios-add.jsp">Adicionar</a>
              </div>
            </div>
            <div class="card-body">
              <table class="table table-striped">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th class="text-right">Opções</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="funcionario" items="${funcionarios}">
                    <tr>
                      <td>${funcionario.id}</td>
                      <td>${funcionario.nome}</td>
                      <td>${funcionario.cpf}</td>
                      <td>${funcionario.email}</td>
                      <td align="right">
                        <a href="/SoftSale/funcionarios-edit?id=${funcionario.id}">
                          <i class="fas fa-edit"></i>
                        </a>
                        <a href="/SoftSale/funcionarios-remove?id=${funcionario.id}">
                          <i class="fas fa-trash"></i>
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
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