package com.turkcell.pair6.customerservice.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name="createdDate")
    private LocalDateTime createdDate;
    @Column(name="updatedDate")
    private LocalDateTime updatedDate;
    @Column(name="deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist
    public void onCreate()
    {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate()
    {
        updatedDate = LocalDateTime.now();
    }

    @PreRemove
    public void onDelete()
    {
        deletedDate = LocalDateTime.now();
    }
}