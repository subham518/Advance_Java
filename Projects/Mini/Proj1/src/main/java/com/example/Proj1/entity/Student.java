package com.example.Proj1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stud")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuid;

    @Column(name = "stuname")
    private String stuname;

    @Column(name = "sturoll")
    private String sturoll;

    @Column(name = "stuadd")
    private String stuadd;

    @Column(name = "stuemail")
    private String stuemail;

    public Student() {}

    public Student(int stuid, String stuname, String sturoll, String stuadd, String stuemail) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.sturoll = sturoll;
        this.stuadd = stuadd;
        this.stuemail = stuemail;
    }

    // Getters & Setters
    public int getStuid() { return stuid; }
    public void setStuid(int stuid) { this.stuid = stuid; }

    public String getStuname() { return stuname; }
    public void setStuname(String stuname) { this.stuname = stuname; }

    public String getSturoll() { return sturoll; }
    public void setSturoll(String sturoll) { this.sturoll = sturoll; }

    public String getStuadd() { return stuadd; }
    public void setStuadd(String stuadd) { this.stuadd = stuadd; }

    public String getStuemail() { return stuemail; }
    public void setStuemail(String stuemail) { this.stuemail = stuemail; }
}