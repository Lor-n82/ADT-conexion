package conexionBase;

import java.sql.*;
public class Main {
public static void main(String[] args) {
 try
 {
//Cargar el driver
 Class.forName("com.mysql.jdbc.Driver");
// Establecemos la conexion con la BD
Connection conexion = DriverManager.getConnection
 ("jdbc:mysql://localhost/empresa","root", "");
//Primer ejemplo Nombre de la BD, Segundo ejemplo Usuario,
 //Tercer ejemplo Clave.
 // Preparamos la consulta
Statement sentencia = conexion.createStatement();
ResultSet resul = sentencia.executeQuery ("SELECT * FROM departamentos");

// Recorremos el resultado para visualizar cada fila
// Se hace un bucle mientras haya registros, se van visualizando
while (resul.next())
{
 System.out.println (resul.getInt(1) + " " + resul.getString(2)+ " " +
 resul.getString(3));
}
resul.close();// Cerrar ResultSet
sentencia.close();// Cerrar Statement

System.out.println("");

Statement sentencia2 = conexion.createStatement();
ResultSet resul2 = sentencia2.executeQuery ("SELECT apellido, oficio , salario FROM empleados Where dept_no=10");

while (resul2.next())
{
 System.out.println (resul2.getString(1) + " " + resul2.getString(2)+ " " +
 resul2.getFloat(3));
}
resul2.close();// Cerrar ResultSet
sentencia2.close();// Cerrar Statement

System.out.println("");

Statement sentencia3 = conexion.createStatement();
ResultSet resul3 = sentencia3.executeQuery ("SELECT apellido, salario , dept_no FROM empleados Where salario in(select max(salario) from empleados)");

while (resul3.next())
{
 System.out.println (resul3.getString(1) + " " + resul3.getFloat(2)+ " " +
 resul3.getInt(3));
}
resul2.close();// Cerrar ResultSet
sentencia2.close();// Cerrar Statement

conexion.close();//Cerrar conexion
 
 }
 catch (ClassNotFoundException cn) {cn.printStackTrace();}
catch (SQLException e) {e.printStackTrace();}
}//fin de main
}//fin de la clase