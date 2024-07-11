package co.com.automation.screenplay.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataRegister {
    private String email;
    private String password;
}
