import java.util.*;

public class Main {

    public static  void addPrefix(String st, Set<String> set){
        String s = new String(st);
        int len = 0;
        int ind;
        do{
            set.add(s);
            ind = s.lastIndexOf('\\');

            if(ind > 0){
                s = s.substring(0, ind);
            }

            len ++ ;
        } while(ind > 0);
    }

    public static List<String> solver(List<String> arr){

        Set<String> set = new TreeSet<>(new Comparator<String>()
        {
            public int compare(String s1,String s2)
            {
                if(s1.equals(s2)) return 0;
                if(s2.indexOf(s1) == 0) return -1;
                if(s1.indexOf(s2) == 0) return 1;
                return s2.compareTo(s1);
            }
        });

        List<String> res = new ArrayList<>();


        arr.stream().forEach(s -> addPrefix(s,set));

        set.stream().forEach(s -> res.add(s));

        return res;
    }


    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        List<String> arr = new ArrayList<>();

        System.out.println("Enter count of strings");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter strings(department names)");

        for(int i=0; i<n; i++){
            arr.add(sc.next());
            sc.nextLine();

        }

        arr = solver(arr);

        arr.stream().forEach(s -> System.out.println(s));
    }
}