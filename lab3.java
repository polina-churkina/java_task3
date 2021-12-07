//Пользователь вводит с клавиатуры строчку, являющуюся паролем. Проверить, надежно ли составлен пароль.
// Пароль считается надежным,если он состоит из 8 или более символов. Символом может быть цифра, английская буква,
// знак подчеркивания. Пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру.

import java.util.Scanner;
import java.util.regex.*;

public class lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = "[а-яА-Я]|[@#!$%^&*()-+='.,><;:`~|]";
        String password;
        System.out.print("Введите пароль, содержащий 8 или более символов. Пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру: ");
        password = sc.next();
        Pattern p0 = Pattern.compile(pattern);
        Matcher m0 = p0.matcher(password);
        if (!(m0.find())) {
            pattern = "[a-z]";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(password);
            if (password.length() >= 8) {
                if (m.find()) {
                    pattern = "[A-Z]";
                    Pattern p1 = Pattern.compile(pattern);
                    Matcher m1 = p1.matcher(password);
                    if (m1.find()) {
                        pattern = "[0-9]";
                        Pattern p2 = Pattern.compile(pattern);
                        Matcher m2 = p2.matcher(password);
                        if (m2.find()) {
                            System.out.println("Пароль является надежным.");
                        } else {
                            System.out.println("Пароль ненадежен. Пароль должен содержать хотя бы одну цифру.");
                        }
                    } else {
                        System.out.println("Пароль ненадежен. Пароль должен содержать хотя бы одну заглавную букву.");
                    }
                } else {
                    System.out.println("Пароль ненадежен. Пароль должен содержать хотя бы одну маленькую букву");
                }
            } else {
                System.out.println("Пароль ненадежен. Пароль должен состоять из 8 или более символов.");
            }
        } else {
            System.out.println("Ошибка ввода. Пароль может содержать только латинские буквы, цифры и нижнее подчеркивание.");
        }
    }
}