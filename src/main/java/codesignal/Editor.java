package codesignal;

import java.util.ArrayList;
import java.util.List;

/*

You are implementing a class that handles text editing operations,
but currently it is not complete and might have some issues.
Your task is to refactor it, fix the issues and add the missing parts.

The following methods should be supported:

onPressLeft() - the cursor moves left by 1 character.
If there are no characters on the left side of the cursor, does nothing.

onPressRight() - the cursor moves right by 1 character.
If there are no characters on the right side of the cursor, does nothing.

onPressHome() - the cursor moves to the beginning of the text.

onPressEnd() - the cursor moves to the end of the text.

onPressDelete() - deletes the character (if there is one) adjacent to the right side of the cursor.

onPressBackspace() - deletes the character (if there is one) adjacent to the left side of the cursor.

onInputCharacter(character) - inserts character on the right side of the cursor.

Example

For commands = ["S", "S", "i", "g", "g", "backspace", "n", "a", "l", "left", "left",
"left", "left", "left", "backspace", "left", "C", "o", "d", "e"],

the output should be

solution(commands) = ["S", "SS", "SSi", "SSig", "SSigg", "SSig", "SSign", "SSigna",
"SSignal", "SSignal", "SSignal", "SSignal", "SSignal", "SSignal", "Signal", "Signal",
"CSignal", "CoSignal", "CodSignal", "CodeSignal"]



 */
public class Editor {
    private String text;
    private int cursor;

    public Editor() {
        this.text = "";
        this.cursor = 0;
    }

    public String onPressLeft() {
        // TODO: fix the bugs in this method if there are any
        if(this.text!=null && !this.text.isEmpty() && cursor!=0)
            this.cursor--;
        return this.text;
    }

    public String onPressRight() {
        // TODO: implement this method
        if(this.text!=null || !this.text.isEmpty()){

        }
        return null;
    }

    public String onPressHome() {
        // TODO: implement this method
        return null;
    }

    public String onPressEnd() {
        // TODO: implement this method
        return null;
    }

    public String onPressDelete() {
        if (this.cursor == this.text.length()) {
            return this.text;
        }
        return this.text;
    }

    public String onPressBackspace() {
        // TODO: implement this method
        return null;
    }

    public String onInputCharacter(String character) {
        // TODO: implement this method
        return null;
    }


    List<String> solution(String[] commands) {
        Editor editor = new Editor();
        List<String> result = new ArrayList<>();

        for (String command : commands) {
            if (command.equals("left")) {
                result.add(editor.onPressLeft());
            } else if (command.equals("right")) {
                result.add(editor.onPressRight());
            } else if (command.equals("home")) {
                result.add(editor.onPressHome());
            } else if (command.equals("end")) {
                result.add(editor.onPressEnd());
            } else if (command.equals("delete")) {
                result.add(editor.onPressDelete());
            } else if (command.equals("backspace")) {
                result.add(editor.onPressBackspace());
            } else {
                result.add(editor.onInputCharacter(command));
            }
        }

        return result;
    }
}