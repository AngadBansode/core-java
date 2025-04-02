package mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    private String [] skills;
}
