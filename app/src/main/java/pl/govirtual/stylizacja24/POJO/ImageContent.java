
package pl.govirtual.stylizacja24.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageContent {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("is_visage")
    @Expose
    private String isVisage;
    @SerializedName("is_face")
    @Expose
    private String isFace;
    @SerializedName("default_image")
    @Expose
    private String defaultImage;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The path
     */
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The isVisage
     */
    public String getIsVisage() {
        return isVisage;
    }

    /**
     * 
     * @param isVisage
     *     The is_visage
     */
    public void setIsVisage(String isVisage) {
        this.isVisage = isVisage;
    }

    /**
     * 
     * @return
     *     The isFace
     */
    public String getIsFace() {
        return isFace;
    }

    /**
     * 
     * @param isFace
     *     The is_face
     */
    public void setIsFace(String isFace) {
        this.isFace = isFace;
    }

    /**
     * 
     * @return
     *     The defaultImage
     */
    public String getDefaultImage() {
        return defaultImage;
    }

    /**
     * 
     * @param defaultImage
     *     The default_image
     */
    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

}
