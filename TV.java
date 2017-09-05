import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class HDTV implements Comparable<HDTV> {

    private int size;
    private String name;

    public HDTV(){

    }

    public HDTV(int size, String name){
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(HDTV o) {
        if (this.getSize() > o.getSize())
            return 1;
        else if (this.getSize() < o.getSize())
            return -1;
        else
            return 0;
    }
}

public class TV {

    public static void main(String[] args){
        HDTV tv1 = new HDTV(65, "Sony");
        HDTV tv2 = new HDTV(60, "LG");
        HDTV tv3 = new HDTV();
        tv3.setName("Panasonic");
        tv3.setSize(70);

        if (tv1.compareTo(tv2) > 0) {
            if (tv1.compareTo(tv3) > 0) {
                System.out.println(tv1.getName() + " is better");
            }else
                System.out.println(tv3.getName() + " is better");
        }
        else
            System.out.println(tv2.getName() + " is better");


        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(1);
        list.add(2);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Comparator<Integer> comparator = Comparator.reverseOrder();
        Collections.sort(list, comparator);
        System.out.println(list);




    }

}

