package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

final class Message {

    final private Long id;
    final private List<String>  text;

    public Message(final Long id, final List<String> text){
        this.id = id;
        this.text = new ArrayList<>(text);
    }

    public Long getId() {
        return id;
    }

    public List<String> getList(){
        return new ArrayList<>(text);
    }

    public static void main(String[] args) {
        List list = new  ArrayList<String>();
        Message message;
        message = new Message(1l,list);
        list.add("dfdf");
    }

}

