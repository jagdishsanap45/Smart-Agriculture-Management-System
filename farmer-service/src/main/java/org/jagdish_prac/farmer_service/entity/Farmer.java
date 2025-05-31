package org.jagdish_prac.farmer_service.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Name Required")
    private String name;

    @NotBlank(message = "contact Required")
    @Pattern(regexp = "\\d{10}", message = "Contact must contain 10 number")
    private String contact;

    @NotBlank(message = "region Required")
    private String region;


}
