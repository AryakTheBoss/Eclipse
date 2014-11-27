/**
 * 
 */
package art;

import java.util.HashMap;
import java.util.Map;
import bs.Encryptor;

/**
 * @author UnityBoss
 *
 */
public class AsciiArt {

    Map<Character, String[]> strings = new HashMap<Character, String[]>();
private static Encryptor e = new Encryptor();

    public AsciiArt() {
       	strings.put('A', letterA());
       	strings.put('B', letterB());
       	strings.put('C', letterC());
       	strings.put('D', letterD());
       	strings.put('E', letterE());
       	strings.put('F', letterF());
       	strings.put('G', letterG());
       	strings.put('H', letterH());
       	strings.put('I', letterI());
       	strings.put('J', letterJ());
       	strings.put('K', letterK());
       	strings.put('L', letterL());
       	strings.put('M', letterM());
       	strings.put('N', letterN());
       	strings.put('O', letterO());
       	strings.put('P', letterP());
       	strings.put('Q', letterQ());
       	strings.put('R', letterR());
        strings.put('S', letterS());
        strings.put('T', letterT());
        strings.put('U', letterU());
        strings.put('V', letterV());
        strings.put('W', letterW());
        strings.put('X', letterX());
        strings.put('Y', letterY());
        strings.put('Z', letterZ());
        
    }

    public static void main(String[] args) {
    
        AsciiArt art = new AsciiArt();
        art.print("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        
    }

    public void print(String text) {
        char[] chars = text.toCharArray();
        String[] finalText = new String[7];
        for (int i = 0; i < 7; i++) {
            finalText[i] = "";
        }
        for (char c : chars) {
            if (strings.containsKey(new Character(c))) {
                for (int i = 0; i < 7; i++) {
                    finalText[i] += strings.get(new Character(c))[i];
                }
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(finalText[i]);
        }
    }

   
    
    public String[] letterA() {
        String[] data = new String[7];//14
        data[0] = "                               ";
        data[1] = "     /\\                       ";
        data[2] = "    /  \\                      ";
        data[3] = "   / __ \\                     ";
        data[4] = "  /      \\                    ";
        data[5] = " /        \\                   ";
        data[6] = "/          \\                  ";
        return data;
    }
    
    public String[] letterB() {
        String[] data = new String[7];//10
        data[0] = " ______                        ";
        data[1] = "|      |                       ";
        data[2] = "|      |                       ";
        data[3] = "|______|                       ";
        data[4] = "|      |                       ";
        data[5] = "|      |                       ";
        data[6] = "|______|                       ";
        return data;
    }
    
    public String[] letterC() {
        String[] data = new String[7];
        data[0] = " ______                        ";
        data[1] = "|                              ";
        data[2] = "|                              ";
        data[3] = "|                              ";
        data[4] = "|                              ";
        data[5] = "|                              ";
        data[6] = "|______                        ";
        return data;
    }
    
    public String[] letterD() {
        String[] data = new String[7];
        data[0] = " _____                         ";
        data[1] = "|      \\                      ";
        data[2] = "|       |                      ";
        data[3] = "|       |                      ";
        data[4] = "|       |                      ";
        data[5] = "|       |                      ";
        data[6] = "|______/                       ";
        return data;
    }
    
    public String[] letterE() {
        String[] data = new String[7];
        data[0] = " _______  ";
        data[1] = "|         ";
        data[2] = "|         ";
        data[3] = "|____     ";
        data[4] = "|         ";
        data[5] = "|         ";
        data[6] = "|_______  ";
        return data;
    }
    
    public String[] letterF() {
        String[] data = new String[7];
        data[0] = " _______  ";
        data[1] = "|         ";
        data[2] = "|         ";
        data[3] = "|____     ";
        data[4] = "|         ";
        data[5] = "|         ";
        data[6] = "|         ";
        return data;
    }
    
    public String[] letterG() {
        String[] data = new String[7];
        data[0] = " _______  ";
        data[1] = "|         ";
        data[2] = "|         ";
        data[3] = "|     __  ";
        data[4] = "|      |  ";
        data[5] = "|      |  ";
        data[6] = "|______|  ";
        return data;
    }
    
    public String[] letterH() {
        String[] data = new String[7];
        data[0] = "            ";
        data[1] = "|        |  ";
        data[2] = "|        |  ";
        data[3] = "|--------|  ";
        data[4] = "|        |  ";
        data[5] = "|        |  ";
        data[6] = "|        |  ";
        return data;
    }
    
    public String[] letterI() {
        String[] data = new String[7];
        data[0] = "  _______  ";
        data[1] = "     |     ";
        data[2] = "     |     ";
        data[3] = "     |     ";
        data[4] = "     |     ";
        data[5] = "     |     ";
        data[6] = "  -------  ";
        return data;
    }
    
    public String[] letterJ() {
        String[] data = new String[7];
        data[0] = "   _______  ";
        data[1] = "      |     ";
        data[2] = "      |     ";
        data[3] = "      |     ";
        data[4] = "      |     ";
        data[5] = "      |     ";
        data[6] = "  ___/      ";
        return data;
    }
    
    public String[] letterK() {
        String[] data = new String[7];
        data[0] = "|    /   ";
        data[1] = "|   /    ";
        data[2] = "|  /     ";
        data[3] = "| /      ";
        data[4] = "| \\     ";
        data[5] = "|  \\    ";
        data[6] = "|   \\   ";
        return data;
    }
    
    public String[] letterL() {
        String[] data = new String[7];
        data[0] = "|         ";
        data[1] = "|         ";
        data[2] = "|         ";
        data[3] = "|         ";
        data[4] = "|         ";
        data[5] = "|         ";
        data[6] = "|_______  ";
        return data;
    }
    
    public String[] letterM() {
        String[] data = new String[7];
        data[0] = "|\\    /|  ";
        data[1] = "| \\  / |  ";
        data[2] = "|  \\/  |  ";
        data[3] = "|       |  ";
        data[4] = "|       |  ";
        data[5] = "|       |  ";
        data[6] = "|       |  ";
        return data;
    }
    
    public String[] letterN() {
        String[] data = new String[7];
        data[0] = "|\\      |  ";
        data[1] = "| \\     |  ";
        data[2] = "|  \\    |  ";
        data[3] = "|   \\   |  ";
        data[4] = "|    \\  |  ";
        data[5] = "|     \\ |  ";
        data[6] = "|      \\|  ";
        return data;
    }
    
    public String[] letterO() {
        String[] data = new String[7];
        data[0] = "  ____   ";
        data[1] = "/      \\";
        data[2] = "|       | ";
        data[3] = "|       | ";
        data[4] = "|       | ";
        data[5] = "|       | ";
        data[6] = " \\_____/ ";
        return data;
    }
    
    public String[] letterP() {
        String[] data = new String[7];
        data[0] = " ______   ";
        data[1] = "|       \\";
        data[2] = "|       | ";
        data[3] = "|______/  ";
        data[4] = "|         ";
        data[5] = "|         ";
        data[6] = "|         ";
        return data;
    }
    
    public String[] letterQ() {
        String[] data = new String[7];
        data[0] = " ________   ";
        data[1] = "|        |  ";
        data[2] = "|        |  ";
        data[3] = "|        |  ";
        data[4] = "|        |  ";
        data[5] = "|     \\ |  ";
        data[6] = "|______\\|  ";
        return data;
    }
    
    public String[] letterR() {
        String[] data = new String[7];
        data[0] = " ______     ";
        data[1] = "|       \\  ";
        data[2] = "|       |   ";
        data[3] = "|______/    ";
        data[4] = "| \\        ";
        data[5] = "|  \\       ";
        data[6] = "|   \\      ";
        return data;
    }
    
    public String[] letterS() {
        String[] data = new String[7];
        data[0] = " ______  ";
        data[1] = "|        ";
        data[2] = "|        ";
        data[3] = "|_____   ";
        data[4] = "      |  ";
        data[5] = "      |  ";
        data[6] = "______|  ";
        return data;
    }
    


    public String[] letterT() {
        String[] data = new String[7];
        data[0] = "  _______  ";
        data[1] = "     |     ";
        data[2] = "     |     ";
        data[3] = "     |     ";
        data[4] = "     |     ";
        data[5] = "     |     ";
        data[6] = "     |     ";
        return data;
    }
    
    public String[] letterU() {
        String[] data = new String[7];
        data[0] = "|       |  ";
        data[1] = "|       |  ";
        data[2] = "|       |  ";
        data[3] = "|       |  ";
        data[4] = "|       |  ";
        data[5] = "|       |  ";
        data[6] = " \\____/  ";
        return data;
    }
    
    public String[] letterV() {
        String[] data = new String[7];
        data[0] = "\\            / ";
        data[1] = " \\          /  ";
        data[2] = "  \\        /   ";
        data[3] = "   \\      /    ";
        data[4] = "    \\    /     ";
        data[5] = "     \\  /      ";
        data[6] = "      \\/       ";
        return data;
    }
    
    public String[] letterW() {
        String[] data = new String[7];
        data[0] = "\\            /\\            / ";
        data[1] = " \\          /  \\          /  ";
        data[2] = "  \\        /    \\        /   ";
        data[3] = "   \\      /      \\      /    ";
        data[4] = "    \\    /        \\    /     ";
        data[5] = "     \\  /          \\  /      ";
        data[6] = "      \\/            \\/       ";
                //"               31                " 
        return data;
    }
    
    public String[] letterX() {
        String[] data = new String[7];
        data[0] = "   \\    /    ";
        data[1] = "    \\  /     ";
        data[2] = "     \\/      ";
        data[3] = "     /\\      ";
        data[4] = "    /  \\     ";
        data[5] = "   /    \\    ";
        data[6] = "  /      \\   ";
        return data;
    }
    
    public String[] letterY() {
        String[] data = new String[7];
        data[0] = "   \\    /   ";
        data[1] = "    \\  /    ";
        data[2] = "     \\/     ";
        data[3] = "      |      ";
        data[4] = "      |      ";
        data[5] = "      |      ";
        data[6] = "      |      ";
        return data;
    }
    
    public String[] letterZ() {
        String[] data = new String[7];
        data[0] = " ______  ";
        data[1] = "      /  ";
        data[2] = "     /   ";
        data[3] = "    /    ";
        data[4] = "   /     ";
        data[5] = "  /      ";
        data[6] = " ------  ";
        return data;
    }
    
}
