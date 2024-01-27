package projects.collections.maps;

import java.util.Objects;

public record Author(String firstName, String lastName) implements Comparable<Author> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }

    @Override
    public int compareTo(Author o) {
        if (o == null) throw new NullPointerException();
        if (o.getClass() != this.getClass()) throw new ClassCastException();

        if (this.firstName.equals(o.firstName()) && this.lastName.equals(o.lastName())) {
            return 0;
        } else if (this.firstName.equals(o.firstName())) {
            return this.lastName.compareTo(o.lastName());
        } else {
            return this.firstName.compareTo(o.firstName());
        }
    }
}
