package app.todo.todo.model;

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
    private String rank;
    private Category category;
    private int idUser;

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

    public Item(int id, String description, Timestamp created, boolean done, String rank) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
        this.rank = rank;
    }

    public Item(int id, String description, Timestamp created, boolean done, String rank, Category category) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
        this.rank = rank;
        this.category = category;
    }

    public Item(int id, String description, Timestamp created, boolean done, String rank, int idUser) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
        this.rank = rank;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
                + ", rank=" + rank
                + ", category=" + category
                + ", idUser" + idUser
                + '}';
    }
}
