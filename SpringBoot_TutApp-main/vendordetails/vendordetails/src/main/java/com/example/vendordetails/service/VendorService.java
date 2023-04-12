package com.example.vendordetails.service;

import com.example.vendordetails.entities.Vendor;
import org.springframework.stereotype.Service;

public interface VendorService {
    Vendor findById(Integer vendorId);

    Vendor createVendor(Vendor vendor);

    Vendor updateVendor(Vendor vendor);

    void deleteById(Integer vendorId);
}
