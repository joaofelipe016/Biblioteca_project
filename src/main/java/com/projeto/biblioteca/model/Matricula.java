package com.projeto.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long idMatricula;

    @Column(nullable = false, name = "nr_matricula")
    private String nrMatricula;

    @Column(nullable = false, name = "st_matricula")
    private Long stMatricula;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Column(nullable = false, name = "dt_matricula")
    private GregorianCalendar dtMatricula;
}
