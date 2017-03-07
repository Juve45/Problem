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
public class Project
{
    /**
     * numele proiectului
     */
    private String nume;
    
    /**
     * numarul maxim de studenti asignati proiectului
     */
    private int capacitate;
    
    /**
     * lista de preferinte a proiectului
     */
    private ArrayList<Student> myStudentPreferences;
    
    /**
     *
     * @author alexandru
     * Default constructor
     */
    Project (){}
    
    /**
     * Constructor
     * @author alexandru
     * @param id_nume numele proiectului
     * @param  id_capacitate numarul maxim de studenti asignati proiectului
     */
    Project (String id_nume,int id_capacitate)
    {
        this.capacitate=id_capacitate;
        this.nume=id_nume;
        myStudentPreferences = new ArrayList<>();
    }
    
    /**
     *
     * @author alexandru
     * @param id_nume 
     */
    public void createProject(String id_nume,int id_capacitate)
    {
        this.capacitate=id_capacitate;
        this.nume=id_nume;
    }
    
    /**
     * 
     * @author alexandru
     * @param  id_capacitate modific numarul maxim de studenti asignati proiectului
     */
    public void setCapcacitate (int id_capacitate)
    {
        this.capacitate=id_capacitate;
    }
    
    /**
     * 
     * @author alexandru
     * @param  id_nume modific numele proiectului
     */
    public void setNume (String id_nume)
    {
        this.nume=id_nume;
    }
    
    
    /**
     * 
     * @author alexandru
     * @return capacitatea proiectului respectiv
     */
    public int getCapacitate ()
    {
        return this.capacitate;
    }

    
    /**
     * 
     * @author alexandru
     * @return numele proiectului respectiv
     */
    public String getNume ()
    {
       return this.nume;
    }
    
    /**
     * Adaug la lista de preferinte mai multi studenti
     * @param prefList adaug la lista de preferinte studentii dati ca parametru aici
     */
    public void setPreferences(Student ... prefList)
    {
        for(Student student: prefList)
        {
            myStudentPreferences.add(student);
        }

    }
    
    /**
     * 
     * @return lista de preferinte
     */
    public ArrayList<Student> getPreferences()
    {

            return myStudentPreferences;

    }

    @Override
    public String toString()
    {
        int i;
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(new StringBuilder ("Nume proiect: "));
        stringBuilder.append(new StringBuilder (this.nume));
        stringBuilder.append(new StringBuilder ("; "));
        stringBuilder.append(new StringBuilder ("Capacitate proiect: "));
        stringBuilder.append(new StringBuilder (this.capacitate));
        stringBuilder.append(new StringBuilder ("\n"));
         stringBuilder.append(new StringBuilder ("Preferintele proiectului: "));
        for(i=0;i<=myStudentPreferences.size();i++)
        {
            stringBuilder.append(new StringBuilder (myStudentPreferences.get(i).getNume()));
             stringBuilder.append(new StringBuilder ("; "));
        }


    return stringBuilder.toString();

    }


    public boolean equals(Project proiect1,Project proiect2)
    {
        if(proiect1.capacitate==proiect2.capacitate && proiect1.nume.equals(proiect2.nume) )
        {
            return true;
        }
        return false;
    }


}