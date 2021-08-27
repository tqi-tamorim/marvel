package br.com.pagseguro.marvel.domain.model

import javax.persistence.*

@Entity
@Table(name = "hero")
class Hero(
    _id: Long? = null,
    _name: String?,
    _style: String?,
    _powers: MutableList<String>?
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_hero")
    var id: Long? = _id

    @Column(name = "nam_hero")
    var name: String? = _name

    @Column(name = "nam_style")
    var style: String? = _style

    @ElementCollection(targetClass = String::class)
    @Column(name = "powers")
    var powers: MutableList<String>? = _powers
}