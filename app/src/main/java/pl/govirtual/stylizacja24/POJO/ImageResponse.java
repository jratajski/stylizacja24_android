
package pl.govirtual.stylizacja24.POJO;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageResponse {

    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("content")
    @Expose
    private List<ImageContent> content = new ArrayList<ImageContent>();

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

    /**
     * 
     * @return
     *     The content
     */
    public List<ImageContent> getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(List<ImageContent> content) {
        this.content = content;
    }

}
