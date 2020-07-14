package com.fusion.model;

public class ChatModel {
    private boolean sender;
    private String isVideo;

    public String isVideo() {
        return isVideo;
    }

    public void setVideo(String video) {
        isVideo = video;
    }

    public boolean isSender() {
        return sender;
    }

    public void setSender(boolean sender) {
        this.sender = sender;
    }
}
