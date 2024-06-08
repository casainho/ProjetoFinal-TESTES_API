package api.mappings.garage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("client")
    private Integer clientId;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("plateYear")
    private Integer plateYear;
    @JsonProperty("type")
    private String type;
    @JsonProperty("plate")
    private String plate;
    @JsonProperty("active")
    private boolean isActive;
}


