import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Population {

    public static int linSearch(Comparable search, Comparable[] arr) {
      int pos = 0;
      boolean flag = false;
      while (pos < arr.length) {
          if (arr[pos].equals(search)) {
              flag = true;
              break;
          }
          ++pos;
      }
      if (!flag) {
          return -1;
      }
      return pos;
    }

    public static int binarySearch(Comparable key, Comparable[] a){ return binarySearch(key, a, 0, a.length); }

    public static int binarySearch(Comparable key, Comparable[] a, int lo, int hi){
        if (hi <= lo) return -1;
        if (a[lo + 2] == null) return lo + 1;
        int mid = (hi + lo) / 2;
        int cmp = key.compareTo(a[mid]);
        if (a[mid].equals(key)) return mid;
        if (cmp > 0) {
            return binarySearch(key, a, mid + 1, hi);
        } else if (cmp < 0){
            return binarySearch(key, a, lo, mid);
        } else {
            return mid;
        }
    }

     private static void swap(Comparable[] arr, int posA, int posB) {
         Comparable temp = arr[posA];
         arr[posA] = arr[posB];
         arr[posB] = temp;
    }

    public static Comparable[] bubbleSort(Comparable[] arr) {
        Comparable[] sortedArr = arr;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j > 0; --j) {
                if (sortedArr[j] == null) break;
                if (sortedArr[j - 1].compareTo(sortedArr[j]) > 0 ) {
                    swap(sortedArr, j - 1, j);
                } else {
                    break;
                }
            }
        }
        return sortedArr;
    }

    public static Comparable[] inserationSort(Comparable[] arr) {
        Comparable[] sortedArr = arr;
        int size = arr.length;
        for (int i = 1; i <= size - 1; ++i) {
            for (int j = i; j > 0; --j) {
                if (sortedArr[j] == null) break;
                if (sortedArr[j].compareTo(sortedArr[j - 1]) < 0)
                    swap(sortedArr, j, j - 1);
            }
        }
        return sortedArr;
    }

    public static Comparable[] changeElements(Comparable[] arr, int position, Comparable newEle) {
        Comparable[] changedArr = arr;
        changedArr[position] = newEle;
        return changedArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] myClientsArray = new String[10];
        myClientsArray[0] = "Butler";
        myClientsArray[1] = "Samuels";
        myClientsArray[2] = "Bond";
        myClientsArray[3] = "Chang";
        myClientsArray[4] = "Baker";
        myClientsArray[5] = "Davis";
        myClientsArray[6] = "Zheng";
        myClientsArray[7] = "Joe";

        Integer[] myClientNumbers = new Integer[10];
        myClientNumbers[0] = 108;
        myClientNumbers[1] = 121;
        myClientNumbers[2] = 188;
        myClientNumbers[3] = 107;
        myClientNumbers[4] = 122;
        myClientNumbers[5] = 111;
        myClientNumbers[6] = 203;
        myClientNumbers[7] = 135;

        System.out.println("******* Parallel Array Processing Application *******");
        System.out.println("To exit the program type exit on any prompt screen");
        System.out.println("Do you want to change elements within the client name or client number array?");
        String changeAns = sc.nextLine();
        if (Objects.equals(changeAns, "yes")) {
            System.out.println("Which array do you want to change?");
            String changeArr = sc.nextLine();
            if (changeArr == "myClientsArray") {
                System.out.println("Put in element and the position you want to put it in (space in between name and position): ");
                String changeEle = sc.nextLine();
                int changePos = sc.nextInt();
                myClientsArray = (String[]) changeElements(myClientsArray, changePos, changeEle);
            } else {
                System.out.println("Put in element and the position you want to put it in (space in between number and position): ");
                Integer changeEle = sc.nextInt();
                int changePos = sc.nextInt();
                myClientNumbers = (Integer[]) changeElements(myClientNumbers, changePos, changeEle);
            }
        }

        System.out.println("Enter the sorting algorithm you want to use ('bubble', or 'insertion'): ");
        String userSort = sc.nextLine();

        if (Objects.equals(userSort, "bubble")) {
            System.out.println(Arrays.toString(bubbleSort(myClientsArray)));
        } else {
            System.out.println(Arrays.toString(inserationSort(myClientsArray)));
        }

        if (Objects.equals(userSort, "insertion")) {
            System.out.println(Arrays.toString(bubbleSort(myClientNumbers)));
        } else {
            System.out.println(Arrays.toString(inserationSort(myClientNumbers)));
        }

        System.out.println("-------------------------------------------");
        System.out.println("Now, enter the search algorithm you want to use ('binary' or 'linear'): ");
        String userSearch = sc.nextLine();
        System.out.println("Enter a Client Name to search for -> ");
        String resString = sc.nextLine();
        System.out.println("Enter a Client Number -> ");
        int resNum = sc.nextInt();

        if (Objects.equals(userSearch, "binary") && Objects.equals(userSort, "bubble")) {
            System.out.println("Client name results: ");
            System.out.println(binarySearch(resString, bubbleSort(myClientsArray)));
            System.out.println("Client number results: ");
            System.out.println(binarySearch(resNum, bubbleSort(myClientNumbers)));
        } else if (Objects.equals(userSearch, "binary") && Objects.equals(userSort, "inseration")) {
            System.out.println("Client name results: ");
            System.out.println(binarySearch(resString, inserationSort(myClientsArray)));
            System.out.println("Client number results: ");
            System.out.println(binarySearch(resNum, inserationSort(myClientNumbers)));
        } else if (Objects.equals(userSearch, "linear") && Objects.equals(userSort, "bubble")) {
            System.out.println("Client name results: ");
            System.out.println(linSearch(resString, bubbleSort(myClientsArray)));
            System.out.println("Client number results: ");
            System.out.println(linSearch(resNum, bubbleSort(myClientNumbers)));
        } else {
            System.out.println("Client name results: ");
            System.out.println(linSearch(resString, inserationSort(myClientsArray)));
            System.out.println("Client number results: ");
            System.out.println(linSearch(resNum, inserationSort(myClientNumbers)));
        }

        System.out.println("-------------------------------------------");
        System.out.println("results: ");
        if (Objects.equals(userSearch, "binary")) {
            if (binarySearch(resString, myClientsArray) == binarySearch(resNum, myClientNumbers)) {
                System.out.println(" the positions of the binary search MATCH");
            } else {
                System.out.println(" the positions of the binary search DON'T MATCH");
            }
        } else {
            if (linSearch(resString, myClientsArray) == linSearch(resNum, myClientNumbers)) {
                System.out.println(" the positions of the linear search MATCH");
            } else {
                System.out.println(" the positions of the linear search DON'T MATCH");
            }
        }
    }
}
