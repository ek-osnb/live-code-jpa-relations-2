package ek.osnb.jparelations2.one2one;


import ek.osnb.jparelations2.common.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class UserDetails extends BaseEntity {
    private String bio;

    public UserDetails() {}

    public UserDetails(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
