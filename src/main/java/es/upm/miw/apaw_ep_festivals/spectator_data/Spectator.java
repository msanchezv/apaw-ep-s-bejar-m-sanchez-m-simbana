package es.upm.miw.apaw_ep_festivals.spectator_data;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Spectator {

    @Id
    private String id;

    private String name;

    private String surname;

    private LocalDateTime birthday;

    public Spectator(String name, String surname, LocalDateTime birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Spectator() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Spectator{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", surname='" + surname +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public static class Builder {

        private Spectator spectator;

        private Builder() {
            this.spectator = new Spectator();
        }

        public Builder name(String name) {
            this.spectator.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.spectator.surname = surname;
            return this;
        }

        public Builder birthday(LocalDateTime birthday) {
            this.spectator.birthday = birthday;
            return this;
        }

        public Builder byDefault() {
            Builder builder = new Builder();
            LocalDateTime date = LocalDateTime.of(1995, 3, 24, 9, 0);
            return builder.name("Tony").surname("Pacheco").birthday(date);
        }

        public Spectator build() {
            return this.spectator;
        }

    }
}
