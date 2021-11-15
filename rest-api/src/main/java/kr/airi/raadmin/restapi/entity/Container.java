package kr.airi.raadmin.restapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Getter
@Setter
@Table(name = "server_container")
@AllArgsConstructor
@NoArgsConstructor
public class Container {

    @Id
    private int number;
    private String container;
    private String content;

    @Column(name = "server_number")
    private int serverNumber;

    @Column(name = "port_number")
    private int portNumber;

}
