package com.example.pictureofday.Repository;

import com.example.pictureofday.Model.Picture;

public interface IPictureRepository {
    Picture findById(int id);

    void save(Picture picture);
}
