package csulb.cecs323.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class IndividualAuthors extends AuthoringEntities {
    @OneToMany (mappedBy = "authors",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<AdHocTeamMembers> teamMembers;

    public IndividualAuthors() { }

    public IndividualAuthors(String name, String email) {
        super(name, email);
    }

    public void addTeamMembers(AdHocTeamMembers teamMember) {
        teamMembers.add(teamMember);
        teamMember.setIndividualAuthors(this);
    }

    public void removeTeamMembers(AdHocTeamMembers teamMember) {
        if (this.teamMembers != null) {
            teamMembers.remove(teamMember);
            teamMember.setIndividualAuthors(null);
        }
    }

    public List<AdHocTeamMembers> getTeamMembers() { return teamMembers; }

    public void setTeamMembers(ArrayList<AdHocTeamMembers> teamMembers) { this.teamMembers = teamMembers; }
}
