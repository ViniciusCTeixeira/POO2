package Users;
import java.sql.*;
import Tools.DatabaseConnection;

public class Users extends Template{

    public Users(String Name,String Birth,String Cpf,String TypeUser,String Salary) {
        this.Name = Name;
        this.Birth = Birth;
        this.Cpf = Cpf;
        this.TypeUser = TypeUser;
        this.Salary = Salary;
    }

    public void View(){
        System.out.printf("%s",this.Name);
        System.out.printf("\n%s",this.Birth);
        System.out.printf("\n%s",this.Cpf);
        System.out.printf("\n%s",this.TypeUser);
        System.out.printf("\n%s",this.Salary);
    }

    public void SaveUser() throws SQLException {
        DatabaseConnection cnn = DatabaseConnection.getInstance();
        Connection connection = cnn.getConnection();

        try {
            System.out.println("Salvando usuario!");

            Statement st = connection.createStatement();

            st.executeUpdate("INSERT INTO users(name,birth,cpf,type_user,salary) VALUES ('"+this.Name+"','"+this.Birth+"','"+this.Cpf+"','"+this.TypeUser+"','"+this.Salary+"')");

        }
        catch(SQLException e ) {
            System.out.println("Error ao salvar!");
            System.out.println(e.getErrorCode());

        }


    }
}
