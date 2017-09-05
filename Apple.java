public class Apple {

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public Apple (String color){
        this.color = color;
    }

    public static void main(String[] args) {
        Apple ap1 = new Apple("green");
        System.out.println(ap1.getColor());
        changeColor(ap1);
        System.out.println(ap1.getColor());



    }

    public static void changeColor(Apple ap){
        ap = new Apple("red");
//        ap.setColor("red");
    }




}
