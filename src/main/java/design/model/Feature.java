package design.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    String variant;

    Integer noOfAirBags;

    Integer noOfSpeakers;

    List<EngineDetail> engineDetails;
}
