package tsuberi.app.pest2.Events;

public class PhoneCallEvent {
    public static final PhoneCallEvent DEFAULT;

    static{
        PhoneCallEvent e = new PhoneCallEvent();
        e.phoneNumber = "DEFAULT PHONE NUMBER";
        DEFAULT = e;
    }

    String phoneNumber;

    public PhoneCallEvent() {
    }

    public PhoneCallEvent(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
