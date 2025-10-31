package autotests.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode

public class DuckProperties {
    @JsonProperty("material")
    private String material;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metersHeight")
    private Double metersHeight;
}
