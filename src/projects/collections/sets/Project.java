package projects.collections.sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Project {

    private final List<Role> roles;

    public Project(Role... roles) {
        this.roles = List.of(roles);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public int getConformity(Set<Member> team) {
        List<Entry> projectEntries = new ArrayList<>();
        for (Role role : roles) {
            for (Skill skill : role.getSkills()) {
                projectEntries.add(new Entry(skill, role.getLevel()));
                System.out.println("P: " + skill + " " + role.getLevel());
            }
        }
        int originalSize = projectEntries.size();

        List<Entry> teamEntries = new ArrayList<>();
        for (Member member : team) {
            for (Skill skill : member.getSkills()) {
                teamEntries.add(new Entry(skill, member.getLevel()));
                System.out.println(skill + " " + member.getLevel());
            }
        }

        for (Entry teamEntry : teamEntries) {
            projectEntries.remove(teamEntry);
        }
        int newSize = projectEntries.size();
        System.out.println("new size: " + newSize);
        System.out.println((((originalSize - newSize) * 100) / originalSize));

        return (int) (((originalSize - newSize) * 100.0) / originalSize);
    }

    private static class Entry {
        private final Skill skill;
        private final Level level;

        public Entry(Skill skill, Level level) {
            this.skill = skill;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return skill == entry.skill && level == entry.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(skill, level);
        }
    }
}

