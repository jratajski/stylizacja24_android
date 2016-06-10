package pl.govirtual.stylizacja24.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 09.06.16.
 */
public class UserInfo {
    @SerializedName("premiumExpiration")
    @Expose
    private Integer premiumExpiration;

    @SerializedName("errorCode")
    @Expose
    private String errorCode;

    /**
     *
     * @return
     * The userId
     */
    public Integer getPremiumExpiration() {
        return premiumExpiration;
    }

    /**
     *
     * @param premiumExpiration
     * The user_id
     */
    public void setPremiumExpiration(Integer premiumExpiration) {
        this.premiumExpiration = premiumExpiration;
    }

    /**
     *
     * @return
     *     The errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @param errorCode
     *     The errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
