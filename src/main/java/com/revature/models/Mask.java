package com.revature.models;

import java.util.Objects;

public class Mask {
    private Long id;
    private String maskName;
    private String gender;
    private StatBlock statBlock;

    private String imageLink;

    public Mask() {
    }

    public Mask(String maskName, String gender, StatBlock statBlock, String imageLink) {
        this.maskName = maskName;
        this.gender = gender;
        this.statBlock = statBlock;
        this.setImageLink(imageLink);
    }

    public Mask(Long id, String maskName, String gender, StatBlock statBlock, String imageLink) {
        this.id = id;
        this.maskName = maskName;
        this.gender = gender;
        this.statBlock = statBlock;
        this.setImageLink(imageLink);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaskName() {
        return maskName;
    }

    public void setMaskName(String maskName) {
        this.maskName = maskName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StatBlock getStatBlock() {
        return statBlock;
    }

    public void setStatBlock(StatBlock statBlock) {
        this.statBlock = statBlock;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mask mask)) return false;
        return Objects.equals(id, mask.id) && Objects.equals(maskName, mask.maskName)
                && Objects.equals(gender, mask.gender) && statBlock.equals(mask.statBlock)
                && Objects.equals(imageLink, mask.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maskName, gender, statBlock, imageLink);
    }
}
