package Collection;

import java.util.HashMap;

class LaunchMap {
    String str = "";
    LaunchMap(String str){
        this.str = str;
    }
    @Override
    public boolean equals(Object o) {
        return true;
    }
    @Override
    public int hashCode() {
        return 2;
    }
    public static void main(String[] args) {
        LaunchMap a1 = new LaunchMap("AB");
        LaunchMap a2 = new LaunchMap("AB");
        LaunchMap a3 = new LaunchMap("PQ");
        LaunchMap a5 = new LaunchMap("PQQ");
        LaunchMap a4 = a1;

        HashMap<LaunchMap,Integer> mp = new HashMap<>();
        mp.put(a1,1);
        mp.put(a1,2);
        mp.put(a2,2);
        mp.put(a3,2);
        mp.put(a4,3);
        int size = mp.size();
        System.out.println("Size of the map: " + size);//1
        System.out.println(mp.get(a1));// 3
        System.out.println(mp.get(a2));//
        System.out.println(mp.get(a3));
        System.out.println(mp.get(a4));
        System.out.println(mp.get(a5));//3
        System.out.println(mp.get(null));
        System.out.println(mp.get(null));

    }
}