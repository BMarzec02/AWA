java package kurier.managedbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.Flash;

import kurier.dao.UzytkownicyDAO;
import kurier.entities.Uzytkownicy;

@Named
@RequestScoped
public class UzytkownicyList {
    private static final String PAGE_UZYTKOWNIK_EDIT = "uzytkownikEdit?faces-redirect=true";
    private static final String PAGE_STAY_AT_THE_SAME = null;

    private String email;

    @Inject
    ExternalContext extcontext;

    @Inject
    Flash flash;

    @EJB
    UzytkownicyDAO uzytkownicyDAO;
    
    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Uzytkownicy> getFullList(){
        return uzytkownicyDAO.getFullList();
    }
    
    public List<Uzytkownicy> getList(){
        List<Uzytkownicy> list = null;
        
        // Prepare search params
        Map<String,Object> searchParams = new HashMap<>();
        
        if (email != null && !email.isEmpty()){
            searchParams.put("email", email);
        }
        
        // Get list
        list = uzytkownicyDAO.getList(searchParams);
        
        return list;
    }

    public String newUzytkownik() {
        Uzytkownicy uzytkownik = new Uzytkownicy();
        
        // Pass object through flash
        flash.put("uzytkownik", uzytkownik);
        
        return PAGE_UZYTKOWNIK_EDIT;
    }

    public String editUzytkownik(Uzytkownicy uzytkownik){
        // Pass object through flash 
        flash.put("uzytkownik", uzytkownik);
        
        return PAGE_UZYTKOWNIK_EDIT;
    }

    public String deleteUzytkownik(Uzytkownicy uzytkownik){
        uzytkownicyDAO.remove(uzytkownik);
        return PAGE_STAY_AT_THE_SAME;
    }
}