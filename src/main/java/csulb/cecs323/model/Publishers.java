package csulb.cecs323.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Publishers {
    @Id
    @Column(length = 80, nullable = false)
    private String name;

    @Column(unique = true, length = 80, nullable = false)
    private String email;

    @Column(unique = true, length = 24, nullable = false)
    private String phone;

    @OneToMany (mappedBy = "publishers",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private ArrayList<Books> books = new ArrayList<>();

    public Publishers() { }

    public Publishers(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void addBooks(Books book) {
        books.add(book);
        book.setPublishers(this);
    }

    public void removeBooks(Books book) {
        if (this.books != null) {
            books.remove(book);
            book.setPublishers(null);
        }
    }

    public ArrayList<Books> getBooks() { return books; }

    public void setBooks(ArrayList<Books> books) { this.books = books; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}