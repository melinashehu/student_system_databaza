package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentMethod studentm = new StudentMethod();
        Scanner scanner = new Scanner(System.in);
        studentm.createTable();
        while (true) {
            System.out.println("menu:");
            System.out.println("1.Add a student");
            System.out.println("2.Remove a student");
            System.out.println("3.Update the table");
            System.out.println("4.get all students");
            System.out.println("5.exit");
            int choice;
            System.out.println("select one number(1,2,3,4,5");
            choice = scanner.nextInt();

            if (choice == 1) {
                Student studentnew = new Student();
                System.out.println("please put an Id");
                int Id = scanner.nextInt();
                studentnew.setId(Id);
                scanner.nextLine();
                System.out.println("please put the name of student:");
                String name = scanner.nextLine();
                studentnew.setName(name);

                System.out.println("please put the age:");
                int age = scanner.nextInt();
                studentnew.setAge(age);
                studentm.addStudent(studentnew);
            } else if (choice == 2) {
                System.out.println("please put the id of the student you want to delete");
                int studentDelete = scanner.nextInt();

                studentm.deleteStudent(studentDelete);
                List<Student> studentsdeleted = studentm.getAllStudents();
                System.out.println("all students deleted");
                for (Student studentelement : studentsdeleted) {
                    System.out.println(studentelement.getId() + "." + studentelement.getName() + "." + studentelement.getAge());
                }

            } else if (choice == 3) {
                Student studentnew = new Student();
                System.out.println("put the name you want to update");
                String name = scanner.nextLine();
                scanner.nextLine();
                System.out.println("put the age you want to update");
                int age = scanner.nextInt();
                studentnew.setName(name);
                studentnew.setAge(age);
                studentm.updateStudent(studentnew);
                List<Student> studentsupdated = studentm.getAllStudents();
                System.out.println("all students updated");
                for (Student studentelement : studentsupdated) {
                    System.out.println(studentelement.getId() + "." + studentelement.getName() + "." + studentelement.getAge());
                }

            }else if (choice==4){
                List<Student> students = studentm.getAllStudents();
        System.out.println("all students");
        for (Student studentelement : students) {
            System.out.println(studentelement.getId() + "." + studentelement.getName() + "." + studentelement.getAge());
        }
            }else {
                System.out.println("thank you");
                break;
            }


        }

//        Student studentnew = new Student();
//        studentnew.setId(1);
//        studentnew.setName("test");
//        studentnew.setAge(22);
//        studentm.addStudent(studentnew);
//
//        List<Student> students = studentm.getAllStudents();
//        System.out.println("all students");
//        for (Student studentelement : students) {
//            System.out.println(studentelement.getId() + "." + studentelement.getName() + "." + studentelement.getAge());
//        }
//
//
    }

}