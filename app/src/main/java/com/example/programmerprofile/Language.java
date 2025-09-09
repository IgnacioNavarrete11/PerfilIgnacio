package com.example.programmerprofile;

public class Language {
    private String name;
    private int imageId;
    private String knowledgeLevel;
    private String knowledgeDescription;

    public Language(String name, int imageId, String knowledgeLevel, String knowledgeDescription) {
        this.name = name;
        this.imageId = imageId;
        this.knowledgeLevel = knowledgeLevel;
        this.knowledgeDescription = knowledgeDescription;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public String getKnowledgeDescription() {
        return knowledgeDescription;
    }
}