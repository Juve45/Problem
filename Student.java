/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probl1;

import java.util.ArrayList;

/**
 *
 * @author alexandru
 */
public class Student {

    /**
     *
     * numele studnetului
     */
    private String nume;
    
    /**
    *email-ul studentului
     */
    private String email;
    /**
    *
    declaram obiectul Project pentru ca avem nevoie la lista de preferinte
    */
    private Project myProject;
    /**
    *lista de preferinte
    */
    private ArrayList<Project> myPreferences;

    /**
    * pentru fiecare studnet avem setat 1 sau 0 daca studnetul respectiv are sau nu asignat un proiect
    */
    private boolean isAssignedProject;
    //Student (){}
    /**
    *constructorul nu l-am lasat implicit pentru a nu lucra cu obiecte neasignate   
    */
    Student(String id_nume, String id_email) {
        this.email = id_email;
        this.nume = id_nume;
        myPreferences = new ArrayList<>();
        isAssignedProject = false;
    }

    /**
    *
    *setam emailul (nu il putem accesa direct fiind privat)
    */
    public void setEmail(String id_email) {
        this.email = id_email;
    }

    /**
    *setam numele (nu il putem accesa direct fiind privat)
    */
    public void setNume(String id_nume) {
        this.nume = id_nume;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNume() {
        return this.nume;
    }
    
    public boolean equals(Student student)
    {
        return email.equals(student.email);
    }
    
    

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new StringBuilder("Nume student: "));
        stringBuilder.append(new StringBuilder(nume + "\n"));
        stringBuilder.append(new StringBuilder("Nume e-mail: "));
        stringBuilder.append(new StringBuilder(email + "\n"));
        stringBuilder.append(new StringBuilder("Project preferences: \n"));
        for (int i = 0; i < myPreferences.size(); i++) {
            stringBuilder.append(new StringBuilder("#"));
            stringBuilder.append(new StringBuilder(Integer.toString(i + 1)));
            stringBuilder.append(new StringBuilder(": "));
            stringBuilder.append(new StringBuilder(myPreferences.get(i).getNume()));
            stringBuilder.append(new StringBuilder("\n"));
        }

        return stringBuilder.toString();
    }

    public boolean assignProject(Project p) {
        if (isAssignedProject == true) {
            return false;
        }
        myProject = p;
        isAssignedProject = true;
        return true;
    }

    public ArrayList<Project> getPreferences() {
        return myPreferences;
    }
    
    public Project getProject()
    {
        return myProject;
    }
    
    public boolean isMatched()
    {
        return isAssignedProject;
    }
    /*
    public void assignProject(Project p)
    {
        isAssignedProject = true;
        myProject = p;
    }*/
    
    public void deassignProject()
    {
        isAssignedProject = false;
        myProject = null;
    }
    
    public int projectScore(Project project)
    {
        return myPreferences.size() - myPreferences.indexOf(project);
    }

    public void setPreferences(Project... prefList) {
        for (Project project : prefList) {
            myPreferences.add(project);
        }
    }
}
