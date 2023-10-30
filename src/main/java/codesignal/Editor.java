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
        if (this.text != null && !this.text.isEmpty() && cursor > 0)
            this.cursor--;
        return this.text;
    }

    public String onPressRight() {
        // TODO: implement this method
        if (this.text != null && !this.text.isEmpty() && cursor != this.text.length() - 1)
            this.cursor++;
        return this.text;
    }

    public String onPressHome() {
        // TODO: implement this method
        if (this.text != null && !this.text.isEmpty())
            this.cursor = 0;
        return this.text;
    }

    public String onPressEnd() {
        // TODO: implement this method
        if (isNotEmptyOrNull(this.text))
            this.cursor = this.text.length() - 1;
        return this.text;
    }

    // onPressDelete() - deletes the character (if there is one) adjacent to the right side of the cursor.
    public String onPressDelete() {
        String leftSubString, rightSubString;
        if (isNotEmptyOrNull(this.text) && (this.text.length()) - cursor == this.text.length()) { // it the cursor is on beginning position
            return this.text;
        } else {
            leftSubString = this.text.substring(0, this.cursor);
            rightSubString = this.text.substring(cursor);
            this.text = leftSubString + rightSubString;
            return this.text;
        }
    }

    public String onPressBackspace() {
        String leftSubString,rightSubString;

        // TODO: implement this method
        if (isNotEmptyOrNull(this.text) && (this.text.length()) - cursor == this.text.length()) { // it the cursor is on beginning position
        } else {
            leftSubString = this.text.substring(0,cursor);
            cursor++;
            rightSubString = this.text.substring(cursor);

            this.text = leftSubString + rightSubString;
            return this.text;
        }
        return this.text;

    }

    //onInputCharacter(character) - inserts character on the right side of the cursor.
    public String onInputCharacter(String character) {
        // TODO: implement this method
        String leftSubString, rightSubString;
        if(this.cursor==0){
            this.text=character+this.text;
        }else if(this.text.length()-1==cursor){
            this.text=this.text+character;
        }else {
            leftSubString = this.text.substring(0,cursor+1);
            rightSubString = this.text.substring(cursor+1);
            this.text = leftSubString+character+rightSubString;
        }
        return this.text;
    }

    public static void main(String[] args) {
        String input = "codeSignal";
                     // 0123456789
        deleteCharFromString(input,6);

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

    private boolean isNotEmptyOrNull(String input) {
        if (this.text != null && !this.text.isEmpty())
            return true;
        else
            return false;
    }

    private static String[] deleteCharFromString(String inputText, Integer index){
        String[] result = new String[2];
        String leftSubString, rightSubString;
        leftSubString = inputText.substring(0, index);
        index++;
        rightSubString = inputText.substring(index);
        result[0] = leftSubString;
        result[1] = rightSubString;
        return result;
    }
}