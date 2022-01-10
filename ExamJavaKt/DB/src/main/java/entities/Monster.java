package entities;

import javax.persistence.*;

@Entity
@Table(name = "monster")
public class Monster {

    public Monster(Integer id, String name, Integer hp, Integer am, Integer apr, Integer damage, Integer damage_mode, Integer armor) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.am = am;
        this.apr = apr;
        this.damage = damage;
        this.damage_mode = damage_mode;
        this.armor = armor;

    }

    public Monster() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    private Integer hp;
    private Integer am;
    private Integer apr;
    private Integer damage;
    private Integer damage_mode;
    private Integer armor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAm() {
        return am;
    }

    public void setAm(Integer am) {
        this.am = am;
    }

    public Integer getApr() {
        return apr;
    }

    public void setApr(Integer apr) {
        this.apr = apr;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getDamage_mode() {
        return damage_mode;
    }

    public void setDamage_mode(Integer damage_mode) {
        this.damage_mode = damage_mode;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }
}
