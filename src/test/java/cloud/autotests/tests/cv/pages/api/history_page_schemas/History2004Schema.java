package cloud.autotests.tests.cv.pages.api.history_page_schemas;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.tools.javac.jvm.Items;
import sun.security.util.Debug;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "action",
        "success",
        "items",
        "debug"
})
public class History2004Schema {

    @JsonProperty("action")
    private String action;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("items")
    private Items items;
    @JsonProperty("debug")
    private Debug debug;

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("items")
    public Items getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items items) {
        this.items = items;
    }

    @JsonProperty("debug")
    public Debug getDebug() {
        return debug;
    }

    @JsonProperty("debug")
    public void setDebug(Debug debug) {
        this.debug = debug;
    }

}