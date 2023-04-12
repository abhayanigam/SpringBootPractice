package com.example.vendordetails.controller;

import com.example.vendordetails.entities.Vendor;
import com.example.vendordetails.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/vendorservices/v1/vendors",
        produces = "application/json",
        consumes = "application/json"
)
public class VendorResource {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/{vendorId}")
    public Vendor getVendor(@PathVariable("vendorId") Integer vendorId){
        return vendorService.findById(vendorId);
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor){
        return vendorService.createVendor(vendor);
    }


    @PutMapping("/{vendorId}")
    public Vendor updateVendor(@PathVariable("vendorId") Integer vendorId, @RequestBody Vendor vendor){
        return vendorService.updateVendor(vendor);
    }

    @DeleteMapping("/{vendorId}")
    public void deleteVendor(@PathVariable("vendorId") Integer vendorId){
         vendorService.deleteById(vendorId);
    }

}
