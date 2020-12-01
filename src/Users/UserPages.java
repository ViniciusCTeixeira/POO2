package Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.util.ArrayList;

public class UserPages extends JFrame implements ActionListener{

    private JLabel lblName;
    private JTextField txtName;

    private JLabel lblBirth;
    private JFormattedTextField txtBirth;

    private JLabel lblCpf;
    private JFormattedTextField txtCpf;

    private JLabel lblUserType;
    private JComboBox sltUserType;
    private final String[] userType = {"Adminstrador","Geral"};

    private JLabel lblSalary;
    private JFormattedTextField txtSalary;

    private JButton btnSend;
    private Container frame;

    public UserPages(){

    }

    public void StartPage() {
        setSize(500,400);
        setTitle("Tela inicial");

        this.frame = getContentPane();

        this.lblName = new JLabel("Nome");
        this.txtName = new JTextField();

        this.lblBirth = new JLabel("Nascimento");
        try{
            this.txtBirth = new JFormattedTextField(new MaskFormatter("##-##-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.lblCpf = new JLabel("CPF");
        try{
            this.txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.lblUserType = new JLabel("Tipo de usuário");
        this.sltUserType = new JComboBox(userType);

        this.lblSalary = new JLabel("Salário");
        try{
            this.txtSalary = new JFormattedTextField(new MaskFormatter("R$: #.###,##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.btnSend = new JButton("Enviar");
        this.frame.setLayout(null);

        this.lblName.setBounds(2,2,100,25);
        this.txtName.setBounds(150,2,200,25);
        this.lblBirth.setBounds(2,52,100,25);
        this.txtBirth.setBounds(150,52,200,25);
        this.lblCpf.setBounds(2,102,100,25);
        this.txtCpf.setBounds(150,102,200,25);
        this.lblUserType.setBounds(2,152,100,25);
        this.sltUserType.setBounds(150,152,200,25);
        this.lblSalary.setBounds(2,202,100,25);
        this.txtSalary.setBounds(152,202,200,25);
        this.btnSend.setBounds(152,252,100,60);

        this.frame.add(this.lblName);
        this.frame.add(this.txtName);
        this.frame.add(this.lblBirth);
        this.frame.add(this.txtBirth);
        this.frame.add(this.lblCpf);
        this.frame.add(this.txtCpf);
        this.frame.add(this.lblUserType);
        this.frame.add(this.sltUserType);
        this.frame.add(this.lblSalary);
        this.frame.add(this.txtSalary);
        this.frame.add(this.btnSend);

        this.btnSend.addActionListener(this);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);

        Users user = new Users(txtName.getText(),txtBirth.getText(),txtCpf.getText(),(String )sltUserType.getSelectedItem(),txtSalary.getText());
        try {
            user.SaveUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        user.View();
        System.exit(0);
    }

}
