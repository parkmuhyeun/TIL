# Hash
#알고리즘/Hash

---

```java
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class L1845 {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }
}
```

```java
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}));
    }

    public static List<Integer> solution(String[] genres, int[] plays) {
        int length = genres.length;
        HashMap<String, Integer> allMap = new HashMap<>();
        HashMap<String, Integer> relateMap = new HashMap<>();
        List<List<Song>> list = new ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < length; i++) {
            allMap.put(genres[i], plays[i] + allMap.getOrDefault(genres[i], 0));

            if (relateMap.get(genres[i]) == null) {
                relateMap.put(genres[i], cnt++);
                list.add(new ArrayList<>());
            }
            list.get(relateMap.get(genres[i])).add(new Song(i, plays[i]));
        }
        ArrayList<String> keySet = new ArrayList<>(allMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return allMap.get(o2) - allMap.get(o1);
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < keySet.size(); i++) {
            int idx = relateMap.get(keySet.get(i));
            List<Song> songs = list.get(idx);
            Collections.sort(songs);
            for (int j = 0; j < songs.size(); j++) {
                answer.add(songs.get(j).id);
                if (j == 1)
                    break;
            }
        }
        return answer;
    }
}

class Song implements Comparable<Song>{
    int id;
    int cnt;

    public Song(int id, int cnt) {
        this.id = id;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Song o) {
        if (cnt == o.cnt)
            return id - o.id;
        return o.cnt - cnt;
    }
}
```