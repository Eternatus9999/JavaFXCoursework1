package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String title;
    private String name;
    private String address;
    private String phone;
    private LocalDate bday;
}
