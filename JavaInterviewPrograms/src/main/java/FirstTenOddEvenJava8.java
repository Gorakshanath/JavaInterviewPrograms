import java.util.stream.IntStream;

public class FirstTenOddEvenJava8 {
    public static void main(String[] args){
        int n=50;
        IntStream.rangeClosed(1,n).filter(i->i%2==0).limit(10).forEach(
                num->System.out.println("Even No :"+num));
        IntStream.rangeClosed(1,n).filter(i->i%2!=0).limit(10).forEach(
                num->System.out.println(" Odd No :"+ num)
        );
    }
}
