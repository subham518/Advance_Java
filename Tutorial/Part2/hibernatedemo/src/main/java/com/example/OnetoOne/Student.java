package com.example.OnetoOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name= "id_card_id")
    private ID_Card idCard;

    public Student() {}

    public int getID() {return id;}
    public void setId(int id) {this.id=id;}

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}
    public ID_Card getIDCard() {return idCard;}
    public void setIDCard(ID_Card idCard) {
        this.idCard = idCard;
    }

}