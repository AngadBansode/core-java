package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// convert object to json and vice versa
public class ObjectMapperDemo {

     public static void main(String[] args) throws IOException {
          System.out.println("Hello, World!");
          ObjectMapper mapper = new ObjectMapper();
          //read json file from resource folder and convert to Industry class
          //  Industry industry = mapper.readValue(Industry.class.getResourceAsStream("/industry.json"), Industry.class);
         InputStream inJson = Industry.class.getResourceAsStream("/industry.json");
         Industry industry = mapper.readValue(new File("src/main/resources/industry.json"), Industry.class);
         System.out.println(industry.toString());

     }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
  class GicsIndustry{
    public int industryId;
    public String industryName;
    public String profile;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
  class MiIndustry{
    public int industryId;
    public String industryName;
    public String profile;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
  class Industry{
    public List<MiIndustry> mi_industries;
    public List<GicsIndustry> gics_industries;
}