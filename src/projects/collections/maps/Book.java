package projects.collections.maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record Book(String title, List<String> genres, BigDecimal cost) implements Comparable<Book> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(genres, book.genres) && Objects.equals(cost, book.cost);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", cost=" + (cost == null ? "unavailable" : cost) +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if (o == null) throw new NullPointerException();
        if (o.getClass() != this.getClass()) {
            throw new ClassCastException();
        }

        int titleComparison = this.title.compareTo(o.title());
        if (titleComparison == 0) {
            if (this.cost == null && o.cost() == null) {
                return 0; // Both costs are null and considered equal
            } else if (this.cost == null) {
                return 1; // Null is considered greater than non-null
            } else if (o.cost() == null) {
                return -1; // Non-null is considered less than null
            } else {
                return this.cost.compareTo(o.cost());
            }
        }
        return titleComparison;
    }
}

