/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probl1;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author alexandru
 */
 public class Problem
    {
        private int nrStudenti;
        private int nrProiecte;
        ArrayList<Student> studentList;
        ArrayList<Project> projectList;
        
        public Problem() {
        }
        public Problem(int studenti,int proiecte)
        {
            this.nrStudenti=studenti;
            this.nrProiecte=proiecte;
            studentList = new ArrayList<>();
            projectList = new ArrayList<>();
        }
        public void setNrStudenti( int studenti)
        {
            this.nrStudenti= studenti;
        }
         public void setNrProiecte(int proiecte)
        {
            this.nrStudenti= proiecte;
        }
         public int getNrStudenti( )
        {
            return this.nrStudenti;
        }
         public int getNrProiecte( )
        {
            return this.nrProiecte;
        }
         
        public Student createStudent(String numeStud, String emailStud)
        {
            Student student = new Student(numeStud, emailStud);
            if(studentList.size() == nrStudenti)
            {
                System.err.println("Nu se mai pot adauga studenti");
                return null;
            }
            studentList.add(student);
            return student;
        }
        public Project createProject(String numeProj, int capacity)
        {
            Project project = new Project(numeProj, capacity);
            if(projectList.size() == nrProiecte)
            {
                System.err.println("Nu se mai pot adauga proiecte");
                return null;
            }
            projectList.add(project);
            return project;
        }
        public boolean addStudent(Student student)
        {
            if(studentList.size() == nrStudenti)
            {
                System.err.println("Nu se mai pot adauga studenti");
                return false;
            }
            studentList.add(student);
            return true;
        }
        
        public boolean match()
        {
            LinkedList <Project> pendingProjects;
            pendingProjects = new LinkedList<Project>(projectList);
            
            System.out.println(pendingProjects.size());
            
            while(!pendingProjects.isEmpty())
            {
                Project curentProject = pendingProjects.poll();
                //System.out.println(curentProject.toString());
                
                ArrayList<Student> pref = curentProject.getPreferences();
                System.out.println(pref.size());
                
                for(int i=0;i<pref.size();i++)
                {
                    Student proposeTo = pref.get(i);
                    if(!proposeTo.isMatched())
                    {
                        proposeTo.assignProject(curentProject);
                        curentProject.addStudent(proposeTo);
                    }
                    else{
                        if(proposeTo.projectScore(curentProject) > proposeTo.projectScore(proposeTo.getProject()))
                        {
                            proposeTo.getProject().removeStudent(proposeTo);
                            pendingProjects.add(proposeTo.getProject());
                            proposeTo.deassignProject();
                            proposeTo.assignProject(curentProject);
                        }
                    }
                    
                    if(curentProject.isFullyMatched())
                        break;
                }
                if(!curentProject.isFullyMatched())
                {
                    System.err.println("Nu se poate gasi un Stable Matching");
                    return false;
                }
            }
            return true;
                
        }
            
    }