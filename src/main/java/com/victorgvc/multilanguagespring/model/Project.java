package com.victorgvc.multilanguagespring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "project", schema = "public")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Integer id;

    @Column(name = "pro_name")
    private String name;

    @Column(name = "pro_description")
    private String description;

    @Column(name = "pro_readme")
    private String readme;

    @Column(name = "pro_link")
    private String link;

    @JsonBackReference
    @JoinColumn(name = "pro_user")
    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "projects")
    private List<Item> items;
}
