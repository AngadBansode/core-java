import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties
@Builder
public class ProfileGicsIndustryFocus {


    private String profile;


    private Integer industryId;


    private String industryName;
}