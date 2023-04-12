package com.example.vendordetails.dao;

import com.example.vendordetails.entities.Vendor;
import org.springframework.stereotype.Repository;

public interface VendorDao {

    Vendor findVend(Integer vendorId);

    Vendor createVend(Vendor vendor);

    Vendor updateVend(Vendor vendor);

    void deleteVend(Integer vendorId);
}
