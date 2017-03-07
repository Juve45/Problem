/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probl1;

/**
 *
 * @author alexandru
 */



public class Probl1 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Problem problem = new Problem(4, 3); //4 students, 3 projects
        
        Student s1 = problem.createStudent("1# Stud", "s1@info.uaic.ro");        
        Student s2 = problem.createStudent("Nume Prenume", "email@info.uaic.ro");
        Student s3 = problem.createStudent("Alex Prenume", "eghmail@info.ro");
        Student s4 = problem.createStudent("Lala Bum", "gsssil@info.ro");
        Student Borcan = new Student("Andreea Borcan", "andreea@yahoo.com");
        
        Project ip1 = new Project("Proiect 1 IP", 4);
        Project ip2 = new Project("Proiect 2 IP", 3);
        Project pa = new Project("Proiect 1 PA", 4);
        Project p1 = problem.createProject("P1", 2); //capacity is 2
        Project p2 = problem.createProject("P2", 1); //capacity is 2
        Project p3 = problem.createProject("P3", 1); //capacity is 2
        
        /*
        boolean ok = problem.addStudent(Borcan);
        System.out.println(ok);
        */
        Borcan.setPreferences(ip1, ip2);
        System.out.println(Borcan.toString());
        
        p1.setPreferences(s3, s1, s2, s4);
        p2.setPreferences(s1, s2, s3, s4);
        p3.setPreferences(s1, s3, s4, s2);
        
        s1.setPreferences(p1, p2, p3);
        s2.setPreferences(p1, p3, p2);
        s3.setPreferences(p1);
        s4.setPreferences(p3, p2, p1);
        
        
        problem.match();
        
    }
        
        
        //p1.setPreferences(s3, s1, s2, s4);                
        //        System.out.println(problem);
    
   
}
