package com.api.solset.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.PersonType;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private PersonType personType;
    private String cnpj;
    private String cpf;
    @Column(nullable = false)
    private String name;
    private String fantasyName;
    @Column(nullable = false)
    private String firstPhoneNumber;
    private String secondPhoneNumber;
    private String email;
    @Column(nullable = false)
    private String requestToken;
    private String postalCode;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String complement;
}
