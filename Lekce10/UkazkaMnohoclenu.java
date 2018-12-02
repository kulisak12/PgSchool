public class UkazkaMnohoclenu {
    public static void main(String args[]) {
        Mnohoclen m1 = new Mnohoclen(7, -5, 0, -3);
        Mnohoclen m2 = new Mnohoclen(3, 4, 5);
        m1.secti(m2);
        System.out.print(m1.ziskejZapis());
    }
}