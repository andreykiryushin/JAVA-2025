package lr2;

public class Listing2 {

    public static String getEncryptString(String encryx, int shift) {

        // преобразуем переданную в метод строку в символьный массив
        char[] arrayChar = encryx.toCharArray();

        // создаем массив с типом данных long, размер массива равен размеру символьного массива
        long[] arrayInt = new long[arrayChar.length];

        // создаем символьный массив для записи преобразованных символов
        char[] arrayCharNew = new char[arrayChar.length];

        // в цикле перебираем все символы строки и сдвигаем их на значение shift
        for (int i = 0; i < arrayChar.length; i++) {
            // прибавляем к символу с индексом i сдвиг (shift)
            arrayInt[i] = arrayChar[i] + shift;
            // преобразуем число обратно в символ и записываем в новый массив
            arrayCharNew[i] = (char) arrayInt[i];
        }

        // преобразуем новый массив символов обратно в строку
        encryx = new String(arrayCharNew);

        // возвращаем зашифрованную строку
        return encryx;
    }
}