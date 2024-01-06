package com.example.vietqr_api.controller;

import com.example.vietqr_api.dto.AccountRequest;
import com.example.vietqr_api.dto.TranssactionInfoRequest;
import com.example.vietqr_api.service.VietQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/viet-qr")
public class VietQRController {


    @Autowired
    private VietQrService service;


    // api tạo qr

    /**
     * {
     * "accountNo": số tài khoản,
     * "accountName": tên tài khoản,
     * "acqId": id ngân hàng,
     * "amount": số tiền,
     * "addInfo": nội dung,
     * "format": "text",
     * "template": "compact2"
     * }
     */
    @PostMapping("/create")
    public ResponseEntity createQr(@RequestBody TranssactionInfoRequest request) throws URISyntaxException {
        return ResponseEntity.ok(service.createVietQr(request));
    }

    // api lấy danh sách ngân hàng
    @GetMapping("/get-list-bank")
    public ResponseEntity getListBank() {
        return ResponseEntity.ok(service.getListBank());
    }

    // api tra cứu số tài khoản ngân hàng
    @PostMapping("/get-bank-account")
    public ResponseEntity getBankAccount(@RequestBody AccountRequest request) {
        return ResponseEntity.ok(service.getBankAccount(request));
    }


}
