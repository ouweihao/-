package chat;

public class TalkTeacher {
    public static void main(String[] args) throws Exception {
        new Thread(new TalkSend(6666, "localhost", 9002)).start();
        new Thread(new TalkReceiver(9001, "学生")).start();
    }
}
