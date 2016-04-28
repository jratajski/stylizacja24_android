
package pl.govirtual.stylizacja24.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageContent {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_visage")
    @Expose
    private Integer isVisage;
    @SerializedName("is_face")
    @Expose
    private Integer isFace;
    @SerializedName("default_image")
    @Expose
    private Integer defaultImage;

    /**
     *
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The path
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param path
     * The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     *
     * @param caption
     * The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The isVisage
     */
    public Integer getIsVisage() {
        return isVisage;
    }

    /**
     *
     * @param isVisage
     * The is_visage
     */
    public void setIsVisage(Integer isVisage) {
        this.isVisage = isVisage;
    }

    /**
     *
     * @return
     * The isFace
     */
    public Integer getIsFace() {
        return isFace;
    }

    /**
     *
     * @param isFace
     * The is_face
     */
    public void setIsFace(Integer isFace) {
        this.isFace = isFace;
    }

    /**
     *
     * @return
     * The defaultImage
     */
    public Integer getDefaultImage() {
        return defaultImage;
    }

    /**
     *
     * @param defaultImage
     * The default_image
     */
    public void setDefaultImage(Integer defaultImage) {
        this.defaultImage = defaultImage;
    }

}
