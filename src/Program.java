import Exceptions.MyArrayDataException;
import Exceptions.MyArraySizeException;

public class Program {

    static int sum;
    public static void sumArray (String [][] arr) throws MyArraySizeException, MyArrayDataException {

        StringBuilder str = new StringBuilder();
        boolean rowEx = false, colEx = false, dataEx = false;
        if (arr.length != 4)
            rowEx = true;
        for (String[] element : arr) {
            if (element.length != 4) {
                colEx = true;
                break;
            }
        }
        if (rowEx) str.append(" количество строк не 4");
        if (colEx) str.append(" количество столбцов не всегда 4");

        if (rowEx || colEx) {
            throw new MyArraySizeException("Неверный размер массива ", str.toString());
        }

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                try {
                    sum += Integer.parseInt(arr[x][y]);
                } catch (NumberFormatException ex) {
                    System.out.printf("не удалось преобразовать в число элемент [%d, %d]\n", x, y);
                    dataEx = true;
                }
            }
        }
        if (dataEx) throw new MyArrayDataException("cумма получена из валидных элементов массива");
    }
    public static void main(String[] args) {

        String [][] MyArray = {{"5","7","3","ilj"}, {"-7","0","1","-12"}, {"8","ljl;j1","3","5"}, {"6","15","-30","61"}};
        try {
            sumArray(MyArray);
        } catch (MyArraySizeException e){
            System.out.printf("%s %s\n",e.getMessage(),e.getDimension());
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.printf("Cумма: %d\n",sum);
        }
    }
}
