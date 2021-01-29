//Define variables in class using static method initialize these variables and display. 
class StaticTest{
    static int a;
    static void show(){
        a =100;
        System.out.println(StaticTest.a);
    }
    public static void main(String[] args) {
        show();
    }
}