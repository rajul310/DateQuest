//package com.app.entities;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.app.enums.PaymentType;
//import com.app.enums.Status;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Table(name = "Payments")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//
//public class Payment extends BaseEntity {
//    @Column(name = "payment_date")
//    private LocalDate date;
//
//    @Column(name = "package_name")
//    private String packageName;
//
//    @Column(name = "total_amount")
//    private double totalAmount;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_type")
//    private PaymentType paymentType;
//    
//    @OneToOne
//    @JoinColumn(name="booking_id")
//    private Booking booking;
//}




