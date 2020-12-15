/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Juri
 */
@Entity
public class Furniture implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    private Integer publishedYear;
    
    

    public Furniture() {
    }

    public Furniture(String name, String color, String size, Integer publishedYear) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.publishedYear = publishedYear;
    }
    public Furniture(String name, String color, String size, String publishedYear) {
        this.name = name;
        this.color = color;
        this.size = size;
        setPublishedYear(publishedYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }    
    

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
    public void setPublishedYear(String publishedYear) {
        try {
            int publishedYearInt = Integer.parseInt(publishedYear);
            this.publishedYear = publishedYearInt;
            System.out.println("Строка "+publishedYear+" успешно преобразована в число.");
        } catch (Exception e) {
            System.out.println("Введены не цифры. Поле не изменено");
        }
        
    }

    @Override
    public String toString() {
        return "Furniture{" 
                + "name=" + name 
                + ",color=" +color
                + ",size=" +size
                + ", publishedYear=" + publishedYear 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + Objects.hashCode(this.size);
        hash = 97 * hash + Objects.hashCode(this.publishedYear);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Furniture other = (Furniture) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }        
        if (!Objects.equals(this.publishedYear, other.publishedYear)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    
    
}
