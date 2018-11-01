package com.nf147.ssm.dao;

import com.nf147.ssm.entity.Pet;
import java.util.List;

public interface PetMapper {

    int deleteByPrimaryKey(Integer petId);

    int insert(Pet record);

    Pet selectByPrimaryKey(Integer petId);

    List<Pet> selectAll();

    Pet findByStatus(String petStatus);

    int updateByPrimaryKey(Pet record);

    int updatePetStatus(Pet pet);
}