import Exceptions.NotFoundException;
import Exceptions.NullException;
import Exceptions.OutOfSizeException;

public class Homework implements StringList {


    private String[] ar;
    private int arSize = 0;

    public Homework(int i) {
        ar = new String[i];
        for (int j = 0; j < i; j++) {
            ar[j] = "";
        }
    }

    @Override
    public String toString() {
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arSize; i++) {
            result += "[" + ar[i] + "] ";
        }
        return result;
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullException("Аргумент не должен быть null");
        }
        for (int i = 0; i < ar.length; i++) {
            if ((ar[i]).equals("")) {
                ar[i] = item;
                arSize++;
                return item;
            } else {
                continue;
            }
        }
        System.out.println("Массив заполнен");
        return null;
    }

    @Override
    public String add(int index, String item) {
        if (ar.length == arSize) {
            throw new OutOfSizeException("Массив заполнен");
        }
        if (index > arSize) {
            throw new OutOfSizeException("Индекс не должен быть больше количества элементов");
        }

        for (int i = arSize; i > index; i--) {
            ar[i] = ar[i - 1];

        }
        ar[index] = item;
        arSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > arSize) {
            throw new OutOfSizeException("Индекс не должен быть больше количества элементов");
        }
        ar[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < ar.length; i++) {
            if ((ar[i]).equals(item)) {
                for (int j = i; j < arSize; j++) {
                    ar[j] = ar[j + 1];
                }
                arSize--;
                break;
            }
            if (i == arSize) {
                throw new NotFoundException("Не удалось найти элемент");
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index > arSize - 1) {
            throw new OutOfSizeException("Индекс не найден");
        }
        String result = ar[index];
        for (int i = index; i < arSize; i++) {
            ar[i] = ar[i + 1];
        }
        arSize--;
        return result;
    }

    @Override
    public boolean contains(String item) {
        for (String s : ar) {
            if (s.equals(item)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arSize; i++) {
            if ((ar[i]).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arSize; i >-1; i--) {
            if ((ar[i]).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if(index>arSize-1){throw new OutOfSizeException("Индекс не найден");}
        return ar[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(this.arSize== otherList.size()){
            for (int i = 0; i < this.arSize; i++) {
                if((this.ar[i]).equals(otherList.get(i))){continue;}else{return false;}
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return arSize;
    }

    @Override
    public boolean isEmpty() {
        if(arSize==0){return true;}
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arSize; i++) {
            ar[i]="";
        }
        arSize=0;
    }

    @Override
    public String[] toArray() {
        String[] ar2 = new String[arSize];
        for (int i = 0; i < arSize; i++) {
            ar2[i]=ar[i];
        }
        return ar2;
    }
}
