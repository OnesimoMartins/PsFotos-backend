package com.isptec.psfotos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name = "album")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private String catalogo;

    @OneToMany
//    @JoinTable(
//            @JoinColumn( name = "")
//    )
//    @JoinColumn(name = "id_amigo")
    @JoinTable(
            name = "amigo_album",
            joinColumns = {
                    @JoinColumn(name = "id_album")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_amigo")
            }
    )
    private Set<Cliente> amigos;

}
