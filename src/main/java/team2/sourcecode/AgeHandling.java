package team2.sourcecode;

public class AgeHandling extends Exception{
    public AgeHandling(String msg,int age){
        super(msg);
        if (age > 120 || age <= 14){
            msg = "Invaild age";
        }

    }
}
