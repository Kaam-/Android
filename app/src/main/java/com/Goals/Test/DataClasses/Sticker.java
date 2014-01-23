package com.Goals.Test.DataClasses;

/**
 * Created by Drew on 1/14/14.
 */
public class Sticker {

    private int pkSticker;
    private String name;
    private String stickerUrl;
    private String dateReceived;

    public Sticker(int pkSticker, String name, String stickerUrl, String dateReceived)
    {
        this.pkSticker = pkSticker;
        this.name = name;
        this.stickerUrl = stickerUrl;
        this.dateReceived = dateReceived;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPkSticker(int pkSticker) {
        this.pkSticker = pkSticker;
    }

    public void setStickerUrl(String stickerUrl) {
        this.stickerUrl = stickerUrl;
    }

    public int getPkSticker() {
        return pkSticker;
    }

    public String getName() {
        return name;
    }

    public String getStickerUrl() {
        return stickerUrl;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDateReceived() {
        return dateReceived;
    }
}
