package pl.govirtual.stylizacja24.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 09.06.16.
 */
public class UserInfoResponse {
    @SerializedName("content")
    @Expose
    private UserInfo content = new UserInfo();
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;

    /**
     *
     * @return
     * The content
     */
    public UserInfo getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(UserInfo content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @param errorCode
     * The errorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
