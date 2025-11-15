public class AppNotification implements Observers {

    @Override
    public void update(String msg) {
        System.out.println("[Notification]: " + msg);
    }

}
