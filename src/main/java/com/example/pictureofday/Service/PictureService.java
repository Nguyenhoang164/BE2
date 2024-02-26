package com.example.pictureofday.Service;

import com.example.pictureofday.Model.Picture;
import com.example.pictureofday.Repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService implements IPictureService{
    @Autowired
    private IPictureRepository pictureRepository;
    @Override
    public Picture findById(int id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }
}
