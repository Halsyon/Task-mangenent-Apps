package ru.job4j.todo.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Модель, описывающая событие в ежедневнике
 */
public class Item {
    private int id;
    private String description;
    private Timestamp created;
    private boolean done;


    private Category category;

    public Item() {
    }

    public Item(int id, String description, Timestamp created, boolean done) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
    }

    public Item(int id, String description, Timestamp created, boolean done, Category category) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id
                && done == item.done
                && description.equals(item.description)
                && created.equals(item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, created, done);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", description='" + description + '\''
                + ", created=" + created
                + ", done=" + done
                + ", category=" + category
                + '}';
    }
}
