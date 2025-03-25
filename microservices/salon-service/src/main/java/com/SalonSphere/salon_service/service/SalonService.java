package com.SalonSphere.salon_service.service;

import com.SalonSphere.salon_service.model.Salon;
import com.SalonSphere.salon_service.payload.dto.SalonDTO;
import com.SalonSphere.salon_service.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDTO salon, UserDTO user);

    Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception;

    List<Salon> getAllSalons();

    Salon getSalonById(Long salonId) throws Exception;

    Salon getSalonByOwnerId(Long ownerId);

    List<Salon> searchSearchByCity(String city);
}
