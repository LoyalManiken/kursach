package dev.application.paymentInfo.Controller;

import dev.application.paymentInfo.Entity.Check;
import dev.application.paymentInfo.Service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paymentinfo/checks")
public class CheckController {
    @Autowired
    private CheckService checkService;
    @GetMapping("/allchecks")
    public ResponseEntity<List<Check>> getAllChecks(){
        List<Check> allChecks = checkService.getAllChecks();
        if(allChecks==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(allChecks,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Check> getCheck(@PathVariable Long id){
       Check check = checkService.getCheckById(id);
        if(check==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(check,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/allchecks")
    public ResponseEntity<String> createNewCheck(@RequestBody Check check){
        check.setCheckSumWithNds(check.getPaymentType().getNds()*check.getCheckSum());
        checkService.saveCheck(check);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/allchecks")
    public ResponseEntity<String> updateCheck(@RequestBody Check check){
        checkService.saveCheck(check);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheck(@PathVariable Long id){
        checkService.deleteCheck(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
