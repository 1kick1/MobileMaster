package com.example.mobilemaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tb_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;

    private String password;
}
