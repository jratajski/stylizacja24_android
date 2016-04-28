
package pl.govirtual.stylizacja24.POJO;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageResponse {

    @SerializedName("content")
    @Expose
    private List<ImageContent> content = new ArrayList<ImageContent>();
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;

    /**
     *
     * @return
     * The content
     */
    public List<ImageContent> getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(List<ImageContent> content) {
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