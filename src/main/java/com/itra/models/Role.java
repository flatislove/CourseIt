package com.itra.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // The user's name
    @NotNull
    private String name;



    public Role(){};
    public Role(long id,String name){
        this.id=id;
        this.name=name;
    }

//    @OneToMany(mappedBy="order")
//    private List<Item> items;
//
//    public Order() {
//        items = new ArrayList<Item>();
//    }
//
//    public void addItem(Item item) {
//        if (item != null)
//            items.add(item);
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
