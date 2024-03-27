package com.app.demospringbootregistrationform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //it create getter setter automatically
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="userregister")
public class User {
    private String name;
    @Id
    private String username;
    private String email;
    private String phone;
    private String password;
    private String cpassword;
    private String gender;

}
