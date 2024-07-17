package com.lambdacode.spring.boot.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private byte status;
    private String description;
    @PrePersist
    public void prePersist() {
        this.status = 0;
        this.description="";
    }
}
