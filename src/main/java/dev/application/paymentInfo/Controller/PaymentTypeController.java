package dev.application.paymentInfo.Controller;

import dev.application.paymentInfo.Entity.PaymentType;
import dev.application.paymentInfo.Repository.PaymentTypeRepository;
import dev.application.paymentInfo.Service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paymentinfo/paymenttype")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;
    @GetMapping("/allpaymenttypes")
    public ResponseEntity<List<PaymentType>> getAllTypes(){
        List<PaymentType> paymentTypes = paymentTypeService.getAllPaymentTypes();
        if(paymentTypes==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(paymentTypes,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentType> getPaymentType(@PathVariable Long id){
        PaymentType paymentType = paymentTypeService.getPaymentTypeById(id);
        if(paymentType==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(paymentType,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/allpaymenttypes")
    public ResponseEntity<String> createNewPaymentType(@RequestBody PaymentType paymentType){
        paymentTypeService.savePaymentType(paymentType);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/allpaymenttypes")
    public ResponseEntity<String> updatePaymentType(@RequestBody PaymentType paymentType){
        paymentTypeService.savePaymentType(paymentType);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaymentType(@PathVariable Long id){
        paymentTypeService.deletePaymentType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
