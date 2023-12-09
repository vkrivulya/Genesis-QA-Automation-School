package pages.thirdHomework;

public class SortMainPage {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 5, 6};

        int n = arr.length;

        System.out.println("BubbleSort: ");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // обмін елементів, якщо вони в неправильному порядку
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // виведення відсортованого масиву
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("InsertionSort: ");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // переміщення елементів масиву, які більше за key, на один вперед
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        // виведення відсортованого масиву
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
