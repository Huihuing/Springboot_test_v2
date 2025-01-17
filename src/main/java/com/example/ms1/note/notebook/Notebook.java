package com.example.ms1.note.notebook;

import com.example.ms1.note.note.Note;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Notebook parent;

    @OneToMany(mappedBy = "notebook")
    List<Note> noteList = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    List<Notebook> children = new ArrayList<>();

    public void addChild(Notebook child) {
        child.setParent(this);
        children.add(child);
    }
}
