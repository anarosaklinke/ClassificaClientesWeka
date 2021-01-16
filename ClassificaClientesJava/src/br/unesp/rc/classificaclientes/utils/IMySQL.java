package br.unesp.rc.classificaclientes.utils;

import java.sql.Connection;

public interface IMySQL {

    final String USUARIO = "root";
    final String SENHA = "1234";
    final String URL = "jdbc:mysql://localhost:3306/classificaClientes?useTimezone=true&serverTimezone=UTC";
    final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
}