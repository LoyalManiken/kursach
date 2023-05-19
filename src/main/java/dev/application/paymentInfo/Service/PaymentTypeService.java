package dev.application.paymentInfo.Service;

import dev.application.paymentInfo.Entity.PaymentType;
import dev.application.paymentInfo.Repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    public List<PaymentType> getAllPaymentTypes(){
        return paymentTypeRepository.findAll();
    }
    public PaymentType getPaymentTypeById(Long id){
        return paymentTypeRepository.getPaymentTypeById(id);
    }
    public PaymentType savePaymentType(PaymentType paymentType){
        return paymentTypeRepository.save(paymentType);
    }
    public void deletePaymentType(Long id){
        paymentTypeRepository.delete(paymentTypeRepository.getPaymentTypeById(id));
    }
}
