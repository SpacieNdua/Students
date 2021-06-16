package Students_Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.json.simple.JSONObject;



public class studentsTable1 {
    private JTextField student_Name;
    private JTextField student_Id;
    private JTextField subjects;
    private JTextField marks_Attained;
    private JButton Submit;
    private JLabel studentName;
    private JLabel studentId;
    private JLabel subject;
    private JLabel marks;
    private JPanel Panel_1;
    //private TextComponent subjectTrial;

    public studentsTable1() {
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String Student_Name = student_Name.getText();
                String Student_ID = student_Id.getText();
                String Subject = subjects.getText();
                String Marks = marks_Attained.getText();



                Connection connection = null;
                String host = "localhost";
                String port = "5432";
                String db_name = "postgres";
                String username = "postgres";
                String password = "root";


                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
                    if (connection != null) {
                        String sql = "insert into Students values('"+ Student_Name +"','" + Student_ID + "', '" + Subject + "','" + Marks + "')";
                        Statement statement = connection.createStatement();
                        int x = statement.executeUpdate(sql);
                        if (x == 0)
                        {
                            JOptionPane.showMessageDialog(Submit, "Try Again");
                            System.out.println("Records NOT  inserted.....");

                        } else {
                            JOptionPane.showMessageDialog(Submit, "Successful");
                            System.out.println("Records inserted.....");
                        }
                        connection.close();

                    } }catch (Exception e1) {
                        e1.printStackTrace();

            }
                JSONObject list = new JSONObject();

                try{
                    //list.put("Subject",subjectTrial.getText());

                }catch(Exception e1){
                    e1.printStackTrace();
                }
                list.toString();
            }});}

    public static void main(String[]args)
    {

        JFrame frame = new JFrame("Saves");
        frame.setContentPane(new studentsTable1().Panel_1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}

