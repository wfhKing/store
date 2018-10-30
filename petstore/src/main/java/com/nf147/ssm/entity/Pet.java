package com.nf147.ssm.entity;

public class Pet {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.pet_id
     *
     * @mbg.generated
     */
    private Integer petId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.category_id
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.pet_name
     *
     * @mbg.generated
     */
    private String petName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.pet_photo
     *
     * @mbg.generated
     */
    private String petPhoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.tag_id
     *
     * @mbg.generated
     */
    private Integer tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.pet_status
     *
     * @mbg.generated
     */
    private String petStatus;

    private Category category;

    private Tag tag;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.pet_id
     *
     * @return the value of pet.pet_id
     *
     * @mbg.generated
     */
    public Integer getPetId() {
        return petId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.pet_id
     *
     * @param petId the value for pet.pet_id
     *
     * @mbg.generated
     */
    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.category_id
     *
     * @return the value of pet.category_id
     *
     * @mbg.generated
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.category_id
     *
     * @param categoryId the value for pet.category_id
     *
     * @mbg.generated
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.pet_name
     *
     * @return the value of pet.pet_name
     *
     * @mbg.generated
     */
    public String getPetName() {
        return petName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.pet_name
     *
     * @param petName the value for pet.pet_name
     *
     * @mbg.generated
     */
    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.pet_photo
     *
     * @return the value of pet.pet_photo
     *
     * @mbg.generated
     */
    public String getPetPhoto() {
        return petPhoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.pet_photo
     *
     * @param petPhoto the value for pet.pet_photo
     *
     * @mbg.generated
     */
    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto == null ? null : petPhoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.tag_id
     *
     * @return the value of pet.tag_id
     *
     * @mbg.generated
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.tag_id
     *
     * @param tagId the value for pet.tag_id
     *
     * @mbg.generated
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.pet_status
     *
     * @return the value of pet.pet_status
     *
     * @mbg.generated
     */
    public String getPetStatus() {
        return petStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.pet_status
     *
     * @param petStatus the value for pet.pet_status
     *
     * @mbg.generated
     */
    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus == null ? null : petStatus.trim();
    }
}