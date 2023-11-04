package projects.collections.sets;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class Role {
    private final Level level;

    private final Position position;

    private final Set<Skill> skills;

    public Role(Position position, Level level, Skill... skills) {
        this.position = position;
        this.level = level;
        this.skills = EnumSet.noneOf(Skill.class);
        Collections.addAll(this.skills, skills);
    }

    public Level getLevel() {
        return level;
    }

    public Position getPosition() {
        return position;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}

