package pl.govirtual.stylizacja24.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 02.06.16.
 */
public class UploadResponse {
    @SerializedName("errorCode")
    @Expose
    private String errorCode;

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
