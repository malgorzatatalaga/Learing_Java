package projects.classes.nested;

public class Contact {

    private static final int MAX_NUMBER_OF_EMAILS = 3;
    private static final int MAX_NUMBER_OF_SOCIALS = 5;
    private String contactName;

    private final Email[] emails;
    private final Social[] socialMedia;
    private ContactInfo phoneInfo = null;
    private int currentNumberOfSocials = 0;
    private int currentNumberOfEmails = 0;

    public Contact(String contactName) {
        this.contactName = contactName;
        this.emails = new Email[MAX_NUMBER_OF_EMAILS];
        this.socialMedia = new Social[MAX_NUMBER_OF_SOCIALS];
    }

    public void rename(String newName) {
        if (newName != null && !newName.isBlank()) {
            this.contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (currentNumberOfEmails >= MAX_NUMBER_OF_EMAILS) {
            return null;
        } else {
            Email email = new Email(localPart + "@" + domain);
            emails[currentNumberOfEmails++] = email;
            return email;
        }
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if (currentNumberOfEmails >= MAX_NUMBER_OF_EMAILS) {
            return null;
        } else {
            Email emailEpam = new Email(firstname + "_" + lastname + "@epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emails[currentNumberOfEmails++] = emailEpam;
            return emailEpam;
        }
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (phoneInfo != null) {
            return null;
        } else {
            phoneInfo = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            return phoneInfo;
        }
    }

    public Social addTwitter(String twitterId) {
        if (currentNumberOfSocials >= MAX_NUMBER_OF_SOCIALS) {
            return null;
        } else {
            Social twitter = new Social("Twitter", twitterId);
            socialMedia[currentNumberOfSocials++] = twitter;
            return twitter;
        }
    }

    public Social addInstagram(String instagramId) {
        if (currentNumberOfSocials >= MAX_NUMBER_OF_SOCIALS) {
            return null;
        } else {
            Social instagram = new Social("Instagram", instagramId);
            socialMedia[currentNumberOfSocials++] = instagram;
            return instagram;
        }
    }

    public Social addSocialMedia(String title, String id) {
        if (currentNumberOfSocials >= MAX_NUMBER_OF_SOCIALS) {
            return null;
        } else {
            Social social = new Social(title, id);
            socialMedia[currentNumberOfSocials++] = social;
            return social;
        }
    }

    public ContactInfo[] getInfo() {
        boolean isPhoneNumber = false;
        int capacity = 1 + currentNumberOfEmails + currentNumberOfSocials;
        if (phoneInfo != null) {
            capacity++;
            isPhoneNumber = true;
        }
        ContactInfo[] contactInfos = new ContactInfo[capacity];
        NameContactInfo name = new NameContactInfo();
        contactInfos[0] = name;
        if (isPhoneNumber) {
            contactInfos[1] = phoneInfo;
            System.arraycopy(emails, 0, contactInfos, 2, currentNumberOfEmails);
            System.arraycopy(socialMedia, 0, contactInfos, 2 + currentNumberOfEmails, currentNumberOfSocials);
        } else {
            System.arraycopy(emails, 0, contactInfos, 1, currentNumberOfEmails);
            System.arraycopy(socialMedia, 0, contactInfos, 1 + currentNumberOfEmails, currentNumberOfSocials);
        }

        return contactInfos;
    }

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private final String emailName;

        public Email(String emailName) {
            this.emailName = emailName;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return emailName;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

}

