package lk.codelabs.rentcloud.rentui.controller;

import com.ayesha.rentcloud.commons.model.Customer;
import lk.codelabs.rentcloud.rentui.config.AcessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableOAuth2Sso //Single sign on
public class UIController extends WebSecurityConfigurerAdapter {

    //from RestTemplate, you can invoke remote service
    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
        // When you find this "/" url, no need to authenticate, just permit all. But any other request must be authenticated.
    }

    @RequestMapping(value = "/")
    public String loadUI(){
        return "home";
    }

    @RequestMapping(value = "/secure")
    public String loadSecuredUI(){
        return "secure";
    }

    @RequestMapping(value = "/customers")
    //You call this url inside the secure.html page form tag.
    public String loadCustomers(Model model){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AcessToken.getAccessToken());
        HttpEntity<Customer>  customerHttpEntity = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://localhost:8181/services/customers", HttpMethod.GET, customerHttpEntity,Customer[].class);
            model.addAttribute("customers_list", responseEntity.getBody());
            // Above customer_list name is used in secure.html page for each list
//            System.out.println(responseEntity.getBody().length+">>>>>>>>>>>>>>>>");
        }catch (HttpStatusCodeException e){
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }


        return "secure";
    }

}
