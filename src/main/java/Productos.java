import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Productos {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****PRODUCTOS*****");

        System.out.println("¿Deseas comprar o consultar uno o todos producto?:");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("comprar")) {
            //

            System.out.print("¿Deseas comprar un producto?: ");
            String compra = scanner.nextLine();

            while (compra.equals("si")) {

                System.out.print("Ingrese el codigo del producto: ");
                String codigo = scanner.nextLine();

                System.out.print("Ingrese el tipo de producto: ");
                String tipo = scanner.nextLine();

                System.out.print("Ingrese nombre del producto: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese el valor del producto: ");
                String valor = scanner.nextLine();

                System.out.print("Ingrese caracteristicas fisicas del producto: ");
                String caracteristicasfisicas = scanner.nextLine();

                System.out.print("Ingrese caracteristicas de fabricacion del producto: ");
                String caracteristicasfabricacion = scanner.nextLine();

                System.out.printf("Ingrese su numero de documento de identidad: ");
                String documento = scanner.nextLine();


                if (codigo.equals("") || tipo.equals("") || nombre.equals("") || valor.equals("") || caracteristicasfisicas.equals("") || caracteristicasfabricacion.equals("") || documento.equals("")) {
                    System.out.println("No se admiten datos vacios.");
                } else {


                    Caracteristicas registroproductos = new Caracteristicas(codigo, tipo, nombre, valor, caracteristicasfisicas, caracteristicasfabricacion);

                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/productos";
                    String username = "root";
                    String password = "";

                    try {
                        Class.forName(driver);
                        Connection connection = DriverManager.getConnection(url, username, password);
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM registroproductos");

                        Insert(registroproductos, documento, connection);
                        connection.close();
                        statement.close();
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Deseas comprar otro producto: ?");
                compra = scanner.nextLine();
            }

        } else if
        (respuesta.equals("consultar un producto")) {
            System.out.println("Ingrese el codigo a consultar: ");
            String id = scanner.nextLine();

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/productos";
            String username = "root";
            String password = "";

            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url, username, password);

                String consultaSQL = "SELECT * FROM registroproductos WHERE codigo = ?";

                PreparedStatement statement = connection.prepareStatement(consultaSQL);
                statement.setString(1, id); // Establecer el valor del parámetro

                // Ejecutar la consulta
                ResultSet resultSet = statement.executeQuery();

                // Procesar el resultado si existe
                if (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String tipo = resultSet.getString("tipo");
                    String nombre = resultSet.getString("nombre");
                    String valor = resultSet.getString("valor");
                    String caracteristicasfisicas = resultSet.getString("caracteristicasfisicas");
                    String caracteristicasfabricacion = resultSet.getString("caracteristicasfabricacion");
                    String documento = resultSet.getString("documento");

                    System.out.println("Estes es el codigo del producto a consultar: " + codigo + "\n" + "de tipo: " + tipo + "\n" + "nombre: " + nombre + "\n" + "con un valor de: " + valor + "\n" + "caracteristicasfisicas: " + caracteristicasfisicas + "\n" + "caracteristicasfabricacion: " + caracteristicasfabricacion);

                } else {
                    System.out.println("No se encontró un registro con el codigo especificado.");
                }

                // Cerrar recursos
                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (respuesta.equals("consultar todos")) {

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/productos";
            String username = "root";
            String password = "";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement2 = connection.createStatement();

            ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM registroproductos");//TABLA

            while (resultSet2.next()) {
                String codigo = resultSet2.getString("codigo");
                String tipo = resultSet2.getString("tipo");
                String nombre = resultSet2.getString("nombre");
                String valor = resultSet2.getString("valor");
                String caracteristicasfisicas = resultSet2.getString("caracteristicasfisicas");
                String caracteristicasfabricacion = resultSet2.getString("caracteristicasfabricacion");
                String documento = resultSet2.getString("documento");

                System.out.println("Estes es el codigo del producto a consultar: " + codigo + "\n" + "de tipo: " + tipo + "\n" + "nombre: " + nombre + "\n" + "con un valor de: " + valor + "\n" + "caracteristicasfisicas: " + caracteristicasfisicas + "\n" + "caracteristicasfabricacion: " + caracteristicasfabricacion);

            }
        }
    }

    public static void Insert(Caracteristicas productos, String documento, Connection connection){

        try {
            // Sentencia INSERT
            String sql = "INSERT INTO registroproductos (codigo, tipo, nombre, valor, caracteristicasfisicas, caracteristicasfabricacion, documento) VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productos.getCodigo());
            preparedStatement.setString(2, productos.getTipo());
            preparedStatement.setString(3, productos.getNombre());
            preparedStatement.setString(4, productos.getValor());
            preparedStatement.setString(5, productos.getCaracteristicasfisicas());
            preparedStatement.setString(6, productos.getCaracteristicasfabricacion());
            preparedStatement.setString(7, documento);



            // Ejecutar la sentencia
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Registro insertado exitosamente.");
            } else {
                System.out.println("No se pudo insertar el registro.");
            }

            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

