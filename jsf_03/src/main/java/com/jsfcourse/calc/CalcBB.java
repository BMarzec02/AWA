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
    private double loanAmount; // kwota kredytu
    private double interestRate; // oprocentowanie roczne w procentach
    private int loanTerm; // czas kredytowania w latach
    private Double monthlyPayment; // miesięczna rata

    @Inject
    FacesContext ctx;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
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
            double principal = this.loanAmount;
            double annualRate = this.interestRate;
            int years = this.loanTerm;

            double totalAmount = principal + (principal * (annualRate / 100));
            monthlyPayment = totalAmount / (years * 12);

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
}
