package chat;

public class TalkStudent {
    public static void main(String[] args) throws Exception {
        new Thread(new TalkSend(9000, "localhost", 9001)).start();
        new Thread(new TalkReceiver(9002, "老师")).start();
    }
}
