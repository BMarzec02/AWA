package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.text.DecimalFormat;

@Named
@RequestScoped
public class CalcBB {
    private String loanAmount; // kwota kredytu
    private String interestRate; // oprocentowanie roczne w procentach
    private String loanTerm; // czas kredytowania w latach
    private Double monthlyPayment; //miesieczna rata

    @Inject
    FacesContext ctx;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    

    public String getFormattedMonthlyPayment() {
    	if (monthlyPayment != null) {
    		DecimalFormat df = new DecimalFormat("#,##0.00");
    		return df.format(monthlyPayment) + " zł";
    	}
    	return null;
    }	

    public boolean calculateLoan() {
        try {
            double principal = Double.parseDouble(this.loanAmount);
            double annualRate = Double.parseDouble(this.interestRate);
            int years = Integer.parseInt(this.loanTerm);

            double monthlyRate = (annualRate / 100) / 12;
            int totalMonths = years * 12;

            monthlyPayment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -totalMonths));

            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
            return true;
        } catch (Exception e) {
            ctx.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
            return false;
        }
    }

    public String calc() {
        if (calculateLoan()) {
            return "showresult";
        }
        return null;
    }

    public String calc_AJAX() {
        if (calculateLoan()) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesięczna rata: " + getFormattedMonthlyPayment(), null));
        }
        return null;
    }

    public String info() {
		return "info"; 
	}
}