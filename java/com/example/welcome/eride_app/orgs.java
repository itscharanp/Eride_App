package com.example.welcome.eride_app;

public class orgs{
    String id;
    String organization;
    String topictaught;
    String student_name;
    String no_of_students;
    String feedback;
    String othervols;
    public orgs()
    {
    }

    public orgs(String id, String organization, String topictaught ,String student_name, String no_of_students,String feedback,String othervols) {
        this.id = id;
        this.organization = organization;
        this.topictaught = topictaught;
        this.student_name = student_name;
        this.no_of_students = no_of_students;
        this.feedback = feedback;
        this.othervols = othervols;
    }

    public String getId() {
        return id;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTopictaught() {
        return topictaught;
    }
}


