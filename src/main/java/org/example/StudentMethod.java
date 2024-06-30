package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentMethod {

    private Connection connection;
    Statement statement = null;

    String query = "create table students("
            + "student_id int(5) NOT NULL,"
            + "name varchar(20) NOT NULL,age int(3) NOT NULL)";


    public StudentMethod() {
        try {
            this.connection = DBCnnector.getConnection();


        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void createTable() {
        try {


            statement = this.connection.createStatement();
            statement.execute(query);
            statement.close();

            System.out.println("table created succesfully");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void addStudent(Student student) {
        String query = "insert into students(student_id,name,age) values(?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
preparedStatement.setInt(1,student.getId());
preparedStatement.setString(2,student.getName());
preparedStatement.setInt(3,student.getAge());
preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public List<Student> getAllStudents(){
        List<Student>students=new ArrayList<>();
        String query ="select * from students";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }
        }catch (Exception e) {
            e.getStackTrace();
        }

        return  students;
    }
    public void updateStudent(Student student){
        String query="update students set name=?,age=?,student_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public void deleteStudent(int studentId){
        String query="delete from students where student_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
          preparedStatement.setInt(1,studentId);
          preparedStatement.executeUpdate();

        }catch (Exception e) {
            e.getStackTrace();
        }
    }

}
