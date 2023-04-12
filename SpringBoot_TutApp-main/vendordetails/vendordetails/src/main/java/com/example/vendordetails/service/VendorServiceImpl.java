package com.example.vendordetails.service;

import com.example.vendordetails.dao.VendorDao;
import com.example.vendordetails.entities.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendorServiceImpl implements VendorService{
    @Autowired
    private VendorDao vendorDao;

    @Override
    public Vendor findById(Integer vendorId) {
        return vendorDao.findVend(vendorId);
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        return vendorDao.createVend(vendor);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        return vendorDao.updateVend(vendor);
    }

    @Override
    public void deleteById(Integer vendorId) {
         vendorDao.deleteVend(vendorId);
    }
}
