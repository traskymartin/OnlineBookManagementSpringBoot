package com.trasky.onlineBookmanagementSystem.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "book")  // Explicit table name specification
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotBlank(message = "Genre cannot be empty")
    private String genre;

    @NotNull(message = "Availability status is required")
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    public enum AvailabilityStatus {
        AVAILABLE,
        CHECKED_OUT
    }
}