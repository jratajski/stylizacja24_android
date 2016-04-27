
package pl.govirtual.stylizacja24.POJO;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Content {

    @SerializedName("api_token")
    @Expose
    private String apiToken;

    /**
     * 
     * @return
     *     The apiToken
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * 
     * @param apiToken
     *     The api_token
     */
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

}
