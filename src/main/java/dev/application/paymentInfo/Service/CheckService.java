package dev.application.paymentInfo.Service;

import dev.application.paymentInfo.Entity.Check;
import dev.application.paymentInfo.Entity.PaymentType;
import dev.application.paymentInfo.Repository.CheckRepository;
import dev.application.paymentInfo.Repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckService {
    @Autowired
    private CheckRepository checkRepository;
    public List<Check> getAllChecks(){
        return checkRepository.findAll();
    }
    public Check getCheckById(Long id){
        return checkRepository.findCheckById(id);
    }
    public Check saveCheck(Check check){
        return checkRepository.save(check);
    }
    public void deleteCheck(Long id){
        checkRepository.delete(checkRepository.findCheckById(id));
    }
}
